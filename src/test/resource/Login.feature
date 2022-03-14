Feature: Login to phptravels

  Scenario: User tries to Sign up in phptravels
  Given User goes to phptravel home page and press Sign up button
  When User fills in registration form and press Register button
  Then User cannot register without captcha