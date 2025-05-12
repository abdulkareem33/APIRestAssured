package day1;

import java.util.HashMap;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestApi {

	public static void main(String[] args) {
		
	/*	//Ex -1 (GET Request)
		
		//Create the Request Object
		RestAssured.baseURI="https://reqres.in";
		RequestSpecification requestObject = RestAssured.given();
		
		//Attach the Query Parameter
		requestObject.queryParam("Page", "2");
		
		//Attach the Headers
		requestObject.header("api-key", "reqres-free-v1");
		
		//Response Object
		Response response = requestSpecification.request(Method.GET,"api/users");
		
		//Get Response code
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
		
		//Get Response Body
		String asPrettyString = response.getBody().asPrettyString();
		System.out.println(asPrettyString);
	*/
		
	/*	//Ex -2 (GET Request)
		
		RestAssured.baseURI="https://reqres.in";
		RequestSpecification requestSpecification = RestAssured.given();
		
		requestSpecification.pathParam("id", "2");
		requestSpecification.header("api-key", "reqres-free-v1");
		
		Response responseObject = requestSpecification.request(Method.GET,"api/users/{id}");
		System.out.println(responseObject.getStatusCode());
		System.out.println(responseObject.getBody().asPrettyString());
	*/
		
	/*	//Ex - 3 (POST Request)
		
		RestAssured.baseURI="https://reqres.in";
		RequestSpecification requestSpecification = RestAssured.given();
		
		requestSpecification.header("api-key", "reqres-free-v1");
		
		//Attach the payload
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", "morpheous");
		jsonObject.put("job", "leader");
		requestSpecification.body(jsonObject.toJSONString());
		
		Response response = requestSpecification.request(Method.POST,"api/users");
		System.out.println(response.getStatusCode());
		System.out.println(response .getBody().asPrettyString());
	*/
		
	/*	//Ex - 4 (PUT Request)
		
		RestAssured.baseURI="https://reqres.in";
		RequestSpecification requestSpecification = RestAssured.given();
		
		//Attach the Payload
		HashMap<String, Object> hm = new HashMap<String, Object>();
		hm.put("name", "morpheous");
		hm.put("job", "zion-resident");
		requestSpecification.body(hm);
		
		requestSpecification.pathParam("id", "2");
		requestSpecification.header("api-key", "reqres-free-v1");
		
		Response response = requestSpecification.request(Method.PUT,"api/users/{id}");
		
		System.out.println(response.getStatusCode());
		System.out.println(response.getBody().asPrettyString());
	*/
		
		//Ex - 5 (Delete Request)
		
		RestAssured.baseURI="https://reqres.in";
		RequestSpecification requestSpecification = RestAssured.given();
		
		requestSpecification.pathParam("id","2");
		requestSpecification.header("api-key", "reqres-free-v1");
		
		Response response = requestSpecification.request(Method.DELETE,"api/users/{id}");
		System.out.println(response.getStatusCode());
		System.out.println(response.getBody().asPrettyString());
		
		
		}

}
