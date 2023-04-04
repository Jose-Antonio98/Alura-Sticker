package edu.joseph.configurations;

import java.util.List;

import edu.joseph.entites.Content;

public interface Extractor {

	List<Content> list(String json);
	void showContent();
	public String choiceContent(int item);
}
