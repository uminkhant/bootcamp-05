package com.jdc.mkt.test;

import java.time.LocalDate;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.jdc.mkt.entity.Address;
import com.jdc.mkt.entity.Contact;
import com.jdc.mkt.entity.Donator;
import com.jdc.mkt.entity.Donator.Gender;

@TestMethodOrder(OrderAnnotation.class)
public class DonatorTest extends JupitorTest{

	@ParameterizedTest
	@CsvSource(delimiter = ':',
	value="william:1995-02-20:MALE:19st:aungmyaytharzan:mandalay:09-256257252:william@gmail.com")
	@Order(1)
	void insertNewDonator(String name,String dob,Gender gender,
			String street,String township,String city,String phone ,String email) {
		var contact = new Contact(phone, email);
		var address = new Address(street,township,city,contact);
		var donator = new Donator(name, LocalDate.parse(dob), address, gender);
		
		em.getTransaction().begin();
		em.persist(address);
		em.persist(donator);
		em.getTransaction().commit();
	}
	@ParameterizedTest
	@ValueSource(strings = {"mandalay","yangon"})
	@Order(2)
	void test_select_donator_with_city(String city) {
		
		var jpql = "select d from Donator d where d.address.city = :city ";
		var query = em.createQuery(jpql,Donator.class);
		
		query.setParameter("city", city);
		
		var list = query.getResultList();
		
		System.out.println("Size :"+list.size());
		
		list.stream().map(Donator::getName)
		.forEach(res ->{
			System.out.println("Name :"+res);
		});
		
		
	}
	
}
