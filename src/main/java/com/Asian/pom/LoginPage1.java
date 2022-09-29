package com.Asian.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage1 {
	public static WebDriver driver;
	
	public LoginPage1(WebDriver driver2) {
		driver = driver2;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='username']")
	private WebElement email_input;

	public WebElement email_input() {
		return email_input;
	}
	public WebElement getEmail_input() {
		return email_input;
	}
	
	
	@FindBy(xpath = "//input[@type='password']")
	private WebElement password_input;

	public WebElement password_input() {
		return password_input;
	}
	public WebElement getPassword_input() {
		return password_input;
	}
	
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement sign_bttn;

	public WebElement sign_bttn() {
		return sign_bttn;
	}
	public WebElement getSign_bttn() {
		return sign_bttn;
	}
	
	@FindBy(xpath = "//a[text()='Register']")
	private WebElement login_register_bttn;

	public WebElement login_register_bttn() {
		return login_register_bttn;
	}
	public WebElement getLogin_register_bttn() {
		return login_register_bttn;
	}
}
