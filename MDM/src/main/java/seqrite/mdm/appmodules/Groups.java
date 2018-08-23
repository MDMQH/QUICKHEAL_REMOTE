/**
* 
*/
package seqrite.mdm.appmodules;

import java.util.NoSuchElementException;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import seqrite.mdm.utils.CommonUtils;
import seqrite.mdm.utils.Constants;
import seqrite.mdm.utils.ExcelUtils;
import seqrite.mdm.utils.Log;
import seqrite.mdm.utils.MDM;
import seqrite.mdm.utils.ORReader;

/**
* @author siddhant.raut
*
*/
public class Groups {

static ORReader OR = new ORReader();

public static String verify_create_group() throws Exception {
try {
String GroupName = ExcelUtils.get_excel_value("GroupName", Constants.Test_Data_Excel_File,
Constants.Test_Data_Sheet_Group);
Log.info("GroupName is: " + GroupName);

String Description = ExcelUtils.get_excel_value("Description", Constants.Test_Data_Excel_File,
Constants.Test_Data_Sheet_Group);
Log.info("Description is: " + Description);

MDM.login();
Thread.sleep(2000);
MDM.gotoGroups();
OR.is_element_present("ADD_DEVICEGROUP_BUTTON").click();
OR.is_element_present("DEVICEGROUPS_NAME_TEXTFIELD").sendKeys(GroupName);
Thread.sleep(2000);
OR.is_element_present("GROUP_DESCRIPTION_TEXTFIELD").sendKeys(Description);
Thread.sleep(2000);
OR.is_element_present("GROUP_SAVE_BUTTON").click();
OR.is_element_present("OK_BUTTON").click();
String GroupNamelbl = OR.is_element_present("GROUP_NAME_LABEL").getText();
Assert.assertEquals(GroupNamelbl, GroupName);
Log.info("Group added succcessfully");
} catch (Exception e) {
e.printStackTrace();
}
return "ok";
}

// =======================================================================================================================================
/**
* @author Lavina Jain This method verifies update Group name functionality.
*/
public static String check_edit_group() throws Exception {
try {
String GroupName = ExcelUtils.get_excel_value("GroupName", Constants.Test_Data_Excel_File,
Constants.Test_Data_Sheet_Group);
Log.info("GroupName is: " + GroupName);

String UpdatedGroupName = ExcelUtils.get_excel_value("UpdatedGroupName", Constants.Test_Data_Excel_File,
Constants.Test_Data_Sheet_Group);
Log.info("UpdatedGroupName is: " + UpdatedGroupName);
MDM.login();
Thread.sleep(2000);
MDM.gotoGroups();
MDM.searchOnListPage(GroupName);
Thread.sleep(1000);
OR.is_element_present("EDIT_BUTTON_ON_LIST_PAGE").click();
Thread.sleep(1000);
OR.is_element_present("USER_EDIT_PROFILE_PAGE").click();
Thread.sleep(2000);
OR.is_element_present("GROUP_NAME_EDIT_LABEL").clear();
OR.is_element_present("GROUP_NAME_EDIT_LABEL").sendKeys(UpdatedGroupName);
OR.is_element_present("GROUP_NAME_EDIT_SAVE_BTN").click();
Thread.sleep(2000);
// MDM.gotoGroups();
OR.is_element_present("GROUPS_TAB").click();
Thread.sleep(2000);
MDM.searchOnListPage(UpdatedGroupName);
String res = OR.is_element_present("GROUP_SEARCH_BY_NAME").getText();
System.out.println("UpdatedGroupName is :" + res);
Assert.assertEquals(res, "xyz ");
Log.info("GROUP_Name added successfully");
} catch (Exception e) {
e.printStackTrace();
}
return "ok";
}

// =======================================================================================================================================
/**
* @author Lavina Jain This method verifies deleting Group from delete icon
* functionality.
*/
public static String check_delete_group() throws Exception {
try {
String GroupName = ExcelUtils.get_excel_value("GroupName", Constants.Test_Data_Excel_File,
Constants.Test_Data_Sheet_Group);
Log.info("GroupName is: " + GroupName);

MDM.login();
Thread.sleep(2000);
// MDM.gotoGroups();
OR.is_element_present("GROUPS_TAB").click();
Thread.sleep(2000);
MDM.searchOnListPage(GroupName);
Thread.sleep(1000);
OR.is_element_present("DELETE_BUTTON_ON_LIST_PAGE").click();
Thread.sleep(2000);
OR.is_element_present("OK_BUTTON").click();
Log.info("Delete Group successful");
} catch (Exception e) {
e.printStackTrace();
}
return "ok";
}

// =======================================================================================================================================
/**
* @author Lavina Jain This method verifies the import Group functionality
*/
public static String check_import_group() throws Exception {

MDM.login();
Thread.sleep(2000);
MDM.gotoGroups();
OR.is_element_present("IMPORT_USERS_BUTTON").click();
Log.info("clicked IMPORT_USERS_BUTTON");

System.out.println(Constants.Test_Data_Excel_Dir_Path);
System.out.println(Constants.Test_Data_Group_CSV_File);
System.out.println(Constants.Test_Data_Excel_Dir_Path + Constants.Test_Data_Group_CSV_File);
Thread.sleep(4000);
// OR.is_element_present("IMPORT_USERS_SELECT_FILE_BTN").click();
OR.is_element_present("IMPORT_USERS_SELECT_FILE_LBL").click();
Log.info("Retrieving data from clipboard");
Thread.sleep(2000);
CommonUtils.get_file_from_testdata(Constants.Test_Data_Excel_Dir_Path, Constants.Test_Data_Group_CSV_File);
// CommonUtils.get_file_from_testdata();

OR.is_element_present("IMPORT_USERS_FILE_IMPORT_BTN").click();
Log.info("IMPORT_USERS csv file uploaded ");
Thread.sleep(3000);
// OR.is_element_present("IMPORT_USERS_NOTIFICATION_TAB").click();
OR.hoverOnElement("IMPORT_USERS_NOTIFICATION_TAB");
Log.info("IMPORT_USERS_NOTIFICATION_TAB clicked");
Thread.sleep(2000);
String s = OR.is_element_present("IMPORT_USERS_CHECK_FILE_IMPORT").getText();
Log.info("Import message is :" + s);
Assert.assertEquals(s, "Group import is Completed. Download Output File.");
return "ok";
}

// =======================================================================================================================================
/**
* @author Lavina Jain This method verifies the Simple Search On Group list
* Page
*/
public static String check_simple_search_group() throws Exception {
try {
String GroupName = ExcelUtils.get_excel_value("GroupName", Constants.Test_Data_Excel_File,
Constants.Test_Data_Sheet_Group);

Log.info("GroupName Details From Excel are: " + GroupName);

MDM.login();
Thread.sleep(2000);
MDM.gotoGroups();
MDM.searchOnListPage(GroupName);
Thread.sleep(1000);

String gname = OR.is_element_present("GROUP_SEARCH_BY_NAME").getText();
Log.info("MATCHING name");
Assert.assertEquals(gname, GroupName);
Log.info("Simple search by name successful");

} catch (Exception e) {
e.printStackTrace();
}

return "ok";
}

// =======================================================================================================================================
/**
* @author Lavina Jain This method verifies the advance search functionality
* on group list page
*/
public static String check_advance_search_group() throws Exception {
try {
MDM.login();
Thread.sleep(2000);
MDM.gotoGroups();
OR.is_element_present("USERS_ADVANCED_SEARCH_BTN").click();
Log.info("USERS_ADVANCED_SEARCH_BTN clicked");
Thread.sleep(2000);
OR.is_element_present("GROUP_ADVANCE_SEARCH_POLICY_DRPDWN_BTN").click();
Thread.sleep(2000);
Log.info("GROUP_ADVANCE_SEARCH_POLICY_DRPDWN_BTN clicked");

OR.selectValueFromDropdown("SELECT_USER_ROLE_DROPDOWN_LIST", "Default Policy");
Thread.sleep(2000);
Log.info("SELECT_USER_ROLE_DROPDOWN_LIST as Default Policy from DROPDOWN");

OR.is_element_present("GROUP_ADVANCE_SEARCH_CREATED_DRPDWN_BTN").click();
Thread.sleep(2000);
Log.info("GROUP_ADVANCE_SEARCH_CREATED_DRPDWN_BTN clicked");

OR.selectValueFromDropdown("SELECT_USER_ROLE_DROPDOWN_LIST", "Omkar Naik");
Thread.sleep(3000);
Log.info("SELECT_USER_ROLE_DROPDOWN_LIST as Omkar Naik from DROPDOWN");

OR.is_element_present("GROUP_ADVANCE_SEARCH_BTN_AFTER_DRPDWN").click();
Thread.sleep(2000);
Log.info("GROUP_ADVANCE_SEARCH_BTN_AFTER_DRPDWN clicked");
boolean res = OR.is_element_present("GROUP_ADVANCE_SEARCH_LBL").isDisplayed();
Log.info("Verifying display label of entries of groups");
Assert.assertTrue(res);
Log.info("Verified advance_search_group");
} catch (Exception e) {
e.printStackTrace();
}
return "ok";
}

// =======================================================================================================================================
/**
* @author Lavina Jain This method verifies the Filter Column by
* selecting/deselecting columns.
*/
public static String check_Filter_Column() throws Exception {
try {
MDM.login();
Thread.sleep(2000);
MDM.gotoGroups();
OR.is_element_present("USERS_FILTER_COLUMNS").click();
Log.info("USERS_FILTER_COLUMNS clicked");
// by unchecking all checkboxes

Thread.sleep(2000);
OR.is_element_present("USERS_FILTER_COLUMNS_BY_ID").click();
Log.info("USERS_FILTER_COLUMNS_BY_ID clicked");
OR.is_element_present("GROUP_FILTER_COLUMN_BY_No_of_Devices").click();
Log.info("GROUP_FILTER_COLUMN_BY_No_of_Devices clicked");
Thread.sleep(1000);
OR.is_element_present("USERS_FILTER_COLUMNS_OUTSIDE").click();
Thread.sleep(1000);
String name = OR.is_element_present("GROUP_FILTER_COLUMN_BY_Group_Name").getText();
Log.info("MATCHING group name");
Assert.assertEquals(name, "Group Name");
// OR.is_element_present("USERS_FILTER_COLUMNS").click();

// if(OR.is_element_present("USERS_FILTER_COLUMNS").isSelected())
// {
// OR.is_element_present("USERS_FILTER_COLUMNS_CHECK_ALL").click();
// Thread.sleep(2000);
// String
// uname=OR.is_element_present("USERS_FILTER_COLUMNS_BY_USERNAME").getText();
// Log.info("MATCHING USER NAME");
// Assert.assertEquals(uname, "User Name");
// }

MDM.gotoGroups();
OR.is_element_present("USERS_FILTER_COLUMNS").click();
Log.info("USERS_FILTER_COLUMNS clicked");
// by checking 2 checkboxes
Thread.sleep(2000);
OR.is_element_present("USERS_FILTER_COLUMNS_BY_ID").click();
Log.info("USERS_FILTER_COLUMNS_BY_ID clicked");
OR.is_element_present("GROUP_FILTER_COLUMN_BY_No_of_Devices").click();
Log.info("GROUP_FILTER_COLUMN_BY_No_of_Devices clicked");
Thread.sleep(1000);

String id = OR.is_element_present("USERS_FILTER_COLUMNS_BY_ID").getText();
Log.info("MATCHING Id");
Assert.assertEquals(id, "Id");

String nodev = OR.is_element_present("GROUP_FILTER_COLUMN_BY_No_of_Devices_CHECK").getText();
Log.info("MATCHING No_of_Devices");
Assert.assertEquals(nodev, "No. of Devices");
Thread.sleep(1000);
// OR.is_element_present("USERS_FILTER_COLUMNS").click();
OR.is_element_present("USERS_FILTER_COLUMNS_OUTSIDE").click();
Thread.sleep(1000);

Log.info("column Values successfully verified ");
} catch (Exception e) {
e.printStackTrace();
}

return "ok";
}

// =======================================================================================================================================
/**
* @author Lavina Jain This method verifies the apply configuration to group
* from with selected option functionality
*/
public static String check_apply_config_with_selected_option() throws Exception {
try {
String GroupName = ExcelUtils.get_excel_value("GroupName", Constants.Test_Data_Excel_File,
Constants.Test_Data_Sheet_Group);

Log.info("GroupName Details From Excel are: " + GroupName);
MDM.login();
Thread.sleep(2000);
MDM.gotoGroups();
MDM.searchOnListPage(GroupName);
Thread.sleep(1000);
OR.is_element_present("CHECKED_THE_SELECT_ALL_CHECKBOX").click();
OR.is_element_present("PERFORM_ACTION_ON_WITH_SELECTED_DROPDOWN").click();
Thread.sleep(2000);
OR.selectValueFromDropdown("GROUP_ACTION_DROPDOWN", "Apply Configuration");
Thread.sleep(2000);
OR.is_element_present("GROUP_ACTION_SELECT_DROPDOWN_SUBMIT_BTN").click();
OR.is_element_present("OK_BUTTON").click();
Log.info("apply configuration to group verified");
} catch (Exception e) {
e.printStackTrace();
}

return "ok";
}

// =======================================================================================================================================
/**
* @author Lavina Jain This method verifies the apply policy to group from
* with selected option functionality
*/
public static String check_apply_policy_with_selected_option() throws Exception {
try {
String GroupName = ExcelUtils.get_excel_value("GroupName", Constants.Test_Data_Excel_File,
Constants.Test_Data_Sheet_Group);

Log.info("GroupName Details From Excel are: " + GroupName);
MDM.login();
Thread.sleep(2000);
MDM.gotoGroups();
MDM.searchOnListPage(GroupName);
Thread.sleep(1000);
OR.is_element_present("CHECKED_THE_SELECT_ALL_CHECKBOX").click();
OR.is_element_present("PERFORM_ACTION_ON_WITH_SELECTED_DROPDOWN").click();
Thread.sleep(2000);
OR.selectValueFromDropdown("GROUP_ACTION_DROPDOWN", "Apply Policy");
Thread.sleep(2000);
OR.is_element_present("GROUP_ACTION_SELECT_DROPDOWN_SUBMIT_BTN").click();
Thread.sleep(2000);
MDM.searchOnListPage(GroupName);
Thread.sleep(1000);
OR.is_element_present("EDIT_BUTTON_ON_LIST_PAGE").click();
Log.info("EDIT_BUTTON_ON_LIST_PAGE clicked");
String res = OR.is_element_present("GROUP_ASSIGNED_POLICY").getText();
System.out.println(res);
Log.info("Matching ASSIGNED_POLICY name");
Assert.assertEquals(res, "Default Policy");
Log.info("apply configuration to group verified");
} catch (Exception e) {
e.printStackTrace();
}

return "ok";
}

// =======================================================================================================================================
/**
* @author Lavina Jain This method verifies the apply Fence Configuration to
* group from with selected option functionality
*/
public static String check_apply_fence_configuration_with_selected_option() throws Exception {
try {
String GroupName = ExcelUtils.get_excel_value("GroupName", Constants.Test_Data_Excel_File,
Constants.Test_Data_Sheet_Group);

Log.info("GroupName Details From Excel are: " + GroupName);
MDM.login();
Thread.sleep(2000);
MDM.gotoGroups();
MDM.searchOnListPage(GroupName);
Thread.sleep(1000);
OR.is_element_present("CHECKED_THE_SELECT_ALL_CHECKBOX").click();
OR.is_element_present("PERFORM_ACTION_ON_WITH_SELECTED_DROPDOWN").click();
Thread.sleep(2000);
OR.selectValueFromDropdown("GROUP_ACTION_DROPDOWN", "Apply Fence Configuration");
Thread.sleep(2000);
OR.is_element_present("GROUP_ACTION_SELECT_DROPDOWN_SUBMIT_BTN").click();
Thread.sleep(2000);
MDM.searchOnListPage(GroupName);
Thread.sleep(1000);
String res1 = OR.is_element_present("GROUP_ASSIGNED_FENCE_CONFIG_AFTER_SEARCH").getText();
System.out.println(res1);
Log.info("Matching ASSIGNED_FENCE_CONFIG name");
Assert.assertEquals(res1, "Omkar_Fence");
Log.info("apply configuration to group verified");
} catch (Exception e) {
e.printStackTrace();
}

return "ok";
}

// =======================================================================================================================================
/**
* @author Lavina Jain This method verifies the apply Broadcast Message to
* group from with selected option functionality
*/
public static String check_broadcast_message_with_selected_option() throws Exception {
try {
String GroupName = ExcelUtils.get_excel_value("GroupName", Constants.Test_Data_Excel_File,
Constants.Test_Data_Sheet_Group);

Log.info("GroupName Details From Excel are: " + GroupName);
MDM.login();
Thread.sleep(2000);
MDM.gotoGroups();
MDM.searchOnListPage(GroupName);
Thread.sleep(1000);
OR.is_element_present("CHECKED_THE_SELECT_ALL_CHECKBOX").click();
OR.is_element_present("PERFORM_ACTION_ON_WITH_SELECTED_DROPDOWN").click();
Thread.sleep(2000);
OR.selectValueFromDropdown("GROUP_ACTION_DROPDOWN", "Broadcast Message");
Thread.sleep(1000);
OR.is_element_present("GROUP_ACTION_SELECT_DROPDOWN_SUBMIT_BTN").click();
Thread.sleep(1000);
OR.is_element_present("OK_BUTTON").click();
Thread.sleep(2000);
OR.is_element_present("GROUP_BROADCAST_MSG_LBL").sendKeys("This is a broadcast msg");
OR.is_element_present("GROUP_BROADCAST_MSG_TYPE").click();
Thread.sleep(1000);
OR.selectValueFromDropdown("GROUP_BROADCAST_MSG_DROPDOWN", "Informative");
Thread.sleep(1000);
OR.is_element_present("GROUP_BROADCAST_MSG_BTN").click();
Thread.sleep(4000);
String res = OR.is_element_present("GROUP_BROADCAST_MSG_NOTIFICATION").getText();
System.out.println(res);
Assert.assertEquals(res, "Command to Broadcast the message sent successfully.");
Log.info("Broadcast Message to group verified");
} catch (Exception e) {
e.printStackTrace();
}

return "ok";
}

// =======================================================================================================================================
/**
* @author Lavina Jain This method verifies the Delete to group from with
* selected option functionality
*/
public static String check_delete_with_selected_option() throws Exception {
try {
String NewGroupName = ExcelUtils.get_excel_value("NewGroupName", Constants.Test_Data_Excel_File,
Constants.Test_Data_Sheet_Group);

Log.info("NewGroupName Details From Excel are: " + NewGroupName);

String Description = ExcelUtils.get_excel_value("Description", Constants.Test_Data_Excel_File,
Constants.Test_Data_Sheet_Group);
Log.info("Description is: " + Description);

MDM.login();
Thread.sleep(2000);
MDM.gotoGroups();
OR.is_element_present("ADD_DEVICEGROUP_BUTTON").click();
OR.is_element_present("DEVICEGROUPS_NAME_TEXTFIELD").sendKeys(NewGroupName);
Thread.sleep(2000);
OR.is_element_present("GROUP_DESCRIPTION_TEXTFIELD").sendKeys(Description);
Thread.sleep(2000);
OR.is_element_present("GROUP_SAVE_BUTTON").click();
OR.is_element_present("OK_BUTTON").click();
String GroupNamelbl = OR.is_element_present("GROUP_NAME_LABEL").getText();
Assert.assertEquals(GroupNamelbl, NewGroupName);
Log.info("Group added succcessfully");
MDM.gotoGroups();
MDM.searchOnListPage(NewGroupName);
Thread.sleep(1000);
OR.is_element_present("CHECKED_THE_SELECT_ALL_CHECKBOX").click();
OR.is_element_present("PERFORM_ACTION_ON_WITH_SELECTED_DROPDOWN").click();
Thread.sleep(2000);
OR.selectValueFromDropdown("GROUP_ACTION_DROPDOWN", "Delete");
Thread.sleep(1000);
OR.is_element_present("GROUP_ACTION_SELECT_DROPDOWN_SUBMIT_BTN").click();
Thread.sleep(1000);
OR.is_element_present("OK_BUTTON").click();
Log.info("Delete action to group verified");
} catch (Exception e) {
e.printStackTrace();
}

return "ok";
}

// =======================================================================================================================================
/**
* @author Lavina Jain This method verifies update Group assigned policy
* functionality.
*/
public static String check_Edit_Group_with_new_policy() throws Exception {
try {
String GroupName = ExcelUtils.get_excel_value("GroupName", Constants.Test_Data_Excel_File,
Constants.Test_Data_Sheet_Group);
Log.info("GroupName is: " + GroupName);

String UpdatedPolicy = ExcelUtils.get_excel_value("UpdatedPolicy", Constants.Test_Data_Excel_File,
Constants.Test_Data_Sheet_Group);
Log.info("UpdatedPolicy is: " + UpdatedPolicy);
MDM.login();
Thread.sleep(2000);
MDM.gotoGroups();
MDM.searchOnListPage(GroupName);
Thread.sleep(1000);
OR.is_element_present("EDIT_BUTTON_ON_LIST_PAGE").click();
Thread.sleep(1000);
OR.is_element_present("USER_EDIT_PROFILE_PAGE").click();
Thread.sleep(2000);
OR.is_element_present("GROUP_DETAILPAGE_EDIT_DROPDOWN").click();
Thread.sleep(2000);
OR.selectValueFromDropdown("GROUP_SELECT_POLICY_FROM_DROPDWN", "Automation Policy Twenty");
Thread.sleep(1000);

OR.is_element_present("GROUP_NAME_EDIT_SAVE_BTN").click();
Thread.sleep(2000);
// MDM.gotoGroups();
OR.is_element_present("GROUPS_TAB").click();
Thread.sleep(2000);
MDM.searchOnListPage(GroupName);
Thread.sleep(2000);
String res = OR.is_element_present("GROUP_SEARCH_BY_ASSIGNED_POLICY").getText();
Assert.assertEquals(res, "Automation Policy Twenty");
Log.info("GROUP_UpdatedPolicy added successfully");
} catch (Exception e) {
e.printStackTrace();
}
return "ok";
}

// =======================================================================================================================================
/**
* @author Lavina Jain This method verifies update Group Fence Configuration
* functionality.
*/
public static String check_Edit_Group_with_new_Fence_Configuration() throws Exception {
try {
String GroupName = ExcelUtils.get_excel_value("GroupName", Constants.Test_Data_Excel_File,
Constants.Test_Data_Sheet_Group);
Log.info("GroupName is: " + GroupName);

String UpdatedFenceConfiguration = ExcelUtils.get_excel_value("UpdatedFenceConfiguration",
Constants.Test_Data_Excel_File, Constants.Test_Data_Sheet_Group);
Log.info("UpdatedFenceConfiguration is: " + UpdatedFenceConfiguration);

MDM.login();
Thread.sleep(2000);
MDM.gotoGroups();
MDM.searchOnListPage(GroupName);
Thread.sleep(1000);
OR.is_element_present("EDIT_BUTTON_ON_LIST_PAGE").click();
Thread.sleep(1000);
OR.is_element_present("USER_EDIT_PROFILE_PAGE").click();
Thread.sleep(2000);
OR.is_element_present("GROUP_DETAILPAGE_EDIT_FENCE_CONFIG_DROPDOWN_BTN").click();
Thread.sleep(2000);
OR.selectValueFromDropdown("GROUP_SELECT_FENCE_CONFIG_FROM_DROPDWN", "Automation_Fence");
Thread.sleep(1000);

OR.is_element_present("GROUP_NAME_EDIT_SAVE_BTN").click();
Thread.sleep(2000);
// MDM.gotoGroups();
OR.is_element_present("GROUPS_TAB").click();
Thread.sleep(2000);
MDM.searchOnListPage(GroupName);
Thread.sleep(2000);
String res = OR.is_element_present("GROUP_ASSIGNED_FENCE_CONFIG_AFTER_SEARCH").getText();
Assert.assertEquals(res, "Automation_Fence");
Log.info("GROUP_UpdatedFenceConfiguration added successfully");
} catch (Exception e) {
e.printStackTrace();
}
return "ok";
}

// =======================================================================================================================================
/**
* @author Lavina Jain This method verifies Edit Group > Device Tab, by adding device to group functionality
*/
public static String check_Edit_Group_with_adding_device() throws Exception {
try {
String GroupName = ExcelUtils.get_excel_value("GroupName", Constants.Test_Data_Excel_File,
Constants.Test_Data_Sheet_Group);
Log.info("GroupName is: " + GroupName);

String GroupAddDevice = ExcelUtils.get_excel_value("GroupAddDevice",
Constants.Test_Data_Excel_File, Constants.Test_Data_Sheet_Group);
Log.info("GroupAddDevice is: " + GroupAddDevice);

MDM.login();
Thread.sleep(2000);
MDM.gotoGroups();
MDM.searchOnListPage(GroupName);
Thread.sleep(1000);
OR.is_element_present("EDIT_BUTTON_ON_LIST_PAGE").click();
Thread.sleep(1000);
OR.is_element_present("USER_EDIT_PROFILE_PAGE").click();
Thread.sleep(2000);
OR.is_element_present("GROUP_EDIT_DEVICES_TAB").click();
Thread.sleep(1000);
OR.is_element_present("GROUP_ADD_DEVICE_BTN").click();
OR.popuphandle("GROUP_ADD_DEVICE_SEARCH_LBL_POPUP",GroupAddDevice);
Log.info("Popup handled");
Log.info("Nexus Test entered on searchbox");
OR.is_element_present("GROUP_ADD_DEVICE_CHECKBOX_POPUP").click();
Thread.sleep(1000);
OR.is_element_present("GROUP_ADD_DEVICES_BTN_POPUP").click();
Thread.sleep(1000);
String res=OR.is_element_present("GROUP_BROADCAST_MSG_NOTIFICATION").getText();
System.out.println(res);
Assert.assertEquals(res, "Device is successfully assigned to Group.");
Log.info("GROUP_UpdatedFenceConfiguration added successfully");
} catch (Exception e) {
e.printStackTrace();
}
return "ok";
}

//=======================================================================================================================================
/**
* @author Lavina Jain This method verifies Edit Group > Group QR Code Tab, Check by Generating QR Code to 
* group functionality
*/
public static String check_Edit_Group_with_generating_QR_code() throws Exception {
String GroupName = ExcelUtils.get_excel_value("GroupName", Constants.Test_Data_Excel_File,
Constants.Test_Data_Sheet_Group);
Log.info("GroupName is: " + GroupName);

String GroupAssignOwner = ExcelUtils.get_excel_value("GroupAssignOwner",
Constants.Test_Data_Excel_File, Constants.Test_Data_Sheet_Group);
Log.info("GroupAssignOwner is: " + GroupAssignOwner);

MDM.login();
Thread.sleep(2000);
MDM.gotoGroups();
MDM.searchOnListPage(GroupName);
Thread.sleep(1000);
OR.is_element_present("EDIT_BUTTON_ON_LIST_PAGE").click();
Thread.sleep(1000);
OR.is_element_present("USER_EDIT_PROFILE_PAGE").click();
Thread.sleep(2000);
OR.is_element_present("GROUP_EDIT_QRCODE_TAB").click();
Thread.sleep(3000);
//	OR.is_element_present("GROUP_EDIT_QRCODE_CHECKBOX").click();
//	Thread.sleep(3000);
boolean b = false;
boolean c= false;
try{
System.out.println("in try");
b=OR.is_element_present("GROUP_EDIT_QRCODE_CHECKBOX_CHECKED").isSelected();

//	OR.is_element_present("GROUP_EDIT_QRCODE_CHECKBOX_CHECKED").click();
//	OR.is_element_present("GROUP_EDIT_QRCODE_CHECKBOX_CHECKED").click();
System.out.println("b in try is:"+b);
}
catch (Exception e) {
System.out.println("in catch");
c=OR.is_element_present("GROUP_EDIT_QRCODE_CHECKBOX_UNCHECKED").isSelected();
System.out.println("c in catch is:"+c);

}

//boolean b=OR.is_element_present("GROUP_EDIT_QRCODE_PRESENCE").isDisplayed()
//	Thread.sleep(3000);
//	System.out.println(b);
//if(OR.is_element_present("GROUP_EDIT_QRCODE_CHECKBOX_CHECKED").isSelected())
if(b||c)
{
System.out.println("in b or c");
OR.is_element_present("GROUP_EDIT_QRCODE_VALIDITY_DROPDWN_BTN_UPDATED").click();
Thread.sleep(2000);
System.out.println("yo");
String validity = OR.is_element_present("GROUP_EDIT_QRCODE_VALIDITY_FROM_DROPDWN_UPDATED").getText();
System.out.println(validity);
if (validity.equalsIgnoreCase("7 days")) {
OR.selectValueFromDropdown("GROUP_EDIT_QRCODE_VALIDITY_FROM_DROPDWN_UPDATED", "15 days");
Thread.sleep(2000);
} else {
OR.selectValueFromDropdown("GROUP_EDIT_QRCODE_VALIDITY_FROM_DROPDWN_UPDATED", "7 days");
Thread.sleep(2000);
}

OR.is_element_present("GROUP_EDIT_UPDATE_QRCODE_BTN").click();
Thread.sleep(2000);
String gname = OR.is_element_present("GROUP_EDIT_QRCODE_GROUP_NAME_VERIFY").getText();
System.out.println(gname);
Assert.assertEquals(gname, GroupName);
Log.info("QR Code Updated");
}
else
{
System.out.println("in else");
OR.is_element_present("GROUP_EDIT_QRCODE_CHECKBOX_UNCHECKED").click();
Thread.sleep(2000);
//	OR.is_element_present("GROUP_EDIT_QRCODE_CHECKBOX_UNCHECKED").click();
//	Thread.sleep(2000);
OR.is_element_present("GROUP_EDIT_QRCODE_ASSIGN_OWNER_BTN").click();
Thread.sleep(2000);
OR.popuphandle("GROUP_ADD_DEVICE_SEARCH_LBL_POPUP",GroupAssignOwner);
Thread.sleep(5000);
Log.info("Popup handled");
Log.info("Automation User entered on searchbox");
OR.is_element_present("GROUP_EDIT_QRCODE_ASSIGN_OWNER").click();
System.out.println("ok");
Thread.sleep(5000);
OR.is_element_present("GROUP_EDIT_QRCODE_VALIDITY_DROPDWN_BTN").click();
System.out.println("yo");
OR.selectValueFromDropdown("GROUP_EDIT_QRCODE_VALIDITY_FROM_DROPDWN","7 days");
Thread.sleep(2000);
OR.is_element_present("GROUP_EDIT_GENERATE_QRCODE_BTN").click();
Log.info("QR Code Generated");
Thread.sleep(2000);
//	OR.is_element_present("GROUP_EDIT_QRCODE_CHECKBOX_CHECKED").click();
//	OR.is_element_present("GROUP_EDIT_QRCODE_CHECKBOX_UNCHECKED").click();
}
return "ok";


}

}