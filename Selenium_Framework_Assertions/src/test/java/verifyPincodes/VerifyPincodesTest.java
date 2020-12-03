package verifyPincodes;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyPincodesTest {

	WebDriver driver;

	String url = "https://chennaiiq.com/chennai/pincode-by-name.php";

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

	//work in progress
	@Test
	public void test() {

		WebElement table = driver.findElement(By.xpath("/html/body/table/tbody/tr[3]/td[2]/table[1]/tbody"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		for (int i = 3; i < rows.size(); i++) {
			List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
			String pinCode1 = cols.get(2).getText();
			for (int j = i; j < rows.size(); j++) {
				String pinCode2 = cols.get(2).getText();
				Assert.assertFalse(pinCode1 == pinCode2); 
			}
			System.out.println(i);
			if (i == 100) {
				break;
			}
		}


	}
	
	 
	
}

	















