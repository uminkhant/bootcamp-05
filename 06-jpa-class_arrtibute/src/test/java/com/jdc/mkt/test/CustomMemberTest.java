package com.jdc.mkt.test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CustomMemberTest {

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
	void test() {}
}
