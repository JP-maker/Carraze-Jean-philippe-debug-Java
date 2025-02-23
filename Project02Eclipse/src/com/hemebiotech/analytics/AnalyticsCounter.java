package com.hemebiotech.analytics;

import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {	
	
	private ISymptomsWithCountReader reader;
	private ISymptomWriter writer;
	
	/**
	 * Constructor
	 * @param reader
	 * @param writer
	 * @throws Exception
	 */
	public AnalyticsCounter(ISymptomsWithCountReader reader, ISymptomWriter writer) throws Exception {
		this.reader = reader;
		this.writer = writer;
	}
	
	/**
	 * Get symptoms and their count
	 * @return Map<String, Integer>
	 * @throws Exception
	 */
	public Map<String, Integer> GetSymptomsAndCount() throws Exception {
		return this.reader.GetSymptomsAndCount();
	}
	
	/**
	 * Sort symptoms
	 * @param symptoms
	 * @return Map<String, Integer>
	 */
	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
		return new TreeMap<>(symptoms);
	}
	
	/**
	 * Write symptoms to file
	 * @param listOfSymptomsSorted
	 * @return boolean
	 * @throws Exception
	 */
	public boolean writeSymtpoms(Map<String, Integer> listOfSymptomsSorted) throws Exception {
		return this.writer.writeSymptoms(listOfSymptomsSorted);
	}
}
