package com.jdc.mkt.entity.dto;

import java.time.LocalDate;

public record TotalSumBetweenDate(
		LocalDate date,
		long total
		) {

}
