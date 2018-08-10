package seqrite.mdm.utils;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author Siddhant.Raut This class contains the MDM functions to use in script
 *         frequently
 */

public class MDM  {
	
	static ORReader OR = new ORReader();
	static ConfigReader cr = new ConfigReader();
		

	/**
	 * @author Siddhant.Raut This method will login to MDM
	 */

	public static void login() throws Exception {
		OR.is_element_present("LOGIN_USERNAME").sendKeys(cr.getsu_username());
		OR.is_element_present("LOGIN_PASSWORD").sendKeys(cr.getsu_password());
		OR.is_element_present("LOGIN_BUTTON").click();
	}
	
	/**
	 * @author Siddhant.Raut This method will navigate to users list page
	 * 
	 */

	public static void gotoUsers() throws Exception {
		OR.is_element_present("MANAGE_TAB").click();
		OR.is_element_present("USERS_TAB").click();
	}
	
	/**
	 * @author Siddhant.Raut This method will navigate to users list page
	 * 
	 */

	public static void gotoDevices() throws Exception {
		OR.is_element_present("MANAGE_TAB").click();
		OR.is_element_present("DEVICES_TAB").click();
	}

	/**
	 * @author Siddhant.Raut This method will navigate to department list page
	 * 
	 */

	public static void gotoDepartments() throws Exception {
		OR.is_element_present("MANAGE_TAB").click();
		OR.is_element_present("DEPARTMENTS_TAB").click();
	}

	/**
	 * @author Siddhant.Raut This method will navigate to dashboard
	 * 
	 */

	public static void gotoDashboard() throws Exception {
		Thread.sleep(2000);
		OR.is_element_present("DASHOBOARD_TAB").click();
	}
	
	/**
	 * @author Siddhant.Raut This method will navigate to Groups list page
	 * 
	 */

	public static void gotoGroups() throws Exception {
		OR.is_element_present("MANAGE_TAB").click();
		OR.is_element_present("GROUPS_TAB").click();
	}
	
	/**
	 * @author Siddhant.Raut This method will navigate to User Roles list page
	 * 
	 */

	public static void gotoUserRole() throws Exception {
		OR.is_element_present("MANAGE_TAB").click();
		OR.is_element_present("USERROLES_TAB").click();
	}
	
	/**
	 * @author Siddhant.Raut This method will navigate to policies list page
	 * 
	 */

	public static void gotoPolicies() throws Exception {
		OR.is_element_present("PROFILES_TAB").click();
		OR.is_element_present("POLICIES_TAB").click();
		
	}
	
	/**
	 * @author Siddhant.Raut This method will navigate to configurations list page
	 * 
	 */

	public static void gotoConfigurations() throws Exception {
		OR.is_element_present("PROFILES_TAB").click();
		OR.is_element_present("CONFIGURATIONS_TAB").click();
	}
	
	
	/**
	 * @author Siddhant.Raut This method will navigate to AppRepository list page
	 * 
	 */

	public static void gotoAppRepository() throws Exception {
		OR.is_element_present("APPS_TAB").click();
		OR.is_element_present("REPOSITORY_TAB").click();
	}
	
	/**
	 * @author Siddhant.Raut This method will navigate to Appconfigurations list page
	 * 
	 */

	public static void gotoAppConfigurations() throws Exception {
		OR.is_element_present("APPS_TAB").click();
		OR.is_element_present("APP_CONFIGURATION_TAB").click();
	}
	
	/**
	 * @author Siddhant.Raut This method will navigate to Fences list page
	 * 
	 */

	public static void gotoFences() throws Exception {
		OR.is_element_present("FENCING_TAB").click();
		OR.is_element_present("FENCES").click();
	}
	
	/**
	 * @author Siddhant.Raut This method will navigate to Fence Configuration list page
	 * 
	 */
	
	public static void gotoFenceConfigurations() throws Exception {
		OR.is_element_present("FENCING_TAB").click();
		OR.is_element_present("FENCE_CONFIGURATIONS").click();
	}
	
	/**
	 * @author Siddhant.Raut This method will navigate to Standard Report list page
	 * 
	 */
	
	public static void gotoStandardReport() throws Exception {
		OR.is_element_present("REPORTS_TAB").click();
		OR.is_element_present("STANDARDREPORT_TAB").click();
	}
	
	/**
	 * @author Siddhant.Raut This method will navigate to Custom Report list page
	 * 
	 */
	
	public static void gotoCustomReport() throws Exception {
		OR.is_element_present("REPORTS_TAB").click();
		OR.is_element_present("CUSTOMREPORT_TAB").click();
	}
	
	/**
	 * @author Siddhant.Raut This method will navigate to Admin Settings list page
	 * 
	 */
	
