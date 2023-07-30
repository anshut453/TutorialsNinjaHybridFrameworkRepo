package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	// Objects
	@FindBy(id = "input-email")
	private WebElement emailInputField;

	@FindBy(id = "input-password")
	private WebElement passwordInputField;

	@FindBy(xpath = "//input[@value='Login']")
	private WebElement loginButton;

	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
	private WebElement actualWarningMessageOnInvalidCredentials;

	// Defining a constructor for the class "LoginPage"
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	};

	// Actions using Objects

	public void enterEmailAddress(String emailText) {
		emailInputField.sendKeys(emailText);
	}

	public void enterPassword(String passwordText) {
		passwordInputField.sendKeys(passwordText);
	}

	public AccountPage clickOnLoginButton() {
		loginButton.click();
		return new AccountPage(driver);
	}

	public AccountPage login(String emailText, String passwordText) {
		emailInputField.sendKeys(emailText);
		passwordInputField.sendKeys(passwordText);
		loginButton.click();
		return new AccountPage(driver);
	}

	public String getTheTextOfActualWarningMessageOnInvalidCredentials() {
		String warningText = actualWarningMessageOnInvalidCredentials.getText();
		return warningText;
	}

}
