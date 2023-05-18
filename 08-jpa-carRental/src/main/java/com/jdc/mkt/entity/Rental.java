package com.jdc.mkt.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.jdc.mkt.entity.converter.DateConverter;

import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter
public class Rental implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Convert(converter = DateConverter.class)
	private LocalDate rent_date;
	private LocalTime rent_time;
	@ManyToOne
	private Address destination;
	@Convert(converter = DateConverter.class)
	private LocalDate return_date;
	private LocalTime return_time;
}
