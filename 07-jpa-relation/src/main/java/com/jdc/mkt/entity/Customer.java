package com.jdc.mkt.entity;

import java.io.Serializable;
import java.util.List;

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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String name;
	@Enumerated(EnumType.STRING)
	@Column(name = "member_type")
	private MemberType memberType;
	//@MapsId
	@OneToOne(optional = false,mappedBy = "customer")
	//@PrimaryKeyJoinColumn
	private Contact contact;
	@ManyToMany(mappedBy = "customers")
	private List<Book> books;
	@ManyToOne
	@JoinTable(name = "customer_address_tbl")
	private Address address;



	public enum MemberType{
		GOLD,SILVER,DIAMOND;
	}
}