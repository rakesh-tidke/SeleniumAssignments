package config;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class PropertiesFile {
	
	WebDriver driver;
	
	@Test
	public void readPropertiesFiles() throws Exception {
		
		Properties prop = new Properties();
		InputStream input = new FileInputStream("C:\\Users\\!dea\\git\\SeleniumAssignments\\Selenium_Framework_TestNG_Annotations\\src\\test\\java\\config\\config.properties");
		prop.load(input);
		
		System.out.println(prop.getProperty("browser"));
		System.out.println(prop.getProperty("url"));
		
		
	}

}
