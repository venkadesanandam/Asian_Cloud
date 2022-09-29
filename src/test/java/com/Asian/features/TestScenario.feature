Feature: Login  in Functionality 



Scenario: User Register in WebAaplication
	To valiate whether user is able to Register successfully in Asian Homepage upon providing valid details 
Given  user Launch The Asian Cloud Aplication
When user Click The Register Button And Navigate To The Register page
And user Enter The Username In Username Field
And user Enter The Password In The Password Field 
And user Reenter The Password In The Conform Password Field
And user Click The Register Button Navigate To Asiancloud Homepage



Scenario: user Login In Web Application

When  user Enter The Username In The Username Field
And  user Enter The  Password In The Password field
Then  user Click On The  Sign Button And User Navigates To The Homepage



	