package com.jdc.mkt.entity;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="customer_tbl")
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;


	@Id
	private int id;
	@Column(nullable = false)
	private String name;
	@Enumerated(EnumType.STRING)
	@Column(name = "member_type")
	private MemberType memberType;
	@MapsId
	@OneToOne
	@PrimaryKeyJoinColumn
	private Contact contact;
	@ManyToOne
	private Address address;
	




	public enum MemberType{
		GOLD,SILVER,DIAMOND;
	}
}