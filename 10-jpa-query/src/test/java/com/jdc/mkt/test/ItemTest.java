package com.jdc.mkt.test;



import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.jdc.mkt.entity.Item;
import com.jdc.mkt.test.utils.JupitorTest;

@TestMethodOrder(OrderAnnotation.class)
public class ItemTest extends JupitorTest {

	@Test
	@Order(1)
	void test_select_by_catName_item() {
//		var query = em.createQuery("""
//				select i from Item i where i.category.name = :cat
//				""",Item.class);
		var query = em.createNamedQuery("Item.selectByCategoryName",Item.class);
		query.setParameter("cat", "Drinks");
		var list = query.getResultList();
		
		list.stream().map(Item::getName)
		.forEach(System.out::println);
		
	
	}
	@ParameterizedTest
	@CsvSource("6,1000")
	@Order(2)
	void test_update_by_catName_item(int id,int price) {
//		var query = em.createQuery("""
//				update Item i set i.price = :price where i.id = :id
//				""");
		var query = em.createNamedQuery("Item.updateById");
		query.setParameter("price", price);
		query.setParameter("id", id);
		em.getTransaction().begin();
		var result = query.executeUpdate();
		em.getTransaction().commit();
		System.out.println(result);
	}
	
	@ParameterizedTest
	@CsvSource("6,1000")
	@Order(3)
	void test_delete_by_catName_item(int id) {
//		var query = em.createQuery("""
//				delete from Item i where i.id = :id
//				""");
		var query = em.createNamedQuery("Item.deleteById");
		query.setParameter("id", id);
		em.getTransaction().begin();
		var result = query.executeUpdate();
		em.getTransaction().commit();
		System.out.println(result);
	}
}
