package com.capg.iplanalysis.ipl_analysis;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import com.capg.iplanalysis.Exceptions.IplAnalysisException;
import com.capg.iplanalysis.Pojos.MostWickets;
import com.capg.iplanalysis.Service.IplAnalyser;
import com.capg.iplanalysis.enums.PlayerType;
import com.capg.iplanalysis.enums.SortingFieldType;

public class IPLBowlingAnalyserTest {

	private static final String IPL_MOST_WICKETS_CSV_FILE_PATH = "H:\\Capgemini\\Capg_Training\\ipl-analysis\\src\\main\\java\\Resources\\MostWickets.csv";

	List<MostWickets> listWickets;
	IplAnalyser iplAnalyser;

	@Before
	public void init() throws IplAnalysisException {
		iplAnalyser = new IplAnalyser(PlayerType.BOWLER);
		listWickets = iplAnalyser.loadCSVFile(IPL_MOST_WICKETS_CSV_FILE_PATH);
	}

	@Test
	public void givenCSVWicketsFile_ShouldReturnrecords() throws IplAnalysisException {
		assertEquals(99, listWickets.size());
	}

	/**
	 * @throws IplAnalysisException Top BOwling Average
	 */
	@Test
	public void givenCSVWicketsFile_ShouldReturnTopBowlingAvg() throws IplAnalysisException {
		listWickets = iplAnalyser.getSortedDataByField(listWickets, SortingFieldType.BOWLING_AVERAGE);
		System.out.println("PLayer woth less bowling average: " + listWickets.get(0));
		assertEquals(11, Double.valueOf(listWickets.get(0).getAvg()));
	}

	/**
	 * @throws IplAnalysisException
	 * @throws NumberFormatException
	 * Top Bowling Strike Rate
	 */
	@Test
	public void givenCSVWicketsFile_ShouldReturnTopBowlingSR() throws IplAnalysisException,NumberFormatException {
		listWickets = iplAnalyser.getSortedDataByField(listWickets, SortingFieldType.BOWLING_SR);
		System.out.println("PLayer with Top SR: " + listWickets.get(0));
		assertEquals(8.66, Double.valueOf(listWickets.get(0).getSr()));
	}
	
	/**
	 * @throws IplAnalysisException
	 * @throws NumberFormatException
	 * Best Economy Rate
	 */
	@Test
	public void givenCSVWicketsFile_ShouldReturnBestEconomyRate() throws IplAnalysisException,NumberFormatException {
		listWickets = iplAnalyser.getSortedDataByField(listWickets, SortingFieldType.ECONOMY_RATE);
		System.out.println("PLayer with Top Economy: " + listWickets.get(0));
		assertEquals(4.8, Double.valueOf(listWickets.get(0).getEcon()));
	}
	
	/**
	 * @throws IplAnalysisException
	 * @throws NumberFormatException
	 * BestStrikeRateWith5Wand4W
	 */
	@Test
	public void givenCSVWicketsFile_ShouldReturnBestStrikeRateWith5Wand4W() throws IplAnalysisException,NumberFormatException {
		listWickets = iplAnalyser.getSortedDataByField(listWickets, SortingFieldType.STRIKE_RATE_WITH_5W4W);
		System.out.println("PLayer with Top Economy: " + listWickets.get(0));
		assertEquals("Kagiso Rabada", listWickets.get(0).getPlayer());
	}
	
	/**
	 * @throws IplAnalysisException
	 * @throws NumberFormatException
	 * BowlingAveragesWithStrikeRate
	 */
	
	@Test
	public void givenCSVWicketsFile_ShouldReturnBowlingAveragesWithStrikeRate() throws IplAnalysisException,NumberFormatException {
		listWickets = iplAnalyser.getSortedDataByField(listWickets, SortingFieldType.BOWLING_AVERAGE_WITH_SR);
		System.out.println("PLayer with Top Economy: " + listWickets.get(0));
		assertEquals("Alzarri Joseph", listWickets.get(0).getPlayer());
	}
	
	/**
	 * @throws IplAnalysisException
	 * @throws NumberFormatException
	 * MaximumWicketsWithBestAVG
	 */
	@Test
	public void givenCSVWicketsFile_ShouldReturnMaximumWicketsWithBestAVG() throws IplAnalysisException,NumberFormatException {
		listWickets = iplAnalyser.getSortedDataByField(listWickets, SortingFieldType.MAXIMUM_WICKETS_WITH_AVERAGE);
		System.out.println("PLayer with Top Economy: " + listWickets.get(0));
		assertEquals("Anukul Roy", listWickets.get(0).getPlayer());
	}
	
	
	
	

}
