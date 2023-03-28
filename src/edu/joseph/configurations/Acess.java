package edu.joseph.configurations;

import java.io.IOException;
import java.net.URI;
import java.net.http.*;
import java.net.http.HttpResponse.BodyHandlers;

public class Acess {
	
	public String openFile(String url) {
		
		try {
			
			URI endereco = URI.create(url);
		    var client = HttpClient.newHttpClient();
		    var request = HttpRequest.newBuilder(endereco).GET().build();
		    HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		    String body = response.body();
			return body;
			
		}catch (IOException | InterruptedException ex) {
			throw new RuntimeException();
		}
		
	}
	
	
	/*public static void main(String[] args) throws Exception {
		var acess = new Acess();
		String body = acess.openFile("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json");
		System.out.println(body);
	}
	*/
}
	

