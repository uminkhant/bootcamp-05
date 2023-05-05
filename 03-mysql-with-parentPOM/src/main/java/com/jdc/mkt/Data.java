package com.jdc.mkt;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter 
public class Data {

	private int id;
	private String name;
	private int age;
	
	public Data(int id, String name,int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}
	
	
}
