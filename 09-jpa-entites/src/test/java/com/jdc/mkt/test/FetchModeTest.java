package com.jdc.mkt.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.jdc.mkt.entity.Customer;

@TestMethodOrder(OrderAnnotation.class)
public class FetchModeTest {

	static EntityManagerFactory emf;
	
	@ParameterizedTest
	@CsvSource("John,admin,123")
	@Order(1)
	void test_create(String name,String loginId,String password) {
		var em = emf.createEntityManager();
		var cu = new Customer(name, loginId, password);
		cu.addTag("ss","aa","ewrw","ssdf");
		
		em.getTransaction().begin();
		em.persist(cu);
		
		em.getTransaction().commit();
	}
	
	@ParameterizedTest
	@ValueSource(ints = 2)
	@Order(2)
	void test_create(int id) {
		var em = emf.createEntityManager();
		var cu = em.find(Customer.class, id);
		
		assertNotNull(cu);
		em.close();
		
		assertEquals("John", cu.getName());
		assertEquals(4, cu.getTags().size());
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
