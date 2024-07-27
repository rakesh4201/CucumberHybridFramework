Feature: Registration functionality

Scenario: User creates account only with mandatory fields
Given User navigates to Register account page
When User enters the details into below fields
|firstName|Rakesh         |
|lastName |  Reddy        |
|telephone|1234567890     |
|password |123456          |
And User selects Privacy Policy
And User clicks on Continue button
Then User account should get created successfully

Scenario: User creates account with all fields
Given User navigates to Register account page
When User enters the details into below fields
|firstName|Rakesh         |
|lastName |  Reddy        |
|telephone|1234567890     |
|password |123456          |
And user selects Yes for Newsletter
And User selects Privacy Policy
And User clicks on Continue button
Then User account should get created successfully

Scenario: User creates a duplicate account
Given User navigates to Register account page
When User enters the details into below fields with duplicate email
|firstName|Rakesh         |
|lastName |  Reddy        |
|email    |  rakesh4everrakhi@gmail.com|
|telephone|1234567890     |
|password |123456          |
And user selects Yes for Newsletter
And User selects Privacy Policy
And User clicks on Continue button
Then User should get warning about duplicate email address

Scenario: User creates an account without filling any details
Given User navigates to Register account page
When User doesnot enter any details into fields
And User clicks on Continue button
Then User should get proper warning message for every mandatory field



