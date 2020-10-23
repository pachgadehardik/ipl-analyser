package com.capg.iplanalysis.ipl_analysis;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.capg.iplanalysis.Exceptions.IplAnalysisException;
import com.capg.iplanalysis.Pojos.MostRuns;
import com.capg.iplanalysis.Service.IplAnalyser;
import com.capg.iplanalysis.enums.PlayerType;
import com.capg.iplanalysis.enums.SortingFieldType;

public class IPLAnalyserTest {

	private static final String IPL_MOST_RUNS_CSV_FILE_PATH = "H:\\Capgemini\\Capg_Training\\ipl-analysis\\src\\main\\java\\Resources\\MostRuns.csv";
	List<MostRuns> listRuns;
	IplAnalyser iplAnalyser;

	@BeforeEach
	public void init() throws IplAnalysisException {
		iplAnalyser = new IplAnalyser(PlayerType.BATSMAN);
		listRuns = iplAnalyser.loadCSVFile(IPL_MOST_RUNS_CSV_FILE_PATH);
	}

	/**
	 * @throws IplAnalysisException
	 * Checks whether Files is uploaded
	 */
	@Test
	public void givenCSVRunsFIle_ShouldReturnRecords() throws IplAnalysisException {
		assertEquals(100, listRuns.size());
	}

	/**
	 * @throws IplAnalysisException
	 * Check for Highest Average Score
	 */
	@Test
	public void givenCSVRunsFile_ShouldReturnHighestAverageScore() throws IplAnalysisException {
		listRuns = iplAnalyser.getSortedDataByField(listRuns, SortingFieldType.AVERAGESCORE);
		System.out.println("Player with Highest Strike Average Score is :"+listRuns.get(0));
		assertEquals(83.2, Double.valueOf(listRuns.get(0).getAvg()));
	}
	
	/**
	 * @throws IplAnalysisException
	 * check for top Strike Rate
	 */
	@Test
	public void givenCSVRunsFile_ShouldReturnTopStrikingRates() throws IplAnalysisException {
		listRuns = iplAnalyser.getSortedDataByField(listRuns,SortingFieldType.STRIKERATE);
		System.out.println("Player with Highest Strike Rate is :"+listRuns.get(0));
		assertEquals(333.33, Double.valueOf(listRuns.get(0).getSr()));
	}
	
	/**
	 * @throws IplAnalysisException
	 * Checking Maximum Boundaries 
	 */
	@Test
	public void	givenCSVRunsFile_ShouldReturnMaximumBoundaries() throws IplAnalysisException {
		listRuns = iplAnalyser.getSortedDataByField(listRuns,SortingFieldType.BOUNDARIES);
		System.out.println("Player With Max Boundaries; "+listRuns.get(0));
		assertEquals(83, Double.valueOf(listRuns.get(0).getFours())+Double.valueOf(listRuns.get(0).getSixes()));
	}
	
	/**
	 * @throws IplAnalysisException
	 * Checking BEstStrikeRate with Max Boundaries
	 */
	@Test
	public void givenCSVRunsFile_ShouldReturnBestStrikeRateWIthBoundaries() throws IplAnalysisException {
		listRuns = iplAnalyser.getSortedDataByField(listRuns,SortingFieldType.BEST_STRIKERATE_WITH_BOUNDARIES);
		System.out.println("Player With BEstStrikeRate and Max Boundaries; "+listRuns.get(0));
		assertEquals("Andre Russell", listRuns.get(0).getPlayer());
	}
	
	

}
