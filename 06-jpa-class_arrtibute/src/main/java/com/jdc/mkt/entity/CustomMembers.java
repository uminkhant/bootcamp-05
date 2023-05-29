package com.jdc.mkt.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.ElementCollection;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.JoinColumn;
import javax.persistence.OrderBy;
import javax.persistence.Enumerated;
import static javax.persistence.EnumType.STRING;
import javax.persistence.Temporal;
import static javax.persistence.TemporalType.DATE;

@Entity
@Getter
@Setter
@Table(name = "custom_tbl")
public class CustomMembers implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "custom_name" ,
			length = 4,
			nullable = false)
	private String name;
	private int age;
	
	@Enumerated(STRING)
	@Column(nullable = false)
	private Gender gender;
	
	@Temporal(DATE)
	private Date dob;
	@Transient
	private boolean deleted;
	
	@ElementCollection
	@CollectionTable(name = "set_tbl")
	private Set<String> setTest;
	@ElementCollection
	@CollectionTable(name = "map_tbl")
	private Map<String,String> mapTest;
	
	@ElementCollection
	@CollectionTable(
			joinColumns =
			@JoinColumn(
					name = "custom_id", 
			referencedColumnName = "id")
	, name = "hobbies_tbl")
	@OrderBy("hobbies desc")
	//@OrderColumn(name = "hob",nullable = false)
	private List<String> hobbies;
	@ElementCollection
	private List<Customer> customers;
	
	
	
	public enum Gender{
		MALE,FEMALE
	}
}
