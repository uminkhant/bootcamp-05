package com.jdc.mkt.entity;


import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.jdc.mkt.entity.listener.EntityListener;
import com.jdc.mkt.entity.listener.ObjectEnableListener;
import com.jdc.mkt.entity.listener.Times;

import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter
@Table(name = "account_tbl")
@EntityListeners(EntityListener.class)
public class Account implements ObjectEnableListener{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private int balance;
	@Embedded
	private Times times;
	
	
	
}
