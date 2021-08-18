package com.qa.test;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.minidev.json.parser.ParseException;

public class Fetch_Bearer_Token {
	@Test
	public String getToken() throws ParseException, org.json.simple.parser.ParseException {
		// 1:-Create Payload for POST request
		HashMap<String, String> payloadData = new HashMap<String, String>();
		payloadData.put("grant_type", "client_credentials");
		payloadData.put("scope", "openid");
		payloadData.put("client_id", "aeff47ef-7552-4d9d-965a-7db683f98294");
		payloadData.put("client_secret", "RVZO6lbsqZ");

		// 2:-Sending POST request and Storing the Response in response Object
		Response response = (Response) RestAssured.given()
				.contentType("application/x-www-form-urlencoded;charset=utf-8").formParams(payloadData).when()
				.accept("application/json")
				.post("https://hclconnectordev.dev.verify.ibmcloudsecurity.com/v1.0/endpoint/default/token");

		// 3:-Uncomment the below statement if you want to print Response on console
		//response.prettyPrint();

		// 4:-Convert JSON Response to String Object
		String jsonString = response.getBody().asString();

		// 5:-Extract & Print Bearer token from String Object
		String Bearer_Token = JsonPath.from(jsonString).get("access_token");
		//System.out.println("Bearer_Token : " + Bearer_Token);
		return Bearer_Token;
	

}
}