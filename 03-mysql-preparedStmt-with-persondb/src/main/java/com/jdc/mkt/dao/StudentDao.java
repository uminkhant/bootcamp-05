package com.jdc.mkt.dao;

import java.util.List;

import com.jdc.mkt.dto.Student;

public interface StudentDao {
	
	
	
	public int insertStudent(String name,
			int gender, String email,
			String contact, int address,
			boolean active) ;
	
	public int updateStudent(int id, String nam,
			int gen, String email, 
			String contact, int address);
	
	public int deleteStudent(int id);
	public List<Student> selectPersonWithAddress();
	
	public static StudentDao getStudentDaoInstance() {
		return new StudentDaoImpl();
	}

}
