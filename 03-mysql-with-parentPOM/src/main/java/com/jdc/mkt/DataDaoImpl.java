package com.jdc.mkt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class DataDaoImpl implements DataDao {
	 
	 private static final String URL = "jdbc:mysql://localhost:3306/test_db";
	 private static final String USER = "root";
	 private static final String PASS = "admin";
	 
	 private static Connection getConnection() throws SQLException {
		 return DriverManager.getConnection(URL,USER,PASS);
	 }

	@Override
	public Data testStoreProcedure(int id) {
		
		String sql = "{call findDataById(?)}";
		
		try(var con = getConnection();
				var stmt = con.prepareCall(sql)){
			
			stmt.setInt(1, id);
			var rs = stmt.executeQuery();
			
			while(rs.next()) {
				Data d = new Data(
						rs.getInt("id"),
						rs.getString("name"),
						rs.getInt("age")
						);
				
				return d;
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
	}

	

}
