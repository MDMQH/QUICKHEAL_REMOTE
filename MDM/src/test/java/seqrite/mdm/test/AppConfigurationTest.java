/**
 * 
 */
package seqrite.mdm.test;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import seqrite.mdm.appmodules.AppConfiguration;
import seqrite.mdm.utils.Setup;
import seqrite.mdm.utils.TestNGListener;

/**
 * @author siddhant.raut
 * 
 *
 */

@Listeners(TestNGListener.class)
public class AppConfigurationTest extends Setup {
	
	String Result;
	
	@Test(priority=1)
	public void verify_Add_App_Configuration() throws Exception{
	Result = AppConfiguration.add_App_Configration();
	Assert.assertEquals(Result, "ok");
	}
//===================================================================================================================
	/*
	 * @author Omkar Naik
	 * */
	
	@Test(priority=2)
	public void verify_Apply_App_Configuration() throws Throwable{
	Result = AppConfiguration.apply_App_Configration();
	Assert.assertEquals(Result, "ok");
	} 
//==================================================================================================================
	/*
	 * @author Omkar Naik
	 * */
	
	@Test(priority=3)
	public void verify_apply_Launcher_Configration() throws Throwable{
	Result = AppConfiguration.apply_Launcher_Configration();
	Assert.assertEquals(Result, "ok");
	}
	
	
	
//===================================================================================================================	
	/*@Test(priority=2)
	public void verify_Update_App_Configuration() throws Exception{
	Result = AppConfiguration.update_App_Configuration();
	Assert.assertEquals(Result, "ok");
	}*/
//===================================================================================================================	
	/*@Test(priority=3)
	public void verify_Delete_App_Configuration() throws Exception{
	Result = AppConfiguration.delete_App_Configuration();
	Assert.assertEquals(Result, "ok");
	}*/
//===================================================================================================================
}
