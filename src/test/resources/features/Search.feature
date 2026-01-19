Feature: Search Functionality

Scenario: search valid Product
Given User opens the application
When User enter the valid product "HP" into Search box field
And  User click on search button
Then User should get valid product displayed in search results

Scenario: search invalid Product
Given User opens the application
When User enter the invalid product "Honda" into Search box field
And  User click on search button
Then User should get a message about no product matching

Scenario: search without any Product
Given User opens the application
When User dont enter any product name in search box field
And  User click on search button
Then User should get a message about no product matching