package com.jdc.mkt.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.Temporal;
import static javax.persistence.TemporalType.DATE;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;

@Entity
@Getter
@Setter
public class Book implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String name;
	@ManyToOne
	private Category category;
	@ManyToOne
	private Author author;
	@ManyToMany
	@JoinTable(name = "book_cu_tbl", 
	joinColumns = 
	@JoinColumn(name = "book_id", referencedColumnName = "id"),
	inverseJoinColumns = 
	@JoinColumn(name = "customer_id", referencedColumnName = "id"))
	private List<Customer>customers;
	
	@Temporal(DATE)
	private Date date;
}
