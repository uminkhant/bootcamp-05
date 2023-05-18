package com.jdc.mkt.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter
//@DiscriminatorValue(value = "Driver")
public class Driver extends Account{

	private static final long serialVersionUID = 1L;
	
	private double commission;
	

	public Driver(String name, Address address, Gender gender, Contact contact) {
		super(name, address, gender, contact);
		setRole(Role.DRIVER);
	}

	public Driver() {
		super();
		setRole(Role.DRIVER);
	}
	
	
	
}
