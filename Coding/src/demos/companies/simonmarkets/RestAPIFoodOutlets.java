package demos.companies.simonmarkets;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.util.*;

import static java.util.stream.Collectors.joining;


class RestAPIFoodOutlets {

    /*
     * Complete the 'getRelevantFoodOutlets' function below.
     *
     * URL for cut and paste
     * https://jsonmock.hackerrank.com/api/food_outlets?city=<city>&page=<pageNumber>
     *
     * The function is expected to return an array of strings.
     * 
     * The function accepts a city argument (String) and maxCost argument(Integer).
     */
	private final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_1_1)
            .build();
	
    public List<String> getRelevantFoodOutlets(String city, int maxCost)  {
    	
    	List<String> result = new ArrayList<>();
    	
    	List<FoodOutlet> outlets = getFoodOutlets(city);
    	for(FoodOutlet outlet:outlets) {
    		if(maxCost > outlet.estimated_cost) result.add(outlet.name);
    	}
    	System.out.println(result);
    	return result;
    }
    private List<FoodOutlet> getFoodOutlets(String city) {
    	List<FoodOutlet> res = new ArrayList<>();
    	int page=1;
    	int total=Integer.MAX_VALUE;
    	String url = "https://jsonmock.hackerrank.com/api/food_outlets?city="+city+"&page=";
    	
    	while(page<total) {
    		String uri = url+page;
	    	HttpRequest request = HttpRequest.newBuilder()
	                .GET()
	                .uri(URI.create(uri))
	                .build();
	/*
	        try {
				HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
				String body = response.body();
				GSonFoodOutlet gsonBody = new Gson().fromJson(body, GSonFoodOutlet.class);
				res.addAll(gsonBody.data);
				page = gsonBody.page + 1;
				if(total==Integer.MAX_VALUE) total = gsonBody.total_pages;
			} catch (Exception e) {
				e.printStackTrace();
			}
	 */
    	}
        return res;
    }

    public static void main(String[] args) {
    	
    	RestAPIFoodOutlets rest = new RestAPIFoodOutlets();
    	rest.getRelevantFoodOutlets("Seattle", 20);
    }
}

class GSonFoodOutlet {
	
	public int page;
	public int per_page;
	public int total_pages;
	public List<FoodOutlet> data = new ArrayList<>();
	
}
class FoodOutlet {
	public String city;
	public String name;
	public int estimated_cost;
	public int id;
	
}
