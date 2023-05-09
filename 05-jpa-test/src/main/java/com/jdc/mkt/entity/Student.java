package com.jdc.mkt.entity;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	private int id;
	private String name;
	private LocalDate date;
	private boolean active;
	private Gender gender;
	
	@Embedded
	private Contact contact;
	
	
	public enum Gender{
		MALE,FEMALE
	}
	
	
}
