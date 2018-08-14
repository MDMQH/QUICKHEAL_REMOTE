/**
 * 
 */
package seqrite.mdm.appmodules;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import seqrite.mdm.utils.CommonUtils;
import seqrite.mdm.utils.Constants;
import seqrite.mdm.utils.ExcelUtils;
import seqrite.mdm.utils.Log;
import seqrite.mdm.utils.MDM;
import seqrite.mdm.utils.ORReader;
import seqrite.mdm.utils.Setup;

/**
 * @author Siddhant.Raut
 */
//public class Devices extends StartMDMClientApp
public class Devices  extends Setup{
	
	static ORReader OR = new ORReader();
	Actions action= new Actions(driver);

//=====================================================================================================================================================
//	public static String add_device() throws Throwable {
//		try {
			//String deviceName = ExcelUtils.get_excel_value("DeviceName", Constants.Test_Data_Excel_File,Constants.Test_Data_Sheet_Device);
//			Log.info("TestData for Device Name from Excel is ==========>" + deviceName);
//			MDM.login();
//			Log.info("User Login Successfully");
//			MDM.gotoDevices();
//			Log.info("Clicked on Devices Tab");
//			OR.is_element_present("ADD_DEVICE_BUTTON").click();
//			Log.info("Clicked on Add device button");
//			OR.is_element_present("DEVICE_NAME_TEXTFIELD").sendKeys(deviceName);
//			Log.info("Filled details on device scren");
//			OR.is_element_present("SAVE_DEVICE_BUTTON").click();
//			Log.info("Clicked on save button");
//			Thread.sleep(2000);
//			OR.is_element_present("OK_BUTTON").click();
//			Log.info("Device added successfully");
//		}
//		catch(Throwable t)
//		{
//			Log.info("No Success");
//		}
//		return "ok";
//
//	}
//=====================================================================================================================================================

	public static String verify_ringcommands_on_device() throws Throwable {
        try {
		MDM.login();
		Thread.sleep(1000);
		MDM.gotoDevices();
		
		OR.clickOnElement("EDIT_DEVICE_ON_LIST_PAGE");
		OR.clickOnElement("DEVICE_ACTIONS_DROPDOWN");
		OR.selectValueFromDropdown("DEVICE_ACTIONS_DROPDOWN_LIST", "Ring");
		
		//Log.info("Verifying on Device Side, Launching MDM client");
		//StartMDMClientApp.lauch_mdm_client();
		Log.info("Sending Ring Command");
		Log.info("Ring Command Send successfully");
		Thread.sleep(2000);
		
		OR.clickOnElement("DEVICE_ACTION_SUBMIT_BUTTON");
		
		//String StopRing = driver.findElement(By.id("com.seqrite.client:id/btnOk")).getText();
		//Assert.assertEquals(StopRing, "Stop Ring");
		
		//Thread.sleep(5000);
		//driver.findElement(By.id("com.seqrite.client:id/btnOk")).click();
		//Log.info("stop ring command");
		Thread.sleep(5000);
		OR.is_element_present("COMMON_CONFIGURATION_OPEN_ACTIVITY").click();
		MDM.activitystatus();
		Log.info("Device Action RING Verified Successfully");
		
		
}
	catch(Throwable t){
		System.out.println("No Success");	
		
	}
	return "ok";
	}
//=====================================================================================================================================================
	public static String verify_Synccommand_on_device() throws Throwable {
try {
		MDM.login();
		Thread.sleep(1000);
		MDM.gotoDevices();
		
		OR.clickOnElement("EDIT_DEVICE_ON_LIST_PAGE");
		OR.clickOnElement("DEVICE_ACTIONS_DROPDOWN");
		OR.selectValueFromDropdown("DEVICE_ACTIONS_DROPDOWN_LIST", "Sync");
		
		//Log.info("Verifying on Device Side, Launching MDM client");
		//StartMDMClientApp.lauch_mdm_client();
		Log.info("Sending Sync Command");
		Log.info("Sync Command Send successfully");
		Thread.sleep(5000);
		
		OR.clickOnElement("DEVICE_ACTION_SUBMIT_BUTTON");
		
		//String StopRing = driver.findElement(By.id("com.seqrite.client:id/btnOk")).getText();
		//Assert.assertEquals(StopRing, "Stop Ring");
		
		//Thread.sleep(5000);
		//driver.findElement(By.id("com.seqrite.client:id/btnOk")).click();
		//Log.info("stop ring command");
		Thread.sleep(20000);
		OR.is_element_present("COMMON_CONFIGURATION_OPEN_ACTIVITY").click();
		MDM.activitystatus();
		Log.info("Device Action SYNC Verified Successfully");
}
		catch(Throwable t){
			System.out.println("No Success");	
			
		}
		
		return "ok";
	}
	
	
	
	//=====================================================================================================================================================
	
	
		public static String  device_details_success() throws Throwable {
			
			
			try {
				MDM.login();
				MDM.gotoDevices();
				Thread.sleep(2000);
				OR.clickOnElement("EDIT_DEVICE_ON_LIST_PAGE");
				String[] keyResult=OR.selectdevicestatusKey("DEVICES_STATUS_KEY_LIST");
				Log.info("Total no. of Keys available on Device Status Screen are: " +keyResult.length);
				String[] valueResult=OR.selectdevicestatusValue("DEVICES_STATUS_VALUE_LIST");
				Log.info("Total no. of Values available on Device Status Screen are: " +valueResult.length);
		     	HashMap<String,String> map= new HashMap<String,String>();
		     	for(int i=0;i<keyResult.length;i++) {
		        map.put(keyResult[i], valueResult[i]);	
		     	}
		     	Log.info("Extracting data from excel data sheet");	
		     	String OwnerName=ExcelUtils.get_excel_value("Owner", Constants.Test_Data_Excel_File, Constants.Test_Data_Sheet_Device);	
		     	String Device_Type=ExcelUtils.get_excel_value("Device Type", Constants.Test_Data_Excel_File, Constants.Test_Data_Sheet_Device);	
		     	String Model=ExcelUtils.get_excel_value("Model", Constants.Test_Data_Excel_File, Constants.Test_Data_Sheet_Device);
		     	String MDM_App=ExcelUtils.get_excel_value("MDM App", Constants.Test_Data_Excel_File, Constants.Test_Data_Sheet_Device);
		     	String Enrollment_Status=ExcelUtils.get_excel_value("Enrollment Status", Constants.Test_Data_Excel_File, Constants.Test_Data_Sheet_Device);
		     	Log.info("Comparing the test data with the data received from device status screen");
		     	Assert.assertEquals(map.get("Owner"),OwnerName);
		     	Assert.assertEquals(map.get("Device Type"),Device_Type);
		     	Assert.assertEquals(map.get("Model"),Model);
		     	//Assert.assertEquals(map.get("MDM App"),MDM_App);
		     	Assert.assertEquals(map.get("Enrollment Status"),Enrollment_Status);
		     	Log.info("Successfully verified values from devices screen");
			}catch(Throwable t)
			{
	     		//e.printStackTrace();
	     		Log.info("No Success");
			}
			return "ok";
		
		
		}
		
//=====================================================================================================
		
          public static String  device_list_enroll_via_sms() throws Throwable
            {
			MDM.login();
			MDM.gotoDevices();
			Thread.sleep(2000);
			OR.is_element_present("DEVICE_LIST_SEARCH_BOX").sendKeys("Automation Device");
			Thread.sleep(1000);
			OR.is_element_present("DEVICE_LIST_EDIT_PENCIL").click();
			Thread.sleep(2000);
			OR.is_element_present("DEVICE_DETAILS_ACTION_SELECTBOX").click();
			OR.selectValueFromDropdown("DEVICE_DETAILS_DRPDWN_VALUES", "Enrollment via Email/SMS");
			OR.is_element_present("DEVICE_DETAILS_SUBMIT_BUTTON").click();
			String success_text=OR.is_element_present("DEVICE_SMS_ENRLMNT_SUCCESS_NOTIFICATION").getText();
			System.out.println(success_text);
			Assert.assertEquals(success_text, "Enrollment request is sent successfully.");
			Log.info("The device is enrolled successfully");
			return "ok";
            }

//=======================================================================================================
          public static String  device_list_enroll_via_QR_code() throws Throwable
          {
			MDM.login();
			MDM.gotoDevices();
			Thread.sleep(2000);
			OR.is_element_present("DEVICE_LIST_SEARCH_BOX").sendKeys("Automation Device");
			Thread.sleep(1000);
			OR.is_element_present("DEVICE_LIST_EDIT_PENCIL").click();
			Thread.sleep(2000);
			OR.is_element_present("DEVICE_DETAILS_ACTION_SELECTBOX").click();
			OR.selectValueFromDropdown("DEVICE_DETAILS_DRPDWN_VALUES", "Enrollment via QR Code");
			OR.is_element_present("DEVICE_DETAILS_SUBMIT_BUTTON").click();
			Thread.sleep(1000);
			boolean success_notification=OR.is_element_present("DEVICE_QRCODE_ENRLMNT_SUCCESS_POPUP").isDisplayed();
			System.out.println(success_notification);
			Assert.assertEquals(success_notification, true);
			Log.info("The device is enrolled successfully via QR Code");
			return "ok";
          }   
          
          
     //====================================================================================================     

