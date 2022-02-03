Feature: Login to phptravels

  Scenario: User goes to Sign up page
  Given User goes to phptravel home page and press Sign up button
  When User fills in registration form and press Register button
  Then User cannot register without captcha

  Scenario: User login to his account
  Given User opens to phptravel home page
  When User press Login button
  And User fills login details
  Then User cannot login without captcha