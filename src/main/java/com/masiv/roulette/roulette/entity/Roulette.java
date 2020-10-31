package com.masiv.roulette.roulette.entity;

import java.util.ArrayList;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import lombok.AllArgsConstructor;
import lombok.Data;
/**
 * Entity Model for a Roulette
 * 
 * @author Jefferson Arenas Castaño
 * @version 1.0
 *
 */
@Data
@AllArgsConstructor
@RedisHash("Roulette")
public class Roulette {
	@Id
	private Long identifier;
	private Boolean status;
	private ArrayList<Bet> bets;

	public Roulette() {
		this.bets = new ArrayList<Bet>();
	}

	public void addnewBet(Bet bet) {
		this.bets.add(bet);
	}
}
