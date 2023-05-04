package com.jdc.mkt.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(OrderAnnotation.class)
public class PersonTest {

	static Connection getConnection() throws SQLException {
		
			return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/person_db", 
					"root", "admin");
			
		
	}

	@BeforeAll
	static void truncateTablePerson() {
		
		try (var conn = getConnection();
			var stmt = conn.createStatement()){
			
			String sql = "truncate table person_tbl";		
			stmt.executeUpdate(sql);
			
			
				
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	@Order(1)
	void createPerson() {
		try (var con = getConnection();var stmt = con.createStatement();){
			System.out.println("create person");
			String sql = String.format("insert into person_tbl(name,age) values(%s,%d)", "'Aye Thida'", 23);

			
			stmt.executeUpdate(sql);
			
		

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	@Order(2)
	void referencePerson() {
		System.out.println("reference person");
		String sql = "select * from person_tbl where id = 1";
		
		try(var con = getConnection();
				var stmt = con.createStatement()){
			
			var rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				System.out.println("Name :%s\tAge :%d".
						formatted(rs.getString("name"),rs.getInt("age")));
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	@Order(3)
	void updatePerson() {
		System.out.println("update person");
		
			
	}

	@Test
	void deletePerson() {
		System.out.println("delete person");
	}

}
