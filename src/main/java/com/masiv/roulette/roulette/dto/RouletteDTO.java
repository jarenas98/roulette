package com.masiv.roulette.roulette.dto;

import java.util.Date;

import com.googlecode.jmapper.annotations.JMap;

import lombok.Data;
@Data
public class RouletteDTO {
	@JMap
	private Long  identifier;
	@JMap
	private Long  status;
	@JMap
	private Short result;
	@JMap
	private Date initialDate;
	@JMap
	private Date finalDate;
}
