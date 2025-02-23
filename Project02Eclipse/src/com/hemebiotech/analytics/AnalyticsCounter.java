package com.hemebiotech.analytics;

import java.util.Map;
import java.util.TreeMap;

/**
 * This class is used to count the number of occurrences of each symptom, sorting and write them to a file.
 */
public class AnalyticsCounter {	
	
	private ISymptomsWithCountReader reader;
	private ISymptomWriter writer;
	
	/**
	 * Constructor
	 * @param reader Interface to read symptoms
	 * @param writer Interface to write symptoms
	 * @throws Exception
	 */
	public AnalyticsCounter(ISymptomsWithCountReader reader, ISymptomWriter writer) throws Exception {
		this.reader = reader;
		this.writer = writer;
	}
	
	/**
	 * Get symptoms and their count
	 * @return Map<String, Integer> Symptoms and their count
	 * @throws Exception
	 */
	public Map<String, Integer> GetSymptomsAndCount() throws Exception {
		return this.reader.GetSymptomsAndCount();
	}
	
	/**
	 * Sort symptoms
	 * @param symptoms Symptoms to sort
	 * @return Map<String, Integer>
	 */
	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
		return new TreeMap<>(symptoms);
	}
	
	/**
	 * Write symptoms to file
	 * @param listOfSymptomsSorted Symptoms sorted to write to file
	 * @return boolean True if the symptoms are written to the file, false otherwise
	 * @throws Exception
	 */
	public boolean writeSymtpoms(Map<String, Integer> listOfSymptomsSorted) throws Exception {
		return this.writer.writeSymptoms(listOfSymptomsSorted);
	}
}
