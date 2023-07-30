package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	
	WebDriver driver;
	
    //  Objects 
	@FindBy(id = "input-firstname")
	private WebElement firstNameInputField;
	
	@FindBy(id = "input-lastname")
	private WebElement lastNameInputField;
	
	@FindBy(id = "input-email")
	private WebElement emailInputField;
	
	@FindBy(id = "input-telephone")
	private WebElement telephoneInputField;
	
	@FindBy(xpath = "//input[@id='input-password']")
	private WebElement passwordInputField;
	
	@FindBy(xpath = "//input[@id='input-confirm']")
	private WebElement confirmPasswordInputField;
	
	@FindBy(xpath = "//input[@name='newsletter'][@value='1']")
	private WebElement newsLetterRadioButton;
	
	@FindBy(name = "agree")
	private WebElement agreeCheckBox;
	
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement continueButtonOnRegisterPage;
	
	
	//Error message on registered page
	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
	private WebElement actualErrorMessageOnDuplicateDetails;
	
	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
	WebElement privacyPolicyWarning;
	
	@FindBy(xpath = "//input[@id='input-firstname']/following-sibling::div")
	WebElement firstNameWarning;
	
	@FindBy(xpath = "//input[@id='input-lastname']/following-sibling::div")
	WebElement lastNameWarning;
	
	@FindBy(xpath = "//input[@id='input-email']/following-sibling::div")
	WebElement emailWarning;
	
	@FindBy(xpath = "//input[@id='input-telephone']/following-sibling::div")
	WebElement telephoneNumeberWarning;
	
	@FindBy(xpath = "//input[@id='input-password']/following-sibling::div")
	WebElement passwordWarning;
	
	// Defining a constructor for the class "RegisterPage"
	public RegisterPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Actions using Objects
//	public void enterFirstName(String firstName) {
//		firstNameInputField.sendKeys(firstName);
//	}
//	
//	public void enterLastName(String lastName) {
//		lastNameInputField.sendKeys(lastName);
//	}
//	
//	public void enterEmail(String emailText)
//	{
//		emailInputField.sendKeys(emailText);
//	}
//	
//	public void enterContact(String contact) {
//		telephoneInputField.sendKeys(contact);
//	}
//	
//	public void enterPassword(String firstPassword) {
//		passwordInputField.sendKeys(firstPassword);
//	}
//	
//	public void enterConfirmPassword(String confirmPassword) {
//		confirmPasswordInputField.sendKeys(confirmPassword);
//	}
	
//	public void checkTheNewsLetterRadioButton() {
//		newsLetterRadioButton.click();
//	}
//	
//	public void agreeDisagreeCheckBox() {
//		agreeCheckBox.click();
//	}
	
	public AccountSuccessPage registrationWithMandatoryField(String firstName, String lastName, String emailText, String contact, String firstPassword, String confirmPassword) {
		firstNameInputField.sendKeys(firstName);
		lastNameInputField.sendKeys(lastName);
		emailInputField.sendKeys(emailText);
		telephoneInputField.sendKeys(contact);
		telephoneInputField.sendKeys(contact);
		passwordInputField.sendKeys(firstPassword);
		confirmPasswordInputField.sendKeys(confirmPassword);
		agreeCheckBox.click();
		continueButtonOnRegisterPage.click();
		return new AccountSuccessPage(driver);
	}
	
	
	public AccountSuccessPage registrationWithAllField(String firstName, String lastName, String emailText, String contact, String firstPassword, String confirmPassword) {
		firstNameInputField.sendKeys(firstName);
		lastNameInputField.sendKeys(lastName);
		emailInputField.sendKeys(emailText);
		telephoneInputField.sendKeys(contact);
		telephoneInputField.sendKeys(contact);
		passwordInputField.sendKeys(firstPassword);
		confirmPasswordInputField.sendKeys(confirmPassword);
		newsLetterRadioButton.click();
		agreeCheckBox.click();
		continueButtonOnRegisterPage.click();
		return new AccountSuccessPage(driver);
	}
	
	public AccountSuccessPage clickOnContinueButton() {
		continueButtonOnRegisterPage.click();
		return new AccountSuccessPage(driver);
	}
	
	public String getActualErrorMessageOnDuplicateUserDetails() {
		String actualErrorMessage = actualErrorMessageOnDuplicateDetails.getText();
		return actualErrorMessage;
	}
	
	public String getActualWarningMessageOnPrivacyPolicy() {
		String actualErrorMessageOnPrivacyPolicy = privacyPolicyWarning.getText();
		return actualErrorMessageOnPrivacyPolicy;
	}
	
	public String getActualWarningMessageOnFirstName() {
		String actualErrorMessageOnFirstName = firstNameWarning.getText();
		return actualErrorMessageOnFirstName;
	}
	
	public String getActualWarningMessageOnLastName() {
		String actualErrorMessageOnLastName = lastNameWarning.getText();
		return actualErrorMessageOnLastName;
	}
	
	public String getActualWarningMessageOnEmail() {
		String actualErrorMessageOnEmail = emailWarning.getText();
		return actualErrorMessageOnEmail;
	}
	
	public String getActualWarningMessageOnContactNumeber() {
		String actualErrorMessageOnContactNumeber = telephoneNumeberWarning.getText();
		return actualErrorMessageOnContactNumeber;
	}
	
	public String getActualWarningMessageOnPassword() {
		String actualErrorMessageOnEmail = passwordWarning.getText();
		return actualErrorMessageOnEmail;
	}
	
	
	public boolean displayStatusOfWarningMessage(String expectedPrivacyPolicyWarning, String expectedFirstNameWarning, String expectedLastNameWarning, String expectedEmailWarning, String expectedTelephoneWarning, String expectedPasswordWarning) {
		boolean privacyPolicyStatus = privacyPolicyWarning.getText().equals(expectedPrivacyPolicyWarning);
		boolean firstNameWarningStatus= firstNameWarning.getText().equals(expectedFirstNameWarning);
		boolean lastNameWarningStatus= lastNameWarning.getText().equals(expectedLastNameWarning);
		boolean emailNameWarningStatus= emailWarning.getText().equals(expectedEmailWarning);
		boolean telephoneWarningStatus= emailWarning.getText().equals(expectedTelephoneWarning);
		boolean passwordWarningStatus= passwordWarning.getText().equals(expectedPasswordWarning);
		return privacyPolicyStatus && firstNameWarningStatus && lastNameWarningStatus && emailNameWarningStatus && telephoneWarningStatus && passwordWarningStatus;
	}

}
