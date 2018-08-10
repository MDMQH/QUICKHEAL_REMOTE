package seqrite.mdm.appmodules;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import seqrite.mdm.utils.CommonUtils;
import seqrite.mdm.utils.Constants;
import seqrite.mdm.utils.ExcelUtils;
import seqrite.mdm.utils.Log;
import seqrite.mdm.utils.MDM;
import seqrite.mdm.utils.ORReader;

/**
 * @author Poonam.Wani
 * This class contains the test case for Users module of mdm application
 * 
 */

public class Users {
	
	static ORReader OR = new ORReader();
	public static String EmailID= null;
	
	/**
	 * @author Poonam.Wani
	 * This method verifies the add new user functionality 
	 */
	
	public static String check_add_new_user() throws Exception {
		
		String FirstName=ExcelUtils.get_excel_value("FirstName", Constants.Test_Data_Excel_File, Constants.Test_Data_Sheet_Users);
		String Lastname=ExcelUtils.get_excel_value("LastName", Constants.Test_Data_Excel_File, Constants.Test_Data_Sheet_Users);
		EmailID=ExcelUtils.get_excel_value("Email", Constants.Test_Data_Excel_File, Constants.Test_Data_Sheet_Users);
		String Phone=ExcelUtils.get_excel_value("Phone", Constants.Test_Data_Excel_File, Constants.Test_Data_Sheet_Users);
		String MobNo=ExcelUtils.get_excel_value("Mobile", Constants.Test_Data_Excel_File, Constants.Test_Data_Sheet_Users);
		String Department_name=ExcelUtils.get_excel_value("Department", Constants.Test_Data_Excel_File, Constants.Test_Data_Sheet_Users);
		
		String expectedUserDetails=EmailID;
		Log.info("User Details From Excel are: " +FirstName +" "+Lastname +" " +EmailID +" "+Phone +" "+MobNo);
		MDM.login();
		Log.info("User Login Successfully" );
		MDM.gotoUsers();
		Thread.sleep(1000);
		OR.is_element_present("ADD_USERS_BUTTON").click();
		OR.is_element_present("FIRST_NAME_FIELD").sendKeys(FirstName);
		OR.is_element_present("LAST_NAME_FIELD").sendKeys(Lastname);
		OR.is_element_present("EMAIL_ID_FIELD").sendKeys(EmailID);
		OR.is_element_present("PHONE_NO_FIELD").sendKeys(Phone);
		OR.is_element_present("MOBILE_NO_FIELD").sendKeys(MobNo);
		//OR.is_element_present("DEPARTMENT_FIELD").click();
		//OR.selectValueFromDropdown("DEPARTMENT_DROPDOWN_LIST", Department_name);
	//	OR.is_element_present("CHOOSE_DEPARTMENT").click();
//		OR.is_element_present("UPLOAD_PROFILE_PHOTO_BUTTON").click();
//		CommonUtils.get_file_from_testdata("Images","UserProfilePic.jpg");
//		Thread.sleep(2000);
//		OR.is_element_present("UPLOAD_BUTTON_ON_POP_UP").click();
//		Thread.sleep(2000);
		OR.is_element_present("USER_SAVE_BUTTON").click();
		OR.is_element_present("OK_BUTTON").click();
		String actual_UserDetails=OR.is_element_present("USER_DETAILS_USERNAME").getText();
		Log.info("Actual user details are "+actual_UserDetails);
		Log.info("Expected User details are "+expectedUserDetails);
		Assert.assertEquals(actual_UserDetails, expectedUserDetails);
		return "ok";
	}
	
//======================================================================================================================================	
	/**
	 * @author Poonam.Wani
	 * This method verifies the edit user functionality 
	 */
	
