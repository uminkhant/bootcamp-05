package com.jdc.mkt.dao;

import java.util.ArrayList;
import java.util.List;

import com.jdc.mkt.dto.Student;
import static com.jdc.mkt.util.MyConnection.getConnection;

public class StoreProcedureImpl implements StoreProcedureDao {

	@Override
	public List<Student> getStudentByClassroomId(int id) {

		String sql = "{call selectStudentByClassroomId(?)}";
		List<Student> list = new ArrayList<>();
		try (var con = getConnection();
				var stmt = con.prepareCall(sql)) {

			stmt.setInt(1, id);
			var rs = stmt.executeQuery();

			while (rs.next()) {
				Student s = new Student();
				s.setName(rs.getString(1));
				list.add(s);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

}
