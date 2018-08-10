/**
 * 
 */
package seqrite.mdm.appmodules;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import seqrite.mdm.utils.Constants;
import seqrite.mdm.utils.ExcelUtils;
import seqrite.mdm.utils.Log;
import seqrite.mdm.utils.MDM;
import seqrite.mdm.utils.ORReader;

/**
 * @author Poonam.Wani This class contains the test case for fence module of mdm
 *         application
 */

public class Fences {

	static ORReader OR = new ORReader();

	/**
	 * @author Poonam.Wani This method will add the Wi-Fi Fence in MDM
	 *         application.
	 * @throws Throwable 
	 * 
	 */
	public static String check_Create_WiFi_Fence() throws Throwable {

		String WifiFenceName = ExcelUtils.get_excel_value("WifiFenceName", Constants.Test_Data_Excel_File,Constants.Test_Data_Sheet_Fence);
		String WifiSSID = ExcelUtils.get_excel_value("WifiSSID", Constants.Test_Data_Excel_File,Constants.Test_Data_Sheet_Fence);

		MDM.login();
		Log.info("User login successfully");
		MDM.gotoFences();
		OR.is_element_present("FENCE_ADD_BUTTON").click();
		OR.is_element_present("SELECT_WIFI_FENCE_OPTION").click();
		OR.is_element_present("WIFI_FENCE_NAME").sendKeys(WifiFenceName);
		OR.is_element_present("WIFI_SSID_NAME").sendKeys(WifiSSID);
		OR.is_element_present("SAVE_WIFI_FENCE_BUTTON").click();
		Log.info("Fence Added Successfuly");
		return ("ok");
	}
// ===================================================================================================================

	/**
	 * @author Poonam.Wani This method will update the Wi-Fi Fence in MDM
	 *         application.
	 * @throws Exception 
	 * 
	 */
	public static String check_Update_WiFi_Fence() throws Exception {
		// TODO Auto-generated method stub
		
		String WiFiFenceName = ExcelUtils.get_excel_value("WifiFenceName", Constants.Test_Data_Excel_File,Constants.Test_Data_Sheet_Fence);
		String UpdateWiFiFenceName = ExcelUtils.get_excel_value("UpdateWiFiFenceName", Constants.Test_Data_Excel_File,Constants.Test_Data_Sheet_Fence);
		
		MDM.login();
		Log.info("User login successfully");
		MDM.gotoFences();
		MDM.searchOnListPage(WiFiFenceName);
		Thread.sleep(1000);
		OR.is_element_present("EDIT_PENCIL_BUTTON").click();
		OR.is_element_present("EDIT_WIFI_FENCE_PROFILE_BUTTON").click();
		OR.is_element_present("WIFI_FENCE_NAME").clear();
		OR.is_element_present("WIFI_FENCE_NAME").sendKeys(UpdateWiFiFenceName);
		OR.is_element_present("UPDATE_WIFI_FENCE_BUTTON").click();
		Log.info("Fence Updated Successfuly");
		
		return ("ok");
	}
	
// ===================================================================================================================
	/**
	 * @author Poonam.Wani This method will add the Geo Fence in MDM
	 *         application.
	 * 
	 */

	public static String check_create_Geo_fence() throws Exception {

		String AreaNameOfGeoFence = ExcelUtils.get_excel_value("AreaNameForFence", Constants.Test_Data_Excel_File,Constants.Test_Data_Sheet_Fence);
		String GeoFenceName = ExcelUtils.get_excel_value("GeoFenceName", Constants.Test_Data_Excel_File,Constants.Test_Data_Sheet_Fence);
		String Radius = ExcelUtils.get_excel_value("RadiusInMeters", Constants.Test_Data_Excel_File,Constants.Test_Data_Sheet_Fence);

		MDM.login();
		Log.info("User login successfully");
		MDM.gotoFences();
		OR.is_element_present("FENCE_ADD_BUTTON").click();
		OR.is_element_present("SELECT_GEO_FENCE_OPTION").click();
		OR.is_element_present("AREA_NAME_FOR_FENCE").sendKeys(AreaNameOfGeoFence);
		OR.is_element_present("AREA_NAME_FOR_FENCE").sendKeys(Keys.SPACE);
		OR.is_element_present("AREA_NAME_FOR_FENCE").sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		OR.is_element_present("ADD_GEO_FENCE_BUTTON").click();
		OR.is_element_present("GEO_FENCE_NAME").sendKeys(GeoFenceName);
		OR.is_element_present("RADIUS_OF_GEO_FENCE").sendKeys(Radius);
		OR.is_element_present("SAVE_GEO_FENCE_BUTTON").click();
		Log.info("Geo Fence created Successfuly");
		return ("ok");
	}

// ===================================================================================================================
	/**
	 * @author Poonam.Wani This method will add the Time Fence in MDM
	 *         application.
	 * 
	 */

