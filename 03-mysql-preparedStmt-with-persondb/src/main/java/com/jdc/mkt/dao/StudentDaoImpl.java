package com.jdc.mkt.dao;

import static com.jdc.mkt.util.MyConnection.getConnection;

import java.util.ArrayList;
import java.util.List;

import com.jdc.mkt.dto.Address;
import com.jdc.mkt.dto.Student;
import com.jdc.mkt.dto.Student.Gender;

class StudentDaoImpl implements StudentDao {

	@Override
	public int insertStudent(String name, int gender, String email, String contact, int address, boolean active) {

		String sql = "INSERT INTO student_tbl (name,gender,email,contact,address_id,active) " + "values (?,?,?,?,?,?) ";

		try (var con = getConnection(); var stmt = con.prepareStatement(sql)) {
			stmt.setString(1, name);
			stmt.setInt(2, gender);
			stmt.setString(3, email);
			stmt.setString(4, contact);
			stmt.setInt(5, address);
			stmt.setBoolean(6, active);

			return stmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public int updateStudent(int id, String nam, int gen, String email, String contact, int address) {

		String sql = "UPDATE student_tbl SET name=?,gender=?,email=?," + "contact=?,address_id=? where id=?";

		try (var con = getConnection(); var stmt = con.prepareStatement(sql)) {
			stmt.setString(1, nam);
			stmt.setInt(2, gen);
			stmt.setString(3, email);
			stmt.setString(4, contact);
			stmt.setInt(5, address);
			stmt.setInt(6, id);

			return stmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public int deleteStudent(int id) {

		String sql = "DELETE FROM student_tbl WHERE id=? ";

		try (var con = getConnection(); var stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, id);
			return stmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public List<Student> selectPersonWithAddress() {
		
		String sql = "SELECT s.id,s.name,s.gender,s.email,s.contact,a.id,a.city,a.township,a.address FROM student_tbl s "
				+ "INNER JOIN address_tbl a ON s.address_id = a.id where active=true";

		List<Student> list = new ArrayList<>();

		try (var con = getConnection(); var stmt = con.prepareStatement(sql)) {

			var rs = stmt.executeQuery();

		
			while (rs.next()) {
				Address ad = new Address(rs.getInt("a.id"), rs.getString("a.city"), rs.getString("a.township"),
						rs.getString("a.address"));
				Student st = new Student(rs.getInt("s.id"), rs.getString("s.name"), rs.getString("s.email"),
						rs.getString("s.contact"), Gender.valueOf(rs.getString("s.gender")), ad, true

				);
				list.add(st);
			}

		} catch (Exception e) {
			e.printStackTrace();

		}

		return list;
	}

}
