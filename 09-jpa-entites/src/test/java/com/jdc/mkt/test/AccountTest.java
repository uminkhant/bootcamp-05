package com.jdc.mkt.test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.jdc.mkt.entity.Account;
@TestMethodOrder(OrderAnnotation.class)
public class AccountTest {

	static EntityManagerFactory emf;
	
	
	@ParameterizedTest
	@CsvSource("JohnDoe,500")
	@Order(1)
	void test_persist(String name,int balance) {
		var acc = new Account();
		var em = emf.createEntityManager();
		acc.setName(name);
		acc.setBalance(balance);
		
		em.getTransaction().begin();
		em.persist(acc);
		em.getTransaction().commit();
	}
	@Test
	@Order(2)
	void test_flush_refresh() {
		var acc_one = getThreadOne();
		var acc_two = getThreadTwo();
		
		acc_one.start();
		acc_two.start();
		
		try {
			Thread.sleep(800);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private Thread getThreadOne() {
		return new Thread(
				()->{
					System.out.println("Account One");
					var em = emf.createEntityManager();
					var acc = em.find(Account.class, 1);
					
					
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					em.getTransaction().begin();
					
					System.out.printf("Before :Account Name :%s and Balance :%d\n",
							acc.getName(),acc.getBalance());
					acc.setBalance(acc.getBalance()+1000);
					em.flush();
					System.out.printf("After :Account Name :%s and Balance :%d\n\n",
							acc.getName(),acc.getBalance());
					
					
					em.getTransaction().commit();
				});
	}
	
	private Thread getThreadTwo() {
		return new Thread(
				()->{
					System.out.println("Account Two");
					var em = emf.createEntityManager();
					var acc = em.find(Account.class, 1);
					
					System.out.println("Acc "+acc.getName());
					
					try {
						Thread.sleep(300);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					em.getTransaction().begin();
					
					System.out.printf("Before :Account Name :%s and Balance :%d\n",
							acc.getName(),acc.getBalance());
					
					em.refresh(acc);
					acc.setBalance(acc.getBalance()-300);
					System.out.printf("After :Account Name :%s and Balance :%d\n\n",
							acc.getName(),acc.getBalance());
					
				
					em.getTransaction().commit();
				});
	}
	
//	@BeforeEach
//	void createEm() {
//		em = emf.createEntityManager();
//	}
//	@AfterEach
//	void closeEm() {
//		em.close();
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
