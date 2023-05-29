package com.jdc.mkt.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

//@Entity
@Getter
@Setter
@Table(name = "sale_tbl")
@SecondaryTables({
	@SecondaryTable(name = "price_tbl"),
	@SecondaryTable(name = "person_tbl") })
public class Sales {
	@Id
	private int saleId;
	private String name;
	@Column(table = "person_tbl")
	private String salePerson;
	private LocalDate saleDate;

	@Column(table = "price_tbl")
	private double totalPrice;
	@Column(table = "price_tbl")
	private double tax;

}
