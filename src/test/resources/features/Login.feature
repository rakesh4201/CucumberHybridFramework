Feature: Login functionality

Scenario Outline: Login with valid credentials
Given User navigates to login page
When User enters valid email address <username> into the email field
And User enters valid password <password> into password field
And User clicks on Login button
Then User should get successfully logged in
Examples: 
|username                    |password|
| rakeshreddy7489@gmail.com  | 12345   |
| rakesh4everrakhi@gmail.com | 123456  |
| rakeshreddy8529@gmail.com  | 123456789|
Scenario: Login with invalid credentials
Given User navigates to login page
When User enters invalid email address  into the email field
And User enters invalid password "1234567890" into password field
And User clicks on Login button
Then User should get warning message about credentials mismatch

Scenario: Login with valid email and invalid password
Given User navigates to login page
When User enters valid email address "rakeshreddy7489@gmail.com" into the email field
And User enters invalid password "1234567890" into password field
And User clicks on Login button
Then User should get warning message about credentials mismatch

Scenario: Login with invalid email and valid password
Given User navigates to login page
When User enters invalid email address  into the email field
And User enters invalid password "123456" into password field
And User clicks on Login button
Then User should get warning message about credentials mismatch

Scenario: Login without providing any credentials
Given User navigates to login page
When User dont enter email address  into the email field
And User dont enter password  into password field
And User clicks on Login button
Then User should get warning message about credentials mismatch
