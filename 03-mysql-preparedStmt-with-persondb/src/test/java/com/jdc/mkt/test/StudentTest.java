package com.jdc.mkt.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.jdc.mkt.dao.StudentDao;

@TestMethodOrder(OrderAnnotation.class)
public class StudentTest {
	
	private static StudentDao studentDao;
	
	@BeforeAll
	static void createStudentObject() {
		studentDao = StudentDao.getStudentDaoInstance();
	}

	//@ParameterizedTest
	@Order(1)
	@CsvSource(value = "Mikey:2:mikey@gmail.com:09-234234:1:true", delimiter = ':')
	void insertStudent(String name, int gender, String email, String contact, int address, boolean active) {
		
		int result = studentDao.insertStudent(name, gender, email, contact, address, active);
		assertEquals(1, result);
	}

	// @ParameterizedTest
	@Order(2)
	@CsvSource(value = { "7:Adrew:1:andrew@gmail.com:09-342323532:2",
			"8:Thomas:1:thomas@gmail.com:09-234234232:3" }, delimiter = ':')
	void updateStudent(int id, String nam, int gen, String email, String contact, int address) {
		int result = studentDao.updateStudent(id, nam, gen, email, contact, address);
		assertEquals(1, result);
	}

	// @ParameterizedTest
	@Order(3)
	@ValueSource(ints = { 12, 13 })
	void deleteStudent(int id) {
		
		int result = studentDao.deleteStudent(id);
		assertEquals(1, result);
	}

	//@Test
	@Order(4)
	void selectPersonWithAddress() {
		var list = studentDao.selectPersonWithAddress();
		assertEquals(12, list.size());
	}
}