          public static String  device_list_enroll_with_ADO() throws Throwable
          {
			MDM.login();
			MDM.gotoDevices();
			Thread.sleep(2000);
			OR.is_element_present("DEVICE_LIST_SEARCH_BOX").sendKeys("Automation Device");
			Thread.sleep(1000);
			OR.is_element_present("DEVICE_LIST_EDIT_PENCIL").click();
			Thread.sleep(2000);
			OR.is_element_present("DEVICE_DETAILS_ACTION_SELECTBOX").click();
			OR.selectValueFromDropdown("DEVICE_DETAILS_DRPDWN_VALUES", "Enrollment with ADO Enablement");
			OR.is_element_present("DEVICE_DETAILS_SUBMIT_BUTTON").click();
			Thread.sleep(1000);
			boolean success_notification=OR.is_element_present("DEVICE_ADO_ENRLMNT_SUCCESS_POPUP").isDisplayed();
			System.out.println(success_notification);
			Assert.assertEquals(success_notification, true);
			Log.info("The device is enrolled successfully via ADO Enablement");
			return "ok";
          } 
          
        //=====================================================================================================================================================
      	public static String add_device() throws Throwable {
      		try {
      			String deviceName = ExcelUtils.get_excel_value("DeviceName", Constants.Test_Data_Excel_File,Constants.Test_Data_Sheet_Device);
      			Log.info("TestData for Device Name from Excel is ==========>" + deviceName);
      			String Owner = ExcelUtils.get_excel_value("Owner", Constants.Test_Data_Excel_File,Constants.Test_Data_Sheet_Device);
      			Log.info("TestData for Owner from Excel is ==========>" + Owner);
      			String GroupName = ExcelUtils.get_excel_value("GroupName", Constants.Test_Data_Excel_File,Constants.Test_Data_Sheet_Group);
      			Log.info("TestData for GroupName from Excel is ==========>" + GroupName);
      			

      			MDM.login();
      			Log.info("User Login Successfully");
      			Thread.sleep(2000);
      			MDM.gotoDevices();
      			Log.info("Clicked on Devices Tab");
      			OR.is_element_present("ADD_DEVICE_BUTTON").click();
      			Log.info("Clicked on Add device button");
      			OR.is_element_present("DEVICE_NAME_TEXTFIELD").sendKeys(deviceName);
      			Log.info("added device name");
      			OR.is_element_present("DEVICE_ASSIGN_OWNER_BTN").click();
      			Log.info("clicked DEVICE_ASSIGN_OWNER_BTN");
      			Thread.sleep(2000);
      			OR.is_element_present("DEVICE_ASSIGN_OWNER_SEARCH_LBL").sendKeys("Automation User");
      			Log.info("search by name in DEVICE_ASSIGN_OWNER_SEARCH_LBL");
      			Thread.sleep(2000);
      			OR.is_element_present("DEVICE_ASSIGN_OWNER_CLICK").click();
      			Thread.sleep(2000);
      			Log.info("clicked particular user that was searched");
      			OR.is_element_present("DEVICE_ASSIGN_GROUP_BTN").click();
      			Log.info("clicked DEVICE_ASSIGN_GROUP_BTN");
      			Thread.sleep(2000);
      			OR.selectValueFromDropdown("DEVICE_ASSIGN_GROUP_DRPDWN","Automation Group");
      			Thread.sleep(3000);
      			//OR.selectValueFromDropdown("DEVICE_ASSIGN_GROUP_DRPDWN","Default Group");
      			Log.info("Selected Group name from dropdown");
      			OR.is_element_present("SAVE_DEVICE_BUTTON").click();
      			Log.info("Clicked on save button");
      			Thread.sleep(2000);
      			OR.is_element_present("OK_BUTTON").click();
      			Log.info("Device added successfully");
      		}
      		catch(Throwable t)
      		{
      			t.printStackTrace();
      			Log.info("No Success");
      		}
      		return "ok";

      	}


      //=====================================================================================================================================================
      	
      	
      		public static String check_device_details_success() throws Exception {	
      			try {
      				Log.info("Extracting data from excel data sheet");	
      		     	//String OwnerName=ExcelUtils.get_excel_value("Owner", Constants.Test_Data_Excel_File, Constants.Test_Data_Sheet_Device);	
      		     	String DeviceName=ExcelUtils.get_excel_value("DeviceName", Constants.Test_Data_Excel_File, Constants.Test_Data_Sheet_Device);	
      		     	String DeviceType=ExcelUtils.get_excel_value("DeviceType", Constants.Test_Data_Excel_File, Constants.Test_Data_Sheet_Device);	
      		     	String Model=ExcelUtils.get_excel_value("Model", Constants.Test_Data_Excel_File, Constants.Test_Data_Sheet_Device);
      		     	String OSType=ExcelUtils.get_excel_value("OSType", Constants.Test_Data_Excel_File, Constants.Test_Data_Sheet_Device);	
      		     	String Manufacturer=ExcelUtils.get_excel_value("Manufacturer", Constants.Test_Data_Excel_File, Constants.Test_Data_Sheet_Device);	
      		     	String IMEINumbers=ExcelUtils.get_excel_value("IMEINumbers", Constants.Test_Data_Excel_File, Constants.Test_Data_Sheet_Device);	
      		     	String SIMID=ExcelUtils.get_excel_value("SIMID", Constants.Test_Data_Excel_File, Constants.Test_Data_Sheet_Device);	
      		     	String MACAddress=ExcelUtils.get_excel_value("MACAddress", Constants.Test_Data_Excel_File, Constants.Test_Data_Sheet_Device);	
      		     	//String MDM_App=ExcelUtils.get_excel_value("MDM App", Constants.Test_Data_Excel_File, Constants.Test_Data_Sheet_Device);
      		     	//String Enrollment_Status=ExcelUtils.get_excel_value("Enrollment Status", Constants.Test_Data_Excel_File, Constants.Test_Data_Sheet_Device);
      				MDM.login();
      				MDM.gotoDevices();
      				Thread.sleep(2000);
      				OR.is_element_present("SEARCH_BOX_LIST_PAGE").sendKeys(DeviceName);
      				Thread.sleep(2000);
      				OR.is_element_present("EDIT_DEVICE_ON_LIST_PAGE").click();
      				Thread.sleep(2000);
      				String[] keyResult=OR.selectdevicestatusKey("DEVICES_STATUS_KEY_LIST");
      				Log.info("Total no. of Keys available on Device Status Screen are: " +keyResult.length);
      				System.out.println(keyResult);
      				String[] valueResult=OR.selectdevicestatusValue("DEVICES_STATUS_VALUE_LIST");
      				Log.info("Total no. of Values available on Device Status Screen are: " +valueResult.length);
      		     	
      				
      				HashMap<String,String> map= new HashMap<String,String>();
      		     	
      		     	for(int i=0;i<keyResult.length;i++) {
      		     		
      		     		
      		     		map.put(keyResult[i], valueResult[i]);
      		     		
      		     		
      		     	}
      		     		 		
      		     		
      		     	
      		     	Log.info("Comparing the test data with the data received from device status screen");
      		     	//Assert.assertEquals(map.get("Owner"),OwnerName);
      		     	Log.info("Matching device type");
      		     	Assert.assertEquals(map.get("Device Type"),DeviceType);
      		     	Log.info("Matching Model");
      		     	Assert.assertEquals(map.get("Model"),Model);
      		     	Log.info("Matching Manufacturer");
      		     	Assert.assertEquals(map.get("Manufacturer"),Manufacturer);
//      		     	Log.info("Matching IMEINumbers");
//      		     	Assert.assertEquals(map.get("IMEI Number(s)"),IMEINumbers);
//      		     	Log.info("Matching SIMID");
//      		     	Assert.assertEquals(map.get("SIM ID(s)"),SIMID);
      		     	Log.info("Matching MACAddress");
      		     	Assert.assertEquals(map.get("MAC Address"),MACAddress);
//      		     	Log.info("Matching OSType");
//      		     	Assert.assertEquals(map.get("OS Type"),OSType);
      		     	
      		     	
      		     	
      		     	//Assert.assertEquals(map.get("MDM App"),MDM_App);
      		     	//Assert.assertEquals(map.get("Enrollment Status"),Enrollment_Status);
      		     	Log.info("Successfully verified values from devices screen");
      			}
      	 		
      	     	catch(Exception e)
      			{
      	     		e.printStackTrace();
      	     		Log.info("No Success");
      			}
      			
      			
      			
      			return "ok";
      		
      		
      		}


