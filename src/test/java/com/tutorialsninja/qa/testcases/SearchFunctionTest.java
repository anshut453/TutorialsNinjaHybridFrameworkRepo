package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.SearchFunctionPage;

public class SearchFunctionTest extends Base {

	public SearchFunctionTest() {
		super();
	}

	SearchFunctionPage searchFunction;
	public WebDriver driver;
	HomePage homePage;

	//BeforeMethod
	@BeforeMethod
	public void setup() {
		//loadPropertiesFile();
		driver = initializBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		homePage = new HomePage(driver);
	}

	//AfterMethod
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	//TestCase 1
	@Test(priority = 1)
	public void verifySearchWithValidProduct() {
		searchFunction = homePage.searchForAProduct(dataProp.getProperty("SearchWithValidProduct"));
		Assert.assertTrue(searchFunction.verifyTheValidProduct());
	}

	//TestCase 2
	@Test(priority = 2, dependsOnMethods = {"verifySearchWithValidProduct"})
	public void verifySearchWithInvalidProduct() {
		searchFunction = homePage.searchForAProduct(dataProp.getProperty("SearchWithInvalidProduct"));
		Assert.assertEquals(searchFunction.verifyTheInvalidProduct(), dataProp.getProperty("noPropductWarningMessage"),
				"No result displayed for search result");

	}

	//TestCase 3
	@Test(priority = 3)
	public void verifySearchWithoutProvidingData() {
		searchFunction = homePage.clickOnSearchButton();
		Assert.assertEquals(searchFunction.verifyTheInvalidProduct(), dataProp.getProperty("noPropductWarningMessage"),
				"No result displayed for search result");
	}
}