	public static String check_edit_user() throws Exception {
		
		String FirstName=ExcelUtils.get_excel_value("Email", Constants.Test_Data_Excel_File, Constants.Test_Data_Sheet_Users);
		
		MDM.login();
		Log.info("User Login Successfully" );
		MDM.gotoUsers();
		MDM.searchOnListPage(FirstName);
		Thread.sleep(1000);
		OR.is_element_present("EDIT_BUTTON_ON_LIST_PAGE").click(); 
		Thread.sleep(1000);
		OR.is_element_present("USER_EDIT_PROFILE_PAGE").click();
		Thread.sleep(2000);
		OR.is_element_present("USER_MOBILE_NO_EDIT").sendKeys("74569899656");
		OR.is_element_present("USER_SAVE_PROFILE_BUTTON").click();
		return "ok";
	}
	
//=======================================================================================================================================
	/**
	 * @author Poonam.Wani
	 * This method verifies the delete user functionality 
	 */
	public static String check_user_delete() throws Exception{
		
		String FirstName=ExcelUtils.get_excel_value("FirstName", Constants.Test_Data_Excel_File, Constants.Test_Data_Sheet_Users);
		MDM.login();
		MDM.gotoUsers();
		MDM.searchOnListPage(FirstName);
		Thread.sleep(3000);
		OR.is_element_present("DELETE_BUTTON_ON_LIST_PAGE").click();
		Thread.sleep(2000);
		OR.is_element_present("OK_BUTTON").click();
		return "ok";
	}
//=======================================================================================================================================
	/**
	 * @author Poonam.Wani
	 * This method verifies the assign admin priviledge to user functionality 
	 */
    public static String check_assign_admin_priviledge_to_user() throws Exception{
		
		String Email=ExcelUtils.get_excel_value("Email", Constants.Test_Data_Excel_File, Constants.Test_Data_Sheet_Users);
		MDM.login();
		MDM.gotoUsers();
		MDM.searchOnListPage(Email);
		Thread.sleep(2000);
		OR.is_element_present("EDIT_BUTTON_ON_LIST_PAGE").click(); 
		Thread.sleep(2000);
		OR.is_element_present("USER_EDIT_PROFILE_PAGE").click();
		OR.is_element_present("USER_EDIT_PRIVILEDGES_TAB").click();
		OR.is_element_present("CHECKED_CHECKBOX_OF_ADMIN_ACCESS_TO_USER").click();
		OR.is_element_present("CLICKED_ON_USER_ROLE_WHILE_ASSIGNING_ADMIN_ACCESS").click();
		OR.selectValueFromDropdown("USER_ROLE_DROPDOWN_LIST", "Admin");
		Thread.sleep(1000);
		OR.is_element_present("SAVE_BUTTON_AFTER_ASSIGNING_ADMIN_ACCESS_TO_USER").submit();
		Thread.sleep(1000);
		
		return "ok";
	}
//=======================================================================================================================================
	/**
	 * @author Poonam.Wani
	 * This method verifies the delete user from with selected option functionality 
	 */
    public static String check_user_delete_With_Selected_Option() throws Exception{
		
		String Email=ExcelUtils.get_excel_value("Email", Constants.Test_Data_Excel_File, Constants.Test_Data_Sheet_Users);
		MDM.login();
		MDM.gotoUsers();
		MDM.searchOnListPage(Email);
		Thread.sleep(1000);
		OR.is_element_present("CHECKED_THE_SELECT_ALL_CHECKBOX").click();
		OR.is_element_present("CLICK_ACTION_ON_WITH_SELECTED_DROPDOWN").click();
		OR.selectValueFromDropdown("WITH_SELECTED_DROPDOWN_LIST", "Delete");
		Thread.sleep(2000);
		OR.is_element_present("USER_DELETE_SUBMIT_BUTTON").click();
		OR.is_element_present("OK_BUTTON").click();
		return "ok";
	}
//=======================================================================================================================================

