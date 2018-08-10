/**
 * 
 */
package seqrite.mdm.test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import seqrite.mdm.appmodules.Department;
import seqrite.mdm.utils.Setup;
import seqrite.mdm.utils.TestNGListener;

/**
 * @author siddhant.raut
 * This class contains the test case for Department module
 * 
 */

@Listeners(TestNGListener.class)
public class DepartmentTest extends Setup{
	
	String Result;
	@Test(priority=1)
	public void verify_Add_Department() throws Exception {
		Result= Department.verify_Add_Department();
		Assert.assertEquals(Result, "ok");
	}
	
//=======================================================================================================================================================
	/*@Test(priority=2)
	public void verify_Update_Department() throws Exception {
		Result= Department.verify_Update_Department();
		Assert.assertEquals(Result, "ok");
	}
	
//=======================================================================================================================================================

	@Test(priority=3)
	public void verify_Delete_Department() throws Exception {
		Result= Department.verify_Delete_Department();
		Assert.assertEquals(Result, "ok");
	}*/
//===================================================================================================================
}
