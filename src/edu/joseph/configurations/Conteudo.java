package edu.joseph.configurations;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import edu.joseph.entites.Filmes;

public class Conteudo {
	
	private List<Filmes> listaFilmes; 
	
	public List<Filmes> listar (String json){
		
		//pega os itens de interesse
		var parser = new JsonParser();
		
	    List<Map<String, String>> listaDeAtributos = parser.parse(json);
	    
	    listaFilmes = new ArrayList<>();
	    
	    for (Map<String, String> itens: listaDeAtributos) {
	    	String title = itens.get("title");
	    	String image = itens.get("image");
	    	String imDbRating = itens.get("imDbRating");
	    	
	    	var filme = new Filmes(title, image, imDbRating);
	    	
	    	listaFilmes.add(filme);
	    	
	    }
	    
		return listaFilmes;
	}
	
	
	public List<Filmes> getListaFilmes() {
		return listaFilmes;
	}


	public void mostrarConteudo() {
		for(Filmes filme : getListaFilmes()) {
			System.out.println(filme.toString());
			System.out.println();
		}
	}
}
