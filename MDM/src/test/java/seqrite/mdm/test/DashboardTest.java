/**
 * 
 */
package seqrite.mdm.test;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import seqrite.mdm.appmodules.Dashboard;
import seqrite.mdm.utils.MDM;
import seqrite.mdm.utils.Setup;
import seqrite.mdm.utils.TestNGListener;

/**
 * @author Siddhant.Raut
 * This class contains the test cases for Dashboard with verification from database.
 *
 */

@Listeners(TestNGListener.class)
public class DashboardTest extends Setup{
	
	String Result;
	
	/**
	 * @author Siddhant.Raut
	 * This method will check the  all MDM menus from left Panel
	 */

		@Test(priority=1)
		public void verify_Mdm_Modules() throws Throwable {
		Result = Dashboard.check_Mdm_Modules();
		Assert.assertEquals(Result,"ok");
		}
//===================================================================================================================
	/**
	 * @author Shital kumbhar  
	 * This method will check the number of days remaining to license expiry 
	 *  and verify from Database
	 */
	
	@Test(priority=2)
	public void  verify_Expiry_Days() throws Throwable {
		Result = Dashboard.validate_Expiry_Days();
		Assert.assertEquals(Result,"ok");
		}
	
//===================================================================================================================
	/**
	 * @author Shital kumbhar  
	 * This method will check the total devices count on dashboard
	 * and verify from Database
	 */
	
	@Test(priority=3)
	public void verify_Device_Count() throws Throwable {
		Result = Dashboard.validate_Device_Count();
		Assert.assertEquals(Result,"ok");
		}
	
//===================================================================================================================	
	/**
	 * @author Shital kumbhar  
	 * This method will check the total number of rooted device count enrolled in mdm
	 * and verify from Database
	 */
	
	@Test(priority=4)
	public void validate_Rooted_Devices_Count() throws Throwable {
		Result = Dashboard.validate_Rooted_DevicesCount();
		Assert.assertEquals(Result,"ok");
		}
	
//===================================================================================================================
	/**
	 * @author Shital kumbhar  
	 * This method will check the total number of uninstallation unsecure count
	 * and verify from Database
	 */
	
	@Test(priority=5)
	public void verify_Uninstallation_Unsecure_Devices_Count() throws Throwable {
		Result = Dashboard.validate_Uninstallation_Unsecure_Devices_Count();
		Assert.assertEquals(Result,"ok");
		}
//===================================================================================================================
	/**
	 * @author Shital kumbhar  
	 * This method will check the total number of blocked devices count
	 * and verify from Database
	 */
	
	@Test(priority=6)
	public void verify_Blocked_Devices_Count() throws Throwable {
		Result = Dashboard.validate_Blocked_devices_Count();
		Assert.assertEquals(Result,"ok");
		}

//===================================================================================================================
	/**
	 * @author Siddhant.Raut This method will check the total number of blocked
	 *         devices count and verify from Database
	 */

	 @Test(priority=7)
	public void verify_Dashboard_Views() throws Throwable {
		Result = Dashboard.check_dashboard_views();
		Assert.assertEquals(Result, "ok");
	}
//===================================================================================================================
	/**
	 * @author Siddhant.Raut This method will check donuts and click to verify
	 *         redirection from dashboard to different device status and
	 *         voilation status, and device connected sience and verify from
	 *         Database
	 */

	@Test(priority=8)
	public void verify_Enrollment_Status_Donut() throws Throwable {
		Result = Dashboard.enrollment_Status();
		Assert.assertEquals(Result, "ok");
	}
	
}
