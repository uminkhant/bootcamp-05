package com.jdc.mkt.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.jdc.mkt.dto.Employee;
import com.jdc.mkt.dto.Employee.Role;

@TestMethodOrder(OrderAnnotation.class)
class AccountTest {

	static Connection getConnection() throws SQLException {

		return DriverManager.getConnection("jdbc:mysql://localhost:3306/account_db", "root", "admin");

	}

	@BeforeAll
	static void init() {
		String sql = "TRUNCATE TABLE employee_tbl";
		try (var con = getConnection(); var stmt = con.createStatement()) {

			stmt.executeUpdate(sql);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static void createDb_Table() {
		String dropDb = "DROP DATABASE IF EXISTS account_db";
		String createDb = "CREATE DATABASE account_db";
		String useDb = "USE account_db";
		String createTable = """

				CREATE TABLE employee_tbl(
				id int PRIMARY KEY AUTO_INCREMENT,
				name varchar(40) check(char_length(name)>=4),
				role enum('ACCOUNTANT','ADMIN','CASHIER') ,
				active boolean default true
				)

				""";

		try (var con = getConnection(); var stmt = con.createStatement()) {

			stmt.execute(dropDb);
			stmt.execute(createDb);
			stmt.execute(useDb);
			stmt.execute(createTable);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@ParameterizedTest
	@Order(1)
	@CsvSource("Sandar,2,1")
	void createEmployee(String name,int role,int active) {
		System.out.println("create Employee");
		String sql = "INSERT INTO employee_tbl(name,role,active) values('%s',%d,%d)"
				.formatted(name,role,active);

		try (var con = getConnection(); 
				var stmt = con.createStatement()) {

			int result = stmt.executeUpdate(sql);
			assertEquals(1, result);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@ParameterizedTest
	@Order(2)
	@ValueSource(ints = { 1 })
	void retrieveEmployee(int id) {
		String sql = "SELECT * FROM employee_tbl where id=%d".formatted(id);

		try (var con = getConnection(); var stmt = con.createStatement()) {

			var rs = stmt.executeQuery(sql);
			Employee emp = null;

			while (rs.next()) {
				emp = new Employee(rs.getInt("id"), 
						rs.getString("name"),
						Role.valueOf(rs.getString("role")),
						rs.getBoolean("active"));
			}

			assertEquals("Sandar", emp.getName());

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	@ParameterizedTest
	@Order(3)
	@CsvSource(value="1:Aung Aung:CASHIER:1",delimiter =':')
	void updateEmployee(int id,String name, String role, int active) {

		String sql = "UPDATE employee_tbl SET name='%s',role='%s',active=%d where id=%d"
				.formatted(name,role,active,id);
		
		try (var con = getConnection(); 
				var stmt = con.createStatement()) {
			stmt.executeUpdate(sql);
			
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
	
	@ParameterizedTest
	@Order(4)
	@ValueSource(ints = 1)
	void deleteEmployee(int id) {
		String sql ="DELETE FROM employee_tbl WHERE id=%d"
				.formatted(id);
		
		try (var con = getConnection(); 
				var stmt = con.createStatement()) {
			int result = stmt.executeUpdate(sql);
			assertEquals(1, result);
			
			
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

}
