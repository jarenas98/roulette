package com.masiv.roulette.roulette.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.masiv.roulette.roulette.dto.BetDTO;
import com.masiv.roulette.roulette.dto.GenericResponseDTO;
import com.masiv.roulette.roulette.dto.ResultRouletteDTO;
import com.masiv.roulette.roulette.entity.Roulette;
import com.masiv.roulette.roulette.service.RestRouletteService;
import com.masiv.roulette.roulette.utilities.ROULETTEconstants;
import com.masiv.roulette.roulette.utilities.ROULETTEvalidator;
/**
 * 
 * @author Jefferson Arenas Castaño
 *
 */
@RestController
@RequestMapping("/roulette")
public class RestRouletteController {
	@Autowired
	RestRouletteService restRouletteService;
	@PostMapping("/create_roulette")
	public Long createRoulette() {

		return restRouletteService.createRoulette();
	}
	@PutMapping("/open_roulette")
	public GenericResponseDTO openRoulette(@RequestParam("identifier") Long identifier) {

		return restRouletteService.openRoulette(identifier);
	}
	@PostMapping("/create_bet")
	public GenericResponseDTO createBet(@RequestBody BetDTO bet) {
		GenericResponseDTO response = new GenericResponseDTO();
		Boolean validatorNewBet = ROULETTEvalidator.isNewBetOk(bet);
		if (validatorNewBet) {
			response = restRouletteService.createBet(bet);
		} else {
			response.setResponseCode(ROULETTEconstants.RESPONSE_CODE_ERROR);
			response.setResponseMessage(ROULETTEconstants.MESSAGE_GENERIC_FILTER_ERROR);
		}

		return response;
	}
	@GetMapping("/close_roulette")
	public ResultRouletteDTO closeRoulette(@RequestParam("identifier") Long identifier) {
		ResultRouletteDTO response = new ResultRouletteDTO();
		response = restRouletteService.closeRoulette(identifier);
		return response;
	}
	@GetMapping("/getAllRoulettes")
	public List<Roulette> getAllRoulettes() {
		return restRouletteService.getAllRoulettes();
	}
}