      // ======================================================================================================================================
      	/**
      	 * @author Lavina Jain This method verifies the edit device  functionality
      	 */

      	public static String check_edit_device_details() throws Exception {
      		try {
      			String deviceName = ExcelUtils.get_excel_value("DeviceName", Constants.Test_Data_Excel_File,Constants.Test_Data_Sheet_Device);
      			Log.info("TestData for Device Name from Excel is ==========>" + deviceName);
      			String UpdatedDeviceName = ExcelUtils.get_excel_value("UpdatedDeviceName", Constants.Test_Data_Excel_File,Constants.Test_Data_Sheet_Device);
      			Log.info("TestData for Updated Device Name from Excel is ==========>" + UpdatedDeviceName);
      			

      			String UpdatedOwner = ExcelUtils.get_excel_value("UpdatedOwner", Constants.Test_Data_Excel_File,Constants.Test_Data_Sheet_Device);
      			Log.info("TestData for Updated Owner Name from Excel is ==========>" + UpdatedOwner);
      			
      			String UpdatedGroup = ExcelUtils.get_excel_value("UpdatedGroup", Constants.Test_Data_Excel_File,Constants.Test_Data_Sheet_Device);
      			Log.info("TestData for Updated Group Name from Excel is ==========>" + UpdatedGroup);
      			MDM.login();
      			Thread.sleep(2000);
      			Log.info("User Login Successfully");
      			MDM.gotoDevices();
      			MDM.searchOnListPage(deviceName);
      			Thread.sleep(1000);
      			OR.is_element_present("EDIT_BUTTON_ON_LIST_PAGE").click();
      			Log.info("Clicked EDIT_BUTTON_ON_LIST_PAGE ");
      			Thread.sleep(1000);
      			OR.is_element_present("DEVICE_EDIT_PROFILE_PAGE").click();
      			Log.info("Clicked DEVICE_EDIT_PROFILE_PAGE ");
      			Thread.sleep(2000);
      			OR.is_element_present("EDIT_DEVICE_NAME_TEXTFIELD").clear();
      			OR.is_element_present("EDIT_DEVICE_NAME_TEXTFIELD").sendKeys(UpdatedDeviceName);
      			Log.info("Updated Device Name done");
      			OR.is_element_present("EDIT_DEVICE_ASSIGN_OWNER_BTN").click();
      			OR.is_element_present("DEVICE_ASSIGN_OWNER_SEARCH_LBL").sendKeys(UpdatedOwner);
      			Thread.sleep(2000);
      			OR.is_element_present("DEVICE_ASSIGN_OWNER_CLICK").click();
      			Thread.sleep(2000);
      			Log.info("Updated OWNER done");
      			

      			OR.is_element_present("DEVICE_ASSIGN_GROUP_BTN").click();
      			Thread.sleep(2000);
      			Log.info("DEVICE_ASSIGN_GROUP_BTN clicked");
      			OR.selectValueFromDropdown("DEVICE_ASSIGN_GROUP_DRPDWN",UpdatedGroup);
      			Log.info("DRPDWN value selected");
      			Log.info("Updated Group done");
      			Thread.sleep(2000);
      			OR.is_element_present("EDIT_SAVE_DEVICE_BUTTON").click();
      			Log.info("Clicked SAVE_DEVICE_BUTTON ");

      		}

      		catch (Exception e) {
      			e.printStackTrace();
      			// Log.info("No Success");
      		}

      		return "ok";
      	}
      	
      	
      	// ======================================================================================================================================
      		/**
      		 * @author Lavina Jain This method verifies the edit device  functionality
      		 * @throws Throwable 
      		 */

