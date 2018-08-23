/**
* 
*/
package seqrite.mdm.appmodules;

import java.io.IOException;

//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import seqrite.mdm.utils.Constants;
import seqrite.mdm.utils.ExcelUtils;
import seqrite.mdm.utils.Log;
import seqrite.mdm.utils.MDM;
import seqrite.mdm.utils.ORReader;
import seqrite.mdm.utils.Setup;

/**
* @author siddhant.raut
*
*/
public class UserRoles extends Setup {

// static WebDriver driver;
static ORReader OR = new ORReader();

// ===========================================================================================
/**
* @author Lavina Jain This method verifies by adding a custom user role functionality.
* 
*/
public static String create_user_role() throws Exception {
String UserRoleName = ExcelUtils.get_excel_value("UserRoleName", Constants.Test_Data_Excel_File,
Constants.Test_Data_Sheet_User_Roles);
Log.info("UserRoleName is: " + UserRoleName);

String UserRoleType = ExcelUtils.get_excel_value("UserRoleType", Constants.Test_Data_Excel_File,
Constants.Test_Data_Sheet_User_Roles);
Log.info("UserRoleType is: " + UserRoleType);

MDM.login();
Thread.sleep(2000);
MDM.gotoUserRole();
OR.is_element_present("ADD_USERROLE_BUTTON").click();
Thread.sleep(2000);
OR.is_element_present("USERROLENAME_TEXTFIELD").sendKeys(UserRoleName);
OR.is_element_present("DROPDOWN_SELECT_USERROLES_BTN").click();
OR.selectValueFromDropdown("DROPDOWN_LIST_USERROLES", UserRoleType);
Log.info("waiting for clicking element");
Thread.sleep(3000);
OR.clickOnElement("SAVE_USERROLE_BUTTON");
Thread.sleep(2000);
OR.is_element_present("OK_BUTTON").click();
Thread.sleep(2000);
OR.is_element_present("USERROLES_TAB").click();
MDM.searchOnListPage(UserRoleName);
String res = OR.is_element_present("USERROLENAME_VERIFY").getText();
System.out.println("res is:" + res);
Assert.assertEquals(res, UserRoleName);
Log.info("create_user_role verified");
return "ok";
}

// ===========================================================================================
/**
* @author Lavina Jain This method verifies deleting a custom user role
* functionality.
*/
public static String check_delete_user_role() throws Exception {
String UserRoleName = ExcelUtils.get_excel_value("UserRoleName", Constants.Test_Data_Excel_File,
Constants.Test_Data_Sheet_User_Roles);
Log.info("UserRoleName is: " + UserRoleName);

MDM.login();
Thread.sleep(2000);
MDM.gotoUserRole();
Thread.sleep(2000);
MDM.searchOnListPage(UserRoleName);
Thread.sleep(1000);
OR.is_element_present("DELETE_BUTTON_ON_LIST_PAGE").click();
Thread.sleep(2000);
OR.is_element_present("OK_BUTTON").click();

Log.info("Delete Group successful");

return "ok";
}

// =======================================================================================================================================
/**
* @author Lavina Jain This method verifies Updating User role with Critical
* Action ON/OFF functionality.
*/
public static String check_update_user_role_critical_action() throws Exception {
String UserRoleName = ExcelUtils.get_excel_value("UserRoleName", Constants.Test_Data_Excel_File,
Constants.Test_Data_Sheet_User_Roles);
Log.info("UserRoleName is: " + UserRoleName);

MDM.login();
Thread.sleep(2000);
MDM.gotoUserRole();
MDM.searchOnListPage(UserRoleName);
Thread.sleep(1000);
OR.is_element_present("EDIT_BUTTON_ON_LIST_PAGE").click();
Thread.sleep(1000);
OR.is_element_present("USER_EDIT_PROFILE_PAGE").click();
Thread.sleep(2000);
OR.is_element_present("USERROLE_EDIT_INHERIT_DROPDOWN_BTN").click();
Thread.sleep(1000);
OR.selectValueFromDropdown("USERROLE_EDIT_INHERIT_DROPDOWN", "Advanced");
Thread.sleep(2000);
String action_state = OR.is_element_present("USERROLE_EDIT_CRITICAL_ACTION_ON_BTN").getText();
System.out.println("action_state is:" + action_state);

OR.is_element_present("USERROLE_EDIT_CRITICAL_ACTION_ON_BTN").click();
Thread.sleep(1000);

String action_state1 = OR.is_element_present("USERROLE_EDIT_CRITICAL_ACTION_OFF_BTN").getText();
System.out.println("action_state is:" + action_state1);

OR.is_element_present("USERROLE_EDIT_SAVE_BTN").click();
Thread.sleep(2000);
OR.is_element_present("USERROLES_TAB").click();
Thread.sleep(2000);
MDM.searchOnListPage(UserRoleName);
Thread.sleep(1000);
OR.is_element_present("EDIT_BUTTON_ON_LIST_PAGE").click();
Thread.sleep(1000);
OR.is_element_present("USER_EDIT_PROFILE_PAGE").click();
Thread.sleep(2000);
String action_verify = OR.is_element_present("USERROLE_EDIT_CRITICAL_ACTION_OFF_BTN").getText();
System.out.println("action_verify is :" + action_verify);
Assert.assertEquals(action_verify, action_state1);
Log.info("Updating User role with Critical Action ON/OFF successful");

return "ok";
}

// ===========================================================================================
/**
* @author Lavina Jain This method verifies editing the privileges of the
* user role functionality.
* @throws Exception
*/
public static String check_edit_privilege_userrole() throws Exception {
String UserRoleName = ExcelUtils.get_excel_value("UserRoleName", Constants.Test_Data_Excel_File,
Constants.Test_Data_Sheet_User_Roles);
Log.info("UserRoleName is: " + UserRoleName);


MDM.login();
Thread.sleep(2000);
MDM.gotoUserRole();
Thread.sleep(2000);
MDM.searchOnListPage(UserRoleName);
Thread.sleep(1000);
String res=OR.is_element_present("USER_ROLE_PRIVILEGES_LBL").getText();
System.out.println("User role privilege is: "+res);
OR.is_element_present("EDIT_BUTTON_ON_LIST_PAGE").click();
Thread.sleep(1000);
OR.is_element_present("USER_EDIT_PROFILE_PAGE").click();
Thread.sleep(2000);
String s=OR.is_element_present("USERROLE_EDIT_CREATE_TOGGLE_ON_BTN").getText();
System.out.println("State before clicking is:"+s);
OR.is_element_present("USERROLE_EDIT_CREATE_TOGGLE_ON_BTN").click();
Thread.sleep(2000);
String s1=OR.is_element_present("USERROLE_EDIT_CREATE_TOGGLE_OFF_BTN").getText();
System.out.println("State after clicking is:"+s1);	
OR.clickOnElement("SAVE_USERROLE_BUTTON");
Thread.sleep(2000);
OR.is_element_present("USERROLES_TAB").click();
Thread.sleep(1000);
MDM.searchOnListPage(UserRoleName);
Thread.sleep(1000);
//	OR.is_element_present("EDIT_BUTTON_ON_LIST_PAGE").click();
//	Thread.sleep(1000);
//	OR.is_element_present("USER_EDIT_PROFILE_PAGE").click();
//	Thread.sleep(2000);
String s2=OR.is_element_present("USER_ROLE_PRIVILEGES_LBL").getText();
System.out.println("the privilege after changing is:"+s2);
Thread.sleep(2000);
int fres=Integer.parseInt(res);
int final1=fres-1;
String final2=Integer.toString(final1);
Assert.assertEquals(s2,final2);
Log.info("editing the privileges of the user role successful");
return "ok";

}

// ===========================================================================================
/**
* @author Lavina Jain This method verifies by adding a custom user role functionality.
* 
*/
public static String check_add_userrole_with_critical_action() throws Exception {
String NewUserRoleName = ExcelUtils.get_excel_value("NewUserRoleName", Constants.Test_Data_Excel_File,
Constants.Test_Data_Sheet_User_Roles);
Log.info("NewUserRoleName is: " + NewUserRoleName);

String NewUserRoleType = ExcelUtils.get_excel_value("NewUserRoleType", Constants.Test_Data_Excel_File,
Constants.Test_Data_Sheet_User_Roles);
Log.info("NewUserRoleType is: " + NewUserRoleType);

MDM.login();
Thread.sleep(2000);
MDM.gotoUserRole();
OR.is_element_present("ADD_USERROLE_BUTTON").click();
Thread.sleep(2000);
OR.is_element_present("USERROLENAME_TEXTFIELD").sendKeys(NewUserRoleName);
OR.is_element_present("DROPDOWN_SELECT_USERROLES_BTN").click();
OR.selectValueFromDropdown("DROPDOWN_LIST_USERROLES", NewUserRoleType);
Log.info("waiting for clicking element");
Thread.sleep(3000);

String action_state = OR.is_element_present("USERROLE_EDIT_CRITICAL_ACTION_ON_BTN").getText();
System.out.println("action_state is:" + action_state);

OR.is_element_present("USERROLE_EDIT_CRITICAL_ACTION_ON_BTN").click();
Thread.sleep(1000);

String action_state1 = OR.is_element_present("USERROLE_EDIT_CRITICAL_ACTION_OFF_BTN").getText();
System.out.println("action_state is:" + action_state1);

OR.clickOnElement("SAVE_USERROLE_BUTTON");
Thread.sleep(2000);
OR.is_element_present("OK_BUTTON").click();
Thread.sleep(2000);
OR.is_element_present("USERROLES_TAB").click();
MDM.searchOnListPage(NewUserRoleName);
Thread.sleep(1000);
OR.is_element_present("EDIT_BUTTON_ON_LIST_PAGE").click();
Thread.sleep(1000);
OR.is_element_present("USER_EDIT_PROFILE_PAGE").click();
Thread.sleep(2000);
String action_verify = OR.is_element_present("USERROLE_EDIT_CRITICAL_ACTION_OFF_BTN").getText();
System.out.println("action_verify is :" + action_verify);
Assert.assertEquals(action_verify, action_state1);
Log.info("adding new user role with Critical Action ON/OFF verified");
return "ok";
}

// ===========================================================================================
/**
* @author Lavina Jain This method verifies by assigning User Role to a User functionality.
* 
*/
public static String check_assign_user_role_to_user() throws Exception {
String FirstName = ExcelUtils.get_excel_value("FirstName", Constants.Test_Data_Excel_File,
Constants.Test_Data_Sheet_Users);
Log.info("FirstName is: " + FirstName);

MDM.login();
Thread.sleep(2000);
MDM.gotoUsers();
Thread.sleep(2000);
MDM.searchOnListPage(FirstName);
Thread.sleep(1000);
OR.is_element_present("EDIT_BUTTON_ON_LIST_PAGE").click(); 
Thread.sleep(1000);
OR.is_element_present("USER_EDIT_PROFILE_PAGE").click();
Thread.sleep(2000);
OR.is_element_present("USER_EDIT_PRIVILEDGES_TAB").click();
Thread.sleep(2000);
OR.is_element_present("CLICKED_ON_USER_ROLE_WHILE_ASSIGNING_ADMIN_ACCESS").click();
Thread.sleep(2000);
OR.selectValueFromDropdown("USER_ROLE_DROPDOWN_LIST", "Advanced");
Thread.sleep(2000);
OR.is_element_present("SAVE_BUTTON_AFTER_ASSIGNING_ADMIN_ACCESS_TO_USER").click();
Thread.sleep(2000);
OR.is_element_present("USERS_TAB").click();
Thread.sleep(2000);
MDM.searchOnListPage(FirstName);
Thread.sleep(2000);
OR.is_element_present("EDIT_BUTTON_ON_LIST_PAGE").click(); 
Thread.sleep(1000);
String res=OR.is_element_present("USER_ROLE_FROM_OVERVIEW_PAGE").getText();
System.out.println(res);
Assert.assertEquals(res, "Advanced");
Log.info("assigning User Role to a User verified");
return "ok";
}

// ===========================================================================================
/**
* @author Lavina Jain This method verifies the privileges assigned to the admins functionality.
* 
*/
public static String check_privileges_assigned_to_admins() throws Exception {
String UserRoleName = ExcelUtils.get_excel_value("UserRoleName", Constants.Test_Data_Excel_File,
Constants.Test_Data_Sheet_User_Roles);
Log.info("UserRoleName is: " + UserRoleName);


MDM.login();
Thread.sleep(2000);
MDM.gotoUserRole();
MDM.searchOnListPage(UserRoleName);
Thread.sleep(1000);


String res=OR.is_element_present("USER_ROLE_PRIVILEGES_LBL").getText();
System.out.println(res);
Assert.assertEquals(res, "55");
Log.info("assigning User Role to a User verified");
return "ok";
}

// ===========================================================================================
/**
* @author Lavina Jain This method verifies un-assigning user role functionality.
* 
*/
public static String check_unassign_user_role() throws Exception {
String UserRoleName = ExcelUtils.get_excel_value("UserRoleName", Constants.Test_Data_Excel_File,
Constants.Test_Data_Sheet_User_Roles);
Log.info("UserRoleName is: " + UserRoleName);

String NewUserRoleType = ExcelUtils.get_excel_value("NewUserRoleType", Constants.Test_Data_Excel_File,
Constants.Test_Data_Sheet_User_Roles);
Log.info("NewUserRoleType is: " + NewUserRoleType);

MDM.login();
Thread.sleep(2000);
MDM.gotoUserRole();
MDM.searchOnListPage(NewUserRoleType);
Thread.sleep(1000);

OR.is_element_present("EDIT_BUTTON_ON_LIST_PAGE").click();
Thread.sleep(1000);
OR.is_element_present("USER_EDIT_PROFILE_PAGE").click();
Thread.sleep(2000);
OR.is_element_present("USERROLE_EDIT_USERS_TAB").click();
Thread.sleep(2000);
OR.is_element_present("USERROLE_EDIT_USERS_CHECKBOX").click();
Thread.sleep(2000);
OR.is_element_present("USERROLE_EDIT_USERS_REMOVE_BTN").click();
Thread.sleep(2000);
OR.is_element_present("").click();
Thread.sleep(2000);
Log.info("assigning User Role to a User verified");
return "ok";
}


}