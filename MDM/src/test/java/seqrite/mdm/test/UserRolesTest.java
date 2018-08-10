/**
 * 
 */
package seqrite.mdm.test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

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
	
	@Test
	public void verify_create_userrole() throws Exception{
		Result=UserRoles.create_user_role();
		Assert.assertEquals(Result, "ok");
		
//=========================================================================================================		
	}

}
