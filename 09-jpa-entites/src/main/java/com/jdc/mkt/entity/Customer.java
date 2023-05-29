package com.jdc.mkt.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.jdc.mkt.entity.listener.EntityListener;
import com.jdc.mkt.entity.listener.ObjectEnableListener;
import com.jdc.mkt.entity.listener.Times;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.CollectionTable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.CascadeType.MERGE;

@Entity
@Getter
@Setter
@Table(name = "customer_tbl")
@NoArgsConstructor
@EntityListeners(EntityListener.class)
public class Customer implements ObjectEnableListener {

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
	@CollectionTable(name = "tags_tbl", 
	joinColumns = @JoinColumn(name = "customer_id", referencedColumnName = "id"))
	private List<String> tags = new ArrayList<>();
	
	@OneToOne(orphanRemoval = true,
			cascade = { PERSIST, MERGE })
	private Contact contact;
	@Embedded
	private Times times;
	
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
