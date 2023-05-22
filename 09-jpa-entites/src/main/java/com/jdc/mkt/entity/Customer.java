package com.jdc.mkt.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.ElementCollection;
import static javax.persistence.FetchType.EAGER;
import javax.persistence.CollectionTable;

@Entity
@Getter
@Setter
@Table(name = "customer_tbl")
@NoArgsConstructor
public class Customer implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String name;
	@Column( nullable = false,
			columnDefinition = "varchar(45) check(char_length(loginId) >= 4)")
	private String loginId;
	private String password;
	
	@ElementCollection(fetch = FetchType.LAZY)
	@CollectionTable(name = "tags_tbl")
	private List<String> tags = new ArrayList<>();
	
	public Customer(String name, String loginId, String password) {
		super();
		this.name = name;
		this.loginId = loginId;
		this.password = password;
	}
	
	public void addTag(String... tag) {
		tags.addAll(Arrays.asList(tag));
	}
	
}
