package edu.joseph.app;

import java.util.Scanner;

import edu.joseph.configurations.Acess;
import edu.joseph.configurations.Conteudo;
import edu.joseph.configurations.Leitor;

public class App {

	public static void main(String[] args) throws Exception {
	
		var sc = new Scanner(System.in);
		var leitor = new Leitor();
		var acess = new Acess();
		var conteudo = new Conteudo();
		
		while(true) {
			
			System.out.println("1 - Top 250 filmes");
			System.out.println("2 - Top 10 filmes");
			System.out.println("3 - top 3 series populares");
			System.out.println("4 - Sair");
			System.out.print("Escolha a opção de ranking que deseja ver:");
			String resp = sc.nextLine();
			leitor.lerOpcoes("C:\\Users\\josea\\OneDrive\\Documentos\\WorkSpace java\\imersao-java-alura-aula01\\rankingDeFilmes.txt");
		
			switch (resp) {
			
			case "1":
				String url = leitor.escolha(1);
				String json = acess.openFile(url);
				conteudo.listar(json);
				conteudo.mostrarConteudo();
				break;
				
			case "2":	
				url = leitor.escolha(2);
				json = acess.openFile(url);
				conteudo.listar(json);
				conteudo.mostrarConteudo();
				break;
				
			case "3":	
				url = leitor.escolha(3);
				json = acess.openFile(url);
				conteudo.listar(json);
				conteudo.mostrarConteudo();	
				break;
		     
			case "4":
				System.out.println("Aplicação encerrada.");
				System.exit(0);
				sc.close();
				break;
			
			default:
				System.out.println("Opção inválida.");
				break;	
			}
			
		}	
	}	
}

