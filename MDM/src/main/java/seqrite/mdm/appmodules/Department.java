/**
 * 
 */
package seqrite.mdm.appmodules;
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
public class Department {
	
	static ORReader OR = new ORReader();
	static String pagetitle=null;
	
	/**
	 * @author siddhant.raut
	 * This method will add department and verify is department is added sucuessfully or not.
	 * This method will also create group with respect to department name also. 
	 * 
	 */
	
	public static String verify_Add_Department() throws Exception{
	
	String departmentName=ExcelUtils.get_excel_value("DepartmentName", Constants.Test_Data_Excel_File,Constants.Test_Data_Sheet_Department);
	String description=ExcelUtils.get_excel_value("Description", Constants.Test_Data_Excel_File,Constants.Test_Data_Sheet_Department);
	String parentDept=ExcelUtils.get_excel_value("ParentDepartment", Constants.Test_Data_Excel_File,Constants.Test_Data_Sheet_Department);
		
	MDM.login();
	Log.info("User Login Successfully");
	Thread.sleep(1000);
	MDM.gotoDepartments();
	OR.is_element_present("ADD_DEPARTMENT_BUTTON").click();
	Log.info("Department Test Data From Excel is: Department Name: " +departmentName +" Description: " +description + " Parent Department: " +parentDept  );
	OR.is_element_present("DEPARTMENT_NAME_TEXTFIELD").sendKeys(departmentName);
	OR.is_element_present("PARENT_DEPT_DRPOPDOWN").click();
	Thread.sleep(1000);
	OR.selectValueFromDropdown("PARENT_DEPT_DROPDOWN_LIST", parentDept);
	OR.is_element_present("DEPARTMENT_DESC_TEXTFIELD").sendKeys(description);
	OR.is_element_present("CREATE_DEPT_GROUP_CHECKBOX").click();
	Thread.sleep(1000);
	OR.is_element_present("SAVE_DEPT_BUTTON").click();
	OR.is_element_present("OK_BUTTON").click();
	pagetitle=CommonUtils.get_page_titile();
	Log.info("Pagetitle is: " +pagetitle );
	//Omkar
	/*String OM =  OR.toString("OK_BUTTON");
	System.out.print(OM);*/
	//Omkar
	Assert.assertEquals(pagetitle, "Department Details");
	return "ok";
	}
	
//============================================================================================================================================================
	
	/**
	 * @author siddhant.raut
	 * This method will update  department 
	 * 
	 */
	public static String verify_Update_Department() throws Exception{
		
		String departmentName=ExcelUtils.get_excel_value("DepartmentName", Constants.Test_Data_Excel_File,Constants.Test_Data_Sheet_Department);
		String DepartmentNameUpdated= ExcelUtils.get_excel_value("DepartmentNameUpdated", Constants.Test_Data_Excel_File, Constants.Test_Data_Sheet_Department);
		
		MDM.login();
		MDM.gotoDepartments();
		MDM.searchOnListPage(departmentName);
		OR.is_element_present("EDIT_BUTTON_ON_LIST_PAGE").click();
		OR.is_element_present("EDIT_DEPARTMENT_TAB").click();
		Thread.sleep(1000);
		OR.is_element_present("EDIT_DEPARTMENT_NAME").click();
		OR.is_element_present("EDIT_DEPARTMENT_NAME").sendKeys(DepartmentNameUpdated);
		Thread.sleep(1000);
		OR.is_element_present("UPDATE_DEPARTMENT_BUTTON").click();
		return "ok";
	}
//============================================================================================================================================================
		
	/**
	 * @author siddhant.raut
	 * This method will delete department
	 * 
	 */
	
	public static String verify_Delete_Department() throws Exception{
		
		String DepartmentNameUpdated= ExcelUtils.get_excel_value("DepartmentNameUpdated", Constants.Test_Data_Excel_File, Constants.Test_Data_Sheet_Department);
		Log.info(DepartmentNameUpdated);
		MDM.login();
		MDM.gotoDepartments();
		MDM.searchOnListPage(DepartmentNameUpdated);
		OR.is_element_present("DELETE_BUTTON_ON_LIST_PAGE").click();
		OR.is_element_present("OK_BUTTON").click();
		return "ok";
	}
}