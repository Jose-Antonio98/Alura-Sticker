package edu.joseph.configurations;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class Leitor {
	
	private String path;
	private Map<String, String> opcoes;
	
	public Leitor() {
		opcoes = new HashMap<>();
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Map<String, String> getOpcoes() {
		return opcoes;
	}
	
	public Map<String, String> lerOpcoes(String path) {
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line = br.readLine();
			while (line != null) {
				
				String[] fields = line.split(",");
				String opcao = fields[0];
				String caminho = fields[1];

				opcoes.put(opcao, caminho);
				line = br.readLine();
			}
		}catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		return opcoes;
		
	}
	
	public String escolha(int escolha) {
		if (escolha == 1) {
			return opcoes.get("Top 250");
		}else if (escolha == 2) {
			return opcoes.get("Top 10");
		}else if (escolha == 3){
			return opcoes.get("Top 03 series");
		}else {
			return "Opção invalida";
		}
	}
}	
