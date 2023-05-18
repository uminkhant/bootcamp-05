package com.jdc.mkt.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
//@DiscriminatorValue("Customer")
public class Customer extends Account{

	private static final long serialVersionUID = 1L;

	private String passport;
	private boolean isLocal;
	public Customer() {
		super();
		setRole(Role.CUSTOMER);
	}
	public Customer(String name, Address address, Gender gender, Contact contact) {
		super(name, address, gender, contact);
		setRole(Role.CUSTOMER);
	}
	
	
}
