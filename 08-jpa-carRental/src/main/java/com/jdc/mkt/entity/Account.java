package com.jdc.mkt.entity;

import java.io.Serializable;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

//@MappedSuperclass
@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name = "acc_type", discriminatorType = INTEGER)
public abstract class Account implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private int id;
	private String name;
	@ManyToOne
	private Address address;
	@Enumerated(EnumType.STRING)
	private Gender gender;
	@Embedded
	private Contact contact;
	@Enumerated(EnumType.STRING)
	private Role role;
		
	public Account(String name, Address address, Gender gender, Contact contact) {
		super();
		this.name = name;
		this.address = address;
		this.gender = gender;
		this.contact = contact;
		
	}


	public Account() {
		super();
	}


	public enum Role{
		ADMIN,DRIVER,CUSTOMER
	}
	
	
	public enum Gender{
		MALE,FEMALE
	}
}
