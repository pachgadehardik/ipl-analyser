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

		@SuppressWarnings("unchecked")
		@Override
		public <T> Comparator<T> getComparator() {
			Comparator<T> comparator = (Comparator<T>) BOUNDARIES.getComparator()
					.thenComparing(STRIKERATE.getComparator());
			return comparator;
		}

	},

	GREAT_AVERAGE_WITH_STRIKERATE {

		@SuppressWarnings("unchecked")
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
	
	MAX_HUNDREDS{

		@Override
		public Comparator<MostRuns> getComparator() {
			Comparator<MostRuns> comparator = Comparator
					.comparing(obj -> Double.parseDouble(obj.getHundreds()));
			return comparator.reversed();
		}
		
	},
	
	ZERO_HUNDREDS_FIFTYS{

		@Override
		public Comparator<MostRuns> getComparator() {
			Comparator<MostRuns> comparator = Comparator
					.comparing(obj -> Double.parseDouble(obj.getHundreds()) + Double.parseDouble(obj.getFiftys()));
			return comparator;
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

	}, BOWLING_SR{

		@Override
		public Comparator<MostWickets> getComparator() {
			Comparator<MostWickets> comparator = Comparator.comparing(obj -> {
				if (((MostWickets) obj).getSr().contains("-")) {
					((MostWickets) obj).setSr("9999");
				}
				return Float.parseFloat(((MostWickets) obj).getSr());
			});
			return comparator;
		}
		
	}, ECONOMY_RATE{

		@Override
		public Comparator<MostWickets> getComparator() {
			Comparator<MostWickets> comparator = Comparator.comparing(obj -> Float.parseFloat(obj.getEcon()));
			return comparator;
		}
		
	},
	FIVEWICKET_FOURWICKET{

		@Override
		public Comparator<MostWickets> getComparator() {
			Comparator<MostWickets> comparator = Comparator
					.comparing(obj -> Double.parseDouble(obj.getFiveWickets()) + Double.parseDouble(obj.getFourWickets()));
			return comparator.reversed();
		}
		
	},
	
	STRIKE_RATE_WITH_5W4W{

		@SuppressWarnings("unchecked")
		@Override
		public <T> Comparator<T> getComparator() {
			Comparator<T> comparator = (Comparator<T>) FIVEWICKET_FOURWICKET.getComparator()
					.thenComparing(BOWLING_SR.getComparator());
			return comparator;
		}
		
	},
	BOWLING_AVERAGE_WITH_SR{
		@SuppressWarnings("unchecked")
		@Override
		public <T> Comparator<T> getComparator() {
			Comparator<T> comparator = (Comparator<T>) BOWLING_SR.getComparator()
					.thenComparing(BOWLING_AVERAGE.getComparator());
			return comparator;
		}
	},
	MAXIMUM_WICKETS{
		@Override
		public Comparator<MostWickets> getComparator() {
			Comparator<MostWickets> comparator = Comparator
					.comparing(obj -> Integer.parseInt(obj.getWkts()));
			return comparator.reversed();
		}
	},
	MAXIMUM_WICKETS_WITH_AVERAGE{
		@SuppressWarnings("unchecked")
		@Override
		public <T> Comparator<T> getComparator() {
			Comparator<T> comparator = (Comparator<T>) BOWLING_AVERAGE.getComparator()
					.thenComparing(MAXIMUM_WICKETS.getComparator());
			return comparator;
		}
	},
	MAXIMUM_HUNDREDS_WITH_BESTAVG{
		@SuppressWarnings("unchecked")
		@Override
		public <T> Comparator<T> getComparator() {
			Comparator<T> comparator = (Comparator<T>) MAX_HUNDREDS.getComparator()
					.thenComparing(AVERAGESCORE.getComparator());
			return comparator;
		}
	},
	ZERO_HUNDREDSFIFTYS_BEST_AVG{
		@SuppressWarnings("unchecked")
		@Override
		public <T> Comparator<T> getComparator() {
			Comparator<T> comparator = (Comparator<T>) ZERO_HUNDREDS_FIFTYS.getComparator()
					.thenComparing(AVERAGESCORE.getComparator());
			return comparator;
		}
	}
	;

	public abstract <T> Comparator<T> getComparator();
}
