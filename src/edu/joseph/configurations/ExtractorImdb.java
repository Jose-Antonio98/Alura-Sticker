package edu.joseph.configurations;

import java.util.*;

import edu.joseph.entites.Content;

public class ExtractorImdb implements Extractor {

	private List<Map<String, String>> listOfAttributes;

	public List<Content> list(String json) {

		var parser = new JsonParser();

		listOfAttributes = parser.parse(json);

		return listOfAttributes.stream()
				.map(attributes -> new Content(attributes.get("title"),
						attributes.get("image").replaceAll("(@+)(.*).jpg$", "$1.jpg"), attributes.get("imdbRating")))
				.toList();
	}

	public void showContent() {
		int counter = 1;
		for (Map<String, String> content : listOfAttributes) {
			System.out.println("ranking: " + counter++);
			System.out.println("Title: " + content.get("title") + "\nrating: " + content.get("imDbRating"));
			System.out.println();

		}
	}

	public String choiceContent(int item) {
		String image = listOfAttributes.get(item - 1).get("image");
		return image;
	}

	public String textRating(int item) {
		String rating = listOfAttributes.get(item - 1).get("imDbRating");
		double note = Math.round(Double.parseDouble(rating));
		if(note > 8) {
			return "Great";
		}else if(note >= 6) {
			return "Good";
		}else {
			return "bad";
		}
	}

}
