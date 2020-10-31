package com.masiv.roulette.roulette.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.masiv.roulette.roulette.entity.Bet;
import com.masiv.roulette.roulette.entity.Roulette;
import com.masiv.roulette.roulette.utilities.ROULETTEconstants;

@Repository
public class BetRepository {
	@Autowired
	private RedisTemplate template;

	public Bet saveBet(Bet bet) {
		template.opsForHash().put(ROULETTEconstants.HASH_KEY_BET, bet.getIdentifier(), bet);
		
		return bet;
	}

	public List<Bet> findAll() {
		
		return template.opsForHash().values(ROULETTEconstants.HASH_KEY_BET);
	}

	public Bet findBetByIdentifier(Long identifier) {

		return (Bet) template.opsForHash().get(ROULETTEconstants.HASH_KEY_BET, identifier);
	}
	
	public int deleteBet(Long identifier) {
		template.opsForHash().delete(ROULETTEconstants.HASH_KEY_BET, identifier);
		
		return 200;
	}
}
