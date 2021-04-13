package archive;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Rough {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@class='header_user_info']")).click();
		driver.findElement(By.id("email")).sendKeys("singh.saurav@icloud.com");
		driver.findElement(By.id("passwd")).sendKeys("mech2704");
		driver.findElement(By.xpath("//*[@id='SubmitLogin']/span")).click();
		driver.findElement(By.xpath("//a[@title='Home']")).click();
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//*[@id='homefeatured']/li[1]/div/div[1]/div/a[1]/img")))
				.build().perform();//move to product
		driver.findElement(By.xpath("//*[@id='homefeatured']/li[1]/div/div[2]/div[2]/a[1]/span")).click();//add to cart
		driver.findElement(By.xpath("//a[@title='Proceed to checkout']")).click();// proceed to checkout //*[@id="center_column"]/p[2]/a[1]/span
		driver.findElement(By.xpath("(//a[@title='Proceed to checkout']/span)[2]")).click();//45.51, 2,43.51
		driver.findElement(By.xpath("(//button[@type='submit'])[2]")).submit();
		driver.findElement(By.xpath("(//button[@type='submit'])[2]")).submit();
		driver.findElement(By.xpath("//*[@id=\"order\"]/div[2]/div/div/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='cgv']")).click();
		Thread.sleep(2000);
		action.moveToElement(driver.findElement(By.xpath("(//button[@type='submit'])[2]"))).click().build().perform();
		//driver.findElement(By.xpath("(//button[@type='submit'])[2]")).submit();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@class='bankwire']")).click();
		driver.findElement(By.xpath("(//button[@type='submit'])[2]")).submit();
		String text = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/p/strong")).getText();
		System.out.println(text);

	}

}
