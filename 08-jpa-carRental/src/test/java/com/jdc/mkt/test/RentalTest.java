package com.jdc.mkt.test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.jdc.mkt.entity.Address;
import com.jdc.mkt.entity.Admin;
import com.jdc.mkt.entity.Contact;
import com.jdc.mkt.entity.Driver;
import com.jdc.mkt.entity.Account.Gender;

public class RentalTest {

	static EntityManagerFactory emf;
	@BeforeAll
	static void init() {
		emf = Persistence.createEntityManagerFactory("CARRENTAL");
		
	}
	@ParameterizedTest
	@CsvSource(value = "Andrew:22st:Aung myay tharzan:mdy:MALE:andrew@gmail.com:092342342",delimiter = ':')
	void test(String name, 
			String street,String township,String city,
			Gender gender,String email ,String contact) {
		
		Address ad = new Address(street,township,city);
		Contact c = new Contact(email, contact);
		var driver = new Driver(name, ad, gender, c) ;
		var admin = new Admin(name, ad, gender, c) ;
		
		var em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(ad);
		em.persist(driver);
		em.persist(admin);
		em.getTransaction().commit();
	}
	
	@AfterAll
	static void close() {
		if( null != emf && emf.isOpen()) {
			emf.close();
		}
	}
}
