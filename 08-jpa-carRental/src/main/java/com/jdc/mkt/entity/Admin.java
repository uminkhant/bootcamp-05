package com.jdc.mkt.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
//@DiscriminatorValue("Admin")
public class Admin  extends Account{

	private static final long serialVersionUID = 1L;

	public Admin() {
		super();
		setRole(Role.ADMIN);
	}

	public Admin(String name, Address address, Gender gender, Contact contact) {
		super(name, address, gender, contact);
		setRole(Role.ADMIN);
	}

	
	
	
}
