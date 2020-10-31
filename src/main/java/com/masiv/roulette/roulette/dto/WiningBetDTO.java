package com.masiv.roulette.roulette.dto;

import lombok.Data;
/**
 * Data transfer object for Winning Bet
 * 
 * @author Jefferson Arenas Castaño
 * @version 1.0
 *
 */
@Data
public class WiningBetDTO {
	private String userIdentifier;
	private Double amountEarned;
}
