Feature: Register Functionality

Scenario: User creates an account with mandatory fields
Given  User navigates to Register Account page
When  User enter the below details  into below fields
|firstName |Salman|
|lastName  |Khan|
|telephone |123456789|
|password  |12345|
And User click the Privacy Policy
And User click the register button
Then User account should get created Successfully

Scenario: User creates an account with all fields
Given  User navigates to Register Account page
When  User enter the below details  into below fields
|firstName |Salman|
|lastName  |Khan|
|telephone |123456789|
|password  |12345|
And select the newletter
And User click the Privacy Policy
And User click the register button
Then User account should get created Successfully

Scenario: User creates duplicate email 
Given  User navigates to Register Account page
When  User enter the below details  into below fields with duplicate email
|firstName |Salman|
|lastName  |Khan|
|email     |rehankhan56390@gmail.com|
|telephone |123456789|
|password  |12345|
And select the newletter
And User click the Privacy Policy
And User click the register button
Then User get warning message duplicate account

Scenario: User creates account filling any fields
Given  User navigates to Register Account page
When  User dont enter any fields
And User click the register button
Then User get warning message with mandatory field