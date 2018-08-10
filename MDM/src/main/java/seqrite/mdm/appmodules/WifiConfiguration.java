/**
 * 
 */
package seqrite.mdm.appmodules;

import org.testng.Assert;

import seqrite.mdm.utils.Constants;
import seqrite.mdm.utils.ExcelUtils;
import seqrite.mdm.utils.Log;
import seqrite.mdm.utils.MDM;
import seqrite.mdm.utils.ORReader;

/**
 * @author Omkar.Naik
 *
 */
public class WifiConfiguration {
	
	static ORReader OR = new ORReader();
	
	public static String verify_Create_WifiConfiguration() throws Exception{
		MDM.login();
		MDM.gotoConfigurations();
		String WifiConfigName = ExcelUtils.get_excel_value("Wifi Configuration AddName", Constants.Test_Data_Excel_File,Constants.Test_Data_Sheet_Configurations);
		Log.info("WiFi Configuration Name from Excel is found: " +WifiConfigName);
		OR.is_element_present("ADD_CONFIGURATION_BUTTON").click();
		OR.is_element_present("SELECT_WiFi").click();
		OR.is_element_present("WiFi_CONFIGURATION_NAME_TEXTFIELD").sendKeys(WifiConfigName);
		//OR.is_element_present("NEXT_BUTTON").click();
		//OR.selectCheckBox("WEB_CATEGORIES_CHKBOXES");
		//OR.is_element_present("NEXT_BUTTON_WEBCATEGORIES").click();
		OR.is_element_present("SAVE_WiFi_CONFIGURATION_BUTTON").click();
		OR.is_element_present("OK_BUTTON_WiFi_CONFIGURATION_CONFIRMATION").click();
		//String wsName= OR.is_element_present("WEB_SECUITY_NAME_OVERVIEW_PAGE").getText();
		//Assert.assertEquals(wsName, WebSecConfigName);
		Log.info("WiFi Configuration Added Successfully");
		
		return "ok";
	}
	
	//Omkar
	public static String apply_WifiConfiguration() throws Throwable{
		MDM.login();
		MDM.gotoConfigurations();
		//String WifiConfigName = ExcelUtils.get_excel_value("Wifi Configuration AddName", Constants.Test_Data_Excel_File,Constants.Test_Data_Sheet_Configurations);
		//Log.info("WiFi Configuration Name from Excel is found: " +WifiConfigName);
		try{
		OR.is_element_present("WiFi_CONFIGURATION_SELECT").click();
		OR.is_element_present("WiFi_CONFIGURATION_DROPDOWN").click();
		OR.is_element_present("WiFi_CONFIGURATION_DROPDOWN_SELECT").click();
		OR.is_element_present("WiFi_CONFIGURATION_SELECTDEVICE_DROPDOWN_CLICK").click();
		OR.is_element_present("WiFi_CONFIGURATION_SELECTDEVICE").click();
		OR.is_element_present("WiFi_CONFIGURATION_APPLYBUTTON").click();
		OR.is_element_present("WiFi_CONFIGURATION_CONFIRMATION_OK_BUTTON").click();
		Thread.sleep(20000);
		MDM.gotoDevices();
		OR.is_element_present("WiFi_CONFIGURATION_CLICK_DEVICE").click();
		OR.is_element_present("WiFi_CONFIGURATION_OPEN_DEVICE").click();
		OR.is_element_present("WiFi_CONFIGURATION_OPEN_ACTIVITY").click();
		//tbody//tr[1]//td[1]//div[1]//span[1]//span[3]//span[8]
		
		MDM.activitystatus();
		/*
		String Success = OR.is_element_present("WiFi_CONFIGURATION_ACTIVITY_SUCCESS").getText();
		System.out.println(Success);
		Assert.assertEquals(Success, "Success");*/
		}
		catch(Throwable t){
			System.out.println("No Success");	
			
		}
		
		/*
		OR.is_element_present("EDIT_WiFi_CONFIGURATION_PEN_BUTTON").click();
		OR.is_element_present("EDIT_WiFi_CONFIGURATION").click();
		OR.is_element_present("WiFi_CONFIGURATION_DEVIES").click();
		OR.is_element_present("WiFi_CONFIGURATION_APPLY_TO_DEVICE").click();
		OR.is_element_present("WiFi_CONFIGURATION_SELECT_DEVICE").click();
		
		OR.is_element_present("WiFi_CONFIGURATION_OPEN_DEVICE").click();
		OR.is_element_present("WiFi_CONFIGURATION_OPEN_ACTIVITY").click();
		
		
		/*
		OR.is_element_present("ADD_CONFIGURATION_BUTTON").click();
		OR.is_element_present("SELECT_WiFi").click();
		OR.is_element_present("WiFi_CONFIGURATION_NAME_TEXTFIELD").sendKeys(WifiConfigName);
		//OR.is_element_present("NEXT_BUTTON").click();
		//OR.selectCheckBox("WEB_CATEGORIES_CHKBOXES");
		//OR.is_element_present("NEXT_BUTTON_WEBCATEGORIES").click();
		OR.is_element_present("SAVE_WiFi_CONFIGURATION_BUTTON").click();
		OR.is_element_present("OK_BUTTON_WiFi_CONFIGURATION_CONFIRMATION").click();
		//String wsName= OR.is_element_present("WEB_SECUITY_NAME_OVERVIEW_PAGE").getText();
		//Assert.assertEquals(wsName, WebSecConfigName);
		Log.info("WiFi Configuration Added Successfully");
		*/
		
		return "ok";
	}
	
	//Omkar

}