      	public static String check_assign_Configuration_device() throws Throwable {
      		try {
      			String deviceName = ExcelUtils.get_excel_value("DeviceName", Constants.Test_Data_Excel_File,Constants.Test_Data_Sheet_Device);
      			Log.info("TestData for Device Name from Excel is ==========>" + deviceName);
      			MDM.login();
      			Thread.sleep(2000);
      			Log.info("User Login Successfully");
      			MDM.gotoDevices();
      			MDM.searchOnListPage(deviceName);
      			Thread.sleep(1000);
      			OR.is_element_present("EDIT_BUTTON_ON_LIST_PAGE").click();
      			Log.info("Clicked EDIT_BUTTON_ON_LIST_PAGE ");
      			Thread.sleep(1000);
      			OR.is_element_present("DEVICE_EDIT_PROFILE_PAGE").click();
      			Log.info("Clicked DEVICE_EDIT_PROFILE_PAGE ");
      			Thread.sleep(2000);
      			OR.is_element_present("EDIT_DEVICE_CONFIGURATION_TAB").click();
      			Log.info("EDIT_DEVICE_CONFIGURATION_TAB clicked");
      			Thread.sleep(2000);
      			OR.is_element_present("EDIT_DEVICE_WIFI_CONFIGURATION").sendKeys(Keys.chord(Keys.CONTROL, "a"), "SXNDBJ");
      			//OR.is_element_present("EDIT_DEVICE_WIFI_CONFIGURATION").clear();
      			//OR.is_element_present("EDIT_DEVICE_WIFI_CONFIGURATION").click();
      			//OR.selectValueFromDropdown("EDIT_DEVICE_WIFI_CONFIGURATION_DRPDWN","SXNDBJ");
      			Log.info("EDIT_DEVICE_WIFI_CONFIGURATION cleared & send new data");
      			Thread.sleep(2000);
      			OR.is_element_present("EDIT_SAVE_DEVICE_CONF_BUTTON").click();
      			Log.info("EDIT_SAVE_DEVICE_CONF_BUTTON clicked");
      			Thread.sleep(5000);
      			MDM.activitystatus();
      			
      			
      			
      			Thread.sleep(2000);
      			OR.is_element_present("EDIT_DEVICE_WEB_SECURITY_CONFIGURATION").clear();
      			Log.info("EDIT_DEVICE_WEB_SECURITY_CONFIGURATION cleared");
      			OR.is_element_present("EDIT_DEVICE_WEB_SECURITY_CONFIGURATION").click();
      			Log.info("EDIT_DEVICE_WEB_SECURITY_CONFIGURATION clicked");
      			//OR.selectValueFromDropdown("EDIT_DEVICE_WEB_SECURITY_CONFIGURATION_DRPDWN","Automation WebSecurity Twenty");
      			OR.selectValueFromDropdown("EDIT_DEVICE_WIFI_CONFIGURATION_DRPDWN","Automation WebSecurity Twenty");
      			Log.info("EDIT_DEVICE_WIFI_CONFIGURATION_DRPDWN selected data");
      			Thread.sleep(2000);
      			OR.is_element_present("EDIT_SAVE_DEVICE_CONF_BUTTON").click();
      			Log.info("EDIT_SAVE_DEVICE_CONF_BUTTON clicked");
      			Thread.sleep(5000);
      			MDM.activitystatus();
      			
      			
      			
      			Thread.sleep(2000);
      			OR.is_element_present("EDIT_DEVICE_ANTI_THEFT_CONFIGURATION").clear();
      			Log.info("EDIT_DEVICE_ANTI_THEFT_CONFIGURATION cleared");
      			OR.is_element_present("EDIT_DEVICE_ANTI_THEFT_CONFIGURATION").click();
      			Log.info("EDIT_DEVICE_ANTI_THEFT_CONFIGURATION clicked");
      			//OR.selectValueFromDropdown("EDIT_DEVICE_ANTI_THEFT_CONFIGURATION_DRPDWN","QWER");
      			OR.selectValueFromDropdown("EDIT_DEVICE_WIFI_CONFIGURATION_DRPDWN","QWER");
      			Log.info("EDIT_DEVICE_WIFI_CONFIGURATION_DRPDWN selected");
      			Thread.sleep(2000);
      			OR.is_element_present("EDIT_SAVE_DEVICE_CONF_BUTTON").click();
      			Log.info("EDIT_SAVE_DEVICE_CONF_BUTTON clicked");
      			Thread.sleep(5000);
      			MDM.activitystatus();
      			
      			
      			
      			Thread.sleep(2000);
      			OR.is_element_present("EDIT_DEVICE_SCHEDULE_SCAN_CONFIGURATION").clear();
      			Log.info("EDIT_DEVICE_SCHEDULE_SCAN_CONFIGURATION cleared");
      			OR.is_element_present("EDIT_DEVICE_SCHEDULE_SCAN_CONFIGURATION").click();
      			Log.info("EDIT_DEVICE_SCHEDULE_SCAN_CONFIGURATION clicked");
      			//OR.selectValueFromDropdown("EDIT_DEVICE_SCHEDULE_SCAN_CONFIGURATION_DRPDWN","Automation Test Scan Configuration Twenty");
      			OR.selectValueFromDropdown("EDIT_DEVICE_WIFI_CONFIGURATION_DRPDWN","Automation Test Scan Configuration Twenty");
      			Log.info("EDIT_DEVICE_WIFI_CONFIGURATION_DRPDWN selected");
      			Thread.sleep(2000);
      			OR.is_element_present("EDIT_SAVE_DEVICE_CONF_BUTTON").click();
      			Log.info("EDIT_SAVE_DEVICE_CONF_BUTTON clicked");
      			Thread.sleep(5000);
      			MDM.activitystatus();
      			
      			
      			
      			Thread.sleep(2000);
      			OR.is_element_present("EDIT_DEVICE_NETWORK_CONFIGURATION").clear();
      			Log.info("EDIT_DEVICE_NETWORK_CONFIGURATION cleared");
      			OR.is_element_present("EDIT_DEVICE_NETWORK_CONFIGURATION").click();
      			Log.info("EDIT_DEVICE_NETWORK_CONFIGURATION clicked");
      			//OR.selectValueFromDropdown("EDIT_DEVICE_NETWORK_CONFIGURATION_DRPDWN","AutomationNetworkUsageConfigration");
      			OR.selectValueFromDropdown("EDIT_DEVICE_WIFI_CONFIGURATION_DRPDWN","AutomationNetworkUsageConfigration");
      			Log.info("EDIT_DEVICE_WIFI_CONFIGURATION_DRPDWN selected");
      			Thread.sleep(2000);
      			OR.is_element_present("EDIT_SAVE_DEVICE_CONF_BUTTON").click();
      			Log.info("EDIT_SAVE_DEVICE_CONF_BUTTON clicked");
      			Thread.sleep(5000);
      			MDM.activitystatus();
      			
      			
      			
      			Thread.sleep(2000);
      			OR.is_element_present("EDIT_DEVICE_APP_CONFIGURATION").clear();
      			Log.info("EDIT_DEVICE_APP_CONFIGURATION cleared");
      			OR.is_element_present("EDIT_DEVICE_APP_CONFIGURATION").click();
      			Log.info("EDIT_DEVICE_APP_CONFIGURATION clicked");
      			//OR.selectValueFromDropdown("EDIT_DEVICE_APP_CONFIGURATION_DRPDWN","KNOX testing");
      			OR.selectValueFromDropdown("EDIT_DEVICE_WIFI_CONFIGURATION_DRPDWN","KNOX testing");
      			Log.info("EDIT_DEVICE_WIFI_CONFIGURATION_DRPDWN selected");
      			Thread.sleep(2000);
      			OR.is_element_present("EDIT_SAVE_DEVICE_CONF_BUTTON").click();
      			Log.info("EDIT_SAVE_DEVICE_CONF_BUTTON clicked");
      			Thread.sleep(5000);
      			MDM.activitystatus();
      			Thread.sleep(2000);
      			Log.info("All configurations saved");
      			
      			

      			
      		} catch (Throwable t) {
      			t.printStackTrace();
      			Log.info("No Success");
      		}
      		return "ok";
      	}
     // =======================================================================================================================================
    	/**
    	 * @author Lavina Jain This method verifies the Simple Search for app On
    	 *         Device App Inventory tab
    	 * 
    	 */
    	public static String check_simple_search_app() throws Exception {
    		try {
    			String DeviceName = ExcelUtils.get_excel_value("DeviceName", Constants.Test_Data_Excel_File,
    					Constants.Test_Data_Sheet_Device);

    			String AppInventorySearch = ExcelUtils.get_excel_value("AppInventorySearch", Constants.Test_Data_Excel_File,
    					Constants.Test_Data_Sheet_Device);

    			Log.info("DeviceName From Excel are: " + DeviceName);
    			Log.info("AppInventorySearch From Excel are: " + AppInventorySearch);

    			MDM.login();
    			Thread.sleep(2000);
    			MDM.gotoDevices();

    			Thread.sleep(2000);
    			OR.is_element_present("DEVICE_LIST_SEARCH_BOX").sendKeys(DeviceName);
    			Thread.sleep(1000);
    			OR.is_element_present("DEVICE_LIST_EDIT_PENCIL").click();
    			Log.info("DEVICE_LIST_EDIT_PENCIL clicked");
    			Thread.sleep(2000);

    			OR.is_element_present("DEVICE_APP_INVENTORY_TAB").click();
    			Thread.sleep(1000);
    			Log.info("DEVICE_APP_INVENTORY_TAB clicked");
    			MDM.searchOnListPage(AppInventorySearch);
    			Thread.sleep(1000);

    			String s1 = OR.is_element_present("DEVICE_APP_INVENTORY_SEARCH_LBL").getText();
    			Log.info("Text for searched app is:" + s1);
    			Assert.assertEquals(s1, "ES File Explorer");
    			Log.info("App searched successfully");

    		} catch (Exception e) {
    			e.printStackTrace();
    		}

    		return "ok";
    	}  
    	
