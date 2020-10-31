package com.masiv.roulette.roulette.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.masiv.roulette.roulette.entity.Roulette;

@Repository
public interface RouletteRepository extends CrudRepository<Roulette, Long> {

}
