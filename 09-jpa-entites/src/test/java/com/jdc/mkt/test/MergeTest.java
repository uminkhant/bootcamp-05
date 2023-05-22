package com.jdc.mkt.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.jdc.mkt.entity.Customer;

public class MergeTest {
	
	static EntityManagerFactory emf;
	
	@ParameterizedTest
	@ValueSource(strings = "John")
	void test_merge(String name) {
		var em = emf.createEntityManager();
		var cu = em.find(Customer.class, 1);
		
		em.detach(cu);
		assertFalse(em.contains(cu));
		
		assertEquals("myothu", cu.getName());
			
		em.getTransaction().begin();
		
		
		var cu1 = em.merge(cu);
		cu.setName(name);
		
		assertFalse(em.contains(cu));
		assertTrue(em.contains(cu1));
		
		em.getTransaction().commit();
		
		
		
		
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
