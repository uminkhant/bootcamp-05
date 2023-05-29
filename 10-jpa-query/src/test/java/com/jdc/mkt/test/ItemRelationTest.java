package com.jdc.mkt.test;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.jdc.mkt.entity.Category;
import com.jdc.mkt.entity.Item;
import com.jdc.mkt.test.utils.JupitorTest;

@TestMethodOrder(OrderAnnotation.class)
public class ItemRelationTest extends JupitorTest{

	//@Test
	@Order(1)
	void test_many_to_one() {
		var item = em.find(Item.class, 1);
		System.out.println(item.getCategory().getName());
	}
	
	//@Test
	@Order(2)
	void test_one_to_many() {
		var category = em.find(Category.class, 1);
		System.out.println(category.getName());
	}
	@Test
	@Order(3)
	void test_many_to_many() {
		
		var item = em.find(Item.class, 1);
		System.out.println(item.getName());
	}
}