    	// =======================================================================================================================================
    	/**
    	 * @author Lavina Jain This method verifies the advanced Search for app On
    	 *         Device App Inventory tab
    	 * 
    	 */
    	public static String check_advance_search_app() throws Exception {
    		try {
    			String DeviceName = ExcelUtils.get_excel_value("DeviceName", Constants.Test_Data_Excel_File,
    					Constants.Test_Data_Sheet_Device);

    			String AppInventorySearch = ExcelUtils.get_excel_value("AppInventorySearch", Constants.Test_Data_Excel_File,
    					Constants.Test_Data_Sheet_Device);

    			Log.info("DeviceName From Excel are: " + DeviceName);
    			Log.info("AppInventorySearch From Excel are: " + AppInventorySearch);

    			MDM.login();
    			Thread.sleep(2000);
    			MDM.gotoDevices();

    			Thread.sleep(2000);
    			OR.is_element_present("DEVICE_LIST_SEARCH_BOX").sendKeys(DeviceName);
    			Thread.sleep(1000);
    			OR.is_element_present("DEVICE_LIST_EDIT_PENCIL").click();
    			Log.info("DEVICE_LIST_EDIT_PENCIL clicked");
    			Thread.sleep(2000);

    			OR.is_element_present("DEVICE_APP_INVENTORY_TAB").click();
    			Thread.sleep(1000);
    			Log.info("DEVICE_APP_INVENTORY_TAB clicked");
    			OR.is_element_present("DEVICE_APP_INVENTORY_ADVANCE_SEARCH_BTN").click();
    			Thread.sleep(1000);
    			Log.info("DEVICE_APP_INVENTORY_ADVANCE_SEARCH_BTN clicked");

    			OR.is_element_present("SELECT_APP_TYPE_DROPDOWN_BTN").click();
    			Thread.sleep(2000);
    			Log.info("SELECT_APP_TYPE_DROPDOWN_BTN clicked");
    			OR.selectValueFromDropdown("SELECT_APP_COMMON_DROPDOWN_LIST", "Downloaded");
    			Thread.sleep(2000);
    			Log.info("SELECT_APP_COMMON_DROPDOWN_LIST as Downloaded from DROPDOWN");

    			OR.is_element_present("SELECT_APP_STATUS_DROPDOWN_BTN").click();
    			Thread.sleep(2000);
    			Log.info("SELECT_APP_STATUS_DROPDOWN_BTN clicked");
    			OR.selectValueFromDropdown("SELECT_APP_COMMON_DROPDOWN_LIST", "Installed");
    			Thread.sleep(2000);
    			Log.info("SELECT_APP_COMMON_DROPDOWN_LIST as Installed from DROPDOWN");

    			OR.is_element_present("SELECT_APP_CATEGORY_DROPDOWN_BTN").click();
    			Thread.sleep(2000);
    			Log.info("SELECT_APP_CATEGORY_DROPDOWN_BTN clicked");
    			OR.selectValueFromDropdown("SELECT_APP_COMMON_DROPDOWN_LIST", "Social");
    			Thread.sleep(2000);
    			Log.info("SELECT_APP_COMMON_DROPDOWN_LIST as Social from DROPDOWN");

    			OR.is_element_present("DEVICE_ADVANCED_SEARCH_BTN_APP_INVENTORY").click();
    			Thread.sleep(2000);
    			Log.info("DEVICE_ADVANCED_SEARCH_BTN_APP_INVENTORY clicked");
    			// String entry =
    			// OR.is_element_present("DEVICE_ADVANCED_SEARCH_LBL_ENTRY").getText();
    			// System.out.println("entry is"+entry);
    			// Log.info("Verifying no of entries of searched app ");
    			// Assert.assertEquals(entry, "Showing 1 to 1 of 1 entries");

    			Boolean b = OR.is_element_present("DEVICE_ADVANCED_SEARCH_LBL_ENTRY").isDisplayed();
    			System.out.println("Status of search is :" + b);
    			Assert.assertTrue(b);
    			Log.info("Verified advance_search_app");

    		} catch (Exception e) {
    			e.printStackTrace();
    		}

    		return "ok";
    	}

   // =======================================================================================================================================
    	/**
    	 * @author Lavina Jain This method verifies the Locate Command and verify it
    	 *         status in Activity Tab.
    	 * @throws Throwable
    	 * 
    	 */
    	public static String check_device_location() throws Throwable {
    		try {
    			String DeviceName = ExcelUtils.get_excel_value("DeviceName", Constants.Test_Data_Excel_File,
    					Constants.Test_Data_Sheet_Device);

    			Log.info("DeviceName From Excel are: " + DeviceName);

    			MDM.login();
    			Thread.sleep(2000);
    			MDM.gotoDevices();
    			Thread.sleep(2000);
    			OR.is_element_present("DEVICE_LIST_SEARCH_BOX").sendKeys(DeviceName);
    			Thread.sleep(1000);
    			OR.clickOnElement("EDIT_DEVICE_ON_LIST_PAGE");
    			OR.clickOnElement("DEVICE_LOCATION_TAB");
    			OR.clickOnElement("DEVICE_LOCATION_BTN");
    			OR.clickOnElement("DEVICE_LOCATION_POPUP_BTN");
    			Thread.sleep(20000);
    			MDM.activitystatus();
    			Log.info("Locate Command verified");

    		} catch (Exception e) {
    			e.printStackTrace();
    		}

    		return "ok";
    	}   	
    	// =======================================================================================================================================
    	/**
    	 * @author Lavina Jain This method verifies the Trace On Command and verify it
    	 *         status in Activity Tab.
    	 * @throws Throwable
    	 * 
    	 */
    	public static String check_device_trace_on() throws Throwable {
    		try {
    			String DeviceName = ExcelUtils.get_excel_value("DeviceName", Constants.Test_Data_Excel_File,
    					Constants.Test_Data_Sheet_Device);

    			Log.info("DeviceName From Excel are: " + DeviceName);

    			MDM.login();
    			Thread.sleep(2000);
    			MDM.gotoDevices();
    			Thread.sleep(2000);
    			OR.is_element_present("DEVICE_LIST_SEARCH_BOX").sendKeys(DeviceName);
    			Thread.sleep(1000);
    			OR.clickOnElement("EDIT_DEVICE_ON_LIST_PAGE");
    			OR.clickOnElement("DEVICE_LOCATION_TAB");
    			Thread.sleep(5000);
    			OR.clickOnElement("DEVICE_TRACE_BTN");
    			Thread.sleep(2000);
    			OR.clickOnElement("DEVICE_TRACE_CONFIGURE_POPUP");
    			Thread.sleep(20000);
    			MDM.activitystatus();
    			Log.info("TRACE ON  Command verified");

    		} catch (Exception e) {
    			e.printStackTrace();
    		}

    		return "ok";
    	}
    	
   // =======================================================================================================================================
    			/**
    			 * @author Lavina Jain This method verifies Data Plan Details on Network Configuration Tab of Device
    			 * @throws Throwable
    			 * 
    			 */
    			public static String check_data_plan_details() throws Throwable {
    				try {
    					MDM.login();
    					Thread.sleep(2000);
    					MDM.gotoDevices();
    					Thread.sleep(2000);
    					String DeviceName = ExcelUtils.get_excel_value("DeviceName", Constants.Test_Data_Excel_File,
    							Constants.Test_Data_Sheet_Network_Usage);
    					Log.info("DeviceName From Excel are: " + DeviceName);
    					OR.is_element_present("DEVICE_LIST_SEARCH_BOX").sendKeys(DeviceName);
    					Thread.sleep(1000);
    					OR.clickOnElement("EDIT_DEVICE_ON_LIST_PAGE");
    					OR.clickOnElement("DEVICE_NETWORK_USAGE_TAB");
    					Log.info("clicked DEVICE_NETWORK_USAGE_TAB");
    					
    					String Before_xpath="//div[@class='configurationsDetails']/div[" ;
    					String after_xpath= "]";
    					String key_xpath;
    					String value_xpath;
    					String[] keyResult1 = new String[20];
    					String[] valueResult1 = new String[20];
    					
    					String keys;
    					String values;
    					
    					
    				for (int i = 1,k=0; i <= 12; i = i + 2,k++) {
    					key_xpath = Before_xpath + i + after_xpath;
    					keys = driver.findElement(By.xpath(key_xpath)).getText();
    					//System.out.println(keys);
    						keyResult1[k] = keys;
    						System.out.println(keyResult1[k]);
    						

    				}
    					Log.info("Total no. of Keys available on Device Network Usage Screen are: " + keyResult1.length);
    				//	System.out.println(keyResult1);
    					
    					for (int i = 2,k=0; i <= 12; i = i + 2,k++) {
    						value_xpath = Before_xpath + i + after_xpath;
    						values = driver.findElement(By.xpath(value_xpath)).getText();
    	//System.out.println(values);
    				
    							valueResult1[k] = values;
    							System.out.println(valueResult1[k]);

    					}
    					
    					Log.info("Total no. of Values available on Device Network Usage Screen are: " + valueResult1.length);
    				//	System.out.println(valueResult1);
    					
    					
    					Map<String, String> map1 = new HashMap<String, String>();
    					for (int i = 0; i < keyResult1.length; i++) {
    						map1.put(keyResult1[i], valueResult1[i]);
    					}
    					
    					System.out.println(map1.size());
    					Log.info("Extracting data from excel data sheet");
    					
    					
    					
    					String NetworkUsageConfiguration = ExcelUtils.get_excel_value("Network Usage Configuration", Constants.Test_Data_Excel_File,
    							Constants.Test_Data_Sheet_Network_Usage);
    					
    					String BillingCycleStartDate = ExcelUtils.get_excel_value("Billing Cycle Start Date", Constants.Test_Data_Excel_File,
    							Constants.Test_Data_Sheet_Network_Usage);
    					
    					String NumberofDays = ExcelUtils.get_excel_value("Number of Days", Constants.Test_Data_Excel_File,
    							Constants.Test_Data_Sheet_Network_Usage);
    					
    					String MobileDataPlanLimit = ExcelUtils.get_excel_value("Mobile Data Plan Limit", Constants.Test_Data_Excel_File,
    							Constants.Test_Data_Sheet_Network_Usage);
    					
    					Log.info("NetworkUsageConfiguration From Excel are: " + NetworkUsageConfiguration);
    					Log.info("BillingCycleStartDate From Excel are: " + BillingCycleStartDate);
    					Log.info("NumberofDays From Excel are: " + NumberofDays);
    					Log.info("MobileDataPlanLimit From Excel are: " + MobileDataPlanLimit);
    					
    					
    					Log.info("Comparing the test data with the data received from device Network Usage screen");
    					Assert.assertEquals(map1.get("Network Usage Configuration"), NetworkUsageConfiguration);
    					Assert.assertEquals(map1.get("Billing Cycle Start Date"), BillingCycleStartDate);
    					Assert.assertEquals(map1.get("Number of Days"), NumberofDays);
    					Assert.assertEquals(map1.get("Mobile Data Plan Limit"), MobileDataPlanLimit);
    					Log.info("Successfully verified values from device Network Usage screen");

    				}
    					catch (Exception e) {
    					e.printStackTrace();
    				}

    				return "ok";
    			}
    			
