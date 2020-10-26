package com.capg.iplanalysis.Service;

import com.capg.iplanalysis.Pojos.MostRuns;
import com.capg.iplanalysis.Pojos.MostWickets;
import com.capg.iplanalysis.enums.PlayerType;

public class IplAnalyseBuilder {
	
	
	

	public static <T> Class<T> getClass(PlayerType playerType) {
		
		if(playerType == PlayerType.BATSMAN)
			return (Class<T>) MostRuns.class;
		else if(playerType == PlayerType.BOWLER)
			return (Class<T>) MostWickets.class;
		return null;
		
	}
		
	}

