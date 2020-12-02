package webpageScroll;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebpageScrollTest {
	
	WebDriver driver;

	String url = "http://openclinic.sourceforge.net/openclinic/home/index.php";

	@Before
	public void windowSetup() throws Exception {

		System.setProperty("webdriver.chrome.driver", "D:\\RAKESH\\Infosys\\ChromeDriver\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		
	}
	
	@After
	public void teardown() {
		driver.quit();
	}
	
	@Test
	public void test() throws InterruptedException {
		
		JavascriptExecutor executer = (JavascriptExecutor) driver;
		executer.executeScript("window.scrollBy(0,800)");
		
		Thread.sleep(5000);
		
	}
	

}