 public static String check_send_enrollment_request() throws Exception{
	    MDM.login();
		MDM.gotoUsers();
		MDM.searchOnListPage("Automation");
		Thread.sleep(1000);
		OR.is_element_present("USER_FIRST_CHEKCBOX").click();
		Thread.sleep(3000);
		OR.is_element_present("CLICK_ACTION_ON_WITH_SELECTED_DROPDOWN").click();
		OR.selectValueFromDropdown("WITH_SELECTED_DROPDOWN_LIST", "Send Enrollment Request");
		Thread.sleep(2000);
		OR.is_element_present("USER_SEND_ENROLLMENT_DROPDOWN").click();
		OR.selectValueFromDropdown("USER_ENRLMNT_SELECT_OPTION", "Enrollment via Email/SMS");
		OR.is_element_present("USER_SUBMIT_BUTTON").click();
		String Success_notificatn=OR.is_element_present("USER_SEND_ENRLMNT_SUCCESS_NOTIFICATION").getText();
		Assert.assertEquals(Success_notificatn, "Enrollment request sent successfully.");
		return "ok";
	}

 
 //==========================================================================================
 public static String check_send_enrollment_request_via_overview() throws Exception{
	 MDM.login();
	 MDM.gotoUsers();
	 MDM.searchOnListPage("Automation");
	 Thread.sleep(1000);
	 OR.is_element_present("USER_LIST_EDIT_BUTTON").click();
	 Thread.sleep(4000);
	 OR.is_element_present("USER_OVERVIEW_ENRLMNT_DRPDWN").click();
	 OR.selectValueFromDropdown("USER_OVERVIEW_ENRLMENT_DRPDWN_VALUES", "Enrollment via Email/SMS");
	 OR.is_element_present("USER_OVERVIEW_PAGE_SUBMIT").click();
	 String Success_notificatn=OR.is_element_present("USER_SEND_ENRLMNT_SUCCESS_NOTIFICATION").getText();
	 Assert.assertEquals(Success_notificatn, "Enrollment request sent successfully.");
	 Log.info("The Enrollment request is successfull");
	  
	 return "ok";	 
	 
}

 //===================================================================================================
     
     
    public static String check_user_admin_request() throws Exception{
	 MDM.login();
	 MDM.gotoUsers();
	 MDM.searchOnListPage("Automation");
	 Thread.sleep(1000);
	 OR.is_element_present("USER_LIST_EDIT_BUTTON").click();
	 Thread.sleep(4000);
	 OR.is_element_present("USER_EDIT_BUTTON").click();
	 Thread.sleep(2000);
	 OR.is_element_present("USER_PRIVILEGES_BUTTON").click();
	 Thread.sleep(2000);
	 OR.is_element_present("USER_ALLOW_ADMIN_CHECKBOX").click();
	 OR.is_element_present("USER_ROLE_DRPDWN").click();
	 OR.selectValueFromDropdown("USER_ROLE_DRPDWN_VALUE", "Admin");
	 OR.is_element_present("USER_ROLE_SAVE_BUTTON").click(); 
	 Log.info("Clicked on the save button");
	 Thread.sleep(5000);
	 OR.is_element_present("USERS_TAB").click();
	 Thread.sleep(2000);
	 MDM.searchOnListPage("Automation");
	 Thread.sleep(1000);
	 OR.is_element_present("USER_LIST_EDIT_BUTTON").click();
	 String Success_Text=OR.is_element_present("USER_ADMIN_ROLE_SUCCESS_TEXT").getText();
	 Assert.assertEquals(Success_Text, "Admin");
	 Log.info("The Enrollment request is successfull");
 
	 return "ok";	 
	 
}
 //==================================================================================================
 
