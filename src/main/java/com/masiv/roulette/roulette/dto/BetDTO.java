package com.masiv.roulette.roulette.dto;

import lombok.Data;

@Data
public class BetDTO {
	private Long identifier;
	private Short betNumber;
	private String betColor;
	private Double betAmount;
	private String userIdentifier;
	private Long rouletteId;
}
