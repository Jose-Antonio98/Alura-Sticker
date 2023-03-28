package edu.joseph.entites;

public class Movie {

	private String title;
	private String image;
	private String imDbRating;

	public Movie(String title, String image, String imDbRating) {
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
		return "\u001b[1mTitle:\u001b[m " + title + "\n" 
				+ "\u001b[1mImage:\u001b[m " + image + "\n" 
				+ "\u001b[1mImDbRating:\u001b[m " + imDbRating;
	}

}
