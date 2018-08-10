/**
 * 
 */
package seqrite.mdm.test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import seqrite.mdm.appmodules.Groups;
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
	 *  This test case is to add group & verify
	 */

	@Test(priority = 1)
	public void verify_add_group() throws Exception
	{
		Result = Groups.verify_create_group();
		Assert.assertEquals(Result, "ok");
	}
	
//===============================================================================================================
	

	
	
	
	
	
	
}
