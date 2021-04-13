package com.saurav.testcases;

import java.util.Map;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.saurav.base.TestBase;
import com.saurav.pages.HomePage;
import com.saurav.pages.LoginPage;
import com.saurav.testutil.TestUtil;

public class LoginPageTest extends TestBase {

	public static Logger log = Logger.getLogger(LoginPageTest.class.getName());

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		loginPage = new LoginPage();
		homePage = new HomePage();
		homePage.clickOnLogin();
		testUtil = new TestUtil();

	}

	@DataProvider()
	public Object getLoginData() {
		Object[][] data = TestUtil.getLoginData(loginSheetPath);
		return data;

	}

	@Test(dataProvider = "getLoginData")
	public void excelLogin(Map<String, String> data) throws InterruptedException {
		homePage = loginPage.Login(data.get("username"), data.get("password"));
		Thread.sleep(2000);
		String title = loginPage.LoginPageTitle();
		Assert.assertEquals(title, "My Store");
		log.info("Website Title Assertion Passed");

	}

	@Test
	public void login() {
		homePage=loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
