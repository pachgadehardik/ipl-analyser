package com.capg.iplanalysis.enums;

import java.util.Comparator;

import com.capg.iplanalysis.Pojos.MostRuns;
import com.capg.iplanalysis.Pojos.MostWickets;

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
		public <T> Comparator<T> getComparator() {
			Comparator<T> comparator = (Comparator<T>) BOUNDARIES.getComparator()
					.thenComparing(STRIKERATE.getComparator());
			return comparator;
		}

	},

	GREAT_AVERAGE_WITH_STRIKERATE {

		@Override
		public <T> Comparator<T> getComparator() {
			Comparator<T> comparator = (Comparator<T>) AVERAGESCORE.getComparator()
					.thenComparing(STRIKERATE.getComparator());
			return comparator;
		}

	},

	MAX_RUNS {

		@Override
		public Comparator<MostRuns> getComparator() {
			Comparator<MostRuns> comparator = Comparator.comparing(obj -> {
				if (((MostRuns) obj).getRuns().contains("-")) {
					((MostRuns) obj).setRuns("0");
				}
				return Float.parseFloat(((MostRuns) obj).getRuns());
			});
			return comparator.reversed();
		}

	},

	MAX_RUNS_WITH_BEST_AVERAGE {

		@Override
		public <T> Comparator<T> getComparator() {
			@SuppressWarnings("unchecked")
			Comparator<T> comparator = (Comparator<T>) MAX_RUNS.getComparator()
					.thenComparing(AVERAGESCORE.getComparator());
			return comparator;
		}

	},

	BOWLING_AVERAGE {

		@Override
		public Comparator<MostWickets> getComparator() {
			Comparator<MostWickets> comparator = Comparator.comparing(obj -> {
				if (((MostWickets) obj).getAvg().contains("-")) {
					((MostWickets) obj).setAvg("99999");
				}
				return Float.parseFloat(((MostWickets) obj).getAvg());
			});
			return comparator;
		}

	};

	public abstract <T> Comparator<T> getComparator();
}
