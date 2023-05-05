package com.jdc.mkt;

public interface DataDao {

	Data testStoreProcedure(int id);
	
	public static DataDao getInstance() {
		return new DataDaoImpl();
	}
}
