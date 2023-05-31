package com.jdc.mkt.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter
@Table(name = "donation")
public class Donation implements Serializable{

	private static final long serialVersionUID = 1L;
	@EmbeddedId
	private DonationPk id;
	@Column(name = "blood_type")
	@Enumerated(EnumType.STRING)
	private BloodType bloodType;
	@Column(name = "donate_date")
	private LocalDate donateDate;
	private boolean isAvaliable;
	@ManyToOne
	@MapsId("donatorId")
	private Donator donator;
	@ManyToOne
	@MapsId("patientId")
	private Patient patient;
	@ManyToOne
	@MapsId("hospitalId")
	private Hospital hospital;
}
