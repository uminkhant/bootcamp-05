package com.jdc.mkt.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.jdc.mkt.entity.Customer;

@TestMethodOrder(OrderAnnotation.class)
public class MergeStateTest {
	
	static EntityManagerFactory emf;
	
	@ParameterizedTest
	@ValueSource(strings = "John")
	@Order(1)
	void test_merge(String name) {
		var em = emf.createEntityManager();
		var cu = em.find(Customer.class, 1);
		
		em.detach(cu);
		assertFalse(em.contains(cu));
			
		em.getTransaction().begin();
	
		var cu1 = em.merge(cu);
		cu1.setName(name);
		
		assertFalse(em.contains(cu));
		assertTrue(em.contains(cu1));
		
		em.getTransaction().commit();	
		
	}
	@Test
	@Order(2)
	void test_transient_to_merge() {
		var em = emf.createEntityManager();
		var cu = em.find(Customer.class, 1);
		
		assertTrue(em.contains(cu));
		em.close();
		em = emf.createEntityManager();
		
		em.getTransaction().begin();
		var cu1 =  em.merge(cu);	
		assertTrue(em.contains(cu1));
		
		em.getTransaction().commit();
		
	}
	@Test
	@Order(3)
	void test_remove_to_merge() {
		var em = emf.createEntityManager();
		var cu = em.find(Customer.class, 1);
		
		assertTrue(em.contains(cu));
		em.remove(cu);
		
		assertThrows(IllegalArgumentException.class,
				()->{
			em.getTransaction().begin();
			var cu1 =  em.merge(cu);	
			assertTrue(em.contains(cu1));	
			em.getTransaction().commit();
		});
		
		
	}
	
	@BeforeAll
	static void init() {
		emf = Persistence.createEntityManagerFactory("jpaEntities");
	}
	
	@AfterAll
	static void close() {
		if(null != emf && emf.isOpen()) {
			emf.close();
		}
	}
}
