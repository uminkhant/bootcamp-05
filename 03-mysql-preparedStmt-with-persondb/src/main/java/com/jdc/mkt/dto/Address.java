package com.jdc.mkt.dto;

public class Address {

	private int id;
	private String city;
	private String township;
	private String street;
	
	public Address() {
		super();
	}
	
	public Address(int id, String city, String township, String street) {
		super();
		this.id = id;
		this.city = city;
		this.township = township;
		this.street = street;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getTownship() {
		return township;
	}
	public void setTownship(String township) {
		this.township = township;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	
	
}
