package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;

	
	// Objects
	@FindBy(xpath = "//span[text()='My Account']")
	private WebElement myAccountDropMenu;

	@FindBy(linkText = "Login")
	private WebElement loginOption;

	@FindBy(linkText = "Register")
	private WebElement registerOption;

	@FindBy(name = "search")
	private WebElement searchBox;

	@FindBy(xpath = "//div[@id='search']/descendant::button")
	private WebElement searchButton;

	
	// Defining a constructor for the class "HomePage"
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	//  Actions
	/* [comment id - d7fpe] Instead of writing this code we can combine it as below navigateToLoginPage
	 * public void clickOnMyAccount() { myAccountDropMenu.click(); }
	 * 
	 * public LoginPage selectLoginOption() { loginOption.click(); return new
	 * LoginPage(driver); }
	 */
	
	public LoginPage navigateToLoginPage() {
		myAccountDropMenu.click();
		loginOption.click();
		return new LoginPage(driver);
	}

	/*
	 * public RegisterPage selectRegisterOption() { registerOption.click(); return
	 * new RegisterPage(driver); }
	 */
	
	public RegisterPage navigateToRegisterPage() {
		myAccountDropMenu.click();
		registerOption.click();
		return new RegisterPage(driver);
	}

	public void searchTheValidProduct(String product) {
		searchBox.sendKeys(product);
	}

	public SearchFunctionPage clickOnSearchButton() {
		searchButton.click();
		return new SearchFunctionPage(driver);
	}
	
	public SearchFunctionPage searchForAProduct(String product) {
		searchBox.sendKeys(product);
		searchButton.click();
		return new SearchFunctionPage(driver);
	}
}
