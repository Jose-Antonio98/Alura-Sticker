package edu.joseph.actions;

import java.io.IOException;
import java.net.URI;
import java.net.http.*;
import java.net.http.HttpResponse.BodyHandlers;

import edu.joseph.exception.ClientException;

public class Client {

	public String connection(String url) {
		try {

			URI address = URI.create(url);
			var client = HttpClient.newHttpClient();
			var request = HttpRequest.newBuilder(address).GET().build();
			HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
			return response.body();

		} catch (IOException | InterruptedException ex) {
			throw new ClientException("Error: url not found");
		}
	}
}
