package com.masiv.roulette.roulette.dto;

import lombok.Data;
/**
 * Data transfer object for a Generic response
 * 
 * @author Jefferson Arenas Castaño
 * @version 1.0
 *
 */
@Data
public class GenericResponseDTO {
	private String responseMessage;
	private int responseCode;
}
