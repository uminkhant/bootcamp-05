package com.jdc.mkt.dto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlConnection {

	static final String url = "jdbc:mysql://localhost:3306/test_db";
	static final String user = "root";
	static final String pass = "admin";
	
	public static Connection connection() throws SQLException {
		return DriverManager.getConnection(url,user,pass);
	}
}
