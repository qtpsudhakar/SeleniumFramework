package com.cuc;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hook {

	
	@Before //before scenario
	public void beforeCtest(){
		System.out.println("precondition executed");
	}
	
	@After //after scenario
	public void afterCtest(){
		System.out.println("postcondition executed");
	}
}
