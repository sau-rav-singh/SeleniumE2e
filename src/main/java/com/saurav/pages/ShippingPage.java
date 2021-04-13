package com.saurav.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saurav.base.TestBase;

public class ShippingPage extends TestBase {
	
	@FindBy(xpath="//input[@id='cgv']")
	WebElement termsConditionsCheckBox;
	
	@FindBy(xpath="(//button[@type='submit'])[2]")
	WebElement shippingPageCheckout;
	
	public ShippingPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void checkTermsConditionCheckBox() {
		termsConditionsCheckBox.click();
	}
	
	public PaymentPage clickShippingPageCheckout() {
		Actions sAction=new Actions(driver);
		sAction.moveToElement(driver.findElement(By.xpath("(//button[@type='submit'])[2]"))).click().build().perform();
		return new PaymentPage();
	}

}
