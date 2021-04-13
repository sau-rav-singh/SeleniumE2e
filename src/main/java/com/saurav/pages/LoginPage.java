package com.saurav.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saurav.base.TestBase;

public class LoginPage extends TestBase {

	@FindBy(id = "email")
	WebElement username;

	@FindBy(id = "passwd")
	WebElement password;

	@FindBy(xpath = "//*[@id='SubmitLogin']/span")
	WebElement submit;

	@FindBy(xpath = "//a[@title='Home']")
	WebElement home;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public HomePage Login(String uname, String pword) {
		username.sendKeys(uname);
		password.sendKeys(pword);
		submit.click();
		home.click();
		return new HomePage();
	}

	public String LoginPageTitle() {
		return driver.getTitle();
	}

}
