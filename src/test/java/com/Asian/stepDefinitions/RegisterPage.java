package com.Asian.stepDefinitions;

import org.apache.poi.hssf.dev.ReSave;
import org.openqa.selenium.WebDriver;

import com.Asian.pom.LoginPage1;
import com.Asian.pom.RegisterPage1;
import com.Asian_Assessment.Baseclass;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class RegisterPage extends Baseclass {


	public static WebDriver driver = Baseclass.driver;
	RegisterPage1 register = new RegisterPage1(driver);
	LoginPage1 login = new LoginPage1(driver);


	@Given("^user Launch The Asian Cloud Aplication$")
	public void user_Launch_The_Asian_Cloud_Aplication() throws Throwable {
		System.out.println(driver.getCurrentUrl());
		
	}

	@When("^user Click The Register Button And Navigate To The Register page$")
	public void user_Click_The_Register_Button_And_Navigate_To_The_Register_page() throws Throwable {
clickonWebelement(login.getLogin_register_bttn());
	
	}

	@When("^user Enter The Username In Username Field$")
	public void user_Enter_The_Username_In_Username_Field() throws Throwable {
		inputValuestoWebelement(register.getEmail_input(), Baseclass.prop.getProperty("email"));

	}

	@When("^user Enter The Password In The Password Field$")
	public void user_Enter_The_Password_In_The_Password_Field() throws Throwable {
		inputValuestoWebelement(register.getPassword_input(), Baseclass.prop.getProperty("password"));
		Thread.sleep(3000);
	}

	@When("^user Reenter The Password In The Conform Password Field$")
	public void user_Reenter_The_Password_In_The_Conform_Password_Field() throws Throwable {
		
		inputValuestoWebelement(register.getconfirmpassword(), Baseclass.prop.getProperty("repassword"));
		
	}

	@When("^user Click The Register Button Navigate To Asiancloud Homepage$")
	public void user_Click_The_Register_Button_Navigate_To_Asiancloud_Homepage() throws Throwable {
		
		clickonWebelement(register.getRegister_bttn());
	clickonWebelement(register.getdrop_menu());
	clickonWebelement(register.getlogout());
	Thread.sleep(3000);
	}
}

	