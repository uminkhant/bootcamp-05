package com.jdc.mkt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import static javax.persistence.CascadeType.PERSIST;

@Entity
@Getter
@Setter
@Table(name = "item")
public class Item implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String name;
	private int price;
	@ManyToOne(cascade = PERSIST)
	private Category category;
	
	
	public Item(String name, int price, Category category) {
		super();
		this.name = name;
		this.price = price;
		this.category = category;
	}


	public Item() {
		super();
	}
	
	
}
