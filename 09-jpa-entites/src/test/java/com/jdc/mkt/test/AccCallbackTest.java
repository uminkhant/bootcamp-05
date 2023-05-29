package com.jdc.mkt.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.jdc.mkt.entity.Account;

@TestMethodOrder(OrderAnnotation.class)
public class AccCallbackTest {

	static EntityManagerFactory emf;
	
	@ParameterizedTest
	@CsvSource("John William,1000")
	@Order(1)
	void test_persist(String name,int balance) {
		var em = emf.createEntityManager();
		var acc = new Account();
		acc.setName(name);
		acc.setBalance(balance);
		
		em.getTransaction().begin();
		em.persist(acc);
		assertEquals(1000, acc.getBalance());
		em.getTransaction().commit();
	}
	
	@ParameterizedTest
	@CsvSource("1,John,800")
	@Order(2)
	void test_update(int id,String name,int balance) {
		var em = emf.createEntityManager();
		var acc = em.find(Account.class, id);
		acc.setName(name);
		acc.setBalance(balance);
		
		em.getTransaction().begin();
		em.merge(acc);
		
//		assertAll(()->{
//			assertEquals("John", acc.getName());
//			assertEquals(800, acc.getBalance());
//		});
		em.getTransaction().commit();
	}
//	
//	@ParameterizedTest
//	@ValueSource(ints = 1)
//	@Order(3)
//	void test_remove(int id) {
//		var em = emf.createEntityManager();
//		var acc = em.find(Account.class, id);
//		
//		em.getTransaction().begin();
//		em.remove(acc);
//		assertFalse(em.contains(acc));
//		em.getTransaction().commit();
//	}
	
	
	
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
