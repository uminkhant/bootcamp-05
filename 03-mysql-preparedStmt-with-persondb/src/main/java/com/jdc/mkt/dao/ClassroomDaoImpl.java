package com.jdc.mkt.dao;

import java.sql.Date;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.jdc.mkt.dto.ClassRoom;
import static com.jdc.mkt.util.MyConnection.getConnection;

class ClassroomDaoImpl implements ClassroomDao {

	@Override
	public int insertClass(String name, LocalDate date) {

		String sql = "INSERT INTO class_room_tbl(name,create_date) values(?,?)";

		try (var con = getConnection(); 
				var stmt = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)) {

			stmt.setString(1, name);
			stmt.setDate(2, Date.valueOf(date));
			
			
			return stmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteClassById(int id) {
		String sql = "DELETE FROM class_room_tbl where id=?";

		try (var con = getConnection(); var stmt = con.prepareStatement(sql)) {

			stmt.setInt(1, id);
			return stmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public int updateClass(int id, String name, LocalDate date, boolean active) {

		String sql = "UPDATE class_room_tbl SET name=?,create_date=?,active=? WHERE id=?";

		try (var con = getConnection(); var stmt = con.prepareStatement(sql)) {

			stmt.setString(1, name);
			stmt.setDate(2, Date.valueOf(date));
			stmt.setBoolean(3, active);
			stmt.setInt(4, id);
			return stmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<ClassRoom> getAllClasses() {
		String sql = "SELECT * FROM class_room_tbl ";
		List<ClassRoom> lists = new ArrayList<>();

		try (var con = getConnection(); var stmt = con.prepareStatement(sql)) {

			var rs = stmt.executeQuery();
			while (rs.next()) {
				ClassRoom cr = new ClassRoom(rs.getInt("id"), rs.getString("name"),
						rs.getDate("create_date").toLocalDate(), rs.getBoolean("active"));

				lists.add(cr);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return lists;
	}

}