	public static String check_create_Time_fence() throws Exception {

		String TimeFenceName = ExcelUtils.get_excel_value("TimeFenceName", Constants.Test_Data_Excel_File,Constants.Test_Data_Sheet_Fence);

		MDM.login();
		Thread.sleep(1000);
		Log.info("User login successfully");
		MDM.gotoFences();
		OR.is_element_present("FENCE_ADD_BUTTON").click();
		Thread.sleep(1000);
		OR.is_element_present("SELECT_TIME_FENCE_OPTION").click();
		Thread.sleep(1000);
		OR.is_element_present("TIME_FENCE_NAME").sendKeys(TimeFenceName);
		Thread.sleep(1000);
		OR.is_element_present("SELECT_DATE_RANGE_FOR_TIME_FENCE").click();
		Thread.sleep(1000);
		//TestClass.selectDateRange("5");
		// Remain to pick the date from the calender for time fence
		//EDIT by Omkar
		OR.is_element_present("FETCH_DATE_RANGE_CHOOSE_START_DATE").click();
		Thread.sleep(1000);
		OR.is_element_present("FETCH_DATE_RANGE_CHOOSE_END_DATE").click();
		Thread.sleep(1000);
		OR.is_element_present("SELECT_DATE_PICKER_FOR_EXCLUDE_DATES").click();
		Thread.sleep(1000);
		OR.is_element_present("SELECT_DATE_1").click();
		Thread.sleep(1000);
		//OR.is_element_present("SELECT_DATE_2").click();
		OR.is_element_present("SAVE_BUTTON_DATE_FENCE").click();
		Thread.sleep(1000);
		Log.info("Time Fence created Successfuly");
		
		//WebElement selectDate = driver.findElement(By.xpath("//span[@aria-controls='datetimepicker_dateview']"));
        
	    //selectDate.click();
		
		//End Omkar
		
		return ("ok");
	}
// ===================================================================================================================
		/**
		 * @author Poonam.Wani This method will add the Fence configuration in MDM
		 *         application.
		 * @throws Exception 
		 * 
		 */
	
	public static String check_create_fence_configuration() throws Exception {
		// TODO Auto-generated method stub
		
		String FenceConfigName = ExcelUtils.get_excel_value("FenceConfigName", Constants.Test_Data_Excel_File,Constants.Test_Data_Sheet_Fence);
		String FenceDescription = ExcelUtils.get_excel_value("Description", Constants.Test_Data_Excel_File,Constants.Test_Data_Sheet_Fence);
		String GeoFenceName = ExcelUtils.get_excel_value("GeoFenceName", Constants.Test_Data_Excel_File,Constants.Test_Data_Sheet_Fence);
		String WifiFenceName = ExcelUtils.get_excel_value("WifiFenceName", Constants.Test_Data_Excel_File,Constants.Test_Data_Sheet_Fence);
		//omkar
		String TimeFenceName = ExcelUtils.get_excel_value("TimeFenceName", Constants.Test_Data_Excel_File,Constants.Test_Data_Sheet_Fence );
		
		MDM.login();
		Log.info("User login successfully");
		MDM.gotoFenceConfigurations();
		OR.is_element_present("ADD_FENCE_CONFIGURATION_BUTTON").click();
		OR.is_element_present("FENCE_CONFIGURATION_NAME").sendKeys(FenceConfigName);
		OR.is_element_present("DESCRIPTION_OF_FENCE_CONFIGURATION").sendKeys(FenceDescription);
		OR.is_element_present("COMPEL_LOCATION_SERVICE_CHECKBOX").click();
		OR.is_element_present("COMPEL_AUTOMATIC_DATE_TIME_CHECKBOX").click();
		OR.is_element_present("COMPEL_WIFI_SERVICE_CHECKBOX").click();
		OR.is_element_present("ADD_FENCE_GROUP_BUTTON").click();
		//omkar
		OR.is_element_present("CLICK_ON_GEO_FENCE").click();
		Log.info("Click on DropDown of Geo Fence");
		OR.selectValueFromDropdown("GEO_FENCE_DROPDOWN", GeoFenceName);
		OR.is_element_present("CLICK_ON_TIME_FENCE").click();
		Log.info("Click on DropDown of Time Fence");
		//OR.selectValueFromDropdown("TIME_FENCE_DROPDOWN", "Time Fence");
		OR.selectValueFromDropdown("TIME_FENCE_DROPDOWN", TimeFenceName);
		OR.is_element_present("CLICK_ON_WIFI_FENCE").click();
		Log.info("Click on DropDown of Wifi Fence");
		OR.selectValueFromDropdown("WIFI_FENCE_DROPDOWN", WifiFenceName);
		//omkar
		
		Log.info("Opened DropDown of Wifi Fence");
		//omkar
		OR.is_element_present("CHECK_BLOCK_ACTION").click();
		//omkar
		Log.info("Block checkbox checked");
		//omkar
		OR.is_element_present("CHOOSE_POLICY_RESTRICTION").click();
		//omkar
		Log.info("policy restriction dropdown opened");
		//omkar
		OR.selectValueFromDropdown("POLICY_RESTRICTION_DROPDOWN", "Default Policy");
		//omkar
		Log.info("Value selected from policy restriction dropdown");
		//omkar
		OR.is_element_present("FENCE_CONFIGURATION_SAVE_BUTTON").click();
		//omkar
		Log.info("Clicked on save button");
		Log.info("check_create_fence_configuration success" );
		//omkar
		return ("ok");
	}
	
// ===================================================================================================================
		/**
		 * @author Poonam.Wani This method will update the Geo Fence in MDM
		 *         application.
		 * @throws Exception 
		 * 
		 */

