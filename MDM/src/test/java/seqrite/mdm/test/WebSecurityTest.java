/**
 * 
 */
package seqrite.mdm.test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import seqrite.mdm.appmodules.WebSecurity;
import seqrite.mdm.appmodules.WifiConfiguration;
import seqrite.mdm.utils.Setup;
import seqrite.mdm.utils.TestNGListener;

/**
 * @author Siddhant.Raut
 *
 */

@Listeners(TestNGListener.class)
public class WebSecurityTest extends Setup{
	
		String Result;
		
//==================================================================================================================================================
		@Test(priority=1)
		public  void verify_Create_WebSecurity() throws Exception
		{
			String Result=WebSecurity.verify_Create_WebSecurity();
			Assert.assertEquals(Result, "ok");
		}
		
//==================================================================================================================================================
		@Test(priority=2)
		public void apply_Configuration() throws Throwable
		{
			Result = WebSecurity.apply_WebConfiguration();
				Assert.assertEquals(Result, "ok");
			
		}
		
		
		
//==================================================================================================================================================

}
