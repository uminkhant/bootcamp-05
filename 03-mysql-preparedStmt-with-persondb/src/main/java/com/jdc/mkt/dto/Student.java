package com.jdc.mkt.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Student {

	private int id;
	private String name;
	private String email;
	private String contact;
	private boolean active;
	private Address address;
	private Gender gender;
	
	public enum Gender{
		MALE,FEMALE,OTHER;
	} 
	
	public Student() {
		super();
	}
	public Student(int id, String name, String email, 
			String contact,Gender gender,Address address, boolean active) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.contact = contact;
		this.address = address;
		this.gender = gender;
		this.active = active;
	}
	
	
	
	
	
}
