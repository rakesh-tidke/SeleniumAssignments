package readExcelFile;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ReadExcelFileTest {

	XSSFWorkbook workbook;
	XSSFSheet sheet;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws Exception {

		String filepath = "C:\\Users\\!dea\\Desktop\\TestData.xlsx";
		FileInputStream FileStream = new FileInputStream(filepath);

		workbook = new XSSFWorkbook(FileStream);
		sheet = workbook.getSheet("Sheet1");

		int rowCount = sheet.getPhysicalNumberOfRows();
		System.out.println("Row Count = "+ rowCount);

		for(int i=1; i < rowCount; i++) {

			int JerseyNo = (int) sheet.getRow(i).getCell(0).getNumericCellValue();
			String FirstName = sheet.getRow(i).getCell(1).getStringCellValue();
			String LastName = sheet.getRow(i).getCell(2).getStringCellValue();

			System.out.println(JerseyNo);
			System.out.println(FirstName);
			System.out.println(LastName);
			System.out.println("***********************************************");

		}

	}

}
