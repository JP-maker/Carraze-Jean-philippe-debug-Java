package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.Map;

public class AnalyticsCounter {		
	
	public static void main(String args[]) throws Exception {

		Map<String, Integer> listOfSymptoms = new HashMap<String, Integer>();
		
		// read symptoms from file
		ISymptomsWithCountReader reader = new ReadSymptomDataFromFile("Project02Eclipse/symptoms.txt");
		// get symptoms
		listOfSymptoms = reader.GetSymptoms();
		
		System.out.println("Symptoms: " + listOfSymptoms);
		
		
		// next generate output
		/*
		FileWriter writer = new FileWriter ("result.out");
		writer.write("headache: " + headacheCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + pupilCount + "\n");
		writer.close();*/
	}
}
