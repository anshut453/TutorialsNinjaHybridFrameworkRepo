package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.AccountPage;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.LoginPage;
import com.tutorialsninja.qa.utils.Utilities;

public class LoginTest extends Base {
	
	AccountPage accountPage;
	LoginPage loginPage;

	public LoginTest() {
		super();
	}

	public WebDriver driver;

	//Before Test
	@BeforeMethod
	public void setup() {
		// loadPropertiesFile();
		driver = initializBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		HomePage homePage = new HomePage(driver);
		loginPage = homePage.navigateToLoginPage();
	}

	//After Test
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	//Test 1
	@Test(priority = 1, dataProvider="validCredentialsSupplier")
	public void verifyLoginWithValidCredentials(String email, String password) {
		accountPage = loginPage.login(email, password);
		Assert.assertTrue(accountPage.getDisplayStatusOfeditYourAccountInformation(), "Check your email and passwor again");
	}

	//DataProvider from ExcelSheet
	@DataProvider(name="validCredentialsSupplier")
	public Object[][] supplyTestData() {
		
		Object[][] data = Utilities.getTestDataFromExcel("Login");
		return data;
	}

	//Test 2
	@Test(priority = 2)
	public void verifyLoginWithInvalidCredentials() {
		loginPage.login(Utilities.generateEmailWithTimeStamp(), dataProp.getProperty("invalidPassword"));
		Assert.assertTrue(loginPage.getTheTextOfActualWarningMessageOnInvalidCredentials().contains(dataProp.getProperty("verifyLoginWithInvalidCredentialsWarningMessage")), "");

	}

	//Test 3
	@Test(priority = 3)
	public void verifyLoginWithInvalidEmailAndValidPassword() {
		loginPage.login(Utilities.generateEmailWithTimeStamp(), prop.getProperty("validPassword"));
		Assert.assertTrue(loginPage.getTheTextOfActualWarningMessageOnInvalidCredentials().contains(dataProp.getProperty("verifyLoginWithInvalidCredentialsWarningMessage")), "");

	}

	//Test 4
	@Test(priority = 4)
	public void verifyLoginWithValidEmailAndInvalidPassword() {
		loginPage.login(prop.getProperty("validEmail"), dataProp.getProperty("invalidPassword"));
		Assert.assertTrue(loginPage.getTheTextOfActualWarningMessageOnInvalidCredentials().contains(dataProp.getProperty("verifyLoginWithInvalidCredentialsWarningMessage")), "");

	}

	//Test 5
	@Test(priority = 5)
	public void verifyLoginsWithoutProvidingCredentials() {
		loginPage.clickOnLoginButton();
		Assert.assertTrue(loginPage.getTheTextOfActualWarningMessageOnInvalidCredentials().contains(dataProp.getProperty("verifyLoginWithInvalidCredentialsWarningMessage")), "");

	}

}
