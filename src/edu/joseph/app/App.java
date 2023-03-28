package edu.joseph.app;

import java.util.Scanner;

import edu.joseph.configurations.Acess;
import edu.joseph.configurations.Content;
import edu.joseph.configurations.Reader;

public class App {

	public static void main(String[] args) throws Exception {

		var sc = new Scanner(System.in);
		var reader = new Reader();
		var acess = new Acess();
		var content = new Content();

		while (true) {

			System.out.println("1 - Top 250 filmes");
			System.out.println("2 - Top 10 filmes");
			System.out.println("3 - top 3 series populares");
			System.out.println("4 - Sair");
			System.out.print("Escolha a opção de ranking que deseja ver: ");
			String resp = sc.nextLine();
			System.out.println();
			reader.readOptions(
					"C:\\Users\\josea\\OneDrive\\Documentos\\WorkSpace java\\imersao-java-alura-aula01\\rankingDeFilmes.txt");

			switch (resp) {

			case "1":
				String url = reader.choice(1);
				String json = acess.openFile(url);
				content.list(json);
				content.showContent();
				break;

			case "2":
				url = reader.choice(2);
				json = acess.openFile(url);
				content.list(json);
				content.showContent();
				break;

			case "3":
				url = reader.choice(3);
				json = acess.openFile(url);
				content.list(json);
				content.showContent();
				break;

			case "4":
				System.out.println("Application closed.");
				System.exit(0);
				sc.close();
				break;

			default:
				System.out.println("Invalid option.");
				break;
			}

		}
	}
}
