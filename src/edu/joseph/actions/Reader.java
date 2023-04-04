package edu.joseph.actions;

import java.io.*;
import java.util.*;

public class Reader {
	
	private Map<String, String> options;

	public Reader() {
		options = new HashMap<>();
	}

	public Map<String, String> readOptions(String path) {

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line = br.readLine();
			while (line != null) {

				String[] fields = line.split(",");
				String value = fields[0];
				String urlPath = fields[1];

				options.put(value, urlPath);
				line = br.readLine();
			}
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		return options;

	}

	public String choice(int choice) {
		if (choice == 1) {
			return options.get("Top 250");
		} else if (choice == 2) {
			return options.get("Top 10");
		} else if (choice == 3) {
			return options.get("Top 03 series");
		} else {
			return "Invalid option";
		}
	}

}
