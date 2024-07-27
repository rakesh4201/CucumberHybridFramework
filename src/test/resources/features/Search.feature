Feature: Search functionality

Scenario: User searches for valid product
Given User opens the application
When User enters valid product "HP" into search box filed
And User clicks on Search button
Then User should get valid product displayed in search results

Scenario: User searches for invalid product
Given User opens the application
When User enters invalid product "Honda" into search box filed
And User clicks on Search button
Then User should get a message about no product matching

Scenario: User searches without any product
Given User opens the application
When User donesnt enter any product name in search box filed
And User clicks on Search button
Then User should get a message about no product matching