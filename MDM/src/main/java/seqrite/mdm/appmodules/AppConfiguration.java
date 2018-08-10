/**
 * 
 */
package seqrite.mdm.appmodules;
import seqrite.mdm.utils.Constants;
import seqrite.mdm.utils.ExcelUtils;
import seqrite.mdm.utils.Log;
import seqrite.mdm.utils.MDM;
import seqrite.mdm.utils.ORReader;

/**
 * @author siddhant.raut
 * This module contains the test cases for App Configuration 
 * 
 */

public class AppConfiguration {
	
	static ORReader OR = new ORReader();

	/**
	 * @author Siddhant.Raut
	 * This method verifies the add app configuration functionality 
	 */
	
	public static String add_App_Configration() throws Exception{
		
		String AppConfigName= ExcelUtils.get_excel_value("App Configuration Name", Constants.Test_Data_Excel_File, Constants.Test_Data_Sheet_Configurations);
		Log.info("App Configuration Name from Excel: " +AppConfigName);
		
		MDM.login();
		Log.info("User Login Successfully");
		MDM.gotoAppConfigurations();
		OR.is_element_present("ADD_APP_CONFIG_BUTTON").click();
		OR.is_element_present("APP_CONFIG_NAME_TXTFIELD").sendKeys(AppConfigName);
		//OR.is_element_present("BLOCK_ACCESS_TO_NEWLY_INSTALLED_APPS_CHKBOX").click();
		OR.is_element_present("APP_CONFIGURATION_NEXT_BUTTON").click();
		OR.selectCheckBox("APP_CATEGORIES_CHECKBOXES");
		OR.is_element_present("APP_CATEGORIES_NEXT_BUTTON").click();
		OR.is_element_present("APP_RESTRICTIONS_NEXT_BUTTON").click();
		OR.is_element_present("APP_RECOMMENDED_NEXT_BUTTON").click();
		//OR.is_element_present("APP_SETTINGS_NEXT_BUTTON").click();
		//OR.is_element_present("APP_CONFIGURATION_SAVE_BUTTON").click();
		
		Thread.sleep(1000);
		OR.is_element_present("APP_SYSTEM_KOISK_MODE").click();
		Thread.sleep(1000);
		OR.is_element_present("APP_SETTINGS_NEXT_BUTTON").click();
		Thread.sleep(1000);
		OR.is_element_present("APP_CONFIGURATION_SAVE_BUTTON").click();
		Thread.sleep(1000);
		OR.is_element_present("APP_LAUNCHER_BRANDING_SAVE").click();
		OR.is_element_present("OK_BUTTON").click();
		
		return "ok";
	}
//=================================================================================================================================================================	
	public static String update_App_Configuration() throws Exception{
		MDM.login();
		Log.info("User Login Successfully");
		String AppConfigName= ExcelUtils.get_excel_value("App Configuration Name", Constants.Test_Data_Excel_File, Constants.Test_Data_Sheet_Configurations);
		String AppConfigUpdatedName= ExcelUtils.get_excel_value("App Configuration Name Update", Constants.Test_Data_Excel_File, Constants.Test_Data_Sheet_Configurations);
		Log.info("App Configuration Updated Name: " +AppConfigUpdatedName);
		MDM.gotoAppConfigurations();
		MDM.searchOnListPage(AppConfigName);
		OR.is_element_present("EDIT_BUTTON_ON_LIST_PAGE").click();
		OR.is_element_present("EDIT_BUTTON_ON_OVERVIEW_PAGE").click();
		OR.is_element_present("APP_CONFIG_NAME_TXTFIELD").click();
		OR.is_element_present("APP_CONFIG_NAME_TXTFIELD").sendKeys(AppConfigUpdatedName);
		OR.is_element_present("APP_CONFIGURATION_NEXT_BUTTON");
		Thread.sleep(2000);
		return "ok";
	}
//=================================================================================================================================================================	
	public static String delete_App_Configuration() throws Exception{
		MDM.login();
		Log.info("User Login Successfully");
		String AppConfigName= ExcelUtils.get_excel_value("App Configuration Name", Constants.Test_Data_Excel_File, Constants.Test_Data_Sheet_Configurations);
		MDM.gotoAppConfigurations();
		MDM.searchOnListPage(AppConfigName);
		OR.is_element_present("DELETE_BUTTON_ON_LIST_PAGE").click();
		OR.is_element_present("OK_BUTTON").click();
		 return "ok";
	}
	
//===========================================================================================================================================================
	/*
	 * @author Omkar Naik
	 * */
	
	public static String apply_App_Configration() throws Throwable{
		
		
		try{
			MDM.login();
			Thread.sleep(1000);
			MDM.gotoAppConfigurations();		
			OR.is_element_present("APP_CONFIGURATION_SELECT").click();
			MDM.ApplyAppConfigurationToDevice();
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
	
	/*
	 * @author Omkar Naik
	 * */
	public static String apply_Launcher_Configration() throws Throwable{
		
		
		try{
			MDM.login();
			Thread.sleep(1000);
			MDM.gotoAppConfigurations();
			
			OR.is_element_present("APP_CONFIGURATION_SELECT").click();
			OR.is_element_present("Launcher_Edit").click();
			Thread.sleep(2000);
			OR.is_element_present("Launcher_Select_Menu").click();
			Thread.sleep(2000);
			OR.is_element_present("Launcher_Switch_App_Configuration").click();
			OR.is_element_present("Launcher_Activate").click();
			Thread.sleep(3000);
			OR.is_element_present("Launcher_Active_Apps").click();
			
			OR.is_element_present("Launcher_Active_Apps_Add_Apps").click();
			Thread.sleep(3000);
			OR.is_element_present("Launcher_Active_Apps_Chckbox").click();
			Thread.sleep(2000);
			OR.is_element_present("Launcher_Active_Apps_Add_Apps_Btn").click();
			Thread.sleep(2000);
			
			OR.is_element_present("Launcher_Save").click();
						
			//MDM.ApplyAppConfigurationToDevice();
			Thread.sleep(20000);
			MDM.gotoDevices();
			Log.info("");
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
