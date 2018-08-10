/**
 * 
 */
package seqrite.mdm.appmodules;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import seqrite.mdm.utils.Constants;
import seqrite.mdm.utils.ExcelUtils;
import seqrite.mdm.utils.Log;
import seqrite.mdm.utils.MDM;
import seqrite.mdm.utils.ORReader;

/**
 * @author Swapnil.Dravid This class contains test cases on Scheduled Scan
 *         Configuration
 */
public class ScheduleScan {
	static ORReader OR = new ORReader();

	static WebDriver driver;

	public static String add_schedule_scan() throws Exception {
		String expected_scan_name;
		String ScanConfigName = ExcelUtils.get_excel_value("Schedule Scan Name", Constants.Test_Data_Excel_File,
				Constants.Test_Data_Sheet_Configurations);
		Log.info(" Scan Configuration Name from Excel is: " + ScanConfigName);
		expected_scan_name = ScanConfigName;
		MDM.login();
		MDM.gotoConfigurations();
		Thread.sleep(2000);
		OR.is_element_present("ADD_CONFIGURATION_BUTTON").click();
		Log.info("Clicked on add configuration");
		Log.info("Selecting the scan configuration ");
		OR.is_element_present("SCHEDULE_SCAN").click();
		OR.is_element_present("SCAN_CONFIG_NAME").sendKeys(ScanConfigName);
		OR.is_element_present("SCAN_CONFIG_SAVE").click();
		OR.is_element_present("OK_BUTTON").click();
		String actual_scan_name = OR.is_element_present("SCANCONFIG_NAME_VERIFY").getText();
		Log.info("The name found for actual result :" + actual_scan_name);
		Log.info("Actual String From UI is: " + actual_scan_name);
		Log.info("Expected String From Excel is:" + expected_scan_name);
		Assert.assertEquals(actual_scan_name, expected_scan_name);
		Log.info("Scan configuration added successfully");
		return "ok";

	}

	// ========================================================================================================================================
	public static String update_schedule_scan() throws Exception {
		String ScanConfigName = ExcelUtils.get_excel_value("Schedule Scan Name", Constants.Test_Data_Excel_File,
				Constants.Test_Data_Sheet_Configurations);
		String NewScanConfigName = ExcelUtils.get_excel_value("Update Schedule Scan Name",
				Constants.Test_Data_Excel_File, Constants.Test_Data_Sheet_Configurations);
		String expected_updated_scan_name = NewScanConfigName;

		System.out.println(NewScanConfigName);
		MDM.login();
		MDM.gotoConfigurations();
		MDM.searchOnListPage(ScanConfigName);
		OR.is_element_present("EDIT_PENCIL_BUTTON").click();
		OR.is_element_present("EDIT_SCHEDULE_SCAN_BUTTON").click();
		OR.is_element_present("SCAN_CONFIG_NAME").click();
		OR.is_element_present("SCAN_CONFIG_NAME").clear();
		OR.is_element_present("SCAN_CONFIG_NAME").sendKeys(NewScanConfigName);
		OR.is_element_present("SCAN_CONFIG_SAVE").click();
		Thread.sleep(1000);
		OR.is_element_present("SCAN_OVERVIEW_TAB").click();
		Thread.sleep(2000);
		String actual_updated_scan_name = OR.is_element_present("SCANCONFIG_NAME_VERIFY").getText();
		Log.info("The actual entered scan Name is :" + actual_updated_scan_name);
		Log.info("The expected result is :" + expected_updated_scan_name);
		Assert.assertEquals(actual_updated_scan_name, expected_updated_scan_name);
		Log.info("Scan configuration updated successfully");
		return "ok";

	}

	// =====================================================================================================================================
	public static String delete_Schedule_Scan() throws Exception {

		try {
			String NewScanConfigName = ExcelUtils.get_excel_value("Update Schedule Scan Name",
					Constants.Test_Data_Excel_File, Constants.Test_Data_Sheet_Configurations);
			MDM.login();
			MDM.gotoConfigurations();
			MDM.searchOnListPage(NewScanConfigName);
			OR.is_element_present("SELECT_CONFIGURATION_CHECKBOX").click();
			OR.is_element_present("CONFIGURATION_WITH_SELECTED_DROPDOWN").click();
			OR.is_element_present("WITH_SELECTED_DD_DELETE_BUTTON").click();
			OR.is_element_present("SUBMIT_BUTTON").click();
			Log.info("Clicked on  Submit button");
			Thread.sleep(2000);
			OR.is_element_present("OK_BUTTON").click();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "ok";

	}
	
	//=======================================================================================================================
	/*
	 * @author Omkar Naik code to apply the scan configuration and check if it is applied successfully
	 * */
	
	public static String apply_schedule_scan() throws Throwable {
		
		try {
			
			MDM.login();
			Thread.sleep(1000);
			MDM.gotoConfigurations();
			OR.is_element_present("SCAN_CONFIGURATION_SELECT").click();
			MDM.ApplyConfigurationToDevice();
			Thread.sleep(20000);
			MDM.gotoDevices();
			
			OR.is_element_present("COMMON_CONFIGURATION_CLICK_DEVICE").click();
			OR.is_element_present("COMMON_CONFIGURATION_OPEN_DEVICE").click();
			OR.is_element_present("COMMON_CONFIGURATION_OPEN_ACTIVITY").click();
			//tbody//tr[1]//td[1]//div[1]//span[1]//span[3]//span[8]
			MDM.activitystatus();
			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("No Success");
		}

		return "ok";

	}
	

}