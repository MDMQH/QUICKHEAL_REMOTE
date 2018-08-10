package seqrite.mdm.appmodules;
import org.testng.Assert;

import seqrite.mdm.utils.CommonUtils;
import seqrite.mdm.utils.Constants;
import seqrite.mdm.utils.ExcelUtils;
import seqrite.mdm.utils.Log;
import seqrite.mdm.utils.MDM;
import seqrite.mdm.utils.ORReader;
import seqrite.mdm.utils.Setup;

/**
 * @author Siddhant.Raut
 *
 */
public class Dashboard extends Setup{
	
	public static String getTitle=null;
	public static String getheading=null;
	public static String UsersPage_expectedTitle="Manage Users";
	public static String DeptPage_expectedTitle="Manage Departments";
	public static String DevicePage_expectedTitle="Manage Devices";
	public static String GroupsPage_expectedTitle="Manage Groups";
	public static String UserRolesPage_expectedTitle="Manage User Roles";
	public static String PoliciesPage_expectedTitle="Manage Policies";
	public static String ConfigurationsPage_expectdTiltle="Configurations";
	public static String AppRepositoryPage_expectedTitle="App Repository";
	public static String AppConfigurationPage_expectedTitle="Manage App Configuration";
	public static String FencesPage_expectedTitle="Fencing";
	public static String FenceConfigrationsPage_expectedTitle="Manage Fence Configuration";
	public static String CustomReportPage_expectedTitle="Report List";
	public static String AdminSettingsPage_expectedTitle="Setup Services";
	public static String AcivityLogsPage_expectedTitle="Manage Activity Logs";
	public static String ActionLogsPage_expectedTitle="Manage Action Logs";
	public static String LicensePage_expectedTitle="License Status";
	public static String StandardReportPage_expectedTitle="Reports";
	public static String DashboardPage_expectedTitle="Dashboard";
	
	public static String db_query=null;
	
	static String ui_count=null;
	static String db_count=null;
	static ORReader OR = new ORReader();

	
	/**
	 * @author Siddhant.Raut
	 * This method is use to check mdm menus 
	 */
//===================================================================================================================
	
	public static String check_Mdm_Modules() throws Exception {
		
		MDM.login();
		Log.info("User Login Successfully");
		
		MDM.gotoUsers();
		getTitle=CommonUtils.get_page_titile();
		Log.info("Page Title is======>" +getTitle);
		Assert.assertEquals(getTitle, UsersPage_expectedTitle);
		
		MDM.gotoPolicies();
		getTitle=CommonUtils.get_page_titile();
		Log.info("Page Title is======>" +getTitle);
		Assert.assertEquals(getTitle, PoliciesPage_expectedTitle);
		
		MDM.gotoDepartments();
		getTitle=CommonUtils.get_page_titile();
		Log.info("Page Title is======>" +getTitle);
		Assert.assertEquals(getTitle, DeptPage_expectedTitle);
		
		MDM.gotoConfigurations();
		getTitle=CommonUtils.get_page_titile();
		Log.info("Page Title is======>" +getTitle);
		Assert.assertEquals(getTitle, ConfigurationsPage_expectdTiltle);
		
		MDM.gotoDevices();
		getTitle=CommonUtils.get_page_titile();
		Log.info("Page Title is======>" +getTitle);
		Assert.assertEquals(getTitle, DevicePage_expectedTitle);
		
		MDM.gotoAppRepository();
		getTitle=CommonUtils.get_page_titile();
		Log.info("Page Title is======>" +getTitle);
		Assert.assertEquals(getTitle, AppRepositoryPage_expectedTitle);
		
		MDM.gotoGroups();
		getTitle=CommonUtils.get_page_titile();
		Log.info("Page Title is======>" +getTitle);
		Assert.assertEquals(getTitle, GroupsPage_expectedTitle);
		
		MDM.gotoAppConfigurations();
		getTitle=CommonUtils.get_page_titile();
		Log.info("Page Title is======>" +getTitle);
		Assert.assertEquals(getTitle, AppConfigurationPage_expectedTitle);
		
		MDM.gotoUserRole();
		getTitle=CommonUtils.get_page_titile();
		Log.info("Page Title is======>" +getTitle);
		Assert.assertEquals(getTitle, UserRolesPage_expectedTitle);
		
		MDM.gotoActivityLogs();
		getTitle=CommonUtils.get_page_titile();
		Log.info("Page Title is======>" +getTitle);
		Assert.assertEquals(getTitle, AcivityLogsPage_expectedTitle);
		
		MDM.gotoFences();
		getTitle=CommonUtils.get_page_titile();
		Log.info("Page Title is======>" +getTitle);
		Assert.assertEquals(getTitle, FencesPage_expectedTitle);
		
		MDM.gotoActionsLogs();
		getTitle=CommonUtils.get_page_titile();
		Log.info("Page Title is======>" +getTitle);
		Assert.assertEquals(getTitle, ActionLogsPage_expectedTitle);
		
		MDM.gotoStandardReport();
		getTitle=CommonUtils.get_page_titile();
		Log.info("Page Title is======>" +getTitle);
		Assert.assertEquals(getTitle, StandardReportPage_expectedTitle);
		
		MDM.gotoAdminSettings();
		getTitle=CommonUtils.get_page_titile();
		Log.info("Page Title is======>" +getTitle);
		Assert.assertEquals(getTitle, AdminSettingsPage_expectedTitle);
		
		MDM.gotoFenceConfigurations();
		getTitle=CommonUtils.get_page_titile();
		Log.info("Page Title is======>" +getTitle);
		Assert.assertEquals(getTitle, FenceConfigrationsPage_expectedTitle);
		
		MDM.gotoCustomReport();
		getTitle=CommonUtils.get_page_titile();
		Log.info("Page Title is======>" +getTitle);
		Assert.assertEquals(getTitle, CustomReportPage_expectedTitle);
		
		MDM.gotoLicenseDetails();
		getTitle=CommonUtils.get_page_titile();
		Log.info("Page Title is======>" +getTitle);
		Assert.assertEquals(getTitle, LicensePage_expectedTitle);
		
		MDM.gotoDashboard();
		getTitle=CommonUtils.get_page_titile();
		Log.info("Page Title is======>" +getTitle);
		Assert.assertEquals(getTitle,DashboardPage_expectedTitle);

		return "ok";
	}
//===================================================================================================================
	
