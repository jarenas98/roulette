package com.masiv.roulette.roulette.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.masiv.roulette.roulette.dto.RouletteDTO;
import com.masiv.roulette.roulette.entity.Roulette;
import com.masiv.roulette.roulette.repository.BetRepository;
import com.masiv.roulette.roulette.repository.RoulettRepository;

@Service
public class RestRouletteService {
	
	@Autowired
	private RoulettRepository rouletteRepository;
	@Autowired
	private BetRepository betRepository;
	@Autowired
	HttpServletRequest http;
	
	
	public Roulette saveRoulette(@RequestBody Roulette roulette) {
		
		return rouletteRepository.saveRoulette(roulette);
	}

	
	public List<Roulette> findAllRoulettes() {
		
		return rouletteRepository.findAll();
	}
	
	public RouletteDTO findRouletteByIdentifier(@PathVariable Long identifier) {

		return rouletteRepository.findRouletteByIdentifier(identifier);
	}
	
	
	public int deleteRoulette(@PathVariable Long identifier) {
		
		return rouletteRepository.deleteRoulette(identifier);
	}

	/**
	 * 
	 * @return
	 */
	public Long createRoulette() {
		Roulette newRoulette = new Roulette();
		newRoulette.setStatus(false);
		Roulette response = rouletteRepository.saveRoulette(newRoulette);
		
		return response.getIdentifier();
	}
	
}
