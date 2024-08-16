package demos.dataannotation.java.resttemplate;

import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;

public class SimpleApiClient {
    private static final String URL = "https://jsonplaceholder.typicode.com/posts";

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        try {
            ResponseEntity<String> response = restTemplate.getForEntity(URL, String.class);
            System.out.println("Response Body: " + response.getBody());
        } catch (HttpClientErrorException e) {
            System.err.println("Error in API request: " + e.getMessage());
        }
    }
}