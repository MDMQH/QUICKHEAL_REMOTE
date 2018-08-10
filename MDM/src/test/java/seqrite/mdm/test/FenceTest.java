/**
 * 
 */
package seqrite.mdm.test;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import seqrite.mdm.appmodules.Fences;
import seqrite.mdm.utils.Setup;
import seqrite.mdm.utils.TestNGListener;

/**
 * @author Poonam.Wani
 * This class contains the test case for Fence module
 */
@Listeners(TestNGListener.class)
public class FenceTest extends Setup{
	
	String Result;
	
	/**
	 * @author Poonam.Wani
	 * This test case will create the Wi-Fi Fence configuration.
	 * @throws Throwable 
	 * 
	 */
	@Test(priority=1)
	public void verify_Create_WiFi_Fence() throws Throwable{
		
		Result=Fences.check_Create_WiFi_Fence();
		Assert.assertEquals(Result,"ok");
	}
	
//===================================================================================================================
		
	
	/**
	 * @author Poonam.Wani
	 * This test case will create the Geo Fence configuration.
	 * 
	 */
	@Test(priority=2)
	public void verify_create_Geo_fence() throws Exception{
		
		Result=Fences.check_create_Geo_fence();
		Assert.assertEquals(Result,"ok");
	}
	
//===================================================================================================================
	
		/**
		 * @author Poonam.Wani
		 * This test case will update the Geo Fence configuration.
		 * 
		 */
		//@Test(priority=4)
		/*public void verify_Update_Geo_Fence() throws Exception{
			
			Result=Fences.check_Update_geo_Fence();
			Assert.assertEquals(Result,"ok");
		}*/
	
//===================================================================================================================
	/**
	 * @author Poonam.Wani
	 * This test case will create the Time Fence configuration.
	 * 
	 */
	@Test(priority=3)
	public void verify_create_Time_fence() throws Exception{
		
		Result=Fences.check_create_Time_fence();
		Assert.assertEquals(Result,"ok");
	}
	
//===================================================================================================================
		/**
		 * @author Poonam.Wani
		 * This test case will create Fence configuration.
		 * 
		 */
	
	@Test(priority=4)
	public void verify_create_fence_configuration() throws Exception{
		
		Result=Fences.check_create_fence_configuration();
		Assert.assertEquals(Result,"ok");
	}
	
//===================================================================================================================	
	/**
	 * @author Poonam.Wani
	 * This test case will update the Wi-Fi Fence configuration.
	 * 
	 */
	/*@Test(priority=4)
	public void verify_Update_WiFi_Fence() throws Exception{
		
		Result=Fences.check_Update_WiFi_Fence();
		Assert.assertEquals(Result,"ok");
	}*/
	
//===================================================================================================================

	@Test(priority=5)
	public void apply_fence_configuration() throws Throwable{
		
		Result=Fences.Apply_fence_configuration();
		Assert.assertEquals(Result,"ok");
	}
	
	
}
