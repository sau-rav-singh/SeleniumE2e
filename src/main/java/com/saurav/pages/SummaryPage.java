package com.saurav.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saurav.base.TestBase;

public class SummaryPage extends TestBase {
	

	@FindBy(xpath="(//a[@title='Proceed to checkout']/span)[2]")
	WebElement summaryPageCheckout;
	
	@FindBy(id="total_product")
	WebElement productAmount;
	
	@FindBy(xpath="//*[@id=\"total_shipping\"]")
	WebElement shippingCost;
	
	@FindBy(xpath="//*[@id='total_price_container']")
	WebElement totalCost;
	
	public SummaryPage() {
		PageFactory.initElements(driver, this);
	}
	
	public AddressPage clickOnSummaryPageCheckout() {
		summaryPageCheckout.click();
		return new AddressPage();
	}
	
	public String verifyProductAmount() {
		return productAmount.getText();
	}
	
	public String verifyShippingCost() {
		return shippingCost.getText();
	}
	
	public String verifyTotalCost() {
		return totalCost.getText();
	}
	
}
