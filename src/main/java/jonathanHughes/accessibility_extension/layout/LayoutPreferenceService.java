package jonathanHughes.accessibility_extension.layout;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.springframework.stereotype.Service;

@Service
public class LayoutPreferenceService {
	
	public LayoutPreferenceService() {
	}
	
	//{"userId":1, "url": "file:///D:/jonny/Documents/University/FinalYearProject/TestWebsite/TestWebsite.html"}
	public String getUserLayoutPreferenceFromPostrge(String userPrefJson) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:5000/GetSessionRuleSets"))
                .POST(HttpRequest.BodyPublishers.ofString(userPrefJson))
                .build();
        HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());
        return response.body();
	}
	
	public String saveCssRulesets(String SaveRuleset) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:5000/SaveRuleset"))
                .POST(HttpRequest.BodyPublishers.ofString(SaveRuleset))
                .build();
        HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());
        return response.body();
	}
	
	//{"userId":1, "url": "file:///D:/jonny/Documents/University/FinalYearProject/TestWebsite/TestWebsite.html", "ruleSetIdArray":34}
	public String saveWebpagePreference(String webpagePreference) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:5000/CreateWepagePreference"))
                .POST(HttpRequest.BodyPublishers.ofString(webpagePreference))
                .build();
        HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());
        return response.body();
	}
	
	//{"userId":1, "url": "file:///D:/jonny/Documents/University/FinalYearProject/TestWebsite/TestWebsite.html", "ruleSetIdArray":34}
	public String deleteWebpagePreference(String webpagePreference) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:5000/DeleteInjectionCssRules"))
                .POST(HttpRequest.BodyPublishers.ofString(webpagePreference))
                .build();
        HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());
        return response.body();
	}
	
//	public String saveCssRuleSetChanges(String SaveRuleset) throws IOException, InterruptedException {
//        HttpClient client = HttpClient.newHttpClient();
//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(URI.create("http://localhost:5000/SaveRuleset"))
//                .POST(HttpRequest.BodyPublishers.ofString(SaveRuleset))
//                .build();
//        HttpResponse<String> response = client.send(request,
//                HttpResponse.BodyHandlers.ofString());
//        return response.body();
//	}

}
