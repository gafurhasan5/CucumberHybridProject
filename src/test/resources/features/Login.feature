Feature: Login Functionality

  Scenario: Login with Valid Credentials
    Given User navigate to login page
    When User entered the valid email address "Rehankhan56390@gmail.com" into the email field
    And User entered the valid password "123456789" into the password field
    And User click the login button
    Then User should get  successfully  logged in

  Scenario: Login with invalid Credentials
    Given User navigate to login page
    When User entered the invalid email address into the email field
    And User entered the valid password "12345678998" into the password field
    And User click the login button
    Then User should get  proper warning message about credential mismatch

  Scenario: Login with Valid email and invalid password
    Given User navigate to login page
    When User entered the valid email address "Rehankhan56390@gmail.com" into the email field
    And User entered the invalid password "12345678998" into the password field
    And User click the login button
    Then User should get  proper warning message about credential mismatch

  Scenario: Login with invalid email and valid password
    Given User navigate to login page
    When User entered the invalid email address into the email field
    And User entered the valid password "123456789" into the password field
    And User click the login button
    Then User should get  proper warning message about credential mismatch

  Scenario: Login without any credentials
    Given User navigate to login page
    When User dont entered email into the email field
    And User dont entered password  into the password field
    And User click the login button
    Then User should get  proper warning message about credential mismatch
