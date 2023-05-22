package com.jdc.mkt.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.jdc.mkt.entity.Contact;
import com.jdc.mkt.entity.Customer;

@TestMethodOrder(OrderAnnotation.class)
public class CustomerTest {

	static EntityManagerFactory emf;
	
	//@ParameterizedTest
	@ValueSource(ints = 1)
	@Order(1)
	void test_persistance(int id) {
		EntityManager em = emf.createEntityManager();
		Customer cu = em.find(Customer.class, id);
		
		assertNotNull(cu);
		System.out.println("Customer name :"+cu.getName());
		assertEquals("myothu", cu.getName());
	}
	//@ParameterizedTest
	@CsvSource(value = "sandar,cashier,123")
	@Order(2)
	void test_persist(String name,String loginId,String password) {
		
		var em = emf.createEntityManager();
		//transient state
		var customer = new Customer(name, loginId, password);
		em.getTransaction().begin();
		
		//managed state
		em.persist(customer);
		customer.setName("Sandar Aung");
		//insert to db
		em.getTransaction().commit();
		
	}
	@ParameterizedTest
	@CsvFileSource(resources = "/customers.csv")
	@Order(3)
	void test_transientProperty(String name,String loginId,
			String password,String email,String phone) {
		
		var customer = new Customer(name, loginId, password);
		var contact = new Contact(phone, email, customer);
		
		var em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(customer);
		em.persist(contact);
		em.getTransaction().commit();
		
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
