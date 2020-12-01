package popupTest;

import java.util.Iterator;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PopUpTest {
	
	WebDriver driver;

	String url = "http://popuptest.com/goodpopups.html";

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
	public void test() {
		
		driver.findElement(By.linkText("Good PopUp #3")).click();
		
		Set<String> window = driver.getWindowHandles();
		
		Iterator<String> iterate = window.iterator();
		
		String parent = iterate.next();
		String child = iterate.next();
		
		driver.switchTo().window(parent);
		System.out.println("Parent window title : "+ driver.getTitle());
		
		driver.switchTo().window(child);
		System.out.println("Child window title : " + driver.getTitle());
		driver.close();
		
		
	}

}

