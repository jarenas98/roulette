package com.masiv.roulette.roulette.dto;

import java.util.ArrayList;
import lombok.Data;
@Data
public class ResultRouletteDTO extends GenericResponseDTO {
	private ArrayList<BetDTO> allBets;
	private ArrayList<WiningBetDTO> allBetsWinners;
	private String colorWinner;
	private Short numberWinner;

	public ResultRouletteDTO() {
		this.allBetsWinners = new ArrayList<WiningBetDTO>();
	}
}
