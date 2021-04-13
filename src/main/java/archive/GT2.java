//package archive;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//import org.apache.log4j.Logger;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.testng.annotations.Test;
//
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//
//public class GT2 {
//
//	static {
//        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
//        System.setProperty("currenttime", dateFormat.format(new Date()));
//    }
//	public static Logger log = Logger.getLogger(GT2.class.getName());
//	@Test
//	public void gt() {
//		Date date = new Date();
//		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
//		String name = dateFormat.format(date);
//		String path = System.getProperty("user.dir") + "\\reports\\" + name + "-index.html";
//		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
//		reporter.config().setReportName("Selenium Suite Test Result");
//		reporter.config().setDocumentTitle("Test Results");
//		ExtentReports extent = new ExtentReports();
//		extent.attachReporter(reporter);
//		extent.setSystemInfo("Run By", "Saurav Singh");
//		extent.createTest("Google");
//		WebDriverManager.chromedriver().setup();
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--headless");
//		options.addArguments("--disable-gpu");
//		WebDriver driver = new ChromeDriver(options);
//		driver.get("https://www.google.com/");
//		log.info("Google Loaded");
//		driver.quit();
//		log.info("This is the information log");
//		extent.flush();
//
//	}
//}
