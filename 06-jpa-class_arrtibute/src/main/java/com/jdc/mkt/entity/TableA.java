package com.jdc.mkt.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import static javax.persistence.TemporalType.TIME;
import javax.persistence.Enumerated;
import static javax.persistence.EnumType.STRING;

//@Entity
@Getter
@Setter
public class TableA {

	@Id
	@GeneratedValue(generator = "tableA_seq")
	@TableGenerator(name = "tableA_seq", allocationSize = 1, initialValue = 2000)
	private int id;
	@Column(name = "table_name",
			nullable = false,
			unique = true,
			length = 50)
	private String name;
	
	@Temporal(TIME)
	private Date date;
	
	@Enumerated(STRING)
	private Type type;
	
	public enum Type {
		SIMPLE,SPECIAL
	}
}
