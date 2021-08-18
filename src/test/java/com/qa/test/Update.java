package com.qa.test;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;
import net.minidev.json.parser.ParseException;

public class Update {

		@Test
		public void SEARCHesponse() throws ParseException, org.json.simple.parser.ParseException{
			Fetch_Bearer_Token token=new Fetch_Bearer_Token();

			// 1:-Send GET Request along with Bearer Token
			RestAssured.baseURI = "https://hclconnectordev.dev.verify.ibmcloudsecurity.com/appaccess/v1.0/applications/3969541193480989262/instructionxml?protocol=saml";
			RequestSpecification getRequest = RestAssured.given();
			getRequest.header("Authorization", "Bearer " + token.getToken()).header("Content-Type", "application/json");

			// 2:-Store GET response (JSON Response) in response type Object
			Response searchResponse = getRequest
					.get("https://hclconnectordev.dev.verify.ibmcloudsecurity.com/appaccess/v1.0/applications/3969541193480989262/instructionxml?protocol=saml");
			
			//3:-Print Response
			searchResponse.prettyPrint();
			
			//3: Verify Status Code
			//int statusCode=templateResponse.statusCode();
			//System.out.println(statusCode);
			Assert.assertEquals(200, searchResponse.statusCode());
		}
		
	}


	
