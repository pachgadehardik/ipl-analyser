package com.capg.iplanalysis.Pojos;

import com.opencsv.bean.CsvBindByName;

public class MostWickets {
	
	@CsvBindByName(column = "POS", required = true) private String pos;
	@CsvBindByName(column = "PLAYER", required = true) private String player;
	@CsvBindByName(column = "Mat", required = true) private String mat;
	@CsvBindByName(column = "Inns", required = true) private String inns;
	@CsvBindByName(column = "Ov", required = true) private String noOfOvers;
	@CsvBindByName(column = "Runs", required = true) private String runs;
	@CsvBindByName(column = "Wkts", required = true) private String wkts;
	@CsvBindByName(column = "BBI", required = true) private String bbi;
	@CsvBindByName(column = "Avg", required = true) private String avg;
	@CsvBindByName(column = "Econ", required = true) private String econ;
	@CsvBindByName(column = "SR", required = true) private String sr;
	@CsvBindByName(column = "4w", required = true) private String fourWickets;
	@CsvBindByName(column = "5w", required = true) private String fiveWickets;
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
	public String getNoOfOvers() {
		return noOfOvers;
	}
	public void setNoOfOvers(String noOfOvers) {
		this.noOfOvers = noOfOvers;
	}
	public String getRuns() {
		return runs;
	}
	public void setRuns(String runs) {
		this.runs = runs;
	}
	public String getWkts() {
		return wkts;
	}
	public void setWkts(String wkts) {
		this.wkts = wkts;
	}
	public String getBbi() {
		return bbi;
	}
	public void setBbi(String bbi) {
		this.bbi = bbi;
	}
	public String getAvg() {
		
		return avg;
	}
	public void setAvg(String avg) {
		this.avg = avg.contains("-") ? "0" : avg;
	}
	public String getEcon() {
		return econ;
	}
	public void setEcon(String econ) {
		this.econ = econ;
	}
	public String getSr() {
		return sr;
	}
	public void setSr(String sr) {
		this.sr = sr;
	}
	public String getFourWickets() {
		return fourWickets;
	}
	public void setFourWickets(String fourWickets) {
		this.fourWickets = fourWickets;
	}
	public String getFiveWickets() {
		return fiveWickets;
	}
	public void setFiveWickets(String fiveWickets) {
		this.fiveWickets = fiveWickets;
	}
	@Override
	public String toString() {
		return "MostWickets [pos=" + pos + ", player=" + player + ", mat=" + mat + ", inns=" + inns + ", noOfOvers="
				+ noOfOvers + ", runs=" + runs + ", wkts=" + wkts + ", bbi=" + bbi + ", avg=" + avg + ", econ=" + econ
				+ ", sr=" + sr + ", fourWickets=" + fourWickets + ", fiveWickets=" + fiveWickets + "]";
	}
	
	
	
}
