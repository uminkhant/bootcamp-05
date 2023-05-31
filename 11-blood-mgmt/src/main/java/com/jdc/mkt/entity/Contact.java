package com.jdc.mkt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@EqualsAndHashCode
public class Contact implements Serializable{

	private static final long serialVersionUID = 1L;
	@Column(nullable = false)
	private String phone;
	private String email;
	
	public Contact(String phone, String email) {
		super();
		this.phone = phone;
		this.email = email;
	}

	public Contact() {
		super();
	}
	
	
}
