/**
 * 
 */
package seqrite.mdm.test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import seqrite.mdm.appmodules.Networkconfig;

import seqrite.mdm.utils.Setup;
import seqrite.mdm.utils.TestNGListener;



@Listeners(TestNGListener.class)
public class NetworkconfigTest extends Setup{
	
		String Result;
		
//==================================================================================================================================================
	
		@Test(priority=1)
		public  void verify_Create_Networkconfig() throws Exception
		{
			String Result= Networkconfig.verify_Create_Networkconfig();
			Assert.assertEquals(Result, "ok");
		}
	
//==================================================================================================================================================
		
		
		@Test(priority=2)
		public  void verify_apply_Networkconfig() throws Throwable
		{
			String Result= Networkconfig.verify_apply_Networkconfig();
			Assert.assertEquals(Result, "ok");
		}
		
		
//==================================================================================================================================================

}
