package day2;

import java.util.HashMap;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseClass {
	
	public static RequestSpecification requestSpecification;
	public static Response response;
	
	// 1. User defined method
	// 2. Write Original business logic inside the user defined method
	// 3. Covert all inputs into Arguments and outputs into Return types
	
	// 1. Request Object
	public static void requestObject(String baseURI)
	{
		RestAssured.baseURI=baseURI;
		requestSpecification = RestAssured.given();
	}
	
	//2. Query Parameter
	public static void queryParameter(String parameterName, String parameterValue) 
	{
		requestSpecification.queryParam(parameterName, parameterValue);
	}
	
	//3. Path Parameter
	public static void pathParameter(String parameterName, String parameterValue) 
	{
		requestSpecification.pathParam(parameterName, parameterValue);
	}
	
	//4. Payload
	public static void payload(JSONObject jsonObject)
	{
		requestSpecification.body(jsonObject.toJSONString());
	}
	public static void payload(HashMap<String, Object> hm)
	{
		requestSpecification.body(hm);
	}
	
	//5. Headers
	public static void headers(String headerName, String headerValue)
	{
		requestSpecification.header(headerName, headerValue);
	}
	
	//6. Authentication Token
	public static void authentication(String userName, String password) 
	{
		requestSpecification.auth().basic(userName, password);
	}
	public static void authentication(String accessToken)
	{
		requestSpecification.auth().oauth2(accessToken);
	}
	
	//7. Response Object
	public static void responseObject(String requestType, String resources)
	{
		switch (requestType)
		{
		case "GET":{
			response = requestSpecification.request(Method.GET, resources);
			break;
		}
		case "POST":{
			response = requestSpecification.request(Method.POST, resources);
			break;
		}
		case "PUT":{
			response = requestSpecification.request(Method.PUT, resources);
			break;
		}
		default:{
			response = requestSpecification.request(Method.DELETE, resources);
		}
		}
	}
	
	// 8. Get the Response Code
	public static void getResponseCode()
	{
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
	}
	
	//9. get Response Body
	public static void getResponseBody()
	{
		String asPrettyString=response.getBody().asPrettyString();
		System.out.println(asPrettyString);
	}
	
	
}
