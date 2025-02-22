package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Anything that will write symptom data to a source
 * The important part is, the input value from the operation, which is a map of strings and integers,
 * 
 * The implementation does not need to order the list
 * 
 */
public interface ISymptomWriter {

	/**
	 * Write the symptoms in a file
	 * @param symptoms
	 */
	void writeSymptoms(Map<String, Integer> symptoms);
}
