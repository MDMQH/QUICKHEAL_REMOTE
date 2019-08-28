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
 * 
 * @author Rajat
 *
 */
public class Antitheft {
	static ORReader OR = new ORReader();
	static String antitheftName=null;

	public static String add_antitheft() throws Throwable {
try {
	antitheftName = ExcelUtils.get_excel_value("Antitheft Configuration Name",Constants.Test_Data_Excel_File, Constants.Test_Data_Sheet_Configurations);
	String MobileNo = ExcelUtils.get_excel_value("Mobile Number", Constants.Test_Data_Excel_File,Constants.Test_Data_Sheet_Configurations);
	Log.info("Test Data from Excel is: " +antitheftName +MobileNo);
	
	MDM.login();
	Log.info("User is looged in successfuly");
	MDM.gotoConfigurations();
	OR.is_element_present("ADD_CONFIGURATION_BUTTON").click();
	OR.is_element_present("SELECT_ANTITHEFT").click();
	OR.is_element_present("ANTITHEFT_NAME_TEXTFIELD").sendKeys(antitheftName);
	OR.is_element_present("ADD_NUMBERS").sendKeys(MobileNo);
	OR.is_element_present("ADD_NUMBERS_BUTTON").click();
	OR.is_element_present("ACTIVE_ON_SIM_CHANGE_DROPDOWN").click();
	OR.is_element_present("LOCK_ON_SIM_CHANGE").click();
	OR.is_element_present("SAVE_ANTITHEFT_BUTTON").click();
	Thread.sleep(2000);
	OR.is_element_present("OK_BUTTON").click();
	Log.info("Ok button clicked");
	
	
}
	catch(Throwable t)
{
		Log.info("No Success");
}
		return "ok";
	}
//===================================================================================================================================================	
	public static String update_antitheft() throws Throwable {
		
		antitheftName = ExcelUtils.get_excel_value("Antitheft Configuration Name",Constants.Test_Data_Excel_File, Constants.Test_Data_Sheet_Configurations);
		String newAntitheftName = ExcelUtils.get_excel_value("Update Antitheft Name", Constants.Test_Data_Excel_File,	Constants.Test_Data_Sheet_Configurations);
		String newMobileNo = ExcelUtils.get_excel_value("Update Mobile Number", Constants.Test_Data_Excel_File,Constants.Test_Data_Sheet_Configurations);

		MDM.login();
		MDM.gotoConfigurations();
		Log.info("Selecting  antitheft configuration from configuration list page" +antitheftName);
		MDM.searchOnListPage(antitheftName);
		OR.is_element_present("EDIT_PENCIL_BUTTON").click();
		OR.is_element_present("EDIT_ANTITHEFT_BUTTON").click();
		OR.is_element_present("ANTITHEFT_NAME_TEXTFIELD").click();
		System.out.println("The  name to update the antitheft :" + newAntitheftName);
		OR.is_element_present("ANTITHEFT_NAME_TEXTFIELD").clear();
		OR.is_element_present("ANTITHEFT_NAME_TEXTFIELD").sendKeys(newAntitheftName);
		OR.is_element_present("ADD_NUMBERS").sendKeys(newMobileNo);
		OR.is_element_present("ADD_NUMBERS_BUTTON").click();
		Log.info("Selecting the option from dropdown");
		Log.info("saving the antitheft setting");
		OR.is_element_present("UPDATE_ANTITHEFT_BUTTON").click();
		Thread.sleep(1000);
		Log.info("antiheft setting is updated  succesfully");
		return "ok";
	}
//===================================================================================================================================================
	
	public static String delete_anitheft() throws Exception {
		String antitheftName1 = ExcelUtils.get_excel_value("Update Antitheft Name",Constants.Test_Data_Excel_File, Constants.Test_Data_Sheet_Configurations);
		
		MDM.login();
		MDM.gotoConfigurations();
		OR.is_element_present("CONFIGURATION_SEARCH").click();
		OR.is_element_present("CONFIGURATION_SEARCH").sendKeys(antitheftName1);
		OR.is_element_present("SELECT_CONFIGURATION_CHECKBOX").click();
		Log.info("Check box is selected ");
		OR.is_element_present("CONFIGURATION_WITH_SELECTED_DROPDOWN").click();
		OR.is_element_present("WITH_SELECTED_DD_DELETE_BUTTON").click();
		OR.is_element_present("SUBMIT_BUTTON").click();
		Log.info("Clicked on  Submit button");
		Thread.sleep(2000);
		OR.is_element_present("OK_BUTTON").click();
		return "ok";
	}
//====================================================================================================================================================
	/*Omkar*/
	
	public static String apply_antitheftConfiguration() throws Throwable {
		
		try{
			MDM.login();
			Thread.sleep(2000);
			MDM.gotoConfigurations();
						
			OR.is_element_present("ANTITHEFT_CONFIGURATION_SELECT").click();
			MDM.ApplyConfigurationToDevice();
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
