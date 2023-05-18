package com.jdc.mkt.entity.converter;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class DateConverter implements AttributeConverter<LocalDate, Date>{

	@Override
	public Date convertToDatabaseColumn(LocalDate localdate) {
		return Date.valueOf(localdate);
	}

	@Override
	public LocalDate convertToEntityAttribute(Date date) {
		return date.toLocalDate();
	}

}
