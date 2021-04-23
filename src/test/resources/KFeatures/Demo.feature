Feature: sample karate api test script
  for help, see: https://github.com/intuit/karate/wiki/ZIP-Release

  Background:
    * url 'https://qtpsudhakar-customersapi.herokuapp.com'

	@testget
  Scenario: get all users and then get the first user by id
    Given path 'customers'
    When method get
    Then status 200

    * def customer1 = response[0]
    * print 'created id is: ', customer1