package com.jdc.mkt.entity.listener;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Embeddable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
@Embeddable
@Getter
@Setter
@EqualsAndHashCode
public class Times implements Serializable{

	private static final long serialVersionUID = 1L;
	private LocalDateTime createDate;
	private LocalDateTime updateDate;
	
}
