package edu.joseph.configurations;

import java.util.*;

import edu.joseph.entites.Movie;

public class Content {

	private List<Movie> listMovies;

	public List<Movie> list(String json) {

		var parser = new JsonParser();

		List<Map<String, String>> listOfAttributes = parser.parse(json);

		listMovies = new ArrayList<>();

		for (Map<String, String> items : listOfAttributes) {
			String title = items.get("title");
			String image = items.get("image");
			String imDbRating = items.get("imDbRating");

			var movie = new Movie(title, image, imDbRating);

			listMovies.add(movie);

		}

		return listMovies;
	}

	public List<Movie> getListMovies() {
		return listMovies;
	}

	public void showContent() {
		for (Movie movie : getListMovies()) {
			System.out.println(movie.toString());
			System.out.println();
		}
	}
}
