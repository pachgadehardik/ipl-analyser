package com.capg.iplanalysis.enums;

import java.util.Comparator;

import com.capg.iplanalysis.Pojos.MostRuns;

public enum SortingFieldType {
	AVERAGESCORE {
		@Override
		public Comparator<MostRuns> getComparator() {
			Comparator<MostRuns> comparator = Comparator.comparing(obj -> {
				if (((MostRuns) obj).getAvg().contains("-")) {
					((MostRuns) obj).setAvg("0");
				}
				return Float.parseFloat(((MostRuns) obj).getAvg());
			});
			return comparator.reversed();
		}
	},
	STRIKERATE {

		@Override
		public Comparator<MostRuns> getComparator() {
			Comparator<MostRuns> comparator = Comparator.comparing(obj -> {
				if (((MostRuns) obj).getSr().contains("-")) {
					((MostRuns) obj).setSr("0");
				}
				return Float.parseFloat(((MostRuns) obj).getSr());
			});
			return comparator.reversed();
		}

	},
	BOUNDARIES {

		@Override
		public Comparator<MostRuns> getComparator() {
			Comparator<MostRuns> comparator = Comparator
					.comparing(obj -> Double.parseDouble(obj.getSixes()) + Double.parseDouble(obj.getFours()));
			return comparator.reversed();
		}

	},

	BEST_STRIKERATE_WITH_BOUNDARIES {

		@Override
		public Comparator<MostRuns> getComparator() {
			Comparator<MostRuns> comparator = BOUNDARIES.getComparator().thenComparing(STRIKERATE.getComparator());
			return comparator;
		}

	};

	public abstract Comparator<MostRuns> getComparator();
}
