package com.jdc.mkt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "address")
public class Address implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String street;
	private String township;
	private String city;
	@Embedded
	private Contact contact;
	public Address() {
		super();
	}
	public Address(String street, String township, String city,Contact contact) {
		
		this.street = street;
		this.township = township;
		this.city = city;
		this.contact = contact;
		
	}
	
	

}
