package com.rest.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestRests1 {
	@Test
	public void testGet() {
//	   Response responce= RestAssured.given()
//	  .when().get("https://reqres.in/api/users/2")
//	  .then().statusCode(200).extract().response();
//	   
//	   System.out.println(responce.body().asString());

		RequestSpecification res = RestAssured.given();
		Response responce = res.request(Method.GET, "https://reqres.in/api/users/13");
		System.out.println(responce.body().asString());
		int rcode = responce.statusCode();
		System.out.println(rcode);
		System.out.println(responce.contentType());
		System.out.println(responce.statusLine());
		Assert.assertEquals(rcode, 200, "Correct status code");
		// 200 : OK, 404: not found		

	}

	@Test
	public void testGetMultiple() {
		RequestSpecification res = RestAssured.given();
		Response responce = res.request(Method.GET, "https://reqres.in/api/users?page=13");
		System.out.println(responce.body().asString());
		int rcode = responce.statusCode();
		System.out.println(rcode);
		Assert.assertEquals(rcode, 200, "Correct status code");
		// 200 : OK, 404: not found
		System.out.println(responce.contentType());
		System.out.println(responce.statusLine());
//		responce.jsonPath();
		
	}

	
	@Test
	public void testGetWithParameters() {
		RestAssured.baseURI = "https://reqres.in/api/users";
		
		RequestSpecification res = RestAssured.given().queryParams("page", "2");
		
		Response responce = res.request(Method.GET);
		System.out.println(responce.body().asString());
		int rcode = responce.statusCode();
		System.out.println(rcode);
		Assert.assertEquals(rcode, 200, "Correct status code");
		// 200 : OK, 404: not found
		System.out.println(responce.contentType());
		System.out.println(responce.statusLine());
	}
	
	@Test
	public void createUser() {
		RestAssured.baseURI = "https://reqres.in/api/users";
		
		RequestSpecification res = RestAssured.given();
		String strJ = "{\"name\": \"morpheus\",\"job\": \"leader\"}";
		
		Response responce = res.body(strJ).request(Method.POST);
		String strJson = responce.body().asString();
		System.out.println(strJson);
		int rcode = responce.statusCode();
		System.out.println(rcode);
		Assert.assertEquals(rcode, 201, "Correct status code");
		// 200 : OK, 404: not found
		System.out.println(responce.contentType());
		System.out.println(responce.statusLine());
		
		String obj = JsonPath.read(strJson, "id");
		System.out.println(obj);
	}
	
	@Test
	public void createCustomer() {
		RestAssured.baseURI = "https://qtpsudhakar-customersapi.herokuapp.com/customers";
		
		RequestSpecification res = RestAssured.given();
		String strJ = "{\"id\":3,\"email\":\"selenium@qtpsudhakar.com\",\"name\":\"selenium\",\"active\":0}";
//		res.header("");
		Response responce = res.body(strJ).header("Content-Type","application/json").request(Method.POST);
		
		String strJson = responce.body().asString();
		System.out.println(strJson);
		int rcode = responce.statusCode();
		System.out.println(rcode);
		Assert.assertEquals(rcode, 200, "Correct status code");
		// 200 : OK, 404: not found
		System.out.println(responce.contentType());
		System.out.println(responce.statusLine());
		
		Object obj = JsonPath.read(strJson, "id");
		System.out.println(obj);
	}
	
	@Test
	public void updateCustomer() {
		RestAssured.baseURI = "https://qtpsudhakar-customersapi.herokuapp.com/customers/41";
		
		RequestSpecification res = RestAssured.given();
		String strJ = "{\"email\":\"selenium1234@qtpsudhakar.com\",\"name\":\"selenium\",\"active\":0}";
//		res.header("");
		Response responce = res.body(strJ).header("Content-Type","application/json").request(Method.PUT);
		
		String strJson = responce.body().asString();
		System.out.println(strJson);
		int rcode = responce.statusCode();
		System.out.println(rcode);
		Assert.assertEquals(rcode, 200, "Correct status code");
		// 200 : OK, 404: not found
		System.out.println(responce.contentType());
		System.out.println(responce.statusLine());
		
		Object obj = JsonPath.read(strJson, "id");
		System.out.println(obj);
	}
	@Test
	public void deleteCustomer() {
		RestAssured.baseURI = "https://qtpsudhakar-customersapi.herokuapp.com/customers/41";
		
//		RequestSpecification res = RestAssured.given().auth().basic("username", "password");
		RequestSpecification res = RestAssured.given();
//		RestAssured.given().auth().oauth(consumerKey, consumerSecret, accessToken, secretToken);
		
		Response responce = res.request(Method.DELETE);
		
		String strJson = responce.body().asString();
		System.out.println(strJson);
		int rcode = responce.statusCode();
		System.out.println(rcode);
		Assert.assertEquals(rcode, 200, "Correct status code");
		// 200 : OK, 404: not found
		System.out.println(responce.contentType());
		System.out.println(responce.statusLine());
		
	}
	
	@Test
	public void login() {
		RestAssured.baseURI = "https://reqres.in/api/login";
		
		RequestSpecification res = RestAssured.given();
		String strJ = "{\"email\": \"eve.holt@reqres.in\",\"password\": \"cityslicka\"}";
		
		Response responce = res.body(strJ).header("Content-Type","application/json").request(Method.POST);
//		Response responce = res.request(Method.POST);
		String strJson = responce.body().asString();
		System.out.println(strJson);
		int rcode = responce.statusCode();
		System.out.println(rcode);
		Assert.assertEquals(rcode, 200, "Correct status code");
		// 200 : OK, 404: not found
		System.out.println(responce.contentType());
		System.out.println(responce.statusLine());
		
		String obj = JsonPath.read(strJson, "token");
		System.out.println(obj);
	}
}
