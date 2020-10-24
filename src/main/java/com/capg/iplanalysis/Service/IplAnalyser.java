package com.capg.iplanalysis.Service;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import com.capg.csvbuilder.CSVBuilderFactory;
import com.capg.csvbuilder.ICSVBuilder;
import com.capg.iplanalysis.Exceptions.IplAnalysisException;
import com.capg.iplanalysis.Exceptions.IplAnalysisException.IplExceptionType;
import com.capg.iplanalysis.Pojos.MostRuns;
import com.capg.iplanalysis.Pojos.MostWickets;
import com.capg.iplanalysis.enums.PlayerType;
import com.capg.iplanalysis.enums.SortingFieldType;

public class IplAnalyser<T> {

	private PlayerType playerType;
	private static final Logger logger = LogManager.getLogger(IplAnalyser.class);
	List<T> playerStatsList;

	public IplAnalyser(PlayerType playerType) {
		this.playerType = playerType;
	}

	public <T> List<T> loadCSVFile(String iplMostRunsCsvFilePath) throws IplAnalysisException {
		DOMConfigurator.configure("log4j.xml");

		try (Reader reader = Files.newBufferedReader(Paths.get(iplMostRunsCsvFilePath));) {
			ICSVBuilder csvBuilder = null;

			csvBuilder = CSVBuilderFactory.createCSVBuilder();
			if (this.playerType == PlayerType.BATSMAN) {
				playerStatsList = csvBuilder.getCSVFileList(reader, MostRuns.class);
			}
			else if(this.playerType == PlayerType.BOWLER)
				playerStatsList = csvBuilder.getCSVFileList(reader, MostWickets.class);
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

	public List<T> getSortedDataByField(List<T> censusCSVList, SortingFieldType fieldType)
			throws IplAnalysisException {

		if (playerStatsList == null || playerStatsList.size() == 0)
			throw new IplAnalysisException(IplExceptionType.OTHER_TYPE, "DATA is Empty");
		Collections.sort(playerStatsList, fieldType.getComparator());
		return (List<T>) playerStatsList;
	}

}
