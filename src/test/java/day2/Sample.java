package day2;

import java.util.ArrayList;

public class Sample extends BaseClass {

	public static void main(String[] args) {
		
		requestObject("https://petstore.swagger.io");
		headers("Content-Type","application/json");
		ArrayList<Tags> tags = new ArrayList();
		Tags tags1 = new Tags(0,"String");
		tags.add(tags1);
		ArrayList<String> photoUrls = new ArrayList();
		photoUrls.add("String");
		Category category = new Category(0,"string");
		Root root = new Root(0, category, "doggie",photoUrls, tags,"available");
		requestSpecification.body(root);
		responseObject("POST","v2/pet");
		getResponseCode();
		getResponseBody();
		
		
		}

}
