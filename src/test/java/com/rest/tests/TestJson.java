package com.rest.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestJson {
	@Test
	public void testGetMultiple() {
		RequestSpecification res = RestAssured.given();
		Response responce = res.request(Method.GET, "https://reqres.in/api/users?page=2");
		String strJson = responce.body().asString();
		int rcode = responce.statusCode();
		System.out.println(rcode);
		Assert.assertEquals(rcode, 200, "Correct status code");
		// 200 : OK, 404: not found
		System.out.println(responce.contentType());
		System.out.println(responce.statusLine());
		
		//extract data from json in gpath way
		//http://groovy-lang.org/processing-xml.html#_gpath
		//https://github.com/rest-assured/rest-assured/wiki/Usage#json-using-jsonpath
		io.restassured.path.json.JsonPath jp = responce.jsonPath();
		Object obj = jp.get("data.id");
		System.out.println(obj);
		
		//extract data from json in jsonpath way
		//https://github.com/json-path/JsonPath
		
		List<String> data = com.jayway.jsonpath.JsonPath.read(strJson, "data..id");
		System.out.println(data.size());
		System.out.println(data);
				
	}
}
