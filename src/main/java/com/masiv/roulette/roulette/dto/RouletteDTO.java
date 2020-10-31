package com.masiv.roulette.roulette.dto;

import java.util.ArrayList;
import lombok.Data;

@Data
public class RouletteDTO {
	private Long identifier;
	private Boolean status;
	private ArrayList<BetDTO> bets;
}
