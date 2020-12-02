package resizeBrowserWindow;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ResizeBrowserWindowTest {
	
	WebDriver driver;

	String url = "https://www.google.com";

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
		
		Dimension size = new Dimension(800, 600);
		driver.manage().window().setSize(size);
		
		Thread.sleep(5000);
		
	}

}