	public static void gotoAdminSettings() throws Exception {
		OR.is_element_present("ADMIN_TAB").click();
		OR.is_element_present("SETTINGS_TAB").click();
	}
		
	/**
	 * @author Siddhant.Raut This method will navigate to Activity Logs list page
	 * 
	 */
	
	public static void gotoActivityLogs() throws Exception {
		OR.is_element_present("ADMIN_TAB").click();
		OR.is_element_present("ACTIVITYLOGS_TAB").click();
	}
	
	/**
	 * @author Siddhant.Raut This method will navigate to Action Logs list page
	 * 
	 */
	
	public static void gotoActionsLogs() throws Exception {
		OR.is_element_present("ADMIN_TAB").click();
		OR.is_element_present("ACTIONLOGS_TAB").click();
	}
	
	/**
	 * @author Siddhant.Raut This method will navigate to Action Logs list page
	 * 
	 */
	
	public static void gotoLicenseDetails() throws Exception {
		OR.is_element_present("ADMIN_TAB").click();
		OR.is_element_present("LICENSE_TAB").click();
	}

//=====================================================Search Function for list Page==========================================================
	
		/**
		 * @author Siddhant.Raut
		 * 		 This method will search for key on list page of MDM [user,groups,department,devices,configurations,user roles]
		 */
		public static void searchOnListPage(String key) throws Exception{
			OR.is_element_present("SEARCH_BOX_LIST_PAGE").sendKeys(key);
		}

//====================================================Success Check=========================================================
		
		/**
		 * @Omkar.Naik
		 */
		
		public static void activitystatus() throws Throwable
		{
			String Success = OR.is_element_present("ACTIVITY_SUCCESS").getText();
			System.out.println(Success);
			Assert.assertEquals(Success, "Success");
		}
		
//=============================================Apply Configuration to device==========================================================		
		
		/**
		 * @Omkar.Naik
		 */
		
		public static void ApplyConfigurationToDevice() throws Exception
		{
			/*OR.is_element_present("ANTITHEFT_CONFIGURATION_DROPDOWN").click();
			OR.is_element_present("ANTITHEFT_CONFIGURATION_DROPDOWN_SELECT").click();
			OR.is_element_present("ANTITHEFT_CONFIGURATION_SELECTDEVICE_DROPDOWN_CLICK").click();
			OR.is_element_present("WEB_CONFIGURATION_SELECTDEVICE").click();
			OR.is_element_present("WEB_CONFIGURATION_APPLYBUTTON").click();
			OR.is_element_present("WEB_CONFIGURATION_CONFIRMATION_OK_BUTTON").click();*/
			
			//OR.is_element_present("ANTITHEFT_CONFIGURATION_DROPDOWN").click();
			OR.is_element_present("COMMON_CONFIGURATION_DROPDOWN").click();
			Thread.sleep(2000);
			//OR.is_element_present("ANTITHEFT_CONFIGURATION_DROPDOWN_SELECT").click();
			OR.selectValueFromDropdown("COMMON_CONFIGURATION_DROPDOWN_SELECT", "Apply to Device");
			Thread.sleep(2000);
			//OR.is_element_present("ANTITHEFT_CONFIGURATION_SELECTDEVICE_DROPDOWN_CLICK").click();
			OR.is_element_present("COMMON_CONFIGURATION_SELECTDEVICE_DROPDOWN_CLICK").click();
			OR.is_element_present("COMMON_CONFIGURATION_SELECTDEVICE").click();
			OR.is_element_present("COMMON_CONFIGURATION_APPLYBUTTON").click();
			OR.is_element_present("COMMON_CONFIGURATION_CONFIRMATION_OK_BUTTON").click();
		}

		
		//=============================================Apply App Configuration to device==========================================================
		
		public static void ApplyAppConfigurationToDevice() throws Exception
		{
			//OR.is_element_present("ANTITHEFT_CONFIGURATION_DROPDOWN").click();
			OR.is_element_present("COMMON_CONFIGURATION_DROPDOWN").click();
			Thread.sleep(2000);
			//OR.is_element_present("ANTITHEFT_CONFIGURATION_DROPDOWN_SELECT").click();
			OR.selectValueFromDropdown("COMMON_CONFIGURATION_DROPDOWN_SELECT", "Apply to Device");
			Thread.sleep(2000);
			//OR.is_element_present("ANTITHEFT_CONFIGURATION_SELECTDEVICE_DROPDOWN_CLICK").click();
			OR.is_element_present("COMMON_CONFIGURATION_SELECTDEVICE_DROPDOWN_CLICK").click();
			OR.is_element_present("COMMON_CONFIGURATION_SELECTDEVICE").click();
			OR.is_element_present("COMMON_CONFIGURATION_APPLYBUTTON").click();
			OR.is_element_present("COMMON_CONFIGURATION_CONFIRMATION_OK_BUTTON").click();
		}
		
		
}
