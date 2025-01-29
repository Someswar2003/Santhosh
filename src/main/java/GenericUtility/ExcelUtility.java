package GenericUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class is used to maintain All specific common methods
 * 
 * @author Sudarshan palla
 *
 */

public class ExcelUtility {

	/**
	 * This Method is used to Fetch the Data from Excel Sheet
	 * 
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws Throwable
	 */
	public String getDataFromExcel(String sheetName, int rowNum, int cellNum) throws Throwable {

		FileInputStream fis = new FileInputStream("./src/main/resources/CommanData/TestData.xls");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(rowNum);
		Cell cel = row.getCell(cellNum);
		String data = cel.getStringCellValue();
		wb.close();
		return data;
	}

	/**
	 * This Method is used to get the Numeric and String Data from the Excel
	 * 
	 * @param sheetname
	 * @param rownum
	 * @param cellnum
	 * @return
	 * @throws Throwable
	 */
	public String getDataFromTheExcel(String Sheetname, int rownum, int cellnum) throws Throwable {

		FileInputStream fis = new FileInputStream("./src/main/resources/CommanData/TestData.xls");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(Sheetname);
		DataFormatter format = new DataFormatter();
		String data = format.formatCellValue(sh.getRow(rownum).getCell(cellnum));
		return data;

	}

	public String getDataFromTheExcel_DoctorDesk(String sheetName, int rowNum, int cellNum) throws Throwable {
		FileInputStream fis = new FileInputStream("./src/main/resources/CommanData/DoctorDeskTestData.xls");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);

		if (sh != null) {
			Row row = sh.getRow(rowNum);
			if (row != null) {
				Cell cell = row.getCell(cellNum);
				if (cell != null) {
					DataFormatter format = new DataFormatter();
					return format.formatCellValue(cell);
				} else {
					throw new IllegalArgumentException("Cell " + cellNum + " does not exist in row " + rowNum);
				}
			} else {
				throw new IllegalArgumentException("Row " + rowNum + " does not exist in sheet " + sheetName);
			}
		} else {
			throw new IllegalArgumentException("Sheet " + sheetName + " does not exist");
		}
	}

	public String getDataFromTheExcel(String fileName, String Sheetname, int rownum, int cellnum) throws Throwable {

		FileInputStream fis = new FileInputStream(fileName);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(Sheetname);
		DataFormatter format = new DataFormatter();
		String data = format.formatCellValue(sh.getRow(rownum).getCell(cellnum));
		return data;

	}

	/**
	 * This Method is used to Get the Numeric Data from the Excel Sheet
	 * 
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws Throwable
	 */
	public double getintDataFromExcel(String sheetName, int rowNum, int cellNum) throws Throwable {

		FileInputStream fis = new FileInputStream("./src/main/resources/CommanData/TestData.xls");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(rowNum);
		Cell cel = row.getCell(cellNum);
		double data = cel.getNumericCellValue();

		wb.close();
		return data;
	}

	/**
	 * This method is used to get the Last Number of Specicified Sheet
	 * 
	 * @param sheetName
	 * @return
	 * @throws Throwable
	 */

	public int getRowCount(String sheetName) throws Throwable {
		FileInputStream fis = new FileInputStream("D:\\Eclipse\\com.Dalvkot.vsshhms2\\src\\main\\resources");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		wb.close();
		return sh.getLastRowNum();
	}

	/**
	 * This method used to Write Data inside the Sheet
	 * 
	 * @param sheetName
	 * @param rowNum
	 * @param celNum
	 * @param data
	 * @throws Throwable
	 */

	public void setDataExcel(String sheetName, int rowNum, int celNum, String data) throws Throwable {
		FileInputStream fis = new FileInputStream("./src/main/resources/CommanData/TestData.xls");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(rowNum);
		Cell cel = row.createCell(celNum);
		cel.setCellValue(data);
		FileOutputStream fos = new FileOutputStream("./");
		wb.write(fos);
		wb.close();

	}

	/**
	 * This method is used to fetch the multiple data from the excel sheet
	 * 
	 * @param sheetName
	 * @return
	 * @throws Throwable
	 */
	public Object[][] getMultipleDataFromExcel(String sheetName) throws Throwable {

		FileInputStream fis = new FileInputStream("./src/main/resources/CommanData/TestData.xls");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Object[][] arr = new Object[sh.getLastRowNum()][sh.getRow(0).getLastCellNum()];
		for (int i = 0; i < sh.getLastRowNum(); i++) {
			for (int j = 0; j < sh.getRow(i).getLastCellNum(); j++) {
				arr[i][j] = sh.getRow(i + 1).getCell(j).getStringCellValue();
			}
		}
		return arr;
	}

	public List<String> fetchDataFromExcel(String sheetName, int columnIndex) {
		List<String> data = new ArrayList<>();
		Set<String> uniqueData = new HashSet<>();
		try (FileInputStream inputStream = new FileInputStream("./src/main/resources/CommanData/TestData.xls");
				Workbook workbook = new HSSFWorkbook(inputStream)) {
			Sheet sheet = workbook.getSheet(sheetName);
			if (sheet != null) {
				for (Row row : sheet) {
					Cell cell = row.getCell(columnIndex); // Fetching data from the specified column index
					if (cell != null) {
						String cellValue = cell.getStringCellValue();
						if (!uniqueData.contains(cellValue)) {
							data.add(cellValue);
							uniqueData.add(cellValue);
						}
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return data;
	}
}