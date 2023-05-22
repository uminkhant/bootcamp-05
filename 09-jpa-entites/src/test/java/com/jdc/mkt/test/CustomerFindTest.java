package com.jdc.mkt.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;

import org.hibernate.LazyInitializationException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.jdc.mkt.entity.Customer;

@TestMethodOrder(OrderAnnotation.class)
public class CustomerFindTest {

	static EntityManagerFactory emf;
	
	@ParameterizedTest
	@ValueSource(ints = 1)
	@Order(1)
	void test_find(int id) {
		var em = emf.createEntityManager();
		
		var cu = em.find(Customer.class, id);
		
		assertNotNull(cu);
		assertTrue(em.contains(cu));
		
		em.close();
		
		assertEquals("myothu", cu.getName());	
		System.out.println("Cu Name :"+cu.getName());
		
		
	}
	
	@ParameterizedTest
	@ValueSource(ints = 1)
	@Order(2)
	void test_get_reference(int id) {
		var em = emf.createEntityManager();
		var cu = em.getReference(Customer.class, id);
		
		assertNotNull(cu);
		assertTrue(em.contains(cu));
		
		em.close();
		
		assertThrows(LazyInitializationException.class,()-> cu.getName());
		
		//System.out.println("Cu Name :"+cu.getName());
		
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
