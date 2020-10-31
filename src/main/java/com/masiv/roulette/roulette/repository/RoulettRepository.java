package com.masiv.roulette.roulette.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.masiv.roulette.roulette.dto.RouletteDTO;
import com.masiv.roulette.roulette.entity.Bet;
import com.masiv.roulette.roulette.entity.Roulette;
import com.masiv.roulette.roulette.utilities.ROULETTEconstants;

@Repository
public class RoulettRepository {
////	@Autowired
////	private RedisTemplate template;
//	@Autowired
//	ObjectMapper objectMapper;
//
//	
//	public Roulette saveRoulette(Roulette roulette) {
//		template.opsForHash().put(ROULETTEconstants.HASH_KEY_ROULETTE, roulette.getIdentifier(), roulette);
//		
//		return roulette;
//	}
//
//	public List<Roulette> findAll() {
//		
//		return template.opsForHash().values(ROULETTEconstants.HASH_KEY_ROULETTE);
//	}
//
//	public RouletteDTO findRouletteByIdentifier(Long identifier) {
//		Roulette roulette = (Roulette) template.opsForHash().get(ROULETTEconstants.HASH_KEY_ROULETTE, identifier);
//		
//		return objectMapper.convertValue(roulette, RouletteDTO.class);
//	}
//	
//	public int deleteRoulette(Long identifier) {
//		template.opsForHash().delete(ROULETTEconstants.HASH_KEY_ROULETTE, identifier);
//		
//		return 200;
//	}
}
