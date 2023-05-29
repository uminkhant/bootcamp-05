package com.jdc.mkt.test;

import org.junit.jupiter.api.Test;

import com.jdc.mkt.entity.Item;
import com.jdc.mkt.test.utils.JupitorTest;

public class CustomJoinTest extends JupitorTest{

	//@Test
	void test_to_one() {
		
		//var jpql = "select i from Item i join i.category c where c.name = :name";
		var jpql = "select i from Item i where i.category.name = :name";
		
		var query = em.createQuery(jpql,Item.class);
		query.setParameter("name", "Drinks");
		
		var list = query.getResultList();
		list.stream().map(Item::getName).forEach(System.out::println);
		
		
	}
	//@Test
	void test_to_many() {
		var jpql = """
				select i from Item i 
				join i.customers c where c.name = :name
				""";
		
		var query = em.createQuery(jpql,Item.class);
		query.setParameter("name", "Arnel");
		var list = query.getResultList();
		list.stream().map(Item::getName).forEach(System.out::println);
	}
	@Test
	void test_select_item_by_township() {
		var jpql = """
				select i from Item i
				join i.customers c where c.address.township = :town
				""";
		var query = em.createQuery(jpql,Item.class);
		query.setParameter("town", "aungmyaytharzan");
		var list = query.getResultList();
		list.stream().map(i -> i.getName()).forEach(System.out::println);
		
	}
}
