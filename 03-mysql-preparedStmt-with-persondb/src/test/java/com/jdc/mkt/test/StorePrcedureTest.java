package com.jdc.mkt.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.jdc.mkt.dao.StoreProcedureDao;
import com.jdc.mkt.dto.Student;

public class StorePrcedureTest {

	static StoreProcedureDao store;
	
	@BeforeAll
	static void init() {
		store = StoreProcedureDao.getProcedure();
	}
	
	@Test
	void testStore() {
		List<Student> list = store.getStudentByClassroomId(2);
		for(Student s :list) {
			System.out.println(s.getName());
		}
		assertEquals(2,list.size());
	}
}
