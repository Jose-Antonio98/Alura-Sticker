package edu.joseph.actions;

import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

import edu.joseph.configurations.ExtractorImdb;

public class ConsumingAPI {

	private Reader reader;
	private Client client;
	private ExtractorImdb content;
	private StickerGenerator sticker;
	private Scanner read;

	public ConsumingAPI() {
		this.reader = new Reader();
		this.client = new Client();
		this.content = new ExtractorImdb();
		this.sticker = new StickerGenerator();
		this.read = new Scanner(System.in);
	}

	public String readData() {
		String text = read.nextLine();
		return text;
	}

	public void choiceAPI(String choice) {
		if (choice.equals("y")) {
			reader.readOptions("C:\\Users\\josea\\OneDrive\\Documentos" + "\\WorkSpace java\\imersao-java-alura-aula01"
					+ "\\entrada padrão\\rankingDeFilmes.txt");
		} else if (choice.equals("n")) {
			System.out.print("Enter with url: ");
			String url = readData();
			usingAPI(url);

		} else {
			System.out.println("Enter a valid option");
		}
	}

	public void usingAPI(int choice) {
		String url = reader.choice(choice);
		String json = client.connection(url);
		content.list(json);
		content.showContent();
	}

	private void usingAPI(String url) {
		client.connection(url);
		String json = client.connection(url);
		content.list(json);
		content.showContent();
	}

	public boolean generetSticker(int item, String fileName) {
		try {
			String image = content.choiceContent(item);
			String text = content.textRating(item);
			InputStream choiceContent = new URL(image).openStream();
			sticker.generate(choiceContent, fileName, text);
			return true;
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		return false;
	}
}
