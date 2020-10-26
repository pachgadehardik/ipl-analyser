package com.capg.iplanalysis.Service;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import com.capg.csvbuilder.CSVBuilderFactory;
import com.capg.csvbuilder.ICSVBuilder;
import com.capg.iplanalysis.Exceptions.IplAnalysisException;
import com.capg.iplanalysis.Exceptions.IplAnalysisException.IplExceptionType;
import com.capg.iplanalysis.Pojos.MostRuns;
import com.capg.iplanalysis.Pojos.MostWickets;
import com.capg.iplanalysis.Pojos.Player;
import com.capg.iplanalysis.enums.PlayerType;
import com.capg.iplanalysis.enums.SortingFieldType;
import com.capg.iplanalysis.interfaces.ISorting;
import com.google.gson.Gson;

public class IplAnalyser<T> {

	private static final Logger logger = LogManager.getLogger(IplAnalyser.class);
	List<T> playerStatsList;

//	public IplAnalyser(PlayerType playerType) {
//		this.playerType = playerType;
//	}

	public IplAnalyser() {}

	public <T> List<T> loadCSVFile(String iplMostRunsCsvFilePath, PlayerType playerType) throws IplAnalysisException {
		DOMConfigurator.configure("log4j.xml");

		try (Reader reader = Files.newBufferedReader(Paths.get(iplMostRunsCsvFilePath));) {
			ICSVBuilder csvBuilder = null;
			csvBuilder = CSVBuilderFactory.createCSVBuilder();
				playerStatsList = csvBuilder.getCSVFileList(reader, IplAnalyseBuilder.getClass(playerType));
			return (List<T>) playerStatsList;
		} catch (IOException e) {
			throw new IplAnalysisException(IplExceptionType.FILE_NOT_FOUND_TYPE, e.getMessage());
		} catch (RuntimeException r) {
			logger.error("Delimiter or header issue !!");
			throw new IplAnalysisException(IplExceptionType.DELIMITER_OR_HEADER_TYPE,
					"Runtime base Exception reagarding Delimiter or any Header Issue: " + r.getMessage());
		} catch (Exception E) {
			logger.error("Other Exception");
			throw new IplAnalysisException(IplExceptionType.OTHER_TYPE, E.getMessage());
		}

	}

	public List<T> getSortedDataByField(List<T> playerList, ISorting fieldType) throws IplAnalysisException {
		if (playerList == null || playerList.size() == 0)
			throw new IplAnalysisException(IplExceptionType.OTHER_TYPE, "DATA is Empty");
		Collections.sort(playerList, fieldType.getComparator());
		return (List<T>) playerList;
	}

	@SuppressWarnings("unchecked")
	public <T> String getCommonData(List<MostRuns> batsmenList, List<MostWickets> bowlersList,
			ISorting batsmanPlayername, ISorting bowlerPlayername) throws IplAnalysisException {

		batsmenList = (List<MostRuns>) new IplAnalyser().getSortedDataByField((List<T>) batsmenList,
				(ISorting) batsmanPlayername);
		bowlersList = (List<MostWickets>) new IplAnalyser().getSortedDataByField((List<T>) bowlersList,
				(ISorting) bowlerPlayername);

		List<Player> playerList = new ArrayList<Player>();
		int index = 0;
		for (MostRuns batsmen : batsmenList) {

			for (int i = index; i < bowlersList.size(); i++) {

				if (batsmen.getPlayer().contains(bowlersList.get(i).getPlayer())) {
					Player player = new Player(batsmen, bowlersList.get(i));
					playerList.add(player);
					index = i + 1;
				}

			}

		}
		return new Gson().toJson(playerList);
	}

}
