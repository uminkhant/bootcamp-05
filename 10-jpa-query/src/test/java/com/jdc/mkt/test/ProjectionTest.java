package com.jdc.mkt.test;


import com.jdc.mkt.entity.dto.ItemByTownship;
import com.jdc.mkt.test.utils.JupitorTest;

public class ProjectionTest extends JupitorTest{

	//@Test
	void test_select_item_by_township() {
		
		var jpql = """
				select new com.jdc.mkt.entity.dto.ItemByTownship(c.name,a.street,i.name) from Item i
				join i.customers c 
				join c.address a
				where a.township = :town
				""";
		
		var query = em.createQuery(jpql,ItemByTownship.class);
		query.setParameter("town", "aungmyaytharzan");
		var list = query.getResultList();
		
		list.forEach(a->{
			System.out.printf("customer :%s\tStreet :%s\tItem :%s\n"
					,a.cuName(),a.adStreet(),a.iName());
			
		});
	}
	
	
	
	
}
