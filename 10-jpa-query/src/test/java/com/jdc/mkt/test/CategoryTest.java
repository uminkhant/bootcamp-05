package com.jdc.mkt.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import javax.persistence.NoResultException;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.jdc.mkt.entity.Category;
import com.jdc.mkt.test.utils.JupitorTest;

@TestMethodOrder(OrderAnnotation.class)
public class CategoryTest extends JupitorTest {

	@Test
	@Order(1)
	void test_select() {
		var query = em.createQuery("select c from Category c", Category.class);

		// var result = query.getResultList();
		// assertEquals(4, result.size());
		var result = query.getResultStream();
		var cat = result.map(r -> r.getName()).findFirst().orElse(null);
		assertEquals("Foods", cat);
	}

	@ParameterizedTest
	@Order(2)
	@CsvSource(value = {"Vegis,3","Snacks,4"})
	void test_select_with_name_and_id(String name,int id) {
		var query = em.createQuery("""
				select c from Category c where c.name = :name and c.id = :id
				""");
		
		query.setParameter("name", name);
		query.setParameter("id", id);
		
		var res = query.getSingleResult();
		
		assertNotNull(res);
	}
	
	@ParameterizedTest
	@Order(3)
	@ValueSource(strings  ={"Food"})
	void test_select_with_no_result_using_index(String name) {
		var query = em.createQuery("""
				select c from Category c where c.name = ?1 
				""");
		
		assertThrows(NoResultException.class, ()->{
			query.setParameter(1, name);
			var res = query.getSingleResult();
			assertNotNull(res);
		});	
	}
}
