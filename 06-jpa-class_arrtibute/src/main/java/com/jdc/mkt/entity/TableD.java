package com.jdc.mkt.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

//@Embeddable
@Getter
@Setter
public class TableD implements Serializable{

	private static final long serialVersionUID = 1L;
	private String namePkA;
	private String namePkB;
	@Override
	public int hashCode() {
		return Objects.hash(namePkB, namePkA);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TableD other = (TableD) obj;
		return Objects.equals(namePkB, other.namePkB) && Objects.equals(namePkA, other.namePkA);
	}
	
}
