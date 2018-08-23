/**
* 
*/
package seqrite.mdm.test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import seqrite.mdm.appmodules.Groups;
import seqrite.mdm.appmodules.Users;
import seqrite.mdm.utils.Setup;
import seqrite.mdm.utils.TestNGListener;

/**
* @author siddhant.raut
*/

@Listeners(TestNGListener.class)
public class GroupTest extends Setup {

String Result;
//==============================================================================================================	
/**
* This test case is to add group & verify
*/

//	@Test(priority = 1)
public void verify_add_group() throws Exception
{
Result = Groups.verify_create_group();
Assert.assertEquals(Result, "ok");
}

//===============================================================================================================

/**
* @author Lavina Jain
* This test case is to update the Group name in an MDM application.
* 
*/
//@Test(priority = 2) 
public void verify_Update_Group() throws Exception{
Result = Groups.check_edit_group();
Assert.assertEquals(Result,"ok");
}

//===============================================================================================================

/**
* @author Lavina Jain
* This test case is to deleting Group from delete icon in an MDM application.
* 
*/
//@Test(priority = 3) 
public void verify_Delete_Group() throws Exception{
Result = Groups.check_delete_group();
Assert.assertEquals(Result,"ok");
}

//===================================================================================================================	
/**
* @author Lavina Jain
* This test case is to import the csv file & add group data from it into MDM application.
* 
*/

//@Test(priority = 4)
public void verify_import_group() throws Exception{
Result= Groups.check_import_group();
Assert.assertEquals(Result, "ok");
}

//===================================================================================================================	
/**
* @author Lavina Jain
* This test case is to Check Simple Search On Group list Page into MDM application.
* 
*/

//@Test(priority = 5)
public void verify_simple_search_group() throws Exception{
Result= Groups.check_simple_search_group();
Assert.assertEquals(Result, "ok");
}
//===================================================================================================================	
/**
* @author Lavina Jain
* This test case is to Check Simple Search On Group list Page into MDM application.
* 
*/

//@Test(priority = 6)
public void verify_advance_search_group() throws Exception{
Result= Groups.check_advance_search_group();
Assert.assertEquals(Result, "ok");
}
//===================================================================================================================	
/**
* @author Lavina Jain
* This test case is to check the Filter Column functionality by ID,No. of Devices in MDM application.
* 
*/	
//@Test(priority = 7)
public void verify_Filter_Column() throws Exception{
Result= Groups.check_Filter_Column();
Assert.assertEquals(Result, "ok");
}

//===================================================================================================================	
/**
* @author Lavina Jain
* This test case is to check the Group List Page, Select a Group and check with selected action 
* Apply Configuration in MDM application.
* 
*/	
//@Test(priority = 8)
public void verify_apply_config_with_selected_option() throws Exception{
Result= Groups.check_apply_config_with_selected_option();
Assert.assertEquals(Result, "ok");
}

//===================================================================================================================	
/**
* @author Lavina Jain
* This test case is to check the Group List Page, Select a Group and check with selected action 
* Apply policy in MDM application.
* 
*/	
//@Test(priority = 9)
public void verify_apply_policy_with_selected_option() throws Exception{
Result= Groups.check_apply_policy_with_selected_option();
Assert.assertEquals(Result, "ok");
}

//===================================================================================================================	
/**
* @author Lavina Jain
* This test case is to check the Group List Page, Select a Group and check with selected action 
* Apply Fence Configuration in MDM application.
* 
*/	
//@Test(priority = 10)
public void verify_apply_fence_configuration_with_selected_option() throws Exception{
Result= Groups.check_apply_fence_configuration_with_selected_option();
Assert.assertEquals(Result, "ok");
}

//===================================================================================================================	
/**
* @author Lavina Jain
* This test case is to check the Group List Page, Select a Group and check with selected action 
* Broadcast Message in MDM application.
* 
*/	
//@Test(priority = 11)
public void verify_broadcast_message_with_selected_option() throws Exception{
Result= Groups.check_broadcast_message_with_selected_option();
Assert.assertEquals(Result, "ok");
}

//===================================================================================================================	
/**
* @author Lavina Jain
* This test case is to check the Group List Page, Select a Group and check with selected action 
* Delete in MDM application.
* 
*/	
//@Test(priority = 12)
public void verify_Delete_with_selected_option() throws Exception{
Result= Groups.check_delete_with_selected_option();
Assert.assertEquals(Result, "ok");
}

//===================================================================================================================	
/**
* @author Lavina Jain
* This test case is to check the Edit Group, Check by updating assigned policy to Group in MDM 
* application.
* 
*/	
//@Test(priority = 13)
public void verify_Edit_Group_with_new_policy() throws Exception{
Result= Groups.check_Edit_Group_with_new_policy();
Assert.assertEquals(Result, "ok");
}

//===================================================================================================================	
/**
* @author Lavina Jain
* This test case is to check the Edit Group, Check by updating assigned Fence Configuration to Group
*	in MDM application.
* 
*/	
//@Test(priority = 14)
public void verify_Edit_Group_with_new_Fence_Configuration() throws Exception{
Result= Groups.check_Edit_Group_with_new_Fence_Configuration();
Assert.assertEquals(Result, "ok");
}

//===================================================================================================================	
/**
* @author Lavina Jain
* This test case is to check Edit Group > Device Tab, by adding device to group
*	in MDM application.
* 
*/	
//@Test(priority = 15)
public void verify_Edit_Group_with_adding_device() throws Exception{
Result= Groups.check_Edit_Group_with_adding_device();
Assert.assertEquals(Result, "ok");
}

//===================================================================================================================	
/**
* @author Lavina Jain
* This test case is to check Edit Group > Group QR Code Tab, Check by Generating QR Code
*	in MDM application.
* 
*/	
@Test(priority = 16)
public void verify_Edit_Group_with_generating_QR_code() throws Exception{
Result= Groups.check_Edit_Group_with_generating_QR_code();
Assert.assertEquals(Result, "ok");
}

}