package com.saurav.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saurav.base.TestBase;

public class OrderHistory extends TestBase {
	
	
	@FindBy(xpath = "//*[@id=\"order-list\"]/tbody/tr[1]/td[1]/a")
	WebElement orderId;

	@FindBy(xpath="//tr[@class='first_item ']/td[3]/span")
	WebElement orderTotal;
	public OrderHistory() {
		PageFactory.initElements(driver, this);
	}
	
	public String printOrderId() {
		return orderId.getText();
		
	}
	public String orderAmount() {
		return orderTotal.getText();
	}

}
