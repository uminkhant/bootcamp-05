package com.jdc.mkt.test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.jdc.mkt.entity.Contact;
import com.jdc.mkt.entity.Customer;

@TestMethodOrder(OrderAnnotation.class)
public class RemoveStateTest {
	static EntityManagerFactory emf;
	
	@ParameterizedTest
	@ValueSource(ints = 1)
	@Order(1)
	void test_managed_remove_with_orphan_removable(int id) {
		var em = emf.createEntityManager();
		var customer = em.find(Customer.class, id);
		
		assertTrue(em.contains(customer));
		
		em.getTransaction().begin();
		em.remove(customer);
		em.getTransaction().commit();
		
	}
	@Test
	@Order(2)
	void transient_to_remove_state() {
		var em = emf.createEntityManager();
		var customer = new Customer();
		
		em.getTransaction().begin();
		em.remove(customer);
		em.getTransaction().commit();
		
	}
	
	@Test
	@Order(3)
	void detached_to_remove_state() {
		var em = emf.createEntityManager();
		var customer = em.find(Customer.class, 1);
		
		assertTrue(em.contains(customer));
		em.detach(customer);
		
		assertThrows(IllegalArgumentException.class, ()->{
			em.getTransaction().begin();
			em.remove(customer);
			
			em.getTransaction().commit();
		});
		
		
	}

	@BeforeEach
	 void init() {
		emf = Persistence.createEntityManagerFactory("jpaEntities");
	}
	
	@AfterEach
	void close() {
		if(null != emf && emf.isOpen()) {
			emf.close();
		}
	}
	
	
}
