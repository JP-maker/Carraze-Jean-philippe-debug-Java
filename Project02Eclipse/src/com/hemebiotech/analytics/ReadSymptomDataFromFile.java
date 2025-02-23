package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Read symptoms from a file and count the number of occurrences of each symptom
 *
 */
public class ReadSymptomDataFromFile implements ISymptomsWithCountReader {

	private String filepath;
	
	/**
	 * Constructor
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */
	public ReadSymptomDataFromFile (String filepath) {
		this.filepath = filepath;
	}
	
	/**
	 * Read symptoms from a file and count the number of occurrences of each symptom
	 * @return Map<String, Integer> Symptoms and their count
	 */
	@Override
	public Map<String, Integer> GetSymptomsAndCount() {
		Map<String, Integer> result = new HashMap<String, Integer>();
		
		if (filepath != null) {
			try {
				BufferedReader reader = new BufferedReader (new FileReader(filepath));
				String line = null;
				
				// read the file line by line
				while ((line = reader.readLine()) != null) {
					// add the symptom to the list if it is not already in it or increment its count if it is
					if (isSymptomInList(result, line)) {
						result.replace(line, result.get(line)+ 1);
					} else {
						result.put(line, 1);
					}
				}
				reader.close();
			}  catch (FileNotFoundException e) {
				System.out.println("Le fichier symptoms.txt n'existe pas.");
			} catch (IOException e) {
				System.out.println("Impossible de lire le fichier symptoms.txt.");
			}
		}
		
		return result;
	}
	
	/**
	 * Check if a symptom is already in the list
	 * @param symptoms Symptoms and their count
	 * @param symptom Symptom to check
	 * @return true if the symptom is in the list, false otherwise
	 */
	private Boolean isSymptomInList(Map<String, Integer> symptoms, String symptom) {
		Set<String> keys = symptoms.keySet();
		boolean isSymptomInList = false;
		for (String s : keys) {
			if (s.equals(symptom)) {
				isSymptomInList = true;
			}
		}
		return isSymptomInList;
	}

}
