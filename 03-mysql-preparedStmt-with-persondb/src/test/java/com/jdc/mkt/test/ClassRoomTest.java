package com.jdc.mkt.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.jdc.mkt.dao.ClassroomDao;

@TestMethodOrder(OrderAnnotation.class)
public class ClassRoomTest {

	
	private static ClassroomDao classroom;
	
	@BeforeAll
	static void init() {
		classroom = ClassroomDao.getInstanceClass();
	}
	
	@ParameterizedTest
	@Order(1)
	@CsvSource(value = {
			"wd-batch-06:2023-07-03",
			"we-batch-03:2023-09-01"
	},delimiter = ':')
	void createClassRoom(String name,String date) {	
	int result = classroom.insertClass(name, LocalDate.parse(date));
	assertEquals(1, result);
	
	}
	
}
