package com.jdc.mkt.test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.jdc.mkt.entity.TableA;
import com.jdc.mkt.entity.TableB;

public class TableGenTest {

	static EntityManagerFactory emf;
	
	@BeforeAll
	static void createEmf() {
		emf = Persistence.createEntityManagerFactory("jpaClassAtribute");
	}
	
	@AfterAll
	static void closeEmf() {
		if(null != emf && emf.isOpen()) {
			emf.close();
		}
	}
	
	@Test
	void test() {
		TableA a = new TableA();
		a.setName("a");
		TableB b = new TableB();
		b.setName("b");
		
		var em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(a);
		System.out.println("Table A : %d".formatted(a.getId()));
		em.persist(b);
		System.out.println("Table B : %d".formatted(b.getId()));
		em.getTransaction().commit();
	}
	
}
