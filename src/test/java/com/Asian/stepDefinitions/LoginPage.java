package com.Asian.stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.Asian.pom.LoginPage1;
import com.Asian_Assessment.Baseclass;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginPage extends Baseclass {

	public static WebDriver driver = Baseclass.driver;
	LoginPage1 login = new LoginPage1(driver);

	@When("^user Enter The Username In The Username Field$")
	public void user_Enter_The_Username_In_The_Username_Field() throws Throwable {
		inputValuestoWebelement(login.getEmail_input(), Baseclass.prop.getProperty("email"));
	}

	@When("^user Enter The  Password In The Password field$")
	public void user_Enter_The_Password_In_The_Password_field() throws Throwable {
		Thread.sleep(3000);
inputValuestoWebelement(login.getPassword_input(), "Venkat@19");
	}

	@Then("^user Click On The  Sign Button And User Navigates To The Homepage$")
	public void user_Click_On_The_Sign_Button_And_User_Navigates_To_The_Homepage() throws Throwable {
		clickonWebelement(login.getSign_bttn());
	
	}

}
