package com.jdc.mkt.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.jdc.mkt.entity.Category;
import com.jdc.mkt.entity.Item;
import com.jdc.mkt.test.utils.JupitorTest;

@TestMethodOrder(OrderAnnotation.class)
public class ItemTest extends JupitorTest{

	@ParameterizedTest
	@CsvSource( value = {
			"Accessories.cable.2500",
			
			},delimiter = '.')
	@Order(1)
	void test_insert_item_with_new_category(
			String cat_name,String item_name,int price) {
		var cat = new Category(cat_name);
		var item = new Item(item_name, price, cat);
		em.getTransaction().begin();
		em.persist(item);
		em.getTransaction().commit();
	}
	
	@ParameterizedTest
	@Order(2)
	@ValueSource(ints = {1,2})
	void test_static_query_selectAll(int cat_id) {
		var query = em.createNamedQuery("Item.selectItemByCatId",Item.class);
		query.setParameter("id", cat_id);
		var res = query.getResultList();
		assertEquals(3, res.size());
	}
}
