package com.capg.iplanalysis.enums;

import java.util.Comparator;

import com.capg.iplanalysis.Pojos.MostWickets;
import com.capg.iplanalysis.Pojos.Player;
import com.capg.iplanalysis.interfaces.ISorting;

public enum PlayerEnum implements ISorting {

	ALLROUNDER_WITH_RUNS_WICKETS {

		@Override
		public Comparator<Player> getComparator() {
			Comparator<Player>comparator=Comparator.comparing(obj->Double.parseDouble(((Player)obj).getBatsman().getRuns())+Double.parseDouble(((Player)obj).getBowler().getWkts()));return comparator.reversed();
		}

	},
	ALLROUNDER_WITH_AVERAGES {

	@Override
		public  Comparator<Player> getComparator() {
			Comparator<Player> comparator = Comparator
					.comparing(obj ->Float.parseFloat(((Player) obj).getBatsman().getAvg()) + Float.parseFloat(((Player) obj).getBowler().getAvg())
					 );
			return comparator.reversed();
		}

	};

}
