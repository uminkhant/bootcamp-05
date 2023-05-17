package com.jdc.mkt.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@EqualsAndHashCode
public class Customer implements Serializable{

	private static final long serialVersionUID = 1L;
	private String name;
	private String age;
//	@ElementCollection
//	private List<String> texting;
}
