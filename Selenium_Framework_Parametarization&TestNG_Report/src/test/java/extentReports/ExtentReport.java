package extentReports;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReport {

	WebDriver driver;

	String url = "https://www.google.com/";
	
	ExtentHtmlReporter reporter;
	ExtentReports extent;
	ExtentTest logger;

	@Before
	public void windowSetup() throws Exception{

		reporter = new ExtentHtmlReporter("./extentReport.html");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		
		logger = extent.createTest("Google Search Test");
		
		System.setProperty("webdriver.chrome.driver", "D:\\RAKESH\\Infosys\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
	}

	@After
	public void teardown() {
		driver.quit();
		logger.pass("Closed the browser");
		
		logger.info("Test Completed");
		
		extent.flush();
	}
	
	@Test
	public void test() throws InterruptedException {
		
		logger.log(Status.INFO, "Starting Test");
		
		driver.get(url);
		logger.pass("Navigated to Google.com");
		
		driver.findElement(By.name("q")).sendKeys("FC Bayern");
		logger.pass("Added text in search box");
		
		driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[3]/center/input[1]")).submit();
		logger.pass("Clicked Google Search button");
		
	}

}
