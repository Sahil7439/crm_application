package genricUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileUtility {
	public String getDataFromPropertiesFile(String path, String key) throws IOException {
		FileInputStream fis = new FileInputStream(path);
		Properties pobj = new Properties();
		pobj.load(fis);
		return pobj.getProperty(key);
	}
	
	public String getDatafromExcelFile(String path, String sheet, int rownum, int cellnum) throws IOException {
		FileInputStream fis = new FileInputStream(path);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheet);
		Row row = sh.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		return cell.getStringCellValue();
	}
}
