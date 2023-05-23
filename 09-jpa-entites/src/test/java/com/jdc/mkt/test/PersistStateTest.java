package com.jdc.mkt.test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.jdc.mkt.entity.Customer;

@TestMethodOrder(OrderAnnotation.class)
public class PersistStateTest {

	static EntityManagerFactory emf;

	@ParameterizedTest
	@CsvSource(value = "Sophia:casher:123:09-242342:sophia@gmail.com", delimiter = ':')
	@Order(1)
	void test_detached_to_persist(String name, String loginId, String password, String phone, String email) {

		var em = emf.createEntityManager();
		var cu = em.find(Customer.class, 1);

		assertTrue(em.contains(cu));

		em.detach(cu);

		assertThrows(PersistenceException.class, () -> {

			em.getTransaction().begin();
			em.persist(cu);
			em.getTransaction().commit();
		});
	}

	@Test
	@Order(2)
	void test_remove_to_persist() {

		var em = emf.createEntityManager();
		var cu = em.find(Customer.class, 1);

		assertTrue(em.contains(cu));

		em.remove(cu);

		em.getTransaction().begin();
		em.persist(cu);
		assertTrue(em.contains(cu));
		em.getTransaction().commit();

	}

	@BeforeEach
	void init() {
		emf = Persistence.createEntityManagerFactory("jpaEntities");
	}

	@AfterEach
	void close() {
		if (null != emf && emf.isOpen()) {
			emf.close();
		}
	}
}
