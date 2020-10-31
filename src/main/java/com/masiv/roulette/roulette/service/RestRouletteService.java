package com.masiv.roulette.roulette.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.masiv.roulette.roulette.dto.BetDTO;
import com.masiv.roulette.roulette.dto.GenericResponseDTO;
import com.masiv.roulette.roulette.dto.ResultRouletteDTO;
import com.masiv.roulette.roulette.dto.WiningBetDTO;
import com.masiv.roulette.roulette.entity.Bet;
import com.masiv.roulette.roulette.entity.Roulette;
import com.masiv.roulette.roulette.repository.RouletteRepository;
import com.masiv.roulette.roulette.utilities.ROULETTEconstants;

@Service
public class RestRouletteService {
	@Autowired
	private RouletteRepository rouletteRepository;
	@Autowired
	ObjectMapper objectMapper;
	@Autowired
	HttpServletRequest http;
	public Long createRoulette() {
		Roulette newRoulette = new Roulette();
		newRoulette.setStatus(false);
		Roulette response = rouletteRepository.save(newRoulette);

		return response.getIdentifier();
	}
	public GenericResponseDTO openRoulette(Long identifier) {
		GenericResponseDTO response = new GenericResponseDTO();
		Optional<Roulette> query = rouletteRepository.findById(identifier);
		if (query.isPresent()) {
			Roulette queryRoulette = query.get();
			if (queryRoulette.getStatus()) {
				response.setResponseMessage(ROULETTEconstants.MESSAGE_ROULETTE_IS_ALREADY_OPEN);
			} else {
				queryRoulette.setBets(null);
				queryRoulette.setStatus(ROULETTEconstants.STATUS_ROULETTE_OPEN);
				rouletteRepository.save(queryRoulette);
				response.setResponseMessage(ROULETTEconstants.MESSAGE_ROULETTE_OPEN_SUCCESSFULLY);
			}
			response.setResponseCode(ROULETTEconstants.RESPONSE_CODE_OK);
		} else {
			response.setResponseMessage(ROULETTEconstants.MESSAGE_GENERIC_ERROR);
			response.setResponseCode(ROULETTEconstants.RESPONSE_CODE_ERROR);
		}

		return response;
	}
	public GenericResponseDTO createBet(BetDTO bet) {
		GenericResponseDTO response = new GenericResponseDTO();
		if (isRouletteOk(bet.getRouletteId())) {
			bet.setUserIdentifier(http.getHeader("user"));
			addBetToRoulette(bet);
			response.setResponseCode(ROULETTEconstants.RESPONSE_CODE_OK);
			response.setResponseMessage(ROULETTEconstants.MESSAGE_CREATE_BET_OK);
		} else {
			response.setResponseCode(ROULETTEconstants.RESPONSE_CODE_ERROR);
			response.setResponseMessage(ROULETTEconstants.MESSAGE_CREATE_BET_ERROR);
		}

		return response;
	}
	private void addBetToRoulette(BetDTO bet) {
		Roulette roulette = rouletteRepository.findById(bet.getRouletteId()).get();
		Bet request = objectMapper.convertValue(bet, Bet.class);
		roulette.addnewBet(request);
		rouletteRepository.save(roulette);
	}
	private boolean isRouletteOk(Long rouletteId) {
		Optional<Roulette> query = rouletteRepository.findById(rouletteId);
		if (query.isPresent()) {
			Roulette queryRoulette = query.get();
			if (queryRoulette.getStatus()) {

				return true;
			}
		}

		return false;
	}
	public ResultRouletteDTO closeRoulette(Long identifier) {
		ResultRouletteDTO response = new ResultRouletteDTO();
		Optional<Roulette> query = rouletteRepository.findById(identifier);
		if (query.isPresent()) {
			Roulette queryRoulette = query.get();
			if (queryRoulette.getStatus()) {
				queryRoulette.setStatus(false);
				rouletteRepository.save(queryRoulette);
				response.setAllBets(
						objectMapper.convertValue(queryRoulette.getBets(), new TypeReference<ArrayList<BetDTO>>() {
						}));
				selectWinners(response);
				response.setResponseMessage(ROULETTEconstants.MESSAGE_ROULETTE_IS_CLOSE_SUCCESSFULLY);
			} else {
				response.setResponseMessage(ROULETTEconstants.MESSAGE_ROULETTE_IS_ALREADY_CLOSE);
			}
			response.setResponseCode(ROULETTEconstants.RESPONSE_CODE_OK);
		} else {
			response.setResponseMessage(ROULETTEconstants.MESSAGE_GENERIC_ERROR);
			response.setResponseCode(ROULETTEconstants.RESPONSE_CODE_ERROR);
		}

		return response;
	}
	private void selectWinners(ResultRouletteDTO response) {
		Random rd = new Random();
		Short numberWinner = (short) rd.nextInt(37);
		String colorWinner = numberWinner % 2 == 0 ? ROULETTEconstants.ROULETTE_COLOR_RED
				: ROULETTEconstants.ROULETTE_COLOR_BLACK;
		response.setNumberWinner(numberWinner);
		response.setColorWinner(colorWinner);
		WiningBetDTO auxWinningBet = new WiningBetDTO();
		for (BetDTO bet : response.getAllBets()) {
			if (bet.getBetColor() != null) {
				if (bet.getBetColor().equals(colorWinner)) {
					auxWinningBet.setUserIdentifier(bet.getUserIdentifier());
					auxWinningBet.setAmountEarned(bet.getBetAmount() * ROULETTEconstants.PERCENTAGE_GAIN_PER_COLOR);
					response.getAllBetsWinners().add(auxWinningBet);
				}
			} else {
				if (bet.getBetNumber() == numberWinner) {
					auxWinningBet.setUserIdentifier(bet.getUserIdentifier());
					auxWinningBet.setAmountEarned(bet.getBetAmount() * ROULETTEconstants.PERCENTAGE_GAIN_PER_NUMBER);
					response.getAllBetsWinners().add(auxWinningBet);
				}
			}
		}
	}

	// AUX
	public List<Roulette> getAllRoulettes() {
		ArrayList<Roulette> consulta = new ArrayList<>();
		rouletteRepository.findAll().forEach(consulta::add);

		return consulta;
	}

}
