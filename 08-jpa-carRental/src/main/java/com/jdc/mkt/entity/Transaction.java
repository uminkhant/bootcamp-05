package com.jdc.mkt.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.JoinTable;
@Entity
@Getter
@Setter
@Table(name = "transaction_tbl")
public class Transaction implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private LocalDate date;
	private double rent_charge;
	@ManyToMany
	@JoinTable(name = "report_tbl")
	private List<Rental>rentals;
	@ManyToOne
	private Car car;
	@ManyToOne
	private Admin admin;
	@ManyToOne
	private Customer customer;
}
