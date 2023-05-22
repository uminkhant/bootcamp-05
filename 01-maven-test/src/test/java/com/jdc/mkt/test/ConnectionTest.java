package com.jdc.mkt.test;

import static com.jdc.mkt.dto.MysqlConnection.connection;

import org.junit.jupiter.api.Test;

public class ConnectionTest {

	@Test
	void insert(String name) {
		String sql = "insert into tbl1 values(%s)".formatted(name);
		try(var con = connection();
				var stmt = con.createStatement() ){
			
			stmt.executeUpdate(sql);
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
