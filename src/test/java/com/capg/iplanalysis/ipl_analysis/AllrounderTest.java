package com.capg.iplanalysis.ipl_analysis;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.capg.iplanalysis.Exceptions.IplAnalysisException;
import com.capg.iplanalysis.Pojos.MostRuns;
import com.capg.iplanalysis.Pojos.MostWickets;
import com.capg.iplanalysis.Pojos.Player;
import com.capg.iplanalysis.Service.IplAnalyser;
import com.capg.iplanalysis.enums.PlayerEnum;
import com.capg.iplanalysis.enums.PlayerType;
import com.capg.iplanalysis.enums.SortingFieldType;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class AllrounderTest {

	private static final String IPL_MOST_WICKETS_CSV_FILE_PATH = "H:\\Capgemini\\Capg_Training\\ipl-analysis\\src\\main\\java\\Resources\\MostWickets.csv";
	private static final String IPL_MOST_RUNS_CSV_FILE_PATH = "H:\\Capgemini\\Capg_Training\\ipl-analysis\\src\\main\\java\\Resources\\MostRuns.csv";

	private static List<MostWickets> bowlersList;
	private static List<MostRuns> batsmenList;
//	
	@BeforeClass
	public static void setup() throws IplAnalysisException  {
		batsmenList = new IplAnalyser().loadCSVFile(IPL_MOST_RUNS_CSV_FILE_PATH,PlayerType.BATSMAN);
		bowlersList =  new IplAnalyser().loadCSVFile(IPL_MOST_WICKETS_CSV_FILE_PATH,PlayerType.BOWLER);
		System.out.println(batsmenList);
	}
	
	
	/**
	 * @throws IplAnalysisException
	 * Testing the best Allrounder with Most Runs and Wickets
	 * 
	 */
	@Test
	public void givenBatsmenBowlerList_ShouldReturnPlayer_WithBestRunsWickets() throws IplAnalysisException {

		@SuppressWarnings("unchecked")
		Player[] playerArr = new Gson().fromJson(new IplAnalyser().getCommonData(batsmenList, bowlersList,
				SortingFieldType.BATSMAN_PLAYERNAME, SortingFieldType.BOWLER_PLAYERNAME), Player[].class);
		playerArr = (Player[]) new IplAnalyser().getSortedDataByField(Arrays.asList(playerArr), PlayerEnum.ALLROUNDER_WITH_RUNS_WICKETS)
				.toArray();
		assertEquals("Andre Russell", playerArr[0].getBatsman().getPlayer());
	}

	@Test
	public void givenBatsmanBowlersList_ShouldReturnPlayer_WithBestBAttingBowlingAvg() throws JsonSyntaxException, IplAnalysisException {
		@SuppressWarnings("unchecked")
		Player[] playerArr = new Gson().fromJson(new IplAnalyser().getCommonData(batsmenList, bowlersList,
				SortingFieldType.BATSMAN_PLAYERNAME, SortingFieldType.BOWLER_PLAYERNAME), Player[].class);
		playerArr = (Player[]) new IplAnalyser().getSortedDataByField(Arrays.asList(playerArr), PlayerEnum.ALLROUNDER_WITH_AVERAGES)
				.toArray();
		System.out.println(playerArr[0].getBatsman().getAvg());
		assertEquals("Krishnappa Gowtham", playerArr[0].getBatsman().getPlayer());
	}
	
}
