/**
* 
*/
package seqrite.mdm.test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import seqrite.mdm.appmodules.Groups;
import seqrite.mdm.appmodules.UserRoles;
import seqrite.mdm.utils.Setup;
import seqrite.mdm.utils.TestNGListener;

/**
* @author siddhant.raut
*/

@Listeners(TestNGListener.class)
public class UserRolesTest extends Setup {

String Result;

//=========================================================================================================
/**
* @author siddhant.raut
* This test verify the create new Userrole functionality
*/

//@Test(priority=1)
public void verify_create_userrole() throws Exception{
Result=UserRoles.create_user_role();
Assert.assertEquals(Result, "ok");
}
//=========================================================================================================	

/**
* @author Lavina Jain
* This test case is to Check by deleting a custom user role in an MDM application.
* 
*/
//@Test(priority =6) 
public void verify_Delete_user_role() throws Exception{
Result = UserRoles.check_delete_user_role();
Assert.assertEquals(Result,"ok");
}
//===============================================================================================================

/**
* @author Lavina Jain
* This test case is to Check by Updating User role with Critical Action ON/OFF in an MDM application.
* 
*/
//	@Test(priority = 2) 
public void verify_update_user_role_critical_action() throws Exception{
Result = UserRoles.check_update_user_role_critical_action();
Assert.assertEquals(Result,"ok");
}

//=========================================================================================================
/**
* @author Lavina Jain
* This test verify editing the privileges of the user role functionality
*/

//@Test(priority=3)
public void verify_edit_privilege_userrole() throws Exception{
Result=UserRoles.check_edit_privilege_userrole();
Assert.assertEquals(Result, "ok");
}

//=========================================================================================================
/**
* @author Lavina Jain
* This test verify by adding new user role with Critical Action ON/OFF functionality
*/

//	@Test(priority=4)
public void verify_add_userrole_with_critical_action() throws Exception{
Result=UserRoles.check_add_userrole_with_critical_action();
Assert.assertEquals(Result, "ok");
}

//=========================================================================================================
/**
* @author Lavina Jain
* This test verify by assigning User Role to a User functionality
*/

//@Test(priority=5)
public void verify_assign_user_role_to_user() throws Exception{
Result=UserRoles.check_assign_user_role_to_user();
Assert.assertEquals(Result, "ok");
}

//=========================================================================================================
/**
* @author Lavina Jain
* This test verify the privileges assigned to the admins functionality
*/

//@Test(priority=6)
public void verify_privileges_assigned_to_admins() throws Exception{
Result=UserRoles.check_privileges_assigned_to_admins();
Assert.assertEquals(Result, "ok");
}

//=========================================================================================================
/**
* @author Lavina Jain
* This test verify by un-assigning user role functionality
*/

//@Test(priority=7)
public void verify_unassign_user_role() throws Exception{
Result=UserRoles.check_unassign_user_role();
Assert.assertEquals(Result, "ok");
}

}