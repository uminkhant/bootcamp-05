package com.jdc.mkt.dto;

import java.time.LocalDate;

public class ClassRoom {

	private int id;
	private String name;
	private LocalDate date;
	private boolean active;
	
	
	public ClassRoom() {
		super();
	}
	public ClassRoom(int id, String name, LocalDate date, boolean active) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
		this.active = active;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
	
	
}
