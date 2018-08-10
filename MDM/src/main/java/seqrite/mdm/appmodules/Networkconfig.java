package seqrite.mdm.appmodules;

import java.io.IOException;

import org.testng.Assert;

import seqrite.mdm.utils.Constants;
import seqrite.mdm.utils.ExcelUtils;
import seqrite.mdm.utils.Log;
import seqrite.mdm.utils.MDM;
import seqrite.mdm.utils.ORReader;

public class Networkconfig {

	
	static ORReader OR = new ORReader();
	public static String verify_Create_Networkconfig() throws Exception{
		
		MDM.login();
		MDM.gotoConfigurations();
		String NetworkUsageConfigrationName = ExcelUtils.get_excel_value("NetworkUsageConfigrationName", Constants.Test_Data_Excel_File,Constants.Test_Data_Sheet_Configurations);
		Log.info("Network Configuration Name from Excel is found: " +NetworkUsageConfigrationName);
		OR.is_element_present("ADD_CONFIGURATION_BUTTON").click();
		Thread.sleep(2000);
		OR.is_element_present("SELECT_NETWORK_USAGE").click();
		Thread.sleep(2000);
		OR.is_element_present("NETWORK_USAGE_NAME_TEXTFIELD").sendKeys(NetworkUsageConfigrationName);
		Thread.sleep(2000);
		OR.is_element_present("BILLING_CYCLE").click();
		Thread.sleep(2000);
		OR.is_element_present("BILLING_CYCLE_CURRENT_DATE").click();
		Thread.sleep(2000);
		OR.is_element_present("BILLING_CYCLE_DAYS").sendKeys("30");
		Thread.sleep(2000);
		OR.is_element_present("MOBILE_DATA_PLAN_LIMIT").sendKeys("500");
		Thread.sleep(2000);
		//OR.is_element_present("BILLING_CYCLE_NOTIFICATION").click();
		//OR.is_element_present("BILLING_CYCLE_NOTIFICATION_PERCENTAGE").click();
		OR.is_element_present("NETWORK_USAGE_CONFIGURATION_SAVE_BUTTON").click();
		OR.is_element_present("NETWORK_USAGE_CONFIGURATION_CONFIRMATION_BUTTON").click();
		//OR.is_element_present("OK_BUTTON").click();
		//String wsName= OR.is_element_present("WEB_SECUITY_NAME_OVERVIEW_PAGE").getText();
		//Assert.assertEquals(wsName, WebSecConfigName);
		Log.info("NETWORK USAGE CONFIGURATION Added Successfully");
		return "ok";
	}
	
public static String verify_apply_Networkconfig() throws Throwable {
/*{
	String NetworkUsageConfigrationName = ExcelUtils.get_excel_value("NetworkUsageConfigrationName", Constants.Test_Data_Excel_File,Constants.Test_Data_Sheet_Configurations);
		MDM.login();
		Thread.sleep(2000);
		MDM.gotoConfigurations();
		MDM.searchOnListPage(NetworkUsageConfigrationName);
		OR.is_element_present("CHECKED_THE_SELECT_ALL_CHECKBOX").click();
		Thread.sleep(2000);
			
	  //OR.is_element_present("CONFIGURATION_DROP_DOWN_BOX").click();
		OR.selectValueFromDropdown("CONFIGURATION_DROP_DOWN_MENU","Apply to Device");
		OR.is_element_present("NETWORK_CONFIGURATION_DROPDOWN_SELECT_DEVICE").click();
		Thread.sleep(2000);
		OR.is_element_present("NETWORK_CONFIGURATION_APPLY_TO_DEVICE_CHECKBOX").click();
		OR.is_element_present("NETWORK_CONFIGURATION_APPLY_TO_DEVICE").click();
		return "ok";
		
		
	}*/
try {
	
	MDM.login();
	Thread.sleep(1000);
	MDM.gotoConfigurations();
	OR.is_element_present("NETWORK_CONFIGURATION_SELECT").click();
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
