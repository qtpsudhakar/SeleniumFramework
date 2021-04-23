Feature: browser automation 1

Background:
   * configure driver = { type: 'chromedriver', showDriverLog: false }

@login
Scenario: try to login to ohrm and then close browser

  Given driver 'https://opensource-demo.orangehrmlive.com/'
  And input("//input[@id='txtUsername']", 'admin')
  And input('#txtPassword', 'admin123')
  When submit().click("#btnLogin")
  Then waitForUrl('https://opensource-demo.orangehrmlive.com/index.php/dashboard')