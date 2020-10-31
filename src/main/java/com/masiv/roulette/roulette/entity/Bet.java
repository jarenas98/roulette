package com.masiv.roulette.roulette.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("Bet")
public class Bet implements Serializable{
	@Id
	private Long identifier;
	private Short betNumber;
	private Short betColor;
	private Integer betAmount;
	private Long userIdentifier;
	
}
