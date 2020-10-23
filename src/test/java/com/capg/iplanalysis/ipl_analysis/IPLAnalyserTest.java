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

	@Test
	public void givenCSVRunsFIle_ShouldReturnRecords() throws IplAnalysisException {
		assertEquals(100, listRuns.size());
	}

	@Test
	public void givenCSVRunsFile_ShouldReturnHighestAverageScore() throws IplAnalysisException {
		listRuns = iplAnalyser.getSortedDataByField(listRuns, SortingFieldType.AVERAGESCORE);
		assertEquals(83.2, Double.valueOf(listRuns.get(0).getAvg()));
	}

}
