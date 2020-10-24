package com.capg.iplanalysis.ipl_analysis;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

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
	 * @throws IplAnalysisException
	 * Top BOwling Average
	 */
	@Test
	public void givenCSVWicketsFile_ShouldReturnTopBowlingAvg() throws IplAnalysisException {
		listWickets = iplAnalyser.getSortedDataByField(listWickets, SortingFieldType.BOWLING_AVERAGE);
		System.out.println("PLayer woth less bowling average: "+listWickets.get(0));
		assertEquals(11, Double.valueOf(listWickets.get(0).getAvg()));
	}
	
	
	
}
