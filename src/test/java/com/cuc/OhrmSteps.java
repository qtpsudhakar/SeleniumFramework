package com.cuc;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OhrmSteps {

	@Given("^I launch the chrome browser$")
	public void OpenBrowser() {
		
		System.out.println("Launched the chrome browser");
	}

	@Given("^I enter OrangeHRM Url$")
	public void NavigateToOhrm() {
		System.out.println("Orange Hrm Application launched");
	}

	@When("^I enter the username$")
	public void enterUserName() {
		System.out.println("Entered the username");
	}
	@When("^I enter the password$")
	public void enterPassword() {
		System.out.println("Entered the Password");
	}
	
	@When("^I click on Login button$")
	public void clickOnLoginButton() {
		System.out.println("Clicked On login Button");
	}
	
	@Then("^I will see the welcome page$")
	public void verifyWelcomePageOpened(){
		System.out.println("Welcome page opened");
	}
	
	@Then("^I will the close Browser$")
	public void closeBrowser(){
		System.out.println("Welcome page opened");
	}
	
}
