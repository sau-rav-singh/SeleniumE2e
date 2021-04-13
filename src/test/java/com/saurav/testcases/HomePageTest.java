package com.saurav.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.saurav.base.TestBase;
import com.saurav.pages.HomePage;

public class HomePageTest extends TestBase {

	HomePage homePage;

	public HomePageTest() {
		super();
	}

	@BeforeClass
	public void setup() throws IOException {
		initialization();
		homePage = new HomePage();

	}

	@Test(priority = 1)
	public void verifyHomePageTitle() {
		Assert.assertEquals(homePage.homePageTitle(), "My Store");
	}

	@Test(priority = 2, enabled = true)
	public void verifyWebsiteEmail() {
		Assert.assertEquals(homePage.websitePhone(), "0123-456-789");
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
