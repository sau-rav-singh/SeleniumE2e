//package archive;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.Formatter;
//import java.util.logging.Logger;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;
//
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//
//public class Extent_Report {
//	static {
//		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
//		System.setProperty("currenttime", dateFormat.format(new Date()));
//	}
//	//public static ExtentReports extent;
//	public static Logger log = Logger.getLogger(Extent_Report.class.getName());
//
//	/*
//	 * @BeforeTest public void config() { // Date date = new Date(); //
//	 * SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
//	 * // String name = dateFormat1.format(date); // String path =
//	 * System.getProperty("user.dir") + "\\reports\\" + name + "-index.html"; //
//	 * String path = System.getProperty("user.dir") + "\\reports\\test.html"; //
//	 * ExtentSparkReporter reporter = new ExtentSparkReporter(path); //
//	 * reporter.config().setReportName("Selenium Suite Test Result"); //
//	 * reporter.config().setDocumentTitle("Test Results"); // extent = new
//	 * ExtentReports(); // extent.attachReporter(reporter); //
//	 * extent.setSystemInfo("Run By", "Saurav Singh");
//	 * 
//	 * }
//	 */
//
//	@Test
//	public void Google() {
//
//		System.out.println("test");
//	//	extent.createTest("Google");
////		WebDriverManager.chromedriver().setup();
////		 ChromeOptions options = new ChromeOptions();
////         options.addArguments("--headless");
////         options.addArguments("--disable-gpu");
////		WebDriver driver = new ChromeDriver();
////		driver.get("https://www.google.com/");
//		log.info("Google Loaded");
//		// driver.quit();
//		//extent.flush();
//
//	}
//
//}
