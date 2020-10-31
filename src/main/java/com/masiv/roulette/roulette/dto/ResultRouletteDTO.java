package com.masiv.roulette.roulette.dto;

import java.util.ArrayList;
import lombok.Data;
/**
 * Data transfer object for Resoult of a Roulettes
 * 
 * @author Jefferson Arenas Castaño
 * @version 1.0
 *
 */
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
