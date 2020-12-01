package dropdownTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class DropdownTest {
	
	WebDriver driver;
	
	String url = "https://www.jquery-az.com/boots/demo.php?ex=63.0_2";
	
	@Before
	public void windowSetup() {
		
		System.setProperty("webdriver.chrome.driver", "D:\\RAKESH\\Infosys\\ChromeDriver\\chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@After
	public void teardown() {
		driver.quit();
	}
	
	@Test
	public void test() {
		
		driver.findElement(By.xpath("/html/body/div[3]/table/tbody/tr[2]/td[3]/div/span/div/button")).click();
		
		List<WebElement> options = driver.findElements(By.xpath("//ul[contains(@class,'multiselect-container')]//li//a//label"));
		
		for (int i = 0; i < options.size(); i++) {
			
			String value = options.get(i).getText();
			
			if(value.contentEquals("Java")||value.contentEquals("Python")) {
				options.get(i).click();
			}
		}
		
	}

}
