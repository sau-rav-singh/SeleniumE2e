package com.saurav.testcases;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.saurav.base.TestBase;
import com.saurav.pages.AddressPage;
import com.saurav.pages.HomePage;
import com.saurav.pages.LoginPage;
import com.saurav.pages.OrderHistory;
import com.saurav.pages.PaymentPage;
import com.saurav.pages.ShippingPage;
import com.saurav.pages.SummaryPage;

public class SimpleOrderTest extends TestBase {
	
	static {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        System.setProperty("currenttime", dateFormat.format(new Date()));
    }
	public static Logger log = Logger.getLogger(SimpleOrderTest.class.getName());

	HomePage homePage;
	LoginPage loginPage;
	SummaryPage summaryPage;
	AddressPage addressPage;
	ShippingPage shippingPage;
	PaymentPage paymentPage;
	OrderHistory orderHistory;

	@BeforeClass
	public void setup() {
		initialization();
		loginPage = new LoginPage();
		homePage = new HomePage();
		homePage.clickOnLogin();
		homePage = loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));

	}

	@Test(priority = 1)
	public void addingProduct1() {
		homePage.addToCart1(homePage.product1());
	}

	@Test(priority = 2)
	public void addingProduct2() {
		summaryPage = homePage.addToCart2(homePage.product2());
	}

	@Test(priority = 3)
	public void clickOnSummaryPageCheckout() {
		Assert.assertEquals(summaryPage.verifyProductAmount(), "$43.51");
		Assert.assertEquals(summaryPage.verifyShippingCost(), "$2.00");
		Assert.assertEquals(summaryPage.verifyTotalCost(), "$45.51");
		addressPage = summaryPage.clickOnSummaryPageCheckout();
	}

	@Test(priority = 4)
	public void clickOnAddressPageCheckout() {
		shippingPage = addressPage.clickOnCheckout();
	}

	@Test(priority = 5)

	public void shippingPageTest() {
		shippingPage.checkTermsConditionCheckBox();
		paymentPage = shippingPage.clickShippingPageCheckout();
	}

	@Test(priority = 6)

	public void paymentPageTest() {
		paymentPage.clickBankWire();
		paymentPage.orderConfirmation();
		String tot = paymentPage.verifyOrderTotal();
		// String t=summaryPage.verifyTotalCost();
		Assert.assertEquals(tot, "$45.51");
		orderHistory=paymentPage.clickOnBackToOrders();
	}

	@Test(priority = 7)

	public void printOrderid() {
		System.out.println(orderHistory.printOrderId());
		Assert.assertEquals(orderHistory.orderAmount(), "$45.51");
		log.info("Order id is "+orderHistory.printOrderId());
	}

	@AfterClass
	public void tearDown() {
		driver.close();
	}
}
