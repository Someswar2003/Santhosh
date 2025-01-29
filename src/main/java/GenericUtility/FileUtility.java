package GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/**
 * This class conatains Property file Specific comman method
 * 
 * @author Sudarshan
 *
 */

public class FileUtility {
	/**
	 * This method is used to read the data from commondata.propertie file
	 * 
	 * @throws Throwable
	 * 
	 */
	public String getProperyKeyValue(String key) throws Throwable {
		FileInputStream fis = new FileInputStream("./src/main/resources/CommanData/Credentials.properties");
		Properties pobj = new Properties();
		pobj.load(fis);
		String value = pobj.getProperty(key);
		return value;
	}
}
