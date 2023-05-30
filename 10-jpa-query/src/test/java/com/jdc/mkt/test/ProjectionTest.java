package com.jdc.mkt.test;


import java.time.LocalDate;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.jdc.mkt.entity.dto.ItemByTownship;
import com.jdc.mkt.entity.dto.TotalSumBetweenDate;
import com.jdc.mkt.entity.dto.TotalSumByTownship;
import com.jdc.mkt.test.utils.JupitorTest;

@TestMethodOrder(OrderAnnotation.class)
public class ProjectionTest extends JupitorTest{

	@Test
	@Order(1)
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
	@Test
	@Order(2)
	void test_select_and_sum_by_voucher_date() {
		var jpql = """
				select new com.jdc.mkt.entity.dto.TotalSumBetweenDate(
				v.voucherDate,sum(vd.total)
				)
				from VoucherDetails vd
				join vd.voucher v where v.voucherDate 
				between (:before) and (:after)	
				group by v.voucherDate
				""";
		var query = em.createQuery(jpql,TotalSumBetweenDate.class);
		query.setParameter("before", LocalDate.of(2022, 01, 07));
		query.setParameter("after", LocalDate.of(2023, 01, 07));
		
		var list = query.getResultList();
		list.forEach(t ->{
			System.out.println("Date :"+t.date()+"\tTotal :"+t.total());
		});
	}
	
	@Test
	@Order(3)
	void test_sum_by_voucher_date() {
		var jpql = """
				select sum(vd.total)
				from VoucherDetails vd where vd.voucher.voucherDate 
				between (:before) and (:after)	
				""";
		var query = em.createQuery(jpql,Long.class);
		query.setParameter("before", LocalDate.of(2022, 01, 07));
		query.setParameter("after", LocalDate.of(2023, 01, 07));
		
		var list = query.getResultList();
		list.forEach(System.out::println);
	}
	@Test
	@Order(4)
	void test_total_by_township_and_date() {
		var jpql = """
				select new com.jdc.mkt.entity.dto.TotalSumByTownship(
				v.voucherDate,a.township,sum(vd.total))
				from VoucherDetails vd
				join vd.voucher v
				join v.customer.address a
				where a.township = :town and v.voucherDate = :date
				group by v.voucherDate
				""";
		
		var query = em.createQuery(jpql,TotalSumByTownship.class);
		query.setParameter("town", "aungmyaytharzan");
		query.setParameter("date", LocalDate.of(2022, 01, 12));
		
		var list = query.getResultList();
		
		list.forEach(e -> System.out.println (
				"Date : "+e.date()+"\t"+e.township()
				+"\tTotal : "+e.total()
				));
	}
	
	
}
