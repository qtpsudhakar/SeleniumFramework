package com.axatrikx.test;

import com.axatrikx.controller.RestExecutor;

public class TestRest {

	private static final String URL = "http://localhost:3000";

	public static void main(String[] args) {
		
		RestExecutor executor = new RestExecutor(URL);
		executor.get("").expectCode(200);
		
		executor.get("").getResponse();
	}

}
