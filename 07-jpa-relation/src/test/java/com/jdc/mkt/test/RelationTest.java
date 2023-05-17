package com.jdc.mkt.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.jdc.mkt.entity.Address;
import com.jdc.mkt.entity.Contact;
import com.jdc.mkt.entity.Customer;
import com.jdc.mkt.entity.Customer.MemberType;

public class RelationTest {

	static EntityManagerFactory emf;
	
	@BeforeAll
	static void init() {
		emf = Persistence.createEntityManagerFactory("jparelation");
	}
	@AfterAll
	static void close() {
		if(null != emf && emf.isOpen()) {
			emf.close();
		}
	}
	@Test
	void test() {
//		Address a = new Address();
//		a.setStreet("19st");
//		a.setTownship("mahar aung myay");
//		a.setCity("mdy");
//		
//		Contact c = new Contact();
//		c.setPhone("09-32423423");
//		c.setEmail("mmmm@gmail.com");
//		
//		Customer cu = new Customer();
//		//cu.setAddress(a);
//		cu.setContact(c);
//		cu.setMemberType(MemberType.SILVER);
//		cu.setName("mm mm");
//		
//		EntityManager em = emf.createEntityManager();
//		
//		em.getTransaction().begin();
//		em.persist(a);
//		em.persist(c);
//		em.persist(cu);
//		em.getTransaction().commit();
	}
}