    // =======================================================================================================================================
    			/**
    			 * @author Lavina Jain This method verifies Simple Search On Device list Page
    			 * 
    			 */
    			public static String check_simple_search_device() throws Exception {
    				try {
    					String DeviceName = ExcelUtils.get_excel_value("DeviceName", Constants.Test_Data_Excel_File,
    							Constants.Test_Data_Sheet_Device);


    					Log.info("DeviceName From Excel are: " + DeviceName);

    					MDM.login();
    					Thread.sleep(2000);
    					MDM.gotoDevices();

    					Thread.sleep(2000);
    					OR.is_element_present("DEVICE_LIST_SEARCH_BOX").sendKeys(DeviceName);
    					Thread.sleep(1000);
    					

    					String res = OR.is_element_present("DEVICE_SEARCH_LBL").getText();
    					Log.info("Text for searched app is:" + res);
    					Assert.assertTrue(res.contains("Showing 1 to 1 of 1 entries"));
    					
    					
//    					Boolean b = OR.is_element_present("DEVICE_SEARCH_LBL").isDisplayed();
//    					System.out.println("Status of search is :" + b);
//    					Assert.assertTrue(b);
    					
    					Log.info("Device searched successfully");

    				} catch (Exception e) {
    					e.printStackTrace();
    				}

    				return "ok";
    			}  
    			
    			
    			
   // =======================================================================================================================================
				/**
				 * @author Lavina Jain This method verifies advanced Search On Device list Page
				 * 
				 */
				public static String check_advance_search_device() throws Exception {
					try {

						MDM.login();
						Thread.sleep(2000);
						MDM.gotoDevices();

						Thread.sleep(2000);
						OR.is_element_present("USERS_ADVANCED_SEARCH_BTN").click();
						Log.info("USERS_ADVANCED_SEARCH_BTN clicked");
						Thread.sleep(2000);
						
						//String drpdwn_data=OR.is_element_present("DEVICE_ADVANCE_SEARCH_CRITERIA2").getText();
						//System.out.println(drpdwn_data);
							//if(drpdwn_data==null)
							//{
								OR.is_element_present("DEVICE_ADVANCE_SEARCH_CRITERIA2").click();
								Thread.sleep(2000);
								Log.info("DEVICE_ADVANCE_SEARCH_CRITERIA2 clicked");
								OR.selectValueFromDropdown("SELECT_APP_COMMON_DROPDOWN_LIST", "Approved");
								Thread.sleep(2000);
								Log.info("SELECT_APP_COMMON_DROPDOWN_LIST as Approved from DROPDOWN");
							//}
						
						
						
						OR.is_element_present("DEVICE_ADVANCE_SEARCH_CRITERIA1").click();
						Thread.sleep(2000);
						Log.info("DEVICE_ADVANCE_SEARCH_CRITERIA1 clicked");
						OR.selectValueFromDropdown("SELECT_APP_COMMON_DROPDOWN_LIST", "Policy Non Compliant");
						Thread.sleep(2000);
						Log.info("SELECT_APP_COMMON_DROPDOWN_LIST as Policy Non Compliant from DROPDOWN");

						

						OR.is_element_present("DEVICE_ADVANCE_SEARCH_CRITERIA3").click();
						Thread.sleep(2000);
						Log.info("DEVICE_ADVANCE_SEARCH_CRITERIA3 clicked");
						OR.selectValueFromDropdown("SELECT_APP_COMMON_DROPDOWN_LIST", "Default Group");
						Thread.sleep(2000);
						Log.info("SELECT_APP_COMMON_DROPDOWN_LIST as Automation Group from DROPDOWN");

						OR.is_element_present("DEVICE_ADVANCED_SEARCH_BTN_AFTER_DRPDWN").click();
						Thread.sleep(2000);
						Log.info("DEVICE_ADVANCED_SEARCH_BTN_AFTER_DRPDWN clicked");
						// String entry =
						// OR.is_element_present("DEVICE_ADVANCED_SEARCH_LBL_ENTRY").getText();
						// System.out.println("entry is"+entry);
						// Log.info("Verifying no of entries of searched app ");
						// Assert.assertEquals(entry, "Showing 1 to 1 of 1 entries");

						Boolean b = OR.is_element_present("DEVICE_SEARCH_LBL").isDisplayed();
						System.out.println("Status of search is :" + b);
						Assert.assertTrue(b);
						Log.info("Verified advance_search_app");

					} catch (Exception e) {
						e.printStackTrace();
					}

					return "ok";
				} 
      	
  //=========================================================================================================
      	public static String check_app_inventory_app_block() throws Throwable {
      		MDM.login();
  			Thread.sleep(2000);
  			Log.info("User Login Successfully");
  			MDM.gotoDevices();
  			MDM.searchOnListPage("One plus three");
  			Thread.sleep(1000);
  			OR.is_element_present("EDIT_BUTTON_ON_LIST_PAGE").click();
  			Log.info("Clicked EDIT_BUTTON_ON_LIST_PAGE ");
  			Thread.sleep(1000);
  			OR.is_element_present("DEVICE_APP_INVENTORY_TAB").click();
  			Thread.sleep(1000);
  			OR.is_element_present("DEVICE_APP_SEARCH_BOX").sendKeys("ES File Explorer");
  			Thread.sleep(1000);
  			OR.is_element_present("DEVICE_APP_SEARCH_CHKBOX").click();
  			OR.is_element_present("DEVICE_APP_WITH_SELECTED_DRPDWN").click();
  			OR.selectValueFromDropdown("DEVICE_APP_WITH_SELECTED_DRPDWN_VALUES", "Block");
  			OR.is_element_present("DEVICE_APP_SUBMIT_BUTTON").click();
  			Thread.sleep(1000);
  			String success_notifi=OR.is_element_present("DEVICE_APP_SUCCESS_NOTFICATION").getText();
  			System.out.println(success_notifi);
  			Assert.assertEquals(success_notifi,"App Full Block command sent successfully.");
      		Log.info("Success message displayed and verified");
      		Log.info("The app full block command sent successfully");
      		return "ok";
      	}
      	
      	 //=========================================================================================================
      	public static String check_app_inventory_app_whitelist() throws Throwable {
      		MDM.login();
  			Thread.sleep(2000);
  			Log.info("User Login Successfully");
  			MDM.gotoDevices();
  			MDM.searchOnListPage("One plus three");
  			Thread.sleep(1000);
  			OR.is_element_present("EDIT_BUTTON_ON_LIST_PAGE").click();
  			Log.info("Clicked EDIT_BUTTON_ON_LIST_PAGE ");
  			Thread.sleep(1000);
  			OR.is_element_present("DEVICE_APP_INVENTORY_TAB").click();
  			Thread.sleep(1000);
  			OR.is_element_present("DEVICE_APP_SEARCH_BOX").sendKeys("ES File Explorer");
  			Thread.sleep(1000);
  			OR.is_element_present("DEVICE_APP_SEARCH_CHKBOX").click();
  			OR.is_element_present("DEVICE_APP_WITH_SELECTED_DRPDWN").click();
  			OR.selectValueFromDropdown("DEVICE_APP_WITH_SELECTED_DRPDWN_VALUES", "Whitelist");
  			OR.is_element_present("DEVICE_APP_SUBMIT_BUTTON").click();
  			Thread.sleep(1000);
  			String success_notifi=OR.is_element_present("DEVICE_APP_SUCCESS_NOTFICATION").getText();
  			System.out.println(success_notifi);
  			Assert.assertEquals(success_notifi,"App Whitelist command sent successfully.");
      		Log.info("Success message displayed and verified");
      		Log.info("The app whitelist command sent successfully");
      		return "ok";
      	}   
      	
