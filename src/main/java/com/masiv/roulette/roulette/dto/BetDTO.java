package com.masiv.roulette.roulette.dto;

import lombok.Data;
/**
 * Data transfer object for Bet Entity
 * 
 * @author Jefferson Arenas Castaño
 * @version 1.0
 *
 */
@Data
public class BetDTO {
	private Long identifier;
	private Short betNumber;
	private String betColor;
	private Double betAmount;
	private String userIdentifier;
	private Long rouletteId;
}
