package com.masiv.roulette.roulette.dto;

import java.util.ArrayList;
import lombok.Data;

/**
 * Data transfer object for Roulette Entity
 * 
 * @author Jefferson Arenas Castaño
 * @version 1.0
 *
 */
@Data
public class RouletteDTO {
	private Long identifier;
	private Boolean status;
	private ArrayList<BetDTO> bets;
}
