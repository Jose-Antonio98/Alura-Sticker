package edu.joseph.entites;

public class Filmes {
	
	private String title;
	private String image;
	private String imDbRating;
	
	public Filmes(String title, String image, String imDbRating) {
		this.title = title;
		this.image = image;
		this.imDbRating = imDbRating;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getImDbRating() {
		return imDbRating;
	}

	public void setImDbRating(String imDbRating) {
		this.imDbRating = imDbRating;
	}

	@Override
	public String toString() {
		return "Title: " + title + "\n"
				+ "Image: " + image + "\n"
				+ "ImDbRating=" + imDbRating;
	}
	
	
}
