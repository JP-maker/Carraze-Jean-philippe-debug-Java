package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {		
	
	public static void main(String args[]) throws Exception {

		Map<String, Integer> listOfSymptoms = new HashMap<String, Integer>();
		Map<String, Integer> listOfSymptomsSorted = new HashMap<String, Integer>();
		
		// read symptoms from file
		ISymptomsWithCountReader reader = new ReadSymptomDataFromFile("Project02Eclipse/symptoms.txt");
		// get symptoms
		listOfSymptoms = reader.GetSymptoms();
		
		// sort symptoms
		listOfSymptomsSorted = sortSymptoms(listOfSymptoms);
		
		ISymptomWriter writer = new WriteSymptomsInFile("result.out");
		// write symptoms to file
		writer.writeSymptoms(listOfSymptomsSorted);
	}
	
	public static Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
		// Sort with TreeMap
        Map<String, Integer> sortedSymptoms = new TreeMap<>(symptoms);
		return sortedSymptoms;
	}
}