 public static String revoke_user_admin_request() throws Exception{
	 MDM.login();
	 MDM.gotoUsers();
	 MDM.searchOnListPage("Automation");
	 Thread.sleep(1000);
	 OR.is_element_present("USER_LIST_EDIT_BUTTON").click();
	 Thread.sleep(4000);
	 OR.is_element_present("USER_EDIT_BUTTON").click();
	 Thread.sleep(2000);
	 OR.is_element_present("USER_PRIVILEGES_BUTTON").click();
	 Thread.sleep(2000);
	 OR.is_element_present("USER_ALLOW_ADMIN_CHECKBOX").click();
	 //OR.is_element_present("USER_ROLE_DRPDWN").click();
	 //OR.selectValueFromDropdown("USER_ROLE_DRPDWN_VALUE", "Admin");
	 OR.is_element_present("USER_ROLE_SAVE_BUTTON").click(); 
	 Log.info("Clicked on the save button");
	 Thread.sleep(5000);
	 OR.is_element_present("USERS_TAB").click();
	 Thread.sleep(2000);
	 MDM.searchOnListPage("Automation");
	 Thread.sleep(1000);
	 OR.is_element_present("USER_LIST_EDIT_BUTTON").click();
	 return "ok";	 
	 
}
 
 
 //==================================================================================================
 
     public static String check_send_enrollment_request_via_overview_QRcode() throws Exception{
	 MDM.login();
	 MDM.gotoUsers();
	 MDM.searchOnListPage("Automation");
	 Thread.sleep(1000);
	 OR.is_element_present("USER_LIST_EDIT_BUTTON").click();
	 Thread.sleep(4000);
	 OR.is_element_present("USER_OVERVIEW_ENRLMNT_DRPDWN").click();
	 OR.selectValueFromDropdown("USER_OVERVIEW_ENRLMENT_DRPDWN_VALUES", "Enrollment via QR Code");
	 OR.is_element_present("USER_OVERVIEW_PAGE_SUBMIT").click();
	 boolean Success_notificatn=OR.is_element_present("USER_SEND_ENRLMNT_QR_NOTIFICATION").isDisplayed();
	 Assert.assertEquals(Success_notificatn, true);
	 Log.info("The Enrollment request is successfull");
	  
	 return "ok";	 
	 
}
 
 //=====================================================================================================
     
     public static String check_send_enrollment_request_via_overview_ADO() throws Exception{
    	 MDM.login();
    	 MDM.gotoUsers();
    	 MDM.searchOnListPage("Automation");
    	 Thread.sleep(1000);
    	 OR.is_element_present("USER_LIST_EDIT_BUTTON").click();
    	 Thread.sleep(4000);
    	 OR.is_element_present("USER_OVERVIEW_ENRLMNT_DRPDWN").click();
    	 OR.selectValueFromDropdown("USER_OVERVIEW_ENRLMENT_DRPDWN_VALUES", "Enrollment with ADO Enablement");
    	 OR.is_element_present("USER_OVERVIEW_PAGE_SUBMIT").click();
    	 boolean Success_notificatn=OR.is_element_present("USER_SEND_ENRLMNT_ADO_NOTIFICATION").isDisplayed();
    	 Assert.assertEquals(Success_notificatn, true);
    	 Log.info("The Enrollment request is successfull");
    	  
    	 return "ok";	 
    	 
    } 
 
 
 //=========================================================================================================
     public static String check_Enroll_New_Device_via_overview() throws Exception{
    	 MDM.login();
    	 MDM.gotoUsers();
    	 MDM.searchOnListPage("Automation");
    	 Thread.sleep(1000);
    	 OR.is_element_present("USER_LIST_EDIT_BUTTON").click();
    	 Thread.sleep(4000);
    	 OR.is_element_present("USER_ENROLLED_DEVICES_TAB").click();
    	 Thread.sleep(2000);
    	 OR.is_element_present("USER_ENROLL_NEW_DEVICE_BUTTON").click();
    	 Thread.sleep(3000);
    	 OR.is_element_present("USER_ADD_DEVICE_NAME_FIELD").sendKeys("Automation Device");
    	 OR.is_element_present("USER_ADD_DEVICE_GROUP_DRPDWN").click();
    	 OR.selectValueFromDropdown("USER_ADD_DEVICE_GROUP_DRPDWN_VALUES", "Default Group");
    	 OR.is_element_present("USER_ADD_DEVICE_SEND_ENRLMNT_CHKBOX").click();
    	 OR.is_element_present("USER_ADD_DEVICE_ENRLMNT_DRPDWN").click();
    	 OR.selectValueFromDropdown("USER_ADD_DEVICE_ENRLMNT_DRPDWN_VALUES", "Enrollment via Email/SMS");
    	 OR.is_element_present("USER_ADD_DEVICE_GROUP_CREATE_BUTTON").click();
         
    	 String device_name_Verification=OR.is_element_present("USER_ADD_DECVICE_SUCCESS_TEXT").getText();
    	 System.out.println(device_name_Verification);
    	 Assert.assertEquals(device_name_Verification, "Automation Device");
        
		 return "ok";
     }
     
