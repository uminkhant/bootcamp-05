package com.jdc.mkt.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(
		name = "product_tbl",
		indexes = { @Index(columnList = "name") },

		uniqueConstraints = {
				@UniqueConstraint(columnNames = "code") 
				})

public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private int id;
	private String name;
	private String code;
	private String category;
	
}
