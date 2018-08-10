package seqrite.mdm.appmodules;
import java.io.IOException;

import seqrite.mdm.utils.Constants;
import seqrite.mdm.utils.ExcelUtils;
import seqrite.mdm.utils.Log;
import seqrite.mdm.utils.MDM;
import seqrite.mdm.utils.ORReader;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
/**
 * @author Siddhant.Raut
 *
 */

public class Policies {
	
	static ORReader OR = new ORReader();
	public static String verify_create_policy() throws Exception{
		
		String policyName = ExcelUtils.get_excel_value("PolicyName", Constants.Test_Data_Excel_File, Constants.Sheet_Policies);
		String policyDesc = ExcelUtils.get_excel_value("PolicyDescription", Constants.Test_Data_Excel_File, Constants.Sheet_Policies);
		Log.info("Fetching Policy Name from: " +Constants.Test_Data_Excel_File +" " + "From Sheet: " +Constants.Sheet_Policies) ;
		MDM.login();
		Thread.sleep(1000);
		MDM.gotoPolicies();
		Log.info("Going on the policies tab");
		OR.is_element_present("ADD_POLICIES_BUTTON").click();
		Log.info("Clicking on the add policies button");
		OR.is_element_present("POLICY_NAME_TEXTFIELD").sendKeys(policyName);
		Log.info("filling information in the Policy field");
		OR.is_element_present("POLICY_DESCRIPTION_TEXTFIELD").sendKeys(policyDesc);
		Log.info("Filling information in policy decription textfield");
		OR.is_element_present("POLICY_CREATE_NEXT_BUTTON").click();
		Log.info("Clicking on create policy next button");
		OR.is_element_present("INHERIT_POLICY_DD").click();
		Log.info("Clicking on the dropdwn field");
		OR.selectValueFromDropdown("INHERIT_POLICY_DD_LIST", "Default Policy");
		Log.info("Selecting the default value from the dropdown");
		Log.info("Default Policy Selected");
		Thread.sleep(1000);
		OR.is_element_present("POLICY_SAVE_AND_PUBLISH_BUTTON").click();
		Log.info("Clicking on the save and publish button ");
		return "ok";
		}
	
	/*
	 * @author Omkar Naik code to apply the policy to device and check if it is applied successfully
	 * */
	public static String verify_apply_policy() throws Throwable {
		
		
		try {
			MDM.login();
			Thread.sleep(1000);
			MDM.gotoGroups();
			Log.info("Clicking on the Groups tab");
			
			OR.is_element_present("GROUP_DEFAULT_SELECT").click();
			Log.info("Selecting the default group");
			OR.is_element_present("GROUP_DEFAULT_EDIT").click();
			Log.info("Editing the default group");
			OR.is_element_present("GROUP_DETAILPAGE_EDIT").click();
			Log.info("Editing the details on the group page");
			Thread.sleep(4000);
			
			//OR.is_element_present("GROUP_DETAILPAGE_EDIT_DROPDOWN").click();
			//Thread.sleep(1000);
			OR.is_element_present("GROUP_DETAILPAGE_EDIT_DROPDOWN").click();
			Log.info("Clicking on the group details edit dropdown");
			
			OR.selectValueFromDropdown("GROUP_SELECT_POLICY_FROM_DROPDWN", "Automation Policy Twenty");
			Log.info("Selecting the value Automation Policy Twenty ");
					
	     	//OR.is_element_present("GROUP_SELECT_POLICY_FROM_DROPDWN").click();
			//.findElement(By.name("Automation Policy Twenty"));
			Thread.sleep(1000);
			//OR.is_element_present("GROUP_DETAILPAGE_EDIT_DROPDOWN_SEARCH").click();
			//Thread.sleep(1000);
			//OR.is_element_present("GROUP_DETAILPAGEONE_EDIT_DROPDOWN_SEARCH").sendKeys("Automation Policy Twenty");
			//Thread.sleep(1000);
			//OR.is_element_present("GROUP_DETAILPAGEONE_EDIT_DROPDOWN_SEARCH").click();
			//Thread.sleep(1000);
			OR.is_element_present("GROUP_DETAILPAGETWO_EDIT").click();
			Log.info("Clicking on the GROUP_DETAILPAGETWO_EDIT button");
			Thread.sleep(12000);
			OR.is_element_present("DEVICES_TAB").click();
			Log.info("Going to devices tab");
			//OR.is_element_present("").click();
			//MDM.ApplyConfigurationToDevice();
			Thread.sleep(1000);
			//MDM.gotoDevices();
			
			OR.is_element_present("COMMON_CONFIGURATION_CLICK_DEVICE").click();
			Log.info("Clicking on the common configurtion devices");
			OR.is_element_present("COMMON_CONFIGURATION_OPEN_DEVICE").click();
			Log.info("Clicking on the open configuration devices");
			OR.is_element_present("COMMON_CONFIGURATION_OPEN_ACTIVITY").click();
			Log.info("Clikcing on the common configuration activity");
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