 //===================================================================================================	    
     
  // =======================================================================================================================================
 	/**
 	 * @author Lavina Jain This method verifies the import User functionality
 	 */
 	public static String check_import_user() throws Exception {

 		MDM.login();
 		Thread.sleep(2000);
 		MDM.gotoUsers();
 		OR.is_element_present("IMPORT_USERS_BUTTON").click();
 		Log.info("clicked IMPORT_USERS_BUTTON");

 		// Actions actions = new Actions(driver);
 		// actions.moveToElement(OR.is_element_present("IMPORT_USERS_SELECT_FILE_LBL")).sendKeys(Constants.Test_Data_Excel_Dir_Path+Constants.Test_Data_CSV_File).build().perform();
 		// OR.is_element_present("IMPORT_USERS_SELECT_FILE_LBL").sendKeys(Constants.Test_Data_Excel_Dir_Path+Constants.Test_Data_CSV_File);
 		// Log.info("IMPORT_USERS csv file to be uploaded");
 		System.out.println(Constants.Test_Data_Excel_Dir_Path);
 		System.out.println(Constants.Test_Data_CSV_File);
 		System.out.println(Constants.Test_Data_Excel_Dir_Path + Constants.Test_Data_CSV_File);
 		Thread.sleep(4000);
 		// OR.is_element_present("IMPORT_USERS_SELECT_FILE_BTN").click();
 		OR.is_element_present("IMPORT_USERS_SELECT_FILE_LBL").click();
 		Log.info("Retrieving data from clipboard");
 		Thread.sleep(2000);
 		CommonUtils.get_file_from_testdata(Constants.Test_Data_Excel_Dir_Path, Constants.Test_Data_CSV_File);
 		// CommonUtils.get_file_from_testdata();

 		OR.is_element_present("IMPORT_USERS_FILE_IMPORT_BTN").click();
 		Log.info("IMPORT_USERS csv file  uploaded ");
 		Thread.sleep(3000);
 		// OR.is_element_present("IMPORT_USERS_NOTIFICATION_TAB").click();
 		OR.hoverOnElement("IMPORT_USERS_NOTIFICATION_TAB");
 		String s = OR.is_element_present("IMPORT_USERS_CHECK_FILE_IMPORT").getText();
 		// String
 		// s=OR.is_element_present("IMPORT_USERS_CHECK_FILE_IMPORT").getText().trim();
 		Log.info("Import message is :" + s);
 		Assert.assertEquals(s, "User import is Completed. Download Output File.");
 		return "ok";
 	}

