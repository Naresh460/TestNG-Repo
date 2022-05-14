package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelreadDattaprovider {


	@Test  @DataProvider
	public String[][] excel2dataprovider() throws IOException {
		File file = new File("C:\\Users\\nbusireddy\\Selenium\\git\\sample.xlsx");
		FileInputStream fis= new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("Sheet3");
		int noOfRows = sheet.getPhysicalNumberOfRows();
		int cellcount= sheet.getRow(0).getLastCellNum();
		System.out.println(noOfRows);
		System.out.println(cellcount);

		String[][] data = new String[noOfRows-1][cellcount];

		for (int i =0; i <noOfRows-1;i++) {
			for (int j = 0; j < cellcount; j++) {

				DataFormatter df = new DataFormatter();
				data[i][j] =df.formatCellValue(sheet.getRow(i+1).getCell(j));
				
			}
		}
		workbook.close();
		fis.close();

		return data;

	}


}
