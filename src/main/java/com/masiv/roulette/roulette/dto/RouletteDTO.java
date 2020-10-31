package com.masiv.roulette.roulette.dto;

import java.util.ArrayList;
import java.util.Date;



import lombok.Data;
@Data
public class RouletteDTO {
	private Long  identifier;
	private Boolean  status;
	private Short result;
	private ArrayList<BetDTO> bets;

}
