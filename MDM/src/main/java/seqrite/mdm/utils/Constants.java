package seqrite.mdm.utils;

/**
 * @author siddhant.raut
 * 
 * This class contains the list of constants variables 
 * required to use constant value in MDM Application.
 */

public class Constants {

	public static String MDM_AutomationServer_url="https://10.10.26.14:8443/#";
	
	public static String FirefoxDriver_Key ="webdriver.firefox.marionette";
	
	public static String ChromeDriver_key ="webdriver.chrome.driver";
	
	public static String Test_Data_Dir_Path = System.getProperty("user.dir")+"\\TestData\\";
	
	public static String Test_Data_Excel_Dir_Path = System.getProperty("user.dir")+"\\TestData\\Excel\\";
	
	public static String FirefoxDriver_Path = System.getProperty("user.dir")+"\\Resources\\geckodriver.exe";
			
    public static String ChromeDriver_Path = System.getProperty("user.dir")+"\\Resources\\chromedriver.exe";
	
//	public static String Test_Data_Excel_File_Name = "MDMTestData.xlsx"; 
	
	public static String Test_Data_Excel_File = "New_MDMTestData.xlsx";
	
	public static String Test_Data_Sheet_UserLogin = "UserLogin";
	
	public static String Test_Data_Sheet_Users = "Users";
	
	public static String Test_Data_Sheet_Configurations = "Configurations";
	
	public static String Test_Data_Sheet_Department = "Department";
	
	public static String Sheet_Policies = "Policies";
	
	public static String DB_Queries_Sheet="DBQueries";
	
	//Lavina
	public static String Test_Data_CSV_File = "Users.csv";
	
	public static String Test_Data_Sheet_Group= "Group";
	
	public static String Test_Data_APK_Dir_Path = System.getProperty("user.dir")+"\\TestData\\APKs\\";
	
	public static String ScreenShot_Dir = System.getProperty("user.dir")+"\\ScreenShots\\";
	
	public static String ScreenShot_Report_Dir = System.getProperty("user.dir")+"\\Reports\\Failed Case Screenshot\\";
	
	//public static String Report_Batch = "cmd /c start E:/Repository/mdm/Omkar/MDM_Sanity_Test_Report.bat";
	public static String Report_Batch = System.getProperty("user.dir")+"\\MDM_Sanity_Test_Report.bat";
	public static String Test_Data_Sheet_Fence = "Fences";
	
	public static String Test_Data_Sheet_Device= "Devices";
			
}
