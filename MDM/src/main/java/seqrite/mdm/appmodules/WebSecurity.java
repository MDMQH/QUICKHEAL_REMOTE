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
 * @author Siddhant.Raut
 *
 */
public class WebSecurity {
	
	static ORReader OR = new ORReader();
	
	public static String verify_Create_WebSecurity() throws Exception{
		try {
			MDM.login();
			MDM.gotoConfigurations();
			Log.info("Clicked on configurations tab");
			String WebSecConfigName = ExcelUtils.get_excel_value("Web Security Name", Constants.Test_Data_Excel_File,Constants.Test_Data_Sheet_Configurations);
			Log.info("WebSecurity Configuration Name from Excel is found: " +WebSecConfigName);
			OR.is_element_present("ADD_CONFIGURATION_BUTTON").click();
			Log.info("Clicked on add configurations tab");
			OR.is_element_present("SELECT_WEBSECURITY").click();
			Log.info("Clicked on SELECT_WEBSECURITY tab");
			OR.is_element_present("WEB_SECURITY_NAME_TEXTFIELD").sendKeys(WebSecConfigName);
			Log.info("WEB_SECURITY_NAME_ entered");
			OR.is_element_present("NEXT_BUTTON").click();
			Log.info("Clicked on NEXT_BUTTON");
			OR.selectCheckBox("WEB_CATEGORIES_CHKBOXES");
			Log.info("Clicked on WEB_CATEGORIES_CHKBOXES");
			OR.is_element_present("NEXT_BUTTON_WEBCATEGORIES").click();
			Log.info("Clicked on NEXT_BUTTON_WEBCATEGORIES");
			OR.is_element_present("SAVE_WEBCATEGORY_BUTTON").click();
			Log.info("Clicked on SAVE_WEBCATEGORY_BUTTON");
			OR.is_element_present("OK_BUTTON").click();
			Log.info("Clicked on OK_BUTTON");
			String wsName= OR.is_element_present("WEB_SECUITY_NAME_OVERVIEW_PAGE").getText();
			Log.info("Text retrieved for WEB_SECUITY_NAME_OVERVIEW_PAGE");
			Assert.assertEquals(wsName, WebSecConfigName);
			Log.info("Web Security Added Successfully");
		}
		catch(Exception e)
		{
			Log.info("No Success");
		}
		
		return "ok";
	}
	
	public static String apply_WebConfiguration() throws Throwable{
		try{
			MDM.login();
			Thread.sleep(2000);
			MDM.gotoConfigurations();
			Log.info("Clicked on configurations tab");
			Thread.sleep(2000);
			OR.is_element_present("WEB_CONFIGURATION_SELECT").click();
			Log.info("Clicked on WEB_CONFIGURATION_SELECT tab");
			Thread.sleep(2000);
			
			MDM.ApplyConfigurationToDevice();
			Log.info("Clicked on ApplyConfigurationToDevice tab");
			Thread.sleep(20000);
			MDM.gotoDevices();
			Log.info("Clicked on Devices tab");
			OR.is_element_present("COMMON_CONFIGURATION_CLICK_DEVICE").click();
			Log.info("Clicked on COMMON_CONFIGURATION_CLICK_DEVICE tab");
			OR.is_element_present("COMMON_CONFIGURATION_OPEN_DEVICE").click();
			Log.info("Clicked on COMMON_CONFIGURATION_OPEN_DEVICE tab");
			OR.is_element_present("COMMON_CONFIGURATION_OPEN_ACTIVITY").click();
			Log.info("Clicked on COMMON_CONFIGURATION_OPEN_ACTIVITY tab");
			//tbody//tr[1]//td[1]//div[1]//span[1]//span[3]//span[8]
			
			MDM.activitystatus();
			
			}
			catch(Throwable t){
				System.out.println("No Success");	
				
			}
		
		
		
		return "ok";
	}
	
	
	

}
