package com.masiv.roulette.roulette.utilities;

import com.masiv.roulette.roulette.dto.BetDTO;

public class ROULETTEvalidator {
	public ROULETTEvalidator() {
		super();
	}
	public static Boolean isNewBetOk(BetDTO betDto) {
		Boolean validatorColor = validatorColor(betDto.getBetColor());
		Boolean validatorNumber = validatorNumber(betDto.getBetNumber());
		Boolean validatorAmount = validatorAmount(betDto.getBetAmount());
		
		if(betDto.getRouletteId() == null) {
			
			return false;
		}
		if (validatorAmount && validatorNumber && validatorColor) {
			
			return false;
		} else if (validatorAmount && !validatorNumber && betDto.getBetNumber() == null && validatorColor) {
			
			return true;
		} else if (validatorAmount && validatorNumber && !validatorColor && betDto.getBetColor() == null ) {
			
			return true;
		}
		
		return false;
	}

	private static Boolean validatorAmount(Double betAmount) {
		if (betAmount != null && betAmount > 0 && betAmount <= 10000) {
			
			return true;
		}
		
		return false;
	}

	private static Boolean validatorNumber(Short betNumber) {
		if (betNumber != null && betNumber >= 0 && betNumber <= 36) {
			return true;
		}

		return false;
	}

	private static Boolean validatorColor(String betColor) {
		if (betColor != null && (ROULETTEconstants.ROULETTE_COLOR_BLACK.equals(betColor)
				|| ROULETTEconstants.ROULETTE_COLOR_RED.equals(betColor))) {
			
			return true;
		}

		return false;
	}

}
