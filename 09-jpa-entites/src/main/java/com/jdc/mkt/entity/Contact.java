package com.jdc.mkt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="contact_tbl")
public class Contact implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String phone;
	@Column(nullable = false)
	private String email;
	@OneToOne(mappedBy = "contact")
	private Customer customer;
	
	public Contact(String phone, String email, Customer customer) {
		super();
		this.phone = phone;
		this.email = email;
		this.customer = customer;
	}
	
	
}
