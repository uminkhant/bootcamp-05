package com.jdc.mkt.test;

import java.time.LocalDate;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.jdc.mkt.entity.Contact;
import com.jdc.mkt.entity.Student;
import com.jdc.mkt.entity.Student.Gender;

public class StudentTest {

	static EntityManagerFactory emf;
	
	@BeforeAll
	static void init() {
		emf = Persistence.createEntityManagerFactory("JPATEST");
	}
	@AfterAll
	static void close() {
		if(null != emf && emf.isOpen()) {
			emf.close();
		}
	}
	
	@Test
	void test() {
		var em = emf.createEntityManager();
		Contact c = new Contact(
				"74st,bet 34X35 maharaungmyay",
				"william@gmail.com",
				"09-53453453");
		Student st = new Student(1,"William",
				LocalDate.now(),
				true,Gender.MALE,c);
		
		em.getTransaction().begin();
		em.persist(st);
		em.getTransaction().commit();
	}
}
