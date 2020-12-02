package brokenLinks;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinksTest {
	

	WebDriver driver;
	String homepage = "http://www.zlti.com";
	String url = "http://www.zlti.com";
	HttpURLConnection httpConnection = null;
	int responseCode= 200;
	
	
	@Before
	public void windowSetup() throws Exception {

		System.setProperty("webdriver.chrome.driver", "D:\\RAKESH\\Infosys\\ChromeDriver\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		Thread.sleep(3000);
		
	}
	
	@After
	public void teardown() {
		driver.quit();
	}
	
	@Test
	public void test() {
		
		driver.get(homepage);
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		
		Iterator<WebElement> iterate = links.iterator();
		
		while(iterate.hasNext()) {
			
			url = iterate.next().getAttribute("href");
			System.out.println(url);
			
			if(url == null || url.isEmpty()) {
				System.out.println("URL is either not configured for anchor tag or it is empty");
				continue;
			}
			
			if(!url.startsWith(homepage)) {
				System.out.println("URL belongs to another domain, skipping it.");
				continue;
			}
			
			try {
				
				httpConnection = (HttpURLConnection) (new URL(url).openConnection());
				httpConnection.setRequestMethod("HEAD");
				httpConnection.connect();
				
				responseCode = httpConnection.getResponseCode();
				
				if(responseCode >= 400) {
					System.out.println(url + " is a broken link");
				}
				else {
					System.out.println(url + " is a valid link");
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				e.getCause();
			}
			
		}
		
	}


}















