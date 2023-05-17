package com.jdc.mkt.entity;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
@Table(name="contact_tbl")
public class Contact implements Serializable {
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(unique = true,nullable = false)
	private String phone;
	@Column(nullable = false)
	private String email;
	@OneToOne
	private Customer customer;

}