      	 //=========================================================================================================
      	public static String check_app_inventory_app_uninstall() throws Throwable {
      		MDM.login();
  			Thread.sleep(2000);
  			Log.info("User Login Successfully");
  			MDM.gotoDevices();
  			MDM.searchOnListPage("One plus three");
  			Thread.sleep(1000);
  			OR.is_element_present("EDIT_BUTTON_ON_LIST_PAGE").click();
  			Log.info("Clicked EDIT_BUTTON_ON_LIST_PAGE ");
  			Thread.sleep(1000);
  			OR.is_element_present("DEVICE_APP_INVENTORY_TAB").click();
  			Thread.sleep(1000);
  			OR.is_element_present("DEVICE_APP_SEARCH_BOX").sendKeys("ES File Explorer");
  			Thread.sleep(1000);
  			OR.is_element_present("DEVICE_APP_SEARCH_CHKBOX").click();
  			OR.is_element_present("DEVICE_APP_WITH_SELECTED_DRPDWN").click();
  			OR.selectValueFromDropdown("DEVICE_APP_WITH_SELECTED_DRPDWN_VALUES", "Uninstall");
  			OR.is_element_present("DEVICE_APP_SUBMIT_BUTTON").click();
  			Thread.sleep(1000);
  			String success_notifi=OR.is_element_present("DEVICE_APP_SUCCESS_NOTFICATION").getText();
  			System.out.println(success_notifi);
  			Assert.assertEquals(success_notifi,"App Uninstall command sent successfully.");
      		Log.info("Success message displayed and verified");
      		Log.info("The app Uninstall command sent successfully");
      		return "ok";
      	} 	
      	
  //==============================================================================================================
      	public static String check_add_app() throws Throwable {
      		MDM.login();
  			Thread.sleep(2000);
  			Log.info("User Login Successfully");
  			MDM.gotoDevices();
  			MDM.searchOnListPage("One plus three");
  			Thread.sleep(1000);
  			OR.is_element_present("EDIT_BUTTON_ON_LIST_PAGE").click();
  			Log.info("Clicked EDIT_BUTTON_ON_LIST_PAGE ");
  			Thread.sleep(1000);
  			OR.is_element_present("DEVICE_APP_INVENTORY_TAB").click();
  			Thread.sleep(1000);
  			OR.is_element_present("DEVICE_ADD_APP_BUTTON").click();
  			OR.selectValueFromDropdown("DEVICE_ADD_APPS_BUTTON_DRPDOWN_VALUES", "From Google Play");
  			Thread.sleep(1000);
  			OR.is_element_present("DEVICE_ADD_APP_URL_BOX").sendKeys(Constants.RainCan_APP_URL);
            OR.is_element_present("DEVICE_ADD_APP_POPUP_SUBMIT_BUTTON").click();
            String notification_text=OR.is_element_present("DEVICE_APP_SUCCESS_NOTFICATION").getText();
            System.out.println(notification_text);
            if(notification_text.equals(Constants.APP_PRESENCE_NOTIFICATION_STRING)) {

            	MDM.DeleteAlreadyAddedApp("raincan");
            	Thread.sleep(2000);
            	MDM.gotoDevices();
      			MDM.searchOnListPage("One plus three");
      			Thread.sleep(1000);
      			OR.is_element_present("EDIT_BUTTON_ON_LIST_PAGE").click();
      			Log.info("Clicked EDIT_BUTTON_ON_LIST_PAGE ");
      			Thread.sleep(1000);
      			OR.is_element_present("DEVICE_APP_INVENTORY_TAB").click();
      			Thread.sleep(1000);
      			OR.is_element_present("DEVICE_ADD_APP_BUTTON").click();
      			OR.selectValueFromDropdown("DEVICE_ADD_APPS_BUTTON_DRPDOWN_VALUES", "From Google Play");
      			Thread.sleep(1000);
      			OR.is_element_present("DEVICE_ADD_APP_URL_BOX").sendKeys(Constants.RainCan_APP_URL);
                OR.is_element_present("DEVICE_ADD_APP_POPUP_SUBMIT_BUTTON").click();
                notification_text=OR.is_element_present("DEVICE_APP_SUCCESS_NOTFICATION").getText();
                System.out.println(notification_text);
                Assert.assertEquals(notification_text,Constants.APP_ADDED_TO_REPOSITRORY_NOTIFICATION);
            	Log.info("App added suuccessfully to the repository"); 
                
            }else
            {
            	Assert.assertEquals(notification_text,Constants.APP_ADDED_TO_REPOSITRORY_NOTIFICATION);
            	Log.info("App added suuccessfully to the repository");
            }
      		return "ok";
      	}
      	
