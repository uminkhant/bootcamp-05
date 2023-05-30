package com.jdc.mkt.entity.dto;

import java.time.LocalDate;

public record TotalSumByTownship(
		LocalDate date,
		String township,
		Long total
		) {

}