 	// =======================================================================================================================================
 	/**
 	 * @author Lavina Jain This method verifies the export User functionality
 	 */
 	public static String check_export_user() throws Exception {

 		try {
 			MDM.login();
 			Thread.sleep(2000);
 			MDM.gotoUsers();
 			OR.is_element_present("EXPORT_USERS_BUTTON").click();
 			Log.info("clicked EXPORT_USERS_BUTTON");
 			// WebElement
 			// export_csv_btn=OR.is_element_present("EXPORT_USERS_BY_CSV_BUTTON");
 			// String srcloc=export_csv_btn.getAttribute("href");
 			// System.out.println(srcloc);
 			// String wget_command = "cmd /c C:\\Wget\\wget.exe -P D:
 			// --no-check-certificate " + srcloc;
 			// try {
 			// Process exec = Runtime.getRuntime().exec(wget_command);
 			// int exitVal = exec.waitFor();
 			// System.out.println("Exit value: " + exitVal);
 			// } catch (Exception e) {
 			// e.printStackTrace();
 			// }
 			OR.is_element_present("EXPORT_USERS_BY_CSV_BUTTON").click();
 			Log.info("clicked EXPORT_USERS_BY_CSV_BUTTON");
 			Thread.sleep(3000);
 			// WebElement
 			// export_pdf_btn=OR.is_element_present("EXPORT_USERS_BY_PDF_BUTTON");
 			// String srcloc1=export_csv_btn.getAttribute("href");
 			// System.out.println(srcloc1);
 			// String wget_command1 = "cmd /c C:\\Wget\\wget.exe -P D:
 			// --no-check-certificate " + srcloc;
 			// try {
 			// Process exec = Runtime.getRuntime().exec(wget_command1);
 			// int exitVal = exec.waitFor();
 			// System.out.println("Exit value: " + exitVal);
 			// } catch (Exception e) {
 			// e.printStackTrace();
 			// }
 			// Log.info("clicked EXPORT_USERS_BY_PDF_BUTTON");
 			// }
 			// catch(Exception e)
 			// {
 			// e.printStackTrace();
 			// }
 		} catch (Exception e) {
 			e.printStackTrace();
 		}
 		return "ok";
 	}

 	// =======================================================================================================================================
 	/**
 	 * @author Lavina Jain This method verifies the Simple Search On User list
 	 *         Page
 	 */
 	public static String check_simple_search_user() throws Exception {
 		try {
 			String EmailID = ExcelUtils.get_excel_value("Email", Constants.Test_Data_Excel_File,
 					Constants.Test_Data_Sheet_Users);
 			String FirstName = ExcelUtils.get_excel_value("FirstName", Constants.Test_Data_Excel_File,
 					Constants.Test_Data_Sheet_Users);
 			String LastName = ExcelUtils.get_excel_value("LastName", Constants.Test_Data_Excel_File,
 					Constants.Test_Data_Sheet_Users);
 			String MobNo = ExcelUtils.get_excel_value("Mobile", Constants.Test_Data_Excel_File,
 					Constants.Test_Data_Sheet_Users);
 			Log.info("User EmailID Details From Excel are: " + EmailID);
 			Log.info("User FirstName Details From Excel are: " + FirstName);
 			Log.info("User LastName Details From Excel are: " + LastName);
 			Log.info("User Mobile Details From Excel are: " + MobNo);
 			String UserName = FirstName + " " + LastName;
 			Log.info("Username is:" + UserName);
 			MDM.login();
 			Thread.sleep(2000);
 			MDM.gotoUsers();
 			MDM.searchOnListPage(EmailID);
 			Thread.sleep(1000);

 			String email = OR.is_element_present("USERS_SEARCH_BY_EMAIL").getText();
 			Log.info("MATCHING EMAIL ID");
 			Assert.assertEquals(email, EmailID);
 			MDM.gotoUsers();
 			MDM.searchOnListPage(MobNo);
 			Thread.sleep(1000);

 			String mob = OR.is_element_present("USERS_SEARCH_BY_MOB").getText();
 			Log.info("MATCHING MOB NO");
 			Assert.assertEquals(mob, MobNo);
 			MDM.gotoUsers();
 			MDM.searchOnListPage(UserName);
 			Thread.sleep(1000);

 			String uname = OR.is_element_present("USERS_SEARCH_BY_USERNAME").getText();
 			Log.info("MATCHING USER NAME");
 			Assert.assertEquals(uname, UserName);

 		} catch (Exception e) {
 			e.printStackTrace();
 		}

 		return "ok";
 	}

