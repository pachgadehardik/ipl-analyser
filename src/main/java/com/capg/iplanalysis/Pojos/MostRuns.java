package com.capg.iplanalysis.Pojos;

import com.opencsv.bean.CsvBindByName;

public class MostRuns {

	@CsvBindByName(column = "POS", required = true) private String pos;
	@CsvBindByName(column = "PLAYER", required = true) private String player;
	@CsvBindByName(column = "Mat", required = true) private String mat;
	@CsvBindByName(column = "Inns", required = true) private String inns;
	@CsvBindByName(column = "NO", required = true) private String not_out;
	@CsvBindByName(column = "Runs", required = true) private String runs;
	@CsvBindByName(column = "HS", required = true) private String highScore;
	@CsvBindByName(column = "Avg", required = true) private String avg;
	@CsvBindByName(column = "BF", required = true) private String bf;
	@CsvBindByName(column = "100", required = true) private String hundreds;
	@Override
	public String toString() {
		return "MostRuns [pos=" + pos + ", player=" + player + ", mat=" + mat + ", inns=" + inns + ", not_out="
				+ not_out + ", runs=" + runs + ", highScore=" + highScore + ", avg=" + avg + ", bf=" + bf
				+ ", hundreds=" + hundreds + ", fiftys=" + fiftys + ", fours=" + fours + ", sixes=" + sixes + "]";
	}
	@CsvBindByName(column = "50", required = true) private String fiftys;
	@CsvBindByName(column = "4s", required = true) private String fours;
	@CsvBindByName(column = "6s", required = true) private String sixes;
	public String getPos() {
		return pos;
	}
	public void setPos(String pos) {
		this.pos = pos;
	}
	public String getPlayer() {
		return player;
	}
	public void setPlayer(String player) {
		this.player = player;
	}
	public String getMat() {
		return mat;
	}
	public void setMat(String mat) {
		this.mat = mat;
	}
	public String getInns() {
		return inns;
	}
	public void setInns(String inns) {
		this.inns = inns;
	}
	public String getNot_out() {
		return not_out;
	}
	public void setNot_out(String not_out) {
		this.not_out = not_out;
	}
	public String getRuns() {
		return runs;
	}
	public void setRuns(String runs) {
		this.runs = runs;
	}
	public String getHighScore() {
		return highScore;
	}
	public void setHighScore(String highScore) {
		this.highScore = highScore;
	}
	public String getAvg() {
		return avg;
	}
	public void setAvg(String avg) {
		this.avg = avg;
	}
	public String getBf() {
		return bf;
	}
	public void setBf(String bf) {
		this.bf = bf;
	}
	public String getHundreds() {
		return hundreds;
	}
	public void setHundreds(String hundreds) {
		this.hundreds = hundreds;
	}
	public String getFiftys() {
		return fiftys;
	}
	public void setFiftys(String fiftys) {
		this.fiftys = fiftys;
	}
	public String getFours() {
		return fours;
	}
	public void setFours(String fours) {
		this.fours = fours;
	}
	public String getSixes() {
		return sixes;
	}
	public void setSixes(String sixes) {
		this.sixes = sixes;
	}
	
	
	
}
