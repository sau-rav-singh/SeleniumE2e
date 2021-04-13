package com.saurav.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saurav.base.TestBase;

public class AddressPage extends TestBase{
	
	@FindBy(xpath="(//button[@type='submit'])[2]")
	WebElement checkout;
	
	public AddressPage() {
		PageFactory.initElements(driver, this);
	}
	
	public ShippingPage clickOnCheckout() {
		checkout.submit();
		return new ShippingPage();
	}

}
