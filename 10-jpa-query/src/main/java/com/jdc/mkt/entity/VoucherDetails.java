package com.jdc.mkt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Setter;

@Entity
@Setter
@Table(name = "voucher_detail")
public class VoucherDetails implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	private Item item;
	@ManyToOne
	private Voucher voucher;
	@Column(nullable = false)
	private int qty;
	@SuppressWarnings("unused")
	@Transient
	private int total;
	
	public int getId() {
		return id;
	}
	public Item getItem() {
		return item;
	}
	public int getQty() {
		return qty;
	}
	public int getTotal() {
		return item.getPrice()*qty;
	}
	
	
}
