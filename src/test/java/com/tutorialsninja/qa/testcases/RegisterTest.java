package com.tutorialsninja.qa.testcases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.AccountSuccessPage;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.RegisterPage;
import com.tutorialsninja.qa.utils.Utilities;

public class RegisterTest extends Base {

	public RegisterTest() {
		super();

	}

	RegisterPage registerPage;
	AccountSuccessPage accountSuccessPage;

	public WebDriver driver;

	// BeforeMethod
	@BeforeMethod
	public void setup() {
		// loadPropertiesFile();
		driver = initializBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		HomePage homePage = new HomePage(driver);
		registerPage = homePage.navigateToRegisterPage();
	}

	// AfterMethod
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	// TestCase 1
	@Test(priority = 1)
	public void verifyRegisteringAnAccountWithMandatoryFeilds() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPLICIT_WAIT_TIME));
		accountSuccessPage = registerPage.registrationWithMandatoryField(dataProp.getProperty("userFirstName"),
				dataProp.getProperty("userLastName"), Utilities.generateEmailWithTimeStamp(),
				dataProp.getProperty("userPhoneNumber"), dataProp.getProperty("registerPassword"),
				dataProp.getProperty("registerPassword"));
		Assert.assertEquals(accountSuccessPage.getTextOfActualSuccessHeadingOnAccountPage(),
				dataProp.getProperty("successMessageOnAccountCreation"), "Account success page is not displayed.");
	}

	// TestCase 2
	@Test(priority = 2)
	public void verifyRegisteringAnAccountByProvingAllFeilds() {
		accountSuccessPage = registerPage.registrationWithAllField(dataProp.getProperty("userFirstName"),
				dataProp.getProperty("userLastName"), Utilities.generateEmailWithTimeStamp(),
				dataProp.getProperty("userPhoneNumber"), dataProp.getProperty("registerPassword"),
				dataProp.getProperty("registerPassword"));
		Assert.assertEquals(accountSuccessPage.getTextOfActualSuccessHeadingOnAccountPage(),
				dataProp.getProperty("successMessageOnAccountCreation"), "Account success page is not displayed.");
	}

	// TestCase 3
	@Test(priority = 3)
	public void verifyRegisteringAnAccountWithExistingEmailAddress() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPLICIT_WAIT_TIME));
		accountSuccessPage = registerPage.registrationWithMandatoryField(dataProp.getProperty("userFirstName"),
				dataProp.getProperty("userLastName"), prop.getProperty("validEmail"),
				dataProp.getProperty("userRealPhoneNumber"), dataProp.getProperty("registerPassword"),
				dataProp.getProperty("registerPassword"));
		Assert.assertEquals(registerPage.getActualErrorMessageOnDuplicateUserDetails(),
				dataProp.getProperty("alreadyRegisteredEmailErrorMessage"), "This Email is not registered");

	}

	// TestCase 4
	@Test(priority = 4)
	public void verifyRegisteringAccountWithoutFillingAnyDetails() {
		registerPage.clickOnContinueButton();
		Assert.assertTrue(registerPage.displayStatusOfWarningMessage(dataProp.getProperty("privacyPolicyWarningIfNull"), dataProp.getProperty("firstNameWarningIfNull"), dataProp.getProperty("lastNameWarningIfNull"), dataProp.getProperty("emailWarningIfNull"), dataProp.getProperty("telephoneWarningIfNull"), dataProp.getProperty("passwordWarningIfNull")));
	}

}
