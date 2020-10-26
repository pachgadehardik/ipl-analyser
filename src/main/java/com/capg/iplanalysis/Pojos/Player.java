package com.capg.iplanalysis.Pojos;

public class Player {
	
	private MostRuns batsman;
	private MostWickets bowler;
	
	public Player(MostRuns batsman, MostWickets bowler) {
		this.batsman = batsman;
		this.bowler = bowler;
	}
	
	public MostRuns getBatsman() {
		return batsman;
	}
	public void setBatsman(MostRuns batsman) {
		this.batsman = batsman;
	}
	public MostWickets getBowler() {
		return bowler;
	}
	public void setBowler(MostWickets bowler) {
		this.bowler = bowler;
	}
	
}
