package screenshots;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

public class TakeScreenshots {

	WebDriver driver;
	String url = "https://api.jquery.com/dblclick/";

	@Before
	public void setUp() throws Exception {

		System.setProperty("webdriver.chrome.driver", "D:\\RAKESH\\Infosys\\ChromeDriver\\chromedriver.exe");

		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void test() {

		try {

			File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			File demo = new File("C:\\Users\\!dea\\Documents\\Screenshots\\SeleniumScreenshot.png");
			Files.copy(screenshot,demo);
			
			Thread.sleep(3000);
			
			System.out.println("Screenshot Taken succesfully");

		}catch (Exception e) {
			System.out.println("Message : "+ e.getMessage());
		}
	}
}