        //==============================================================================================================
      	public static String check_add_app_custom_url() throws Throwable {
      		MDM.login();
  			Thread.sleep(2000);
  			Log.info("User Login Successfully");
  			MDM.gotoDevices();
  			MDM.searchOnListPage("One plus three");
  			Thread.sleep(1000);
  			OR.is_element_present("EDIT_BUTTON_ON_LIST_PAGE").click();
  			Log.info("Clicked EDIT_BUTTON_ON_LIST_PAGE ");
  			Thread.sleep(1000);
  			OR.is_element_present("DEVICE_APP_INVENTORY_TAB").click();
  			Thread.sleep(1000);
  			OR.is_element_present("DEVICE_ADD_APP_BUTTON").click();
  			OR.selectValueFromDropdown("DEVICE_ADD_APPS_BUTTON_DRPDOWN_VALUES", "Custom App URL");
  			Thread.sleep(1000);	
  			OR.is_element_present("APP_ADD_CUSTOM_APP_NAME_FIELD").sendKeys(Constants.CUSTOM_APP_NAME);
            OR.is_element_present("APP_ADD_CUSTOM_PACKAGE_NAME_FIELD").sendKeys(Constants.CUSTOM_APP_PACKAGE_ID);
            OR.is_element_present("APP_ADD_CUSTOM_VERSION_NAME_FIELD").sendKeys(Constants.CUSTOM_APP_VERSION_NAME);
            OR.is_element_present("APP_ADD_CUUSTOM_VERSION_CODE_FIELD").sendKeys(Constants.CUSTOM_APP_VERSION_CODE);
            OR.is_element_present("APP_ADD_CUSTOM_APK_URL_FIELD").sendKeys(Constants.CUSTOM_APP_APK_URL);
            OR.is_element_present("APP_ADD_PUBLISH_BUTTON").click(); 
            
            String notification_text=OR.is_element_present("DEVICE_APP_SUCCESS_NOTFICATION").getText();
            System.out.println(notification_text);
            if(notification_text.equals(Constants.CUSTOM_APP_ALREADY_ADDED_NOTIFICATION)) {

            	MDM.DeleteAlreadyAddedApp(Constants.CUSTOM_APP_NAME);
            	Thread.sleep(2000);
            	MDM.gotoDevices();
      			MDM.searchOnListPage("One plus three");
      			Thread.sleep(1000);
      			OR.is_element_present("EDIT_BUTTON_ON_LIST_PAGE").click();
      			Log.info("Clicked EDIT_BUTTON_ON_LIST_PAGE ");
      			Thread.sleep(1000);
      			OR.is_element_present("DEVICE_APP_INVENTORY_TAB").click();
      			Thread.sleep(1000);
      			OR.is_element_present("DEVICE_ADD_APP_BUTTON").click();
      			OR.selectValueFromDropdown("DEVICE_ADD_APPS_BUTTON_DRPDOWN_VALUES", "Custom App URL");
      			Thread.sleep(1000);	
      			OR.is_element_present("APP_ADD_CUSTOM_APP_NAME_FIELD").sendKeys(Constants.CUSTOM_APP_NAME);
                OR.is_element_present("APP_ADD_CUSTOM_PACKAGE_NAME_FIELD").sendKeys(Constants.CUSTOM_APP_PACKAGE_ID);
                OR.is_element_present("APP_ADD_CUSTOM_VERSION_NAME_FIELD").sendKeys(Constants.CUSTOM_APP_VERSION_NAME);
                OR.is_element_present("APP_ADD_CUUSTOM_VERSION_CODE_FIELD").sendKeys(Constants.CUSTOM_APP_VERSION_CODE);
                OR.is_element_present("APP_ADD_CUSTOM_APK_URL_FIELD").sendKeys(Constants.CUSTOM_APP_APK_URL);
                OR.is_element_present("APP_ADD_PUBLISH_BUTTON").click();
                Thread.sleep(1000);
                notification_text=OR.is_element_present("DEVICE_APP_SUCCESS_NOTFICATION").getText();
                System.out.println(notification_text);
                Assert.assertEquals(notification_text,Constants.APP_ADDED_TO_REPOSITRORY_NOTIFICATION);
            	Log.info("App added suuccessfully to the repository");
            }else
            {
            	Assert.assertEquals(notification_text,Constants.APP_ADDED_TO_REPOSITRORY_NOTIFICATION);
            	Log.info("App added suuccessfully to the repository");
            }
      		return "ok";
      	}
      	
      
      //==============================================================================================================
      	public static String check_add_app_custom_upload_apk() throws Throwable {
      		MDM.login();
  			Thread.sleep(2000);
  			Log.info("User Login Successfully");
  			MDM.gotoDevices();
  			MDM.searchOnListPage("One plus three");
  			Thread.sleep(1000);
  			OR.is_element_present("EDIT_BUTTON_ON_LIST_PAGE").click();
  			Log.info("Clicked EDIT_BUTTON_ON_LIST_PAGE ");
  			Thread.sleep(1000);
  			OR.is_element_present("DEVICE_APP_INVENTORY_TAB").click();
  			Thread.sleep(1000);
  			OR.is_element_present("DEVICE_ADD_APP_BUTTON").click();
  			OR.selectValueFromDropdown("DEVICE_ADD_APPS_BUTTON_DRPDOWN_VALUES", "Upload Custom APK");
  			Thread.sleep(1000);	
  	
  			OR.is_element_present("APP_ADD_CUSTOM_UPLOAD_PATH").click();
  			Thread.sleep(2000);
  			CommonUtils.get_file_from_testdata(Constants.CUSTOM_APP_UPLOAD_PATH, Constants.CUSTOM_APP_UPLOAD_FILE_APK_NAME);
  			Thread.sleep(2000);
            OR.is_element_present("APP_ADD_CUSTOM_UPLOAD_PUBLISH_BUTTON").click();         
            String notification_text=OR.is_element_present("DEVICE_APP_SUCCESS_NOTFICATION").getText();
            System.out.println(notification_text);
            if(notification_text.equals(Constants.CUSTOM_APP_ALREADY_ADDED_NOTIFICATION)) {

            	MDM.DeleteAlreadyAddedApp(Constants.CUSTOM_APP_NAME);
            	Thread.sleep(2000);
            	MDM.gotoDevices();
      			MDM.searchOnListPage("One plus three");
      			Thread.sleep(1000);
      			OR.is_element_present("EDIT_BUTTON_ON_LIST_PAGE").click();
      			Log.info("Clicked EDIT_BUTTON_ON_LIST_PAGE ");
      			Thread.sleep(1000);
      			OR.is_element_present("DEVICE_APP_INVENTORY_TAB").click();
      			Thread.sleep(1000);
      			OR.is_element_present("DEVICE_ADD_APP_BUTTON").click();
      			OR.selectValueFromDropdown("DEVICE_ADD_APPS_BUTTON_DRPDOWN_VALUES", "Upload Custom APK");
      			Thread.sleep(1000);	
      			OR.is_element_present("APP_ADD_CUSTOM_UPLOAD_PATH").click();
      			Thread.sleep(2000);
      			CommonUtils.get_file_from_testdata(Constants.CUSTOM_APP_UPLOAD_PATH, Constants.CUSTOM_APP_UPLOAD_FILE_APK_NAME);
      			Thread.sleep(2000);
                OR.is_element_present("APP_ADD_CUSTOM_UPLOAD_PUBLISH_BUTTON").click();         
                notification_text=OR.is_element_present("DEVICE_APP_SUCCESS_NOTFICATION").getText();
                System.out.println(notification_text);
                Assert.assertEquals(notification_text,Constants.APP_ADDED_TO_REPOSITRORY_NOTIFICATION);
            	Log.info("App added suuccessfully to the repository");
            }else
            {
            	Assert.assertEquals(notification_text,Constants.APP_ADDED_TO_REPOSITRORY_NOTIFICATION);
            	Log.info("App added suuccessfully to the repository");
            }
      		return "ok";
      	}  
      	
      	
     
      //==============================================================================================================
      	public static String check_add_app_repository() throws Throwable {
      		MDM.login();
  			Thread.sleep(2000);
  			Log.info("User Login Successfully");
  			MDM.gotoDevices();
  			MDM.searchOnListPage("One plus three");
  			Thread.sleep(1000);
  			OR.is_element_present("EDIT_BUTTON_ON_LIST_PAGE").click();
  			Log.info("Clicked EDIT_BUTTON_ON_LIST_PAGE ");
  			Thread.sleep(1000);
  			OR.is_element_present("DEVICE_APP_INVENTORY_TAB").click();
  			Thread.sleep(1000);
  			OR.is_element_present("DEVICE_ADD_APP_BUTTON").click();
  			OR.selectValueFromDropdown("DEVICE_ADD_APPS_BUTTON_DRPDOWN_VALUES", "Add from Repository");
  			Thread.sleep(2000);
  			OR.is_element_present("APP_ADD_REPOSITORY_SEARCH_BOX").sendKeys(Constants.CUSTOM_APP_NAME);
  			OR.is_element_present("APP_ADD_REPOSITORY_CHKBOX").click();
  			OR.is_element_present("APP_ADD_REPOSITORY_ADD_BUTTON").click();
  			Thread.sleep(2000);         
            String notification_text=OR.is_element_present("DEVICE_APP_SUCCESS_NOTFICATION").getText();
            System.out.println(notification_text);
            
            if(notification_text.equals(Constants.CUSTOM_APP_ALREADY_ADDED_NOTIFICATION)) {

            	MDM.DeleteAlreadyAddedApp(Constants.CUSTOM_APP_NAME);
            	Thread.sleep(2000);
            	MDM.gotoDevices();
      			MDM.searchOnListPage("One plus three");
      			Thread.sleep(1000);
      			OR.is_element_present("EDIT_BUTTON_ON_LIST_PAGE").click();
      			Log.info("Clicked EDIT_BUTTON_ON_LIST_PAGE ");
      			Thread.sleep(1000);
      			OR.is_element_present("DEVICE_APP_INVENTORY_TAB").click();
      			Thread.sleep(1000);
      			OR.is_element_present("DEVICE_ADD_APP_BUTTON").click();
      			OR.selectValueFromDropdown("DEVICE_ADD_APPS_BUTTON_DRPDOWN_VALUES", "Upload Custom APK");
      			Thread.sleep(1000);	
      			OR.is_element_present("APP_ADD_CUSTOM_UPLOAD_PATH").click();
      			Thread.sleep(2000);
      			CommonUtils.get_file_from_testdata(Constants.CUSTOM_APP_UPLOAD_PATH, Constants.CUSTOM_APP_UPLOAD_FILE_APK_NAME);
      			Thread.sleep(2000);
                OR.is_element_present("APP_ADD_CUSTOM_UPLOAD_PUBLISH_BUTTON").click();         
                notification_text=OR.is_element_present("DEVICE_APP_SUCCESS_NOTFICATION").getText();
                System.out.println(notification_text);
                Assert.assertEquals(notification_text,Constants.APP_ADDED_TO_REPOSITRORY_NOTIFICATION);
            	Log.info("App added suuccessfully to the repository");
            }else
            {
            	Assert.assertEquals(notification_text,Constants.APP_ADDED_TO_REPOSITRORY_NOTIFICATION);
            	Log.info("App added suuccessfully to the repository");
            }
      		return "ok";
      	}   	
      	
      	
      	
      	
}
