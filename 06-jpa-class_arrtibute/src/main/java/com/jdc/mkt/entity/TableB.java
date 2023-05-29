package com.jdc.mkt.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.SequenceGenerator;

//@Entity
@Getter
@Setter
public class TableB {

	@Id
	@GeneratedValue(generator = "tableB_seq")
	@SequenceGenerator(name = "tableB_seq", allocationSize = 1, initialValue = 2000)
	private int id;
	private String name;
}
