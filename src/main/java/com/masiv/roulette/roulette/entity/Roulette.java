package com.masiv.roulette.roulette.entity;



import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@AllArgsConstructor
@NoArgsConstructor
@RedisHash("Roulettes")
public class Roulette {
	@Id
	private Long  identifier;
	private Boolean  status;
	private Short result;
	private ArrayList<Bet> bets;
	
}
