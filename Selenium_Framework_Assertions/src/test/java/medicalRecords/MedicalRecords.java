package medicalRecords;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MedicalRecords {

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

		//Click on "Medical Records" link
		driver.findElement(By.linkText("Medical Records")).click();

		//Click on "Search Patient" link
		driver.findElement(By.linkText("Search Patient")).click();

		//click on field Drop down
		WebElement fieldDropdown = driver.findElement(By.id("search_type"));
		Select field = new Select(fieldDropdown);

		//Wait for page to load
		Thread.sleep(2000);

		//Select First Name option
		field.selectByVisibleText("First Name");

		//Click "Search" button
		driver.findElement(By.xpath("//*[@id=\"search_patient\"]")).submit();

		//To verify if navigated to search results window
		String title = driver.findElement(By.xpath("//*[@id=\"content\"]/h1")).getText();
		
		if(title.contains("Search Results")) {
			System.out.println("Test Passed.. Navigated to " + title + " window");
		}
		else {
			System.out.println("Test Failed.. Navigated to " + title + " window");
		}

	}


}
