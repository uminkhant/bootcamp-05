package com.jdc.mkt.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@EqualsAndHashCode
public class DonationPk implements Serializable {

	private static final long serialVersionUID = 1L;
	private int donatorId;
	private int hospitalId;
	private int patientId;
}
