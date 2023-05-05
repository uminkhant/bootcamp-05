package com.jdc.mkt.test;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.jdc.mkt.DataDao;

public class DataTest {

	private static DataDao dataDao;
	
	@BeforeAll
	static void init() {
		dataDao = DataDao.getInstance();
	}
	
	@Test
	void testData() {
		var data = dataDao.testStoreProcedure(1);
		assertEquals("aa", data.getName());
	}
}
