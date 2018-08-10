/**
 * 
 */
package seqrite.mdm.test;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import seqrite.mdm.appmodules.Policies;
import seqrite.mdm.utils.Setup;
import seqrite.mdm.utils.TestNGListener;

/**
 * @author Siddhant.Raut
 *
 */

@Listeners(TestNGListener.class)
public class PoliciesTest extends Setup {
	
	String Result;
	
//==================================================================================================================================================
	
	/**
	 * @author Siddhant.Raut
	 * This test verify the create policy functionality
	 */
	
	@Test(priority=1)
	public  void verify_create_policy() throws Exception
	{
		String Result=Policies.verify_create_policy();
		Assert.assertEquals(Result, "ok");
	}
	
//=================================================================================================================================================

	/*
	 * Omkar Naik
	 * */
	
	
	@Test(priority=2)
	public  void apply_policy() throws Throwable
	{
		String Result=Policies.verify_apply_policy();
		Assert.assertEquals(Result, "ok");
	}
	
	
	
}