 	// =======================================================================================================================================
 	/**
 	 * @author Lavina Jain This method verifies the advance search functionality
 	 *         on User list page
 	 */
 	public static String check_advance_search_user() throws Exception {

 		MDM.login();
 		Thread.sleep(2000);
 		MDM.gotoUsers();
 		OR.is_element_present("USERS_ADVANCED_SEARCH_BTN").click();
 		Log.info("USERS_ADVANCED_SEARCH_BTN clicked");
 		Thread.sleep(2000);
 		OR.is_element_present("SELECT_USER_ROLE_DROPDOWN_BTN").click();
 		Thread.sleep(2000);
 		Log.info("SELECT_USER_ROLE_DROPDOWN_BTN clicked");
 		OR.selectValueFromDropdown("SELECT_USER_ROLE_DROPDOWN_LIST", "Super");
 		Thread.sleep(2000);
 		Log.info("SELECT_USER_ROLE_DROPDOWN_LIST as super from DROPDOWN");
 		OR.is_element_present("USERS_ADVANCED_SEARCH_BTN_AFTER_DRPDWN").click();
 		Thread.sleep(2000);
 		Log.info("USERS_ADVANCED_SEARCH_BTN_AFTER_DRPDWN clicked");
 		String entry = OR.is_element_present("SUPER_USERS_ADVANCED_SEARCH_LBL").getText();
 		Log.info("Verifying no of entries of super user");
 		Assert.assertEquals(entry, "Showing 1 to 1 of 1 entries");
 		Log.info("Verified advance_search_user");
 		return "ok";
 	}

