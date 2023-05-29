package com.jdc.mkt.test.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public abstract class JupitorTest {

	 protected static EntityManagerFactory emf;
	 protected EntityManager em;

	@BeforeEach
	void createEm() {
		em = emf.createEntityManager();
	}

	@AfterEach
	void closeEm() {
		if (null != em && em.isOpen()) {
			em.close();
		}
	}

	@BeforeAll
	static void init() {
		emf = Persistence.createEntityManagerFactory("jpaquery");
	}

	@AfterAll
	static void closeEmf() {
		if (null != emf && emf.isOpen()) {
			emf.close();
		}
	}
}
