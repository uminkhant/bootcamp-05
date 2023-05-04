package com.jdc.mkt.dto;

public class Employee {

	private int id;
	private String name;
	private Role role;
	private boolean active;
	
	public enum Role{
		ACCOUNTANT,ADMIN,CASHIER;
	}

	public Employee(int id,String name, Role role, boolean active) {
		super();
		this.id = id;
		this.name = name;
		this.role = role;
		this.active = active;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Role getRole() {
		return role;
	}

	public boolean isActive() {
		return active;
	}
	
	
}