 	// =======================================================================================================================================
 	/**
 	 * @author Lavina Jain This method verifies the Filter Column by
 	 *         selecting/deselecting columns.
 	 */
 	public static String check_Filter_Column() throws Exception {
 		try {
 			MDM.login();
 			Thread.sleep(2000);
 			MDM.gotoUsers();
 			OR.is_element_present("USERS_FILTER_COLUMNS").click();
 			Log.info("USERS_FILTER_COLUMNS clicked");
 			// by unchecking all checkboxes

 			Thread.sleep(2000);
 			OR.is_element_present("USERS_FILTER_COLUMNS_BY_ID").click();
 			Log.info("USERS_FILTER_COLUMNS_BY_ID clicked");
 			OR.is_element_present("USERS_FILTER_COLUMNS_BY_DEPARTMENT").click();
 			Log.info("USERS_FILTER_COLUMNS_BY_DEPARTMENT clicked");
 			OR.is_element_present("USERS_FILTER_COLUMNS_BY_EMAIL").click();
 			Log.info("USERS_FILTER_COLUMNS_BY_EMAIL clicked");
 			OR.is_element_present("USERS_FILTER_COLUMNS_BY_MOB").click();
 			Log.info("USERS_FILTER_COLUMNS_BY_MOB clicked");
 			Thread.sleep(1000);
 			// OR.is_element_present("USERS_FILTER_COLUMNS").click();
 			OR.is_element_present("USERS_FILTER_COLUMNS_OUTSIDE").click();
 			Thread.sleep(1000);
 			String uname = OR.is_element_present("USERS_FILTER_COLUMNS_BY_USERNAME").getText();
 			Log.info("MATCHING USER NAME");
 			Assert.assertEquals(uname, "User Name");

 			String action = OR.is_element_present("USERS_FILTER_COLUMNS_BY_ACTION").getText();
 			Log.info("MATCHING action");
 			Assert.assertEquals(action, "Action");

 			// if(OR.is_element_present("USERS_FILTER_COLUMNS").isSelected())
 			// {
 			// OR.is_element_present("USERS_FILTER_COLUMNS_CHECK_ALL").click();
 			// Thread.sleep(2000);
 			// String
 			// uname=OR.is_element_present("USERS_FILTER_COLUMNS_BY_USERNAME").getText();
 			// Log.info("MATCHING USER NAME");
 			// Assert.assertEquals(uname, "User Name");
 			// }

 			MDM.gotoUsers();
 			OR.is_element_present("USERS_FILTER_COLUMNS").click();
 			Log.info("USERS_FILTER_COLUMNS clicked");
 			// by checking 4 checkboxes
 			OR.is_element_present("USERS_FILTER_COLUMNS_BY_ID").click();
 			String id = OR.is_element_present("USERS_FILTER_COLUMNS_BY_ID").getText();

 			OR.is_element_present("USERS_FILTER_COLUMNS_BY_DEPARTMENT").click();
 			String dept = OR.is_element_present("USERS_FILTER_COLUMNS_BY_DEPARTMENT").getText();
 			OR.is_element_present("USERS_FILTER_COLUMNS_BY_EMAIL").click();
 			String email = OR.is_element_present("USERS_FILTER_COLUMNS_BY_EMAIL").getText();
 			OR.is_element_present("USERS_FILTER_COLUMNS_BY_MOB").click();
 			String mob = OR.is_element_present("USERS_FILTER_COLUMNS_BY_MOB").getText();
 			Thread.sleep(1000);
 			// OR.is_element_present("USERS_FILTER_COLUMNS").click();
 			OR.is_element_present("USERS_FILTER_COLUMNS_OUTSIDE").click();
 			Thread.sleep(1000);
 			Log.info("MATCHING id");
 			Assert.assertEquals(id, "Id");
 			Log.info("MATCHING Department");
 			Assert.assertEquals(dept, "Department");
 			Log.info("MATCHING Email");
 			Assert.assertEquals(email, "Email");
 			Log.info("MATCHING Mobile");
 			Assert.assertEquals(mob, "Mobile No.");
 			Log.info("column Values successfully verified ");
 		} catch (Exception e) {
 			e.printStackTrace();
 		}

 		return "ok";
 	}
 	// =======================================================================================================================================
 		/**
 		 * @author Lavina Jain This method verifies Column header sorting on User List Page in MDM application.
 		 */
 		public static String check_column_header_sorting() throws Exception {
 			try {
 			   WebElement YourLocator;
 				MDM.login();
 				Thread.sleep(2000);
 				MDM.gotoUsers();
 				OR.is_element_present("SORT_USER_NAME_BTN").click();
 				Thread.sleep(2000);
 				String total_users=OR.is_element_present("SUPER_USERS_ADVANCED_SEARCH_LBL").getText();
 				System.out.println(total_users);
 				String count=total_users.substring(13);
 				int result = Integer.parseInt(count);
 				for(int i=0;i<result;i++)
 				{
 					YourLocator=OR.is_element_present("SORT_USER_NAME_BEFORE_XPATH"+i+"SORT_USER_NAME_AFTER_XPATH");
 				}
 				//need to make driver.findElements(By.xpath(YourLocator)); in OR READER 
// 				ArrayList<String> obtainedList = new ArrayList<String>(); 
// 				List<WebElement> elementList= driver.findElements(By.xpath(YourLocator));
// 				for(WebElement we:elementList){
// 				   obtainedList.add(we.getText());
// 				}
// 				ArrayList<String> sortedList = new ArrayList<>();   
// 				for(String s:obtainedList){
// 				sortedList.add(s);
// 				}
// 				Collections.sort(sortedList);
// 				Assert.assertTrue(sortedList.equals(obtainedList));
// 				
// 				
// 				For descending order add:
 //
// 					Collections.reverse(sortedList);
// 					after Collections.sort(sortedList);
 			}
 			catch (Exception e) {
 				e.printStackTrace();
 			}

 			return "ok";
 		}

     
     
     
     
     
 
 
}



