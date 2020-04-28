package jonathanHughes.accessibility_extension.user;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	HttpClient client = HttpClient.newHttpClient();
	
	HttpRequest request;
	
	public HttpResponse<String> getUserPreference(final String ID) throws IOException, InterruptedException {
		request = HttpRequest.newBuilder()
				.uri(URI.create("http://localhost:8090/mongodb/userPref/" + ID)).build();
		HttpResponse<String> responseText = client.send(request, HttpResponse.BodyHandlers.ofString());
		return responseText;
	}
	
	public String getUserId(final String ID) throws IOException, InterruptedException {
		request = HttpRequest.newBuilder()
				.uri(URI.create("http://localhost:5000/GetUser?id=" + ID)).build();
		HttpResponse<String> responseText = client.send(request, HttpResponse.BodyHandlers.ofString());
		return responseText.body();
	}
	
	public String createUser() throws IOException, InterruptedException {
		request = HttpRequest.newBuilder()
				.uri(URI.create("http://localhost:5000/CreateUser")).build();
		HttpResponse<String> responseText = client.send(request, HttpResponse.BodyHandlers.ofString());
		return responseText.body();
	}

	public String createUser(long userId) throws IOException, InterruptedException {
		request = HttpRequest.newBuilder()
				.uri(URI.create("http://localhost:5000/CreateUser?id=" + userId)).build();
		HttpResponse<String> responseText = client.send(request, HttpResponse.BodyHandlers.ofString());
		return responseText.body();
	}

}