	public static String check_dashboard_views() throws Exception{
		
		MDM.login();
		
		OR.is_element_present("NETWORK_USAGE_BUTTON").click();
		getheading=OR.is_element_present("NETWORK_USAGE_STATUS_HEADING").getText();
		Assert.assertEquals(getheading, "Network Usage Status");
		
		OR.is_element_present("OVERVIEW_BUTTON").click();
		getheading=OR.is_element_present("ENROLLMENT_STATUS_HEADING").getText();
		Assert.assertEquals(getheading, "Enrollment Status");
		
		OR.is_element_present("INFECTION_STATUS_BUTTON").click();
		OR.is_element_present("INFECTION_STATUS_BUTTON").click();
		boolean graph=OR.is_element_present("INFECTION_GRAPH").isDisplayed();
		
		if(graph){
			System.out.println("Infection status displayed");
		}
		else{
			System.out.println("infection stais is not display");
		}
		return "ok";
	}
	
//==========================================================================================================================

	public static String validate_Expiry_Days() throws Throwable {
		MDM.login();
		Thread.sleep(1000);
		ui_count = OR.is_element_present("LICENSE_TO_EXPIRE").getText();
		Log.info("Days remaining to expire on UI : " + ui_count);
		db_query= ExcelUtils.get_excel_value("Get_Lisence_Expiry_Days_of_Tenant_Qeury", Constants.Test_Data_Excel_File , Constants.DB_Queries_Sheet);
		db_count=CommonUtils.executeQueryOnGolbalDB("select datediff(expiry_date,current_date) from view_company where company_code='UJYhJm'");
		Log.info("Days remaining to expire from  DB : " + db_count);
		Assert.assertEquals(ui_count, db_count);
		return "ok";
	}
//==========================================================================================================================
	public static String validate_Device_Count() throws Throwable {
		MDM.login();
		Thread.sleep(1000);
		ui_count = OR.is_element_present("DEVICES_COUNT").getText();
		Log.info("Total Devices count on UI: " + ui_count);
		db_query= ExcelUtils.get_excel_value("Get_Devices_Count_Query", Constants.Test_Data_Excel_File , Constants.DB_Queries_Sheet);
		db_count=CommonUtils.executeQueryOnTenantDB(db_query);
		Log.info("Device Count from DB : " + db_count);
		Assert.assertEquals(ui_count, db_count);
		return "ok";
	}
//==========================================================================================================================
	
	public static String validate_Rooted_DevicesCount() throws Throwable {
		MDM.login();
		Thread.sleep(1000);
		ui_count = OR.is_element_present("ROOTED_COUNT").getText();
		Log.info("Rooted device count on UI:" + ui_count);
		db_query= ExcelUtils.get_excel_value("Get_Rooted_Device_Count_Query", Constants.Test_Data_Excel_File , Constants.DB_Queries_Sheet);
		db_count=CommonUtils.executeQueryOnTenantDB(db_query);
		Log.info("Rooted Device Count from DB : " + db_count);
		Assert.assertEquals(ui_count, db_count);
		return "ok";
	}
//=========================================================================================================================
	public static String validate_Uninstallation_Unsecure_Devices_Count() throws Throwable {
		MDM.login();
		Thread.sleep(1000);
		ui_count = OR.is_element_present("UNINSTALLATION_UNSECURE_COUNT").getText();
		Log.info("Unintallation Unsecure Count on UI : " + ui_count);
		db_query= ExcelUtils.get_excel_value("Get_Uninstallation_Unsecure_Count_Query", Constants.Test_Data_Excel_File , Constants.DB_Queries_Sheet);
		db_count=CommonUtils.executeQueryOnTenantDB(db_query);
		Log.info("Uninstalltion Unsecure Count from DB : " + db_count);
		Assert.assertEquals(ui_count, db_count);
		return "ok";
	}
//=========================================================================================================================
	public static String validate_Blocked_devices_Count() throws Throwable {
		MDM.login();
		Thread.sleep(1000);
		ui_count = OR.is_element_present("BLOCKED_COUNT").getText();
		Log.info("Blocked Devices Count on UI : " + ui_count);
		db_query= ExcelUtils.get_excel_value("Get_Blocked_Devices_Count_Query", Constants.Test_Data_Excel_File , Constants.DB_Queries_Sheet);
		db_count=CommonUtils.executeQueryOnTenantDB(db_query);
		Log.info("Blocked Device Count from DB : " + db_count);
		Assert.assertEquals(ui_count, db_count);
		return "ok";
	}
//========================================================================================================================
	public static String enrollment_Status() throws Throwable {
		MDM.login();
		OR.is_element_present("ENROLLMENT_STATUS").click();
		MDM.gotoDashboard();
		OR.is_element_present("VOILATION_STATUS").click();
		MDM.gotoDashboard();
		OR.is_element_present("DEVICE_CONNECTED_SINCE").click();
		return "ok";
	}
//========================================================================================================================
}
