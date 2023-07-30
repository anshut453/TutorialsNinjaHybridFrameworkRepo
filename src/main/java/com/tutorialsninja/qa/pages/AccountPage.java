package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {
	
	WebDriver driver;
	
	
    //  Objects
	@FindBy(linkText = "Edit your account information")
	private WebElement editYourAccountInformation;
	
	
	// Defining a constructor for the class "AccountPage"
	public AccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// Actions using Objects 
	public boolean getDisplayStatusOfeditYourAccountInformation() {
		boolean displayStatus = editYourAccountInformation.isDisplayed();
		return displayStatus;
	}
}
