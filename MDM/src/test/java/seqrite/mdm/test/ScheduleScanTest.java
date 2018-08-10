/**
 * 
 */
package seqrite.mdm.test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import seqrite.mdm.appmodules.ScheduleScan;
import seqrite.mdm.utils.Setup;
import seqrite.mdm.utils.TestNGListener;

/**
 * @author Swapnil.Dravid
 *
 */
@Listeners(TestNGListener.class)
public class ScheduleScanTest extends Setup {
	String Result;

	/**
	 * @author Swapnil.dravid This test case is to add schedule scan
	 *         configuration
	 *
	 */

	 @Test(priority = 1)
	public void verify_add_ScheduleScan() throws Exception

	{
		Result = ScheduleScan.add_schedule_scan();
		Assert.assertEquals(Result, "ok");

	}

	 //=====================================================================================================================
	/*
	 * @author Omkar Naik
	 * */
	 
	 @Test(priority = 2)
		public void apply_ScheduleScan() throws Throwable

		{
			Result = ScheduleScan.apply_schedule_scan();
			Assert.assertEquals(Result, "ok");

		}
	 
	 
	 
	// ==========================================================================================================================
	/**
	 * @author Swapnil.dravid This test case is to update the schedule scan
	 *         configuration
	 * @throws Exception
	 *
	 */

	/* @Test(priority = 2)
	public void verify_update_scheduleScan() throws Exception {

		Result = ScheduleScan.update_schedule_scan();
		Assert.assertEquals(Result, "ok");

	}*/

	// =============================================================================================================================
	/**
	 * @author Swapnil.dravid This test case is to delete the schedule scan
	 *         configuration
	 * @throws Exception
	 *
	 */
	/*@Test(priority = 3)
	public void verify_delete_ScheduleScan() throws Exception {
		Result = ScheduleScan.delete_Schedule_Scan();
		Assert.assertEquals(Result, "ok");

	}*/

}
