package com.masiv.roulette.roulette.entity;

import org.springframework.data.redis.core.index.Indexed;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bet {
	@Indexed
	private Long identifier;
	private Short betNumber;
	private String betColor;
	private Double betAmount;
	private String userIdentifier;
	private Long rouletteId;
}
