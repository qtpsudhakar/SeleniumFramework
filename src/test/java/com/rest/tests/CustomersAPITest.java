package com.rest.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CustomersAPITest {
  @Test
  public void f() {
		RequestSpecification res = RestAssured.given();
		Response responce = res.request(Method.GET, "https://qtpsudhakar-customersapi.herokuapp.com/");
		String strJson = responce.body().asString();
		int rcode = responce.statusCode();
		System.out.println(rcode);
		Assert.assertEquals(rcode, 200, "Correct status code");
		
		System.out.println(responce.contentType());
		System.out.println(responce.statusLine());
	
  }
}
