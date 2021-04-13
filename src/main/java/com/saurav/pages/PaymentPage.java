package com.saurav.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saurav.base.TestBase;

public class PaymentPage extends TestBase{
	
	@FindBy(xpath="//a[@class='bankwire']")
	WebElement bankWire;
	
	@FindBy(xpath="(//button[@type='submit'])[2]")
	WebElement confirmOrder;
	
	@FindBy(xpath="//*[@id=\"center_column\"]/div/span/strong")
	WebElement orderTotal;
	
	@FindBy(xpath="//*[@id=\"center_column\"]/p/a")
	WebElement backToOrders;
	
	public PaymentPage() {
		PageFactory.initElements(driver, this);
	}

	public void clickBankWire() {
		bankWire.click();
	}
	public void orderConfirmation() {
		confirmOrder.submit();
	}
	
	public String verifyOrderTotal() {
		return orderTotal.getText();
	}
	
	public OrderHistory clickOnBackToOrders() {
		backToOrders.click();
		return new OrderHistory();
	}
}
