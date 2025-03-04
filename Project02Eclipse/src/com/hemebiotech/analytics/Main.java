package com.hemebiotech.analytics;

public class Main {
	
	/**
	 * Main method
	 * @param args
	 */
	private static String FILE_SYMPTOMS_READER = "./symptoms.txt";
	private static String FILE_RESULT_PATH = "result.out";

	public static void main(String[] args) {
		try {
			AnalyticsCounter analyticsCounter = new AnalyticsCounter(new ReadSymptomDataFromFile(FILE_SYMPTOMS_READER), new WriteSymptomsInFile(FILE_RESULT_PATH));
			boolean result = analyticsCounter.writeSymtpoms(analyticsCounter.sortSymptoms(analyticsCounter.GetSymptomsAndCount()));
			if (result) {
				System.out.println("Le traitement est terminé avec succès.");
			} else {
				System.out.println("Une erreur s'est produite.");
			}
		} catch (Exception e) {
			System.out.println("Une erreur s'est produite: " + e.getMessage());
		}	
	}
}
