package dataProvider;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class Testng {
	@Test(dataProvider = "data")
	public void test (Integer JerseyNo, String FirstName,String LastName) throws IOException {
		System.out.println("******** FC Bayern Team ********");
		System.out.println("Player No "+JerseyNo);
		System.out.println(FirstName);
		System.out.println(LastName);
	}

	@DataProvider(name="data")
	public Object[][] information() {
		Object[][] data = new Object[2][3];

		data[0][0]=9;
		data[0][1]="Robert";
		data[0][2]="Lewandowski";

		data[1][0]=25;
		data[1][1]="Thomas";
		data[1][2]="Muller";

		return data;
	}
	@BeforeTest
	public void beforeTest() {
	}

	@AfterTest
	public void afterTest() {
	}

}
