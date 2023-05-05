package com.jdc.mkt.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.jdc.mkt.dao.ClassroomDao;
import com.jdc.mkt.dto.ClassRoom;

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
	
	//@ParameterizedTest
	@Order(2)
	@CsvSource(value = {
			"5:wd-batch-06:2023-07-11:true",
			"6:we-batch-03:2023-09-05:false"
	},delimiter = ':')
	void updateClassroom(int id,String name,String date,boolean active) {
		int result = classroom.updateClass(id,name, LocalDate.parse(date), active);
		assertEquals(1, result);
	}
	
	
	//@ParameterizedTest
	@Order(3)
	@ValueSource(ints = 6)
	void deleteClassroom(int id) {
		int result = classroom.deleteClassById(id);
		assertEquals(1, result);
	}
	
	//@Test
	@Order(4)
	void getAllClassroom() {
		List<ClassRoom>list = classroom.getAllClasses();
		assertEquals(5, list.size());
	}
	
}
