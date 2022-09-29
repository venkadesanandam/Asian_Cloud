package com.Asian.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage1 {

	public static WebDriver driver;
	
	
	public RegisterPage1(WebDriver driver2) {
		driver = driver2;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='email']")
	private WebElement email_input;

	public WebElement username_input() {
		return email_input;
	}
	public WebElement getEmail_input() {
		return email_input;
	}

	@FindBy(xpath = "(//input[@id='password'])[1]")
	private WebElement Password_input;

	public WebElement Password_input() {
		return Password_input;
	}
	public WebElement getPassword_input() {
		return Password_input;
	}
	
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement register_bttn;

	public WebElement register_bttn() {
		return register_bttn;
	}
	public WebElement getRegister_bttn() {
		return register_bttn;
	}
	
	@FindBy(xpath = "(//input[@type='password'])[2]")
	private WebElement confirmpassword;

	public WebElement confirmpassword() {
		return confirmpassword;
	}
	public WebElement getconfirmpassword() {
		return confirmpassword;
	}
	//span[normalize-space()='G']
	
	
	@FindBy(xpath = "//button[text()='Logout']")
	private WebElement logout;

	public WebElement logout() {
		return logout;
	}
	public WebElement getlogout() {
		return logout;
	}
	@FindBy(xpath = "(//a[@class='c-header-nav-link'])[4]")
	private WebElement drop_menu;

	public WebElement drop_menu() {
		return drop_menu;
	}
	public WebElement getdrop_menu() {
		return drop_menu;
	}
}
