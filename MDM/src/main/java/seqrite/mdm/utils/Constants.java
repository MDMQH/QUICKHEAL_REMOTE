package seqrite.mdm.utils;

/**
 * @author siddhant.raut
 * 
 * This class contains the list of constants variables 
 * required to use constant value in MDM Application.
 */

public class Constants {

	public static String MDM_AutomationServer_url="https://10.10.26.14:8443/#";
	
	public static String FirefoxDriver_Key ="webdriver.firefox.marionette";
	
	public static String ChromeDriver_key ="webdriver.chrome.driver";
	
	public static String Test_Data_Dir_Path = System.getProperty("user.dir")+"\\TestData\\";
	
	public static String Test_Data_Excel_Dir_Path = System.getProperty("user.dir")+"\\TestData\\Excel\\";
	
	public static String FirefoxDriver_Path = System.getProperty("user.dir")+"\\Resources\\geckodriver.exe";
			
    public static String ChromeDriver_Path = System.getProperty("user.dir")+"\\Resources\\chromedriver.exe";
	
//	public static String Test_Data_Excel_File_Name = "MDMTestData.xlsx"; 
	
	public static String Test_Data_Excel_File = "New_MDMTestData.xlsx";
	
	public static String Test_Data_Sheet_UserLogin = "UserLogin";
	
	public static String Test_Data_Sheet_Users = "Users";
	
	public static String Test_Data_Sheet_Configurations = "Configurations";
	
	public static String Test_Data_Sheet_Department = "Department";
	
	public static String Sheet_Policies = "Policies";
	
	public static String DB_Queries_Sheet="DBQueries";
	
	//Lavina
	public static String Test_Data_CSV_File = "Users.csv";
	
	public static String Test_Data_Sheet_Group= "Group";
	
	public static String Test_Data_APK_Dir_Path = System.getProperty("user.dir")+"\\TestData\\APKs\\";
	
	public static String ScreenShot_Dir = System.getProperty("user.dir")+"\\ScreenShots\\";
	
	public static String ScreenShot_Report_Dir = System.getProperty("user.dir")+"\\Reports\\Failed Case Screenshot\\";
	
	//public static String Report_Batch = "cmd /c start E:/Repository/mdm/Omkar/MDM_Sanity_Test_Report.bat";
	public static String Report_Batch = System.getProperty("user.dir")+"\\MDM_Sanity_Test_Report.bat";
	public static String Test_Data_Sheet_Fence = "Fences";
	
	public static String Test_Data_Sheet_Device= "Devices";
	
	public static String RainCan_APP_URL="https://play.google.com/store/apps/details?id=com.raincan.android.hybrid";
	
	public static String APP_PRESENCE_NOTIFICATION_STRING="6542 : App is already present in repository.";
	
	public static String APP_ADDED_TO_REPOSITRORY_NOTIFICATION="App is successfully published on device.";
	
	public static String CUSTOM_APP_NAME="Vidmate";
	
	public static String CUSTOM_APP_PACKAGE_ID="com.nemo.vidmate";
	
	public static String CUSTOM_APP_VERSION_NAME="3.5102";
	
	public static String CUSTOM_APP_VERSION_CODE="35102";
	
	public static String CUSTOM_APP_APK_URL="https://vidmate.onl/download/";
	
    public static String CUSTOM_APP_ALREADY_ADDED_NOTIFICATION="9653 : App with same version code is already added in app repository.";
	
    public static String CUSTOM_APP_UPLOAD_PATH=System.getProperty("user.dir")+"\\TestData\\APKs";
    
    public static String CUSTOM_APP_UPLOAD_FILE_APK_NAME="vidmate.apk";
	
    public static String Test_Data_Sheet_Network_Usage= "Nw Config";
    
    //Rajat goyal
    
    public static String Activity_Tab_Call_SMS_Enable_Text="Enable Call/SMS logs Monitoring";
    
    public static String Activity_Tab_Call_SMS_Disable_Text="Disable Call/SMS logs Monitoring";
    
    public static String Device_Sync_Command_Success_Text="Device Sync command submitted successfully.";
    
    public static String Device_drpdown_action="Device actions";
    
    public static String Device_action_drpdown_sync="Sync";
    
    public static String Device_action_drpdown_locate="Locate";
    
    public static String Device_action_locate_Success_notification="Device Locate command submitted successfully.";
	
    public static String Device_action_trace_on="Trace On";
    
    public static String Device_trace_on_success_Notfication="Continuous Trace On command submitted successfully.";
    
    public static String Device_action_trace_off="Trace Off";
    
    public static String Device_trace_off_success_Notifcation="Continuous Trace Off command submitted successfully.";
    
    public static String Device_action_scan="Scan";
    
    public static String Device_action_scan_success_notification="Device Scan command submitted successfully.";
    
    public static String Device_action_boradcast_message="Broadcast Message";
    
    public static String Device_action_boradcast_text="This is sample test for testing";
    
    public static String Device_broadcast_message_success_notification="Command to Broadcast the message sent successfully.";
    
    public static String Device_enabling_call_sms="Call/SMS Monitoring ON";
    
    public static String Device_disabling_call_sms="Call/SMS Monitoring OFF";
    
    public static String Device_move_to_group="Move to group";
    
    public static String Device_moveto_group_default_group="Default Group";
    
    public static String Device_moveto_group_success_notification="Device(s) moved to group successfully.";
    
    public static String Device_moveto_group_automation="Automation Group";
    
    public static String Device_apply_configuration="Apply Configuration";
    
    public static String Device_apply_configuration_antitheft="Anti-Theft";
    
    public static String Device_apply_configuration_antitheft_value="Default antitheft setting";
    
    public static String Device_apply_configuration_antitheft_success_message="Configuration(s) Assigned successfully.";
    
    public static String Device_apply_configuration_websecurity="Web Security";
    
    public static String Device_apply_configuration_websecurity_value="Default Web Security Setting";
    
    public static String Device_apply_configuration_wifi="Wi-Fi";
    
    public static String Device_apply_configuration_wifi_value="Automation Wifi Configuration";
    
    public static String Device_apply_configuration_schedule_scan="Schedule Scan";
    
    public static String Device_apply_configuration_schedule_scan_value="Automation Test Scan Configuration Twenty";
    
    public static String Device_apply_configuration_app_configuration="App configuration";
    
    public static String Device_apply_configuration_app_configuration_value="Default App Configuration";
    
    public static String Device_apply_configuration_network_usage="Network Usage";
    
    public static String Device_apply_configuration_network_usage_value="AutomationNetworkUsageConfigration"; 
    
    public static String Device_locate_on_map="Locate on Map";
    
    public static String Device_search_push_config_text="Push Fence Configuration";
    
    public static String Device_search_push_policy_text="Push Policy";
    
    
}
