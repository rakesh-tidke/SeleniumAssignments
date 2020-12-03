package googleAccountCreate;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class GoogleAccountCreation {

	WebDriver driver;

	String url = "https://accounts.google.com/signup";

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
		
		//Checking First Name text field
		driver.findElement(By.name("firstName")).sendKeys("Robert");
		
		//Checking Last Name text field
		driver.findElement(By.name("lastName")).sendKeys("Lewandowski");
		
		//Checking Username text field
		WebElement username = driver.findElement(By.name("Username"));
		username.sendKeys("lewangoatski9");
		System.out.println("Username : "+username.getAttribute("value"));
		
		String password = "BestStriker#9";
		
		//Checking password text field
		driver.findElement(By.name("Passwd")).sendKeys(password);
		
		//Checking confirm password text field
		driver.findElement(By.name("ConfirmPasswd")).sendKeys(password);
		
		//clicking on Next Button
		driver.findElement(By.xpath("//*[@id=\"accountDetailsNext\"]/div/button")).click();
		
		//wait for page to load
		Thread.sleep(5000);
		
		//checking if navigating to next page
		String title = driver.findElement(By.id("headingText")).getText();
		
		if(title.contains("Verifying your phone number")) {
			System.out.println("Test Passed.. Navigated to " + title + " window");
		}
		else {
			System.out.println("Test Failed.. Navigated to " + title + " window");
		}
		
		
	}
}
