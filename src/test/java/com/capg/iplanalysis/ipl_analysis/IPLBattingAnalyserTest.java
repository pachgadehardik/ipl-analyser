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
import com.google.gson.Gson;

public class IPLBattingAnalyserTest {

	private static final String IPL_MOST_RUNS_CSV_FILE_PATH = "H:\\Capgemini\\Capg_Training\\ipl-analysis\\src\\main\\java\\Resources\\MostRuns.csv";

	List<MostRuns> listRuns;
	IplAnalyser iplAnalyser;

	@BeforeEach
	public void init() throws IplAnalysisException {
		iplAnalyser = new IplAnalyser();
		listRuns = iplAnalyser.loadCSVFile(IPL_MOST_RUNS_CSV_FILE_PATH,PlayerType.BATSMAN);
	}

	/**
	 * @throws IplAnalysisException Checks whether Files is uploaded
	 */
	@Test
	public void givenCSVRunsFIle_ShouldReturnRecords() throws IplAnalysisException {
		assertEquals(100, listRuns.size());
	}

	/**
	 * @throws IplAnalysisException Check for Highest Average Score
	 * Used GSON to store the data in json format
	 */
	@Test
	public void givenCSVRunsFile_ShouldReturnHighestAverageScore() throws IplAnalysisException {
		listRuns = iplAnalyser.getSortedDataByField(listRuns, SortingFieldType.AVERAGESCORE);
		System.out.println("Player with Highest Strike Average Score is :" + listRuns.get(0));
		String toJSon = new Gson().toJson(listRuns);
        MostRuns[] mostRuns = new Gson().fromJson(toJSon, MostRuns[].class);
		assertEquals(83.2, Double.valueOf(mostRuns[0].getAvg()));
	}

	/**
	 * @throws IplAnalysisException check for top Strike Rate
	 */
	@Test
	public void givenCSVRunsFile_ShouldReturnTopStrikingRates() throws IplAnalysisException {
		listRuns = iplAnalyser.getSortedDataByField(listRuns, SortingFieldType.STRIKERATE);
		System.out.println("Player with Highest Strike Rate is :" + listRuns.get(0));
		assertEquals(333.33, Double.valueOf(listRuns.get(0).getSr()));
	}

	/**
	 * @throws IplAnalysisException Checking Maximum Boundaries
	 */
	@Test
	public void givenCSVRunsFile_ShouldReturnMaximumBoundaries() throws IplAnalysisException {
		listRuns = iplAnalyser.getSortedDataByField(listRuns, SortingFieldType.BOUNDARIES);
		System.out.println("Player With Max Boundaries; " + listRuns.get(0));
		assertEquals(83, Double.valueOf(listRuns.get(0).getFours()) + Double.valueOf(listRuns.get(0).getSixes()));
	}

	/**
	 * @throws IplAnalysisException Checking BEstStrikeRate with Max Boundaries
	 */
	@Test
	public void givenCSVRunsFile_ShouldReturnBestStrikeRateWIthBoundaries() throws IplAnalysisException {
		listRuns = iplAnalyser.getSortedDataByField(listRuns, SortingFieldType.BEST_STRIKERATE_WITH_BOUNDARIES);
		System.out.println("Player With BEstStrikeRate and Max Boundaries; " + listRuns.get(0));
		assertEquals("Andre Russell", listRuns.get(0).getPlayer());
	}

	/**
	 * @throws IplAnalysisException GreatAveragesWithStrikeRate
	 */
	@Test
	public void givenCSVRunsFile_ShouldReturnGreatAveragesWithStrikeRate() throws IplAnalysisException {
		listRuns = iplAnalyser.getSortedDataByField(listRuns, SortingFieldType.GREAT_AVERAGE_WITH_STRIKERATE);
		System.out.println("Player With Great Average and Max Strike Rate; " + listRuns.get(0));
		assertEquals("MS Dhoni", listRuns.get(0).getPlayer());
	}

	/**
	 * @throws IplAnalysisException MAXRunsWithAverage
	 */
	@Test
	public void givenCSVRunsFile_ShouldReturnMAXRunsWithAverage() throws IplAnalysisException {
		listRuns = iplAnalyser.getSortedDataByField(listRuns, SortingFieldType.MAX_RUNS_WITH_BEST_AVERAGE);
		System.out.println("Player With Great Average and Max Strike Rate; " + listRuns.get(0));
		assertEquals("David Warner", listRuns.get(0).getPlayer());
	}
	
	/**
	 * @throws IplAnalysisException
	 * MAX100sWithBestAverage
	 */
	@Test
	public void givenCSVRunsFile_ShouldReturnMAX100sWithBestAverage() throws IplAnalysisException {
		listRuns = iplAnalyser.getSortedDataByField(listRuns, SortingFieldType.MAXIMUM_HUNDREDS_WITH_BESTAVG);
		System.out.println("Player With MAX 100s and Max Avg: " + listRuns.get(0));
		assertEquals("David Warner", listRuns.get(0).getPlayer());
	}
	
	/**
	 * @throws IplAnalysisException
	 * BestAverageWithoutCenturies
	 */
	@Test
	public void givenCSVRunsFile_ShouldReturnPlayersWithBestAverageWithoutCenturies() throws IplAnalysisException {
		listRuns = iplAnalyser.getSortedDataByField(listRuns, SortingFieldType.ZERO_HUNDREDSFIFTYS_BEST_AVG);
		System.out.println("Player With 0 100s and Max Avg: " + listRuns.get(0));
		assertEquals("Marcus Stoinis", listRuns.get(0).getPlayer());
	}
	

}