		public static String check_Update_geo_Fence() throws Exception {
			// TODO Auto-generated method stub
			
			String GeoFenceName = ExcelUtils.get_excel_value("GeoFenceName", Constants.Test_Data_Excel_File,Constants.Test_Data_Sheet_Fence);
			String UpdateGeoFenceName = ExcelUtils.get_excel_value("UpdateGeoFenceName", Constants.Test_Data_Excel_File,Constants.Test_Data_Sheet_Fence);
			
			MDM.login();
			Log.info("User login successfully");
			MDM.gotoFences();
			MDM.searchOnListPage(GeoFenceName);
			OR.is_element_present("EDIT_PENCIL_BUTTON").click();
			OR.is_element_present("EDIT_WIFI_FENCE_PROFILE_BUTTON").click();
			OR.is_element_present("WIFI_FENCE_NAME").clear();
			OR.is_element_present("WIFI_FENCE_NAME").sendKeys(UpdateGeoFenceName);
			OR.is_element_present("UPDATE_WIFI_FENCE_BUTTON").click();
			
			return ("ok");
		}

// ===================================================================================================================	

		//Omkar
		public static String Apply_fence_configuration() throws Throwable{
			try{
				MDM.login();
				Thread.sleep(2000);
				MDM.gotoFenceConfigurations();
				Thread.sleep(2000);
				OR.is_element_present("FENCE_CONFIGURATION_SELECT").click();
				Thread.sleep(2000);
				OR.is_element_present("COMMON_CONFIGURATION_DROPDOWN").click();
				Thread.sleep(2000);
				//OR.is_element_present("ANTITHEFT_CONFIGURATION_DROPDOWN_SELECT").click();
				OR.selectValueFromDropdown("COMMON_CONFIGURATION_DROPDOWN_SELECT", "Apply to Groups");
				Thread.sleep(2000);
				OR.is_element_present("FENCE_CONFIGURATION_SELECT_GROUPS_BUTTON").click();
				Thread.sleep(2000);
				
				OR.is_element_present("FENCE_CONFIGURATION_SELECT_GROUP").click();
				Thread.sleep(2000);
				
				OR.is_element_present("FENCE_CONFIGURATION_APPLYBUTTON").click();
				OR.is_element_present("COMMON_CONFIGURATION_CONFIRMATION_OK_BUTTON").click();
				//MDM.ApplyConfigurationToDevice();
		
				Thread.sleep(20000);
				MDM.gotoDevices();
				OR.is_element_present("COMMON_CONFIGURATION_CLICK_DEVICE").click();
				OR.is_element_present("COMMON_CONFIGURATION_OPEN_DEVICE").click();
				OR.is_element_present("COMMON_CONFIGURATION_OPEN_ACTIVITY").click();
				//tbody//tr[1]//td[1]//div[1]//span[1]//span[3]//span[8]
				
				MDM.activitystatus();
				
				}
				catch(Throwable t){
					System.out.println("No Success");	
					
				}
			
			
			
			return "ok";
		}

		
		
		
		
		
		
}
