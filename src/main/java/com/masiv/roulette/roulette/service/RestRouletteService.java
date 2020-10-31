package com.masiv.roulette.roulette.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.masiv.roulette.roulette.dto.GenericResponseDTO;
import com.masiv.roulette.roulette.dto.RouletteDTO;
import com.masiv.roulette.roulette.entity.Roulette;
import com.masiv.roulette.roulette.repository.BetRepository;
import com.masiv.roulette.roulette.repository.RoulettRepository;
import com.masiv.roulette.roulette.repository.RouletteRepository;
import com.masiv.roulette.roulette.utilities.ROULETTEconstants;

@Service
public class RestRouletteService {
	
//	@Autowired
//	private RoulettRepository rouletteRepository;
//	@Autowired
//	private BetRepository betRepository;
	
	@Autowired
	private RouletteRepository RouletteRepository;
	@Autowired
	ObjectMapper objectMapper;
	@Autowired
	HttpServletRequest http;
	
	
//	public Roulette saveRoulette(@RequestBody Roulette roulette) {
//		
//		return rouletteRepository.saveRoulette(roulette);
//	}
//
//	
//	public List<Roulette> findAllRoulettes() {
//		
//		return rouletteRepository.findAll();
//	}
//	
//	public RouletteDTO findRouletteByIdentifier(@PathVariable Long identifier) {
//
//		return rouletteRepository.findRouletteByIdentifier(identifier);
//	}
//	
//	
//	public int deleteRoulette(@PathVariable Long identifier) {
//		
//		return rouletteRepository.deleteRoulette(identifier);
//	}

	/**
	 * 
	 * @return
	 */
	public Long createRoulette() {
		Roulette newRoulette = new Roulette();
		newRoulette.setStatus(false);
		Roulette response = RouletteRepository.save(newRoulette);
		
		return response.getIdentifier();
	}
	
	/**
	 * 
	 * @return
	 */
	public GenericResponseDTO openRoulette(Long identifier) {
		GenericResponseDTO response = new GenericResponseDTO();
		Optional<Roulette> query = RouletteRepository.findById(identifier);
		if(query.isPresent()) {
			Roulette queryRoulette = query.get();
			if(queryRoulette.getStatus()) {
				response.setResponseMessage(ROULETTEconstants.MESSAGE_ROULETTE_IS_ALREADY_OPEN);
			}else {
				queryRoulette.setBets(null);
				queryRoulette.setStatus(ROULETTEconstants.STATUS_ROULETTE_OPEN);
				RouletteRepository.save(queryRoulette);
				response.setResponseMessage(ROULETTEconstants.MESSAGE_ROULETTE_OPEN_SUCCESSFULLY);
			}
			response.setResponseCode(ROULETTEconstants.RESPONSE_CODE_OK);
		}else {
			response.setResponseMessage(ROULETTEconstants.MESSAGE_GENERIC_ERROR);
			response.setResponseCode(ROULETTEconstants.RESPONSE_CODE_ERROR);
		}
		
		return response;
	}
	
	

	//AUX
	public List<Roulette> getAllRoulettes() {
		ArrayList<Roulette> consulta = new ArrayList<>();
		RouletteRepository.findAll().forEach(consulta::add);
		
		return consulta;
	}

	

	

	
}
