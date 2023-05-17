package com.jdc.mkt.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;

import lombok.Getter;
import lombok.Setter;

//@Entity
@Getter
@Setter
@IdClass(value = TableD.class)
public class TableC implements Serializable{

	private static final long serialVersionUID = 1L;
	private String name;
	@Id
	private String namePkA;
	@Id
	private String namePkB;
	//@EmbeddedId
	//private TableD tablePk;
}
