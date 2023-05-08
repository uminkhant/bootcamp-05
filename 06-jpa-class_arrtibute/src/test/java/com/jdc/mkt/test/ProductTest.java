package com.jdc.mkt.test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.jdc.mkt.entity.Product;

public class ProductTest {

	private static EntityManagerFactory emf;
	
	@BeforeAll
	static void createEmf() {
		emf = Persistence.createEntityManagerFactory(null);
	}
	
	@AfterAll
	static void closeEmf() {
		if(null != emf && emf.isOpen()) {
			emf.close();
		}
	}
	@Test
	void createProduct() {
		var em = emf.createEntityManager();
		Product p = new Product(1, "Orange", "001O","Fruits");
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
	}

}
