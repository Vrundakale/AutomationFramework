package generic_utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * *This class consists of all generic methods related to File operation
 */

public class FileUtility {
	public String readDataFromPropertyFile(String key) throws IOException{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Common data.prop");
		Properties p= new Properties();
		p.load(fis);
		String value=p.getProperty(key);
		return value;
	}
	
	public String readDataFromExcelFileString (String sheetName,int rownum, int cellnum ) throws EncryptedDocumentException, IOException{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Test Data.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		 String value = wb.getSheet(sheetName).getRow(rownum).getCell(cellnum).getStringCellValue();
		return value;
		
	}
	
	public double readDataFromExcelFileDouble (String sheetName,int rownum, int cellnum ) throws EncryptedDocumentException, IOException{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Data driven testing .xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		  double value = wb.getSheet(sheetName).getRow(rownum).getCell(cellnum).getNumericCellValue();
		return value;
	}

}
