package seqrite.mdm.test;
//import java.awt.List;
import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import seqrite.mdm.utils.CommonUtils;
import seqrite.mdm.utils.ConfigReader;
import seqrite.mdm.utils.Constants;
import seqrite.mdm.utils.ExcelUtils;
import seqrite.mdm.utils.Log;
import seqrite.mdm.utils.MDM;
import seqrite.mdm.utils.ORReader;
import seqrite.mdm.utils.Setup;
import seqrite.mdm.utils.TestNGListener;

@Listeners(TestNGListener.class)
public class TestClass extends Setup {

	ConfigReader cr = new ConfigReader();
	static ORReader OR = new ORReader();
	static WebElement element;
	String db_count=null;
	 
//	@Test	
	public void GetTitle() throws Exception {
		
		System.out.println(driver.getCurrentUrl());
		String Title = driver.getTitle();
		Assert.assertEquals("Welcome to Seqrite Mobile Device Management - Sign In", Title);
		driver.manage().window().maximize();

				try {
			// Entering user id
			driver.findElement(OR.getlocator("LOGIN_USERNAME")).sendKeys(cr.getsu_username());
			Thread.sleep(3000);
			
			// Entering Password
			driver.findElement(OR.getlocator("LOGIN_PASSWORD")).sendKeys(cr.getsu_password());
			Thread.sleep(3000);
			// sign in
			driver.findElement(OR.getlocator("LOGIN_BUTTON")).click();
		} 
		catch (Exception e)
		{
			CommonUtils.takeScreenShot("GetTitle");
			throw e;
		}
				
				
		// *******************Excel data read by passing key as parameter**********************************
		// Read Excel data by passing key as parameter to get value
		ExcelUtils.get_excel_value("Mobile", Constants.Test_Data_Excel_File, Constants.Test_Data_Sheet_UserLogin);
		ExcelUtils.get_excel_value("Mobile", Constants.Test_Data_Excel_File, Constants.Test_Data_Sheet_Users);
		ExcelUtils.get_excel_value("New", Constants.Test_Data_Excel_File, Constants.Test_Data_Sheet_Users);
		ExcelUtils.get_excel_value("SuperAdmin", Constants.Test_Data_Excel_File, Constants.Test_Data_Sheet_UserLogin);
		ExcelUtils.get_excel_value("Antitheft Configuration Name", Constants.Test_Data_Excel_File, Constants.Test_Data_Sheet_Users);
		
		// ***************************************Starting uploading File********************************
		
		Thread.sleep(2000);
		// Navigating to Apps
		driver.findElement(By.xpath(".//*[@id='sidebarAccordian']/li[4]/a")).click();
		// navigating to repository
		driver.findElement(By.xpath(".//*[@id='app_control_components']/li[1]/a")).click();
		Thread.sleep(2000);
		// clicking on Add button
		driver.findElement(By.xpath(".//*[@id='user-export-dropdown']/span")).click();
		// selecting custom apk option
		driver.findElement(By.xpath(".//*[@id='custom-apk-modal-link']/a")).click();
		Thread.sleep(2000);
		// selecting the upload apk option
		driver.findElement(By.xpath(".//*[@id='app-repo-add-app-apk']/label/div/div/div/span/span")).click();
		Thread.sleep(2000);
		CommonUtils.get_file_from_testdata("APKs","2048 Puzzle.apk");
		Thread.sleep(2000);
		

// ******************************************DB function to Execute query by passing query as parameter**********************
		CommonUtils.executeQueryOnTenantDB("select * from device");
	}
	
	@Test
	public void get_Values() throws Exception{
		
		String DeviceCount= ExcelUtils.get_excel_value("Get_Devices_Count", Constants.Test_Data_Excel_File , Constants.DB_Queries_Sheet);
		Log.info("Device Count From Database iS= "+ DeviceCount);
		String db_count=CommonUtils.executeQueryOnTenantDB(DeviceCount);
		Log.info("Device Count from Database is ==================> " +db_count);
		
		String RootedDeviceCount= ExcelUtils.get_excel_value("Get_Rooted_Device_Count", Constants.Test_Data_Excel_File , Constants.DB_Queries_Sheet);
		Log.info("Device Count From Database iS= "+ RootedDeviceCount);
		db_count=CommonUtils.executeQueryOnTenantDB(RootedDeviceCount);
		Log.info("Rooted Device Count from Database is ==================> " +db_count);
		
		String Get_Uninstallation_Unsecure_Count= ExcelUtils.get_excel_value("Get_Rooted_Device_Count", Constants.Test_Data_Excel_File , Constants.DB_Queries_Sheet);
		Log.info("Get_Uninstallation_Unsecure_Count iS= "+ Get_Uninstallation_Unsecure_Count);
		db_count=CommonUtils.executeQueryOnTenantDB(Get_Uninstallation_Unsecure_Count);
		Log.info("Rooted Device Count from Database is ==================> " +db_count);
			
		
		String Get_Blocked_Devices_Count= ExcelUtils.get_excel_value("Get_Rooted_Device_Count", Constants.Test_Data_Excel_File , Constants.DB_Queries_Sheet);
		Log.info("Get_Blocked_Devices_Count is= "+ Get_Blocked_Devices_Count);
		db_count=CommonUtils.executeQueryOnTenantDB(Get_Blocked_Devices_Count);
		Log.info("Rooted Device Count from Database is ==================> " +db_count);
	}
	
// ******************************************Pass value to select from dropdown**********************************
/*//@Test
	public void selectValueFromDropdown() throws Exception
	{
		MDM.login();
		OR.is_element_present("NETWORK_USAGE_TIMELINE").click();
		Thread.sleep(2000);
		List <WebElement> dd_list=driver.findElements(By.xpath("//ul[@id='select2-results-1']//li/div"));
		System.out.println(dd_list.size());
		for(int i=0; i<dd_list.size();i++){
			WebElement element= dd_list.get(i);
			String textContent=element.getAttribute("textContent");
			if(textContent.contentEquals("Current Month"))
			{
				System.out.println("clicked on Current Month ");
				element.click();
				Thread.sleep(5000);
				break;
			}
			System.out.println("Values from dropdown is: " +textContent);
			Thread.sleep(2000);
		}
	}*/

//	@Test
	public void checkNetworkGraprh() throws Exception
	{
		MDM.login();
		OR.is_element_present("NETWORK_USAGE_TIMELINE").click();
		Log.info("Click on DropDown");
		Thread.sleep(2000);
		OR.selectValueFromDropdown("NETWORK_USAGE_DROPDOWN" , "Current Month");
	}
//===================================================================================================================================
//	@Test
	public static  void add_App_Configrations() throws Exception{
		
		String AppConfigName= ExcelUtils.get_excel_value("App Configuration Name", Constants.Test_Data_Excel_File, Constants.Test_Data_Sheet_Configurations);
		Log.info("App Configuration Name from Excel: " +AppConfigName);
		MDM.login();
		Log.info("User Login Successfully");
		MDM.gotoAppConfigurations();
		OR.is_element_present("ADD_APP_CONFIG_BUTTON").click();
		OR.is_element_present("APP_CONFIG_NAME_TXTFIELD").sendKeys(AppConfigName);
		OR.is_element_present("BLOCK_ACCESS_TO_NEWLY_INSTALLED_APPS_CHKBOX").click();
		OR.is_element_present("APP_CONFIGURATION_NEXT_BUTTON").click();
		OR.selectCheckBox("APP_CATEGORIES_CHECKBOXES");
//		return "ok";
	}

}

