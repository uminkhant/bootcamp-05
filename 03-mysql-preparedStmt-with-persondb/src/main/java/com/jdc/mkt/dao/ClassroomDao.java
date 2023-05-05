package com.jdc.mkt.dao;

import java.time.LocalDate;
import java.util.List;

import com.jdc.mkt.dto.ClassRoom;

public interface ClassroomDao {

	int insertClass(String name,LocalDate date) ;
	int deleteClassById(int id);
	int updateClass(int id,String name,LocalDate date,boolean active);
	List<ClassRoom> getAllClasses();
	
	public static ClassroomDao getInstanceClass() {
		return new ClassroomDaoImpl();
	}
}
