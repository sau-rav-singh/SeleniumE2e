package com.saurav.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saurav.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//div[@class='header_user_info']")
	WebElement login;

	@FindBy(xpath = "//span[@class='shop-phone']/strong")
	WebElement websitePhone;

	@FindBy(xpath = "//*[@id=\"homefeatured\"]/li[1]/div/div[1]/div/a[1]/img")
	WebElement product1;
	
	@FindBy(xpath = "//*[@id=\"homefeatured\"]/li[2]/div/div[1]/div/a[1]/img")
	WebElement product2;

	@FindBy(xpath = "//*[@id=\"homefeatured\"]/li[1]/div/div[2]/div[2]/a[1]/span")////*[@id="homefeatured"]/li[2]/div/div[2]/div[2]/a[1]/span
	WebElement addToCart1;
	
	@FindBy(xpath = "//*[@id=\"homefeatured\"]/li[2]/div/div[2]/div[2]/a[1]/span")////*[@id="homefeatured"]/li[2]/div/div[2]/div[2]/a[1]/span
	WebElement addToCart2;

	@FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span")
	WebElement checkout1;
	
	@FindBy(xpath="//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/span/span")
	WebElement continueShopping;
	
	@FindBy(xpath="//a[@title='Proceed to checkout']")
	WebElement proceedToCheckout;
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement product1() {
		return product1;
	}
	
	public WebElement product2() {
		return product2;
	}
	public void addToCart1(WebElement prod) {
		Actions action = new Actions(driver);
		action.moveToElement(prod).build().perform();
		addToCart1.click();
		continueShopping.click();
		
	}
	
	public SummaryPage addToCart2(WebElement prod) {
		Actions action = new Actions(driver);
		action.moveToElement(prod).build().perform();
		addToCart2.click();
		proceedToCheckout.click();
		return new SummaryPage();
	}

	public LoginPage clickOnLogin() {
		login.click();
		return new LoginPage();
	}

	public String homePageTitle() {
		return driver.getTitle();
	}

	public String websitePhone() {
		return websitePhone.getText();
	}
	
	
}
