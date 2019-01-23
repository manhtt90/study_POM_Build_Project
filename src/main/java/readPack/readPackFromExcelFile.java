package readPack;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

/*
 * Apache POI lÃ  má»™t thÆ° viá»‡n mÃ£ nguá»“n má»Ÿ Java,
 * Poor Obfuscation Implementation: Sá»± thá»±c hiá»‡n cÃ¡i nghÃ¨o nÃ n ngu muá»™i 
 * Ä‘Æ°á»£c cung cáº¥p bá»Ÿi Apache, nÃ³ lÃ  má»™t thÆ° viá»‡n Ä‘áº§y sá»©c máº¡nh giÃºp báº¡n lÃ m viá»‡c 
 * vá»›i cÃ¡c tÃ i liá»‡u cá»§a Microsoft nhÆ° Word, Excel, Power point, Visio,... 
 */
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;//Ä�á»�c vÃ  ghi Ä‘á»‹nh dáº¡ng file Open Office XML (XLSX).
import org.testng.annotations.DataProvider;

public class readPackFromExcelFile {
	//@SuppressWarnings("deprecation")
	public static String randomPackIdRange1;	// set a Global variable to use later in other Payment class
	public static String randomPackIdRange2;
	public static String randomPackIdRange3;

	public void readExcel(String filePath, String fileName, String sheetName) throws IOException {
		// Create an object of File class to open xlsx file, need import java.io.File
		File file = new File(filePath + "\\" + fileName);
		// Create an object of FileInputStream class to read excel file,
		// need import java.io.FileInputStream
		FileInputStream inputStream = new FileInputStream(file);
		// interface Workbook, need to import org.apache.poi.ss.usermodel.Workbook
		Workbook guru99Workbook = null;
		// Find the file extension by splitting file name in substring and getting only
		// extension name
		String fileExtensionName = fileName.substring(fileName.indexOf("."));
		// Check condition if the file is xlsx file
		if (fileExtensionName.equals(".xlsx")) {
			// If it is xlsx file then create object of XSSFWorkbook class
			// need to import org.apache.poi.xssf.usermodel.XSSFWorkbook
			guru99Workbook = new XSSFWorkbook(inputStream);
		}
		// Check condition if the file is xls file
		else if (fileExtensionName.equals(".xls")) {
			// If it is xls file then create object of HSSFWorkbook class
			// need to import org.apache.poi.hssf.usermodel.HSSFWorkbook
			guru99Workbook = new HSSFWorkbook(inputStream);
		}
		// interface Sheet, Read sheet inside the workbook by its name
		Sheet guru99Sheet = guru99Workbook.getSheet(sheetName);
		/*System.out.println("SheetName of workbook is: " + sheetName);*/
		// Find number of rows in excel file
		int rowCount = guru99Sheet.getLastRowNum() - guru99Sheet.getFirstRowNum();
		/*System.out.println("rowCount is: " + rowCount);*/

		// Create a loop over all the rows of excel file to read it
		List<Package> listPack = new ArrayList();
		for (int i = 0; i < rowCount; i++) {
			/*
			 * System.out.println("*** First loop ***"); // Do not count blank value, +1 to
			 * remove first row "name" here // interface Row, need to import
			 * org.apache.poi.ss.usermodel.Row
			 */ Row row = guru99Sheet.getRow(i + guru99Sheet.getFirstRowNum() + 1);
			// Create a loop to print cell values in a row
			// interface Cell, need to import org.apache.poi.ss.usermodel.Cell
			Cell cellNo = row.getCell(0); 		//tu bang lay dc, lay hang dau tien la chua cellNo of bang
			Cell cellPackID = row.getCell(1);	//tu bang lay dc, lay hang thu hai la chua cellPackId of bang
			Cell cellPackValue = row.getCell(2);//tu bang lay dc, lay hang thu ba la chua cellPackValue of bang

			//tao class package p
			Package p = new Package();
			p.packNo = Integer.parseInt(getValueOfCell(cellNo));			//chuyen cellNo sang dinh dang Int neu no la string
			p.packID = getValueOfCell(cellPackID);							//packID la string cung duoc
			p.packValue = Integer.parseInt(getValueOfCell(cellPackValue));	//chuyen cellPackValue sang dinh dang Int neu no la string
			listPack.add(p);

			/*
			 * System.out.println("Package is: " + p); System.out.println("Package No is: "
			 * + p.packNo); System.out.println("Package ID is: " + p.packID);
			 * System.out.println("Package Value is: " + p.packValue);
			 */
		}

		//WITHOUT SORTED: Print all values in Excel file
		/*System.out.println();
		System.out.println("~~ Print all values in Excel file, without SORT ~~");*/
		for (int i = 0; i < listPack.size(); i++) {
			Package p = listPack.get(i);
			/*System.out.println("No " + p.packNo + " PackID: " + p.packID + " Value: " + p.packValue);*/
		}

		// SORT 1: SORTED by Package Value from lowest price to highest price
		Collections.sort(listPack, new Comparator<Package>() {
			public int compare(Package p1, Package p2) {
				return p1.packValue.compareTo(p2.packValue);
			}
		}
		);

		//SORT 2: SORTED by Package Value from lowest price to highest price
		/*System.out.println();
		System.out.println("=== SORTED by Package Value from lowest price to highest price ===");*/
		for (int i = 0; i < listPack.size(); i++) {
			Package p = listPack.get(i);
			/*System.out.println("No " + p.packNo + " PackID: " + p.packID + " Value: " + p.packValue);*/
		}

		// I. FILTER VALUE RANGE1 (0 to below 50000)
		List<Package> listPFilterRange1 = new ArrayList();
		int minRange1a = 0;
		int maxRange1b = 100000;
		for (int i = 0; i < listPack.size(); i++) {
			Package p = listPack.get(i);
			if (p.packValue <maxRange1b && p.packValue > minRange1a) {
				listPFilterRange1.add(p);
			}
		}
		/*System.out.println();
		System.out.println("=== FILTER VALUE RANGE FROM 0 to below 100000 ===");*/
		for (int i = 0; i < listPFilterRange1.size(); i++) {
			Package p = listPFilterRange1.get(i);
			/*System.out.println("No " + p.packNo + " PackID: " + p.packID + " Value: " + p.packValue);*/
		}

		// Get RANDOM value within RANGE1 (0 to 100000) to make Zalo
		Random randomValueRange1 = new Random();
		int indexRange1 = randomValueRange1.nextInt(listPFilterRange1.size());
		/*System.out.println();
		System.out.println("===RANDOM VALUE===");
		System.out.println("index random cell position is: " + indexRange1);*/
		Package packRandomRange1 = listPFilterRange1.get(indexRange1);
		/*System.out.println("packRandomRange1: No " + packRandomRange1.packNo + " PackID: " + packRandomRange1.packID + " Value: " + packRandomRange1.packValue);*/
		//set an object to get packRandom.Id for Payment purpost
		randomPackIdRange1 = packRandomRange1.packID;
		System.out.println("randomPackIdRange1: " +randomPackIdRange1);

		// I. FILTER VALUE RANGE2 (50000 to 20000000)
		List<Package> listPFilterRange2 = new ArrayList();
		int minRange2a = 50000;
		int maxRange2b = 20000000;
		for (int i = 0; i < listPack.size(); i++) {
			Package p = listPack.get(i);
			if (p.packValue <=maxRange2b && p.packValue >= minRange2a) {
				listPFilterRange2.add(p);
			}
		}
		/*System.out.println();
		System.out.println("=== FILTER VALUE RANGE FROM 50000 to 20000000 ===");*/
		for (int i = 0; i < listPFilterRange2.size(); i++) {
			Package p = listPFilterRange2.get(i);
			/*System.out.println("No " + p.packNo + " PackID: " + p.packID + " Value: " + p.packValue);*/
		}

		// Get RANDOM value within RANGE1 (0 to 49999) to make Zalo
		Random randomValueRange2 = new Random();
		int indexRange2 = randomValueRange2.nextInt(listPFilterRange2.size());
		/*System.out.println();
		System.out.println("===RANDOM VALUE===");
		System.out.println("index random cell position is: " + indexRange2);*/
		Package packRandomRange2 = listPFilterRange2.get(indexRange2);
		/*System.out.println("packRandomRange2: No " + packRandomRange2.packNo + " PackID: " + packRandomRange2.packID + " Value: " + packRandomRange2.packValue);*/
		//set an object to get packRandom.Id for Payment purpost
		randomPackIdRange2 = packRandomRange2.packID;
		System.out.println("randomPackIdRange2: " +randomPackIdRange2);

		// Demo: Only print the first Row (not count Blank value)
//		Row row = guru99Sheet.getRow(guru99Sheet.getFirstRowNum() + 1);
//		Cell cellNo = row.getCell(0);
//		Cell cellPackID = row.getCell(1);
//		Cell cellPackValue = row.getCell(2);
//
//		Package p = new Package();
//		p.packNo = Integer.parseInt(getValueOfCell(cellNo));
//		p.packID = getValueOfCell(cellPackID);
//		p.packValue = Integer.parseInt(getValueOfCell(cellPackValue));
//
//		System.out.println("No " + p.packNo + " PackID: " + p.packID + " Value: " + p.packValue);
	}

	// Filter neu value cua Cell lÃ  dáº¡ng NUMERIC hay BOOLEAN hay STRING thÃ¬ Ä‘á»�u tráº£
	// vá»� dáº¡ng STRING
	private static String getValueOfCell(Cell cell) {
		switch (cell.getCellType()) {
		case Cell.CELL_TYPE_NUMERIC:
			return String.valueOf((int) cell.getNumericCellValue());
		case Cell.CELL_TYPE_STRING:
			return cell.getStringCellValue();
		case Cell.CELL_TYPE_BOOLEAN:
			return String.valueOf(cell.getBooleanCellValue());
		default:
			return null;
		}
	}

	// Main function is calling readExcel function to read data from excel file
	public static void main(String... strings) throws IOException {
		// Create an object of ReadGuru99ExcelFile class
		readPackFromExcelFile objExcelFile = new readPackFromExcelFile();
		// Prepare the path of excel file
		String filePath = System.getProperty("user.dir") + "\\src\\excelExportAndFileIO";
		// Call read file method of the class to read data
		objExcelFile.readExcel(filePath, "ExportExcelAllGames.xlsx", "jxm");
	}

	public class Package {
		Integer packNo;
		String packID;
		Integer packValue;
	}
}
