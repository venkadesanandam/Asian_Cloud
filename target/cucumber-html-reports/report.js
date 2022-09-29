$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/java/com/Asian/features/TestScenario.feature");
formatter.feature({
  "line": 1,
  "name": "Login  in Functionality",
  "description": "",
  "id": "login--in-functionality",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 5,
  "name": "User Register in WebAaplication",
  "description": "To valiate whether user is able to Register successfully in Asian Homepage upon providing valid details",
  "id": "login--in-functionality;user-register-in-webaaplication",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 7,
  "name": "user Launch The Asian Cloud Aplication",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "user Click The Register Button And Navigate To The Register page",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "user Enter The Username In Username Field",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "user Enter The Password In The Password Field",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "user Reenter The Password In The Conform Password Field",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "user Click The Register Button Navigate To Asiancloud Homepage",
  "keyword": "And "
});
formatter.match({
  "location": "RegisterPage.user_Launch_The_Asian_Cloud_Aplication()"
});
formatter.result({
  "duration": 88065800,
  "status": "passed"
});
formatter.match({
  "location": "RegisterPage.user_Click_The_Register_Button_And_Navigate_To_The_Register_page()"
});
formatter.result({
  "duration": 385674400,
  "status": "passed"
});
formatter.match({
  "location": "RegisterPage.user_Enter_The_Username_In_Username_Field()"
});
formatter.result({
  "duration": 261302000,
  "status": "passed"
});
formatter.match({
  "location": "RegisterPage.user_Enter_The_Password_In_The_Password_Field()"
});
formatter.result({
  "duration": 3184783400,
  "status": "passed"
});
formatter.match({
  "location": "RegisterPage.user_Reenter_The_Password_In_The_Conform_Password_Field()"
});
formatter.result({
  "duration": 258799900,
  "status": "passed"
});
formatter.match({
  "location": "RegisterPage.user_Click_The_Register_Button_Navigate_To_Asiancloud_Homepage()"
});
formatter.result({
  "duration": 5722637800,
  "status": "passed"
});
formatter.scenario({
  "line": 16,
  "name": "user Login In Web Application",
  "description": "",
  "id": "login--in-functionality;user-login-in-web-application",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 18,
  "name": "user Enter The Username In The Username Field",
  "keyword": "When "
});
formatter.step({
  "line": 19,
  "name": "user Enter The  Password In The Password field",
  "keyword": "And "
});
formatter.step({
  "line": 20,
  "name": "user Click On The  Sign Button And User Navigates To The Homepage",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginPage.user_Enter_The_Username_In_The_Username_Field()"
});
formatter.result({
  "duration": 274605900,
  "status": "passed"
});
formatter.match({
  "location": "LoginPage.user_Enter_The_Password_In_The_Password_field()"
});
formatter.result({
  "duration": 3252392900,
  "status": "passed"
});
formatter.match({
  "location": "LoginPage.user_Click_On_The_Sign_Button_And_User_Navigates_To_The_Homepage()"
});
formatter.result({
  "duration": 1130644600,
  "status": "passed"
});
});