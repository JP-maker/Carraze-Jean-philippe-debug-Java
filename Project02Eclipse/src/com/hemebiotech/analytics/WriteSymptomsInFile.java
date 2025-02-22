package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

public class WriteSymptomsInFile  {
	
	private String filepath;
	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */
	public void WriteSymptomDataToFile (String filepath) {
		this.filepath = filepath;
	}
	
	/**
	 * Write the symptoms in a file
	 * @param symptoms
	 */
	public void WriteSymptoms(Map<String, Integer> symptoms) {
		if (filepath != null) {
			try {
				FileWriter writer = new FileWriter (filepath);
				Set<String> keys = symptoms.keySet();
				for (String key : keys) {
					writer.write(key + ": " + symptoms.get(key) + "\n");
				}
				writer.close();
			} catch (IOException e) {
				System.out.println("Impossible d'écrire dans le fichier " + filepath);
			}
		}	
	}
}
