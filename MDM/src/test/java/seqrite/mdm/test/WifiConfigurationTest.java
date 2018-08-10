/**
 * 
 */
package seqrite.mdm.test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import seqrite.mdm.appmodules.WifiConfiguration;
import seqrite.mdm.utils.Setup;
import seqrite.mdm.utils.TestNGListener;

/**
 * @author Omkar.Naik
 *
 */

@Listeners(TestNGListener.class)
public class WifiConfigurationTest extends Setup{
	
		String Result;
		
//==================================================================================================================================================
	@Test(priority=1)
		public  void verify_Create_WifiConfiguration() throws Exception
		{
			String Result=WifiConfiguration.verify_Create_WifiConfiguration();
			Assert.assertEquals(Result, "ok");
		}
		
//==================================================================================================================================================
		@Test(priority=2)
		public void apply_WifiConfiguration() throws Throwable
		{
					
				Result = WifiConfiguration.apply_WifiConfiguration();
				Assert.assertEquals(Result, "ok");
						
		}
		
		
		
//==================================================================================================================================================

}
