package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchFunctionPage {
	
	WebDriver driver;
	
    //  Objects 
	@FindBy(linkText ="HPD LP3065")
	private WebElement searchedValidProductOnSearchPage;
	
	@FindBy(xpath = "//div[@id='content']/descendant::p[2]")
	private WebElement searchedInvalidProductOnSearchPage;
	
	
	// Defining a constructor for the class "RegisterPage"
	public SearchFunctionPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// Actions using Objects
	public Boolean verifyTheValidProduct() {
		Boolean product = searchedValidProductOnSearchPage.isDisplayed();
		return product;
	}
	
	public String verifyTheInvalidProduct() {
		String warningMessageOnInvalidProduct = searchedInvalidProductOnSearchPage.getText();
		return warningMessageOnInvalidProduct;
	}
	

}
