#Author: your.email@your.domain.com
Feature: this is a demo feature

@smoke
Scenario: to test login

	Given I have chrome browser
	And I opened login page
	When I enter username and password
	And I click on Login button
	Then I will see welcome page
	And I will close browser 
	
@Reg
Scenario: to test add employee

	Given I have chrome browser
	And I logged in to application
	When I click on PIM link
	And I click on Add Employee link
	Then I will see Add Employee page
	When I enter firstname and lastname
	And I click on save button
	Then I should see employee details page