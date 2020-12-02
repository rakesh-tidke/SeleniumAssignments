package googleSearch;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchTest {
	
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
		
		driver.findElement(By.name("q")).sendKeys("Selenium");
		
		List<WebElement> result = driver.findElements(By.xpath("//ul[@class='erkvQe']//li"));
		
		for(int i= 0; i < result.size(); i++) {
	
			String value = result.get(i).getText();
			System.out.println(value);
			
			if(value == "selenium webdriver") {
				
				result.get(i).click();
				Thread.sleep(5000);
				break;
			}
		}
		
		
	}

}


