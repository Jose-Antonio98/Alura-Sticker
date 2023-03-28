package edu.joseph.configurations;

import java.io.IOException;
import java.net.URI;
import java.net.http.*;
import java.net.http.HttpResponse.BodyHandlers;

public class Acess {

	public String openFile(String url) {

		try {

			URI address = URI.create(url);
			var client = HttpClient.newHttpClient();
			var request = HttpRequest.newBuilder(address).GET().build();
			HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
			String body = response.body();
			return body;

		} catch (IOException | InterruptedException ex) {
			throw new RuntimeException();
		}
	}
}
