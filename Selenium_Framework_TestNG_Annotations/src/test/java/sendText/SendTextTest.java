package sendText;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SendTextTest {
	
	WebDriver driver;

	String url = "https://www.gmail.com";

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
		executer.executeScript("document.getElementById('identifierId').value='rakeshtidke72@gmail.com'");
		
		Thread.sleep(5000);
		
	}
		

}
