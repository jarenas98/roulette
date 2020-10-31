package com.masiv.roulette.roulette.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.masiv.roulette.roulette.entity.Roulette;

/**
 * This interface contains the basic operations of roulette
 * 
 * @author Jefferson Arenas Castaño
 * @version 1.0
 *
 */
@Repository
public interface RouletteRepository extends CrudRepository<Roulette, Long> {

}
