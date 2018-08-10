package seqrite.mdm.utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;
//	private static XSSFRow Row;

	
	/**
	 * @author siddhant.raut
	 * 
	 * This class contains the list of  methods to read data from excel data using different ways 
	 * 
	 */

		public static void setExcelFile(String Path,String SheetName) throws Exception  {

			try {

				// Open the Excel file

			FileInputStream ExcelFile = new FileInputStream(Path);

			// Access the required test data sheet

			ExcelWBook = new XSSFWorkbook(ExcelFile);
			
			ExcelWSheet = ExcelWBook.getSheet(SheetName);
			
			} catch (Exception e){

				throw (e);

			}
	}
		
		/**
		 * @author siddhant.raut
		 * 
		 * This method is to read the test data from the Excel cell, 
		 * in this we are passing parameters as Row num and Col num 
		 * 
		 */

		public static String getCellData(int RowNum, int ColNum) throws Exception{
				
			try {

				Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);

				String CellData = Cell.getStringCellValue();

				return CellData;

				}catch (Exception e){

				return"";

				}
		}
		
//		@Test
		public static void readexcelvalue() throws Exception{
			
			setExcelFile(Constants.Test_Data_Dir_Path+Constants.Test_Data_Excel_File, Constants.Test_Data_Sheet_UserLogin);
			System.out.println("FilePath:" + Constants.Test_Data_Dir_Path+Constants.Test_Data_Excel_File);
			System.out.println(Constants.Test_Data_Sheet_UserLogin);
			String data0= getCellData(1,1);
			System.out.println(data0);
		}
		
//===============================================================================================================================================================	
		
		/**
		 * @author siddhant.raut
		 * 
		 * This method is to read the test data from the Excel, 
		 * which read the all data from Excel from sheet 
		 * 
		 */
		
		 public static void readExcel(String filePath,String fileName,String sheetName) throws IOException{

			    File file =    new File(filePath+"\\"+fileName);
			    FileInputStream inputStream = new FileInputStream(file);

			    Workbook Workbook = null;
			    
			    //Find the file extension by spliting file name in substring and getting only extension name
			    String fileExtensionName = fileName.substring(fileName.indexOf("."));

			    if(fileExtensionName.equals(".xlsx")){
			    	Workbook = new XSSFWorkbook(inputStream);
			    }
			    else if(fileExtensionName.equals(".xls")){
			    	Workbook = new HSSFWorkbook(inputStream);
			    }

			    //Read sheet inside the workbook by its name
			    Sheet MDMTestData = Workbook.getSheet(sheetName);
			    //Find number of rows in excel file

			    int rowCount = MDMTestData.getLastRowNum()-MDMTestData.getFirstRowNum();
			    System.out.println(rowCount);
			    
			    String data = null, data0 = null;
			    for (int i = 0; i <= rowCount+1; i++) {

			        Row row = MDMTestData.getRow(i);

			        //Create a loop to print cell values in a row

			        for (int j = 0; j < row.getLastCellNum(); j++) {

			        	System.out.print(row.getCell(j).getStringCellValue()+ "  ");
			        }
			        System.out.println();
			    }
  }

//		 @Test
			public static void readexcelvalue1() throws Exception {
				
			 	readExcel("E:\\Chat\\workspace\\MDM\\TestData\\Excel\\", "MDMTestData.xlsx", "UserLogin");
	}
		 
//==============================================================================================================================================================
			/**
			 * @author siddhant.raut
			 * This method is to read the test data from the Excel cell, 
			 * This method is use to read the all data from Excel from sheet 
			 */
			
		 	 public static String get_excel_value(String key, String excelName, String sheetname) throws IOException{
		 		 
		 	 Log.info("Excel Data key, ExcelName, SheetName:" +key +excelName +sheetname);
		 	 
			 File src = new File(Constants.Test_Data_Excel_Dir_Path+excelName);
			 
			 FileInputStream fis = new FileInputStream(src);
			 
			 XSSFWorkbook wb1 = new XSSFWorkbook(fis);
			 
			 XSSFSheet sh1 = wb1.getSheet(sheetname);
			 
			 Log.info("Excel Sheet Found:" +sheetname);
			 
			 // Create an ArrayList to store the data read from excel sheet.
			 
			 List sheetData  =new ArrayList();
			 
			 Iterator rows = sh1.rowIterator();
			 
			 while (rows.hasNext()) 
			 {
				 XSSFRow row = (XSSFRow) rows.next();
				 
				 Iterator cells = row.cellIterator();
				 
				 List celldata = new ArrayList();
				 
			 while (cells.hasNext()) {
				 
				 XSSFCell cell = (XSSFCell) cells.next();

				 celldata.add(cell);
				 }
			 
				 sheetData.add(celldata);
			 }
			 Map<String,String> test = new HashMap<String,String>();
			 
			 for (int i=0;i<sheetData.size();i++)
			 {
//				 System.out.println("sheetdata :"+sheetData.get(i).toString().replace("[", "").replace("]", ""));
				 
				 test.put(sheetData.get(i).toString().replace("[", "").replace("]", "").split(",")[0].trim(), 
						 sheetData.get(i).toString().replace("[", "").replace("]", "").split(",")[1].trim());
			 }
			 String value = test.get(key);
			Log.info("Value for key " +key +"is= "+ test.get(key));
			 return value;
	}
}

//=====================================================================================================================================================================
	
		 	 
	