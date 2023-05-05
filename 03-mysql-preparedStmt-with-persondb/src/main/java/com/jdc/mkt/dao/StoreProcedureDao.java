package com.jdc.mkt.dao;

import java.util.List;

import com.jdc.mkt.dto.Student;

public interface StoreProcedureDao {

	List<Student> getStudentByClassroomId(int id);
	
	public static StoreProcedureDao getProcedure() {
		return new StoreProcedureImpl();
	}
}
