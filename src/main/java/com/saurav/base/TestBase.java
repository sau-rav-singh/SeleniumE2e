package com.saurav.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static Properties prop;
	public static WebDriver driver;
	public static String loginSheetPath = System.getProperty("user.dir") + "\\src\\main\\resources\\loginData.xlsx";

	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\main\\java\\com\\saurav\\config\\config.properties");
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initialization() {
		String browser = prop.getProperty("browser");
		if (browser.contains("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.contains("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
	}

	public void takeScreenshot(String result, String Result) {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
		String name = dateFormat.format(date);
		long millis=System.currentTimeMillis();  
		java.sql.Date dateFolder=new java.sql.Date(millis);
		if(Result.equals("Pass")) {
		try {
			FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/"+dateFolder+"/success/" + result + name + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}}else if(Result.equals("Fail")) {
			try {
				FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/"+dateFolder+"/failure/" + result + name + ".png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
