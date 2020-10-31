package com.masiv.roulette.roulette.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masiv.roulette.roulette.dto.RouletteDTO;
import com.masiv.roulette.roulette.entity.Roulette;
import com.masiv.roulette.roulette.repository.BetRepository;
import com.masiv.roulette.roulette.repository.RoulettRepository;
import com.masiv.roulette.roulette.service.RestRouletteService;


@RestController
@RequestMapping("/roulette")
public class RestRouletteController {
	
	@Autowired
	RestRouletteService restRouletteService;
	
	@PostMapping("/save_roulette")
	public Roulette saveRoulette(@RequestBody Roulette roulette) {
		
		return restRouletteService.saveRoulette(roulette);
	}
	
	@PostMapping("/create_roulette")
	public Long createRoulette() {
		
		return restRouletteService.createRoulette();
	}

	@GetMapping("/find_all_roulettes")
	public List<Roulette> findAllRoulettes() {
		
		return restRouletteService.findAllRoulettes();
	}
	@GetMapping("/find_roulette_by_identifier/{identifier}")
	public RouletteDTO findRouletteByIdentifier(@PathVariable Long identifier) {

		return restRouletteService.findRouletteByIdentifier(identifier);
	}
	
	@DeleteMapping("/delete_roulette/{identifier}")
	public int deleteRoulette(@PathVariable Long identifier) {
		
		return restRouletteService.deleteRoulette(identifier);
	}

}
