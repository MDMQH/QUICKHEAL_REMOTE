package seqrite.mdm.utils;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/**
 * @author siddhant.raut
 * This class contains the  common utilities for MDM like 
 * Take screenshot, pick TestData file to upload,  
 * Database connection to execute query
 *  
 */

public class CommonUtils extends Setup{

//	static WebDriver driver;
	public static String screenPath = Constants.ScreenShot_Dir;
	public static String FinalPath = Constants.ScreenShot_Report_Dir;
	public static String methodName=null;
	private static ConfigReader cr = new ConfigReader();
	public static Connection cont = null;
	public static Connection cong = null;
	public static ResultSet rs;
	public static Statement smt;
	public static String QueryResult;
	public static String title;
	public static String DB_URL=cr.getDB_URL_Tenant();
	public static String DB_URL_Global=cr.get_DB_URL_Global();
	public static String DB_User=cr.getDB_User();
	public static String DB_Password=cr.getDB_Password();
	public ExtentTest extentTest;

	
	
	static ORReader OR = new ORReader();

//===============================================Take ScreenShot========================================================	

	/**
	 * @author poonam.wani
	 *  This method is to write to take screenshot of application.   
	 *  Screenshot get captured on failure to Screenshot directory and move to report directory.
	 *  
	 */
//	public static void takeScreenShot(WebDriver driver, String methodName) throws InterruptedException {
		
public static void takeScreenShot(String methodName) throws InterruptedException {
		
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss");
		  
		  Date date = new Date();
		  
	    	File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    	 
	    	String ScreenshotName = screenPath+ methodName + "_"+ dateFormat.format(date) +".png";
	    	 
	    	String DestScreenshotName = FinalPath+ methodName + "_"+ dateFormat.format(date) +".png";
	    	
	    	Log.info("Failed : Taking Screenshot : " + ScreenshotName);
	    	 
	    	 File source= new File(ScreenshotName);
	    	 File dest=new File(DestScreenshotName);
	    	 
	         //The below method will save the screen shot in d drive with test method name 
	            try {
					FileUtils.copyFile(scrFile, source);
					System.out.println("***Screen shot is placed in "+source+"***");
					//FileUtils.copyFile(source, Destination);
					   FileUtils.copyFile(scrFile, dest);
	            }
					 catch (IOException e) {
			e.printStackTrace();
		}
	}
	      
	
	

	
	
	
	
	/*@AfterMethod

	public void onTestFailure(ITestResult result) throws InterruptedException {

		if (ITestResult.FAILURE == result.getStatus()) {

			System.out.println("***** Error " + result.getName() + " test has failed *****");
			String methodName = result.getName().toString().trim();
			takeScreenShot(methodName);
	} */ 
	
	
	
	
	


// ===============================================Read File from TestData Location ========================================================
	/**
	 * @author swapnil.dravid		
	 * This method is to test select file from TestData directory to upload on AUT
	 *    
	 */
	public static void get_file_from_testdata(String File_Dir, String File_Name) throws Exception {

		StringSelection ss = new StringSelection(File_Dir + "\\" + File_Name);
		Log.info(" Path of Test Data File is: " + ss);
		
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		// imitate mouse events like ENTER, CTRL+C, CTRL+V
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

//================================================ Connect to database and Execute Query ===================================================
	/**
	 * @author Rochak.Bhalla & Siddhant Raut
	 *  This method is to write to connect database and execute query.
	 *  Pass query as parameter   
	 */
	
    public static Connection connectTenantDB() throws ClassNotFoundException, SQLException{
   
	Log.info("Connecting to Tenant Database");
    Log.info("DB Url Found:" +DB_URL);
	Log.info("DB User & DB Password:" +DB_User +DB_Password);
	
	Class.forName("com.mysql.cj.jdbc.Driver");
	cont =DriverManager.getConnection(DB_URL, DB_User,DB_Password);
	Log.info("QHMDM Tenant Database connected Successfully");
	return cont;
    }
    
    /**
	 * @author siddhant.raut	
	 *  This method is execute query passing sql query as parameter
	 */
    
	public static String executeQueryOnTenantDB(String query) throws Exception{
		cont=connectTenantDB();		
		smt=cont.createStatement();
		rs=smt.executeQuery(query);
		while(rs.next())
			{			
			QueryResult = rs.getString(1);
		}
		return QueryResult;
	}
//=====================================================================================================================================
		
		public static Connection connectGlobaldb() throws Exception {
			
			Log.info("Connecting to Global Database");
		    Log.info("DB Url Found:" +DB_URL_Global);
			Log.info("DB User:" +DB_User);
			Log.info("DB Password:" +DB_Password);
			Class.forName("com.mysql.cj.jdbc.Driver");
			cong =DriverManager.getConnection(DB_URL_Global, DB_User,DB_Password);
			Log.info("QHMDM Global Database connected Successfully");
			return cong;
		    }
		
	public static String  executeQueryOnGolbalDB(String gloablquery) throws Exception{
		
		cong=connectGlobaldb();		
		smt=cong.createStatement();
		rs=smt.executeQuery(gloablquery);
		while(rs.next())
			{			
			QueryResult = rs.getString(1);
			Log.info("Database record is " +QueryResult);
		}
		return QueryResult;
	}

//======================================================Maximize Browser window=============================================================
	/**
	 * @author  siddhnat.raut	
	 *  This method is maximize browser window
	 */
	
	public static void maximize_browser_window(WebDriver driver){
		driver.manage().window().maximize();
		}
	
//==================================================Execute Batch===========================================================================
	/**
	 * @author  siddhnat.raut	
	 *  This method is use to execute batch File
	 */
	
	public static void execute_batch() throws IOException {

		Log.info("searching for batch file .........");
		String path = Constants.Report_Batch;
		Log.info(path);
		Runtime rn = Runtime.getRuntime();
		Process pr = rn.exec(path);
		Log.info("Batch Executed Successfully ..........");
		System.out.println("Batch Executed Successfully ..........");
	}
//=====================================================GetTitle of Page=====================================================================	
	/**
	 * @author  siddhnat.raut	
	 *  This method is use to get Title of Page
	 */
	
	public static String get_page_titile(){
		String pagetitle=driver.getTitle();
		return pagetitle;
		}
	
//=====================================================Get Refresh=====================================================================
	
	public static void pageRefresh(){
		driver.navigate().refresh();
	}
	
	
//====================================================ScrollintoView====================
	
	public static void scrolluntilElementIsVisible(WebElement Element) {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", Element);
		
	}
	
		



	
	
}