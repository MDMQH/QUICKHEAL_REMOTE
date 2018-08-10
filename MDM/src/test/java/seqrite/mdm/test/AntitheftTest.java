package seqrite.mdm.test;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import seqrite.mdm.appmodules.Antitheft;
import seqrite.mdm.utils.Setup;
import seqrite.mdm.utils.TestNGListener;

/**
 * @author Swapnil.dravid This test class containse test cases for schedule scan configuration 
 *
 */
@Listeners(TestNGListener.class)
public class AntitheftTest extends Setup {

	String Result;

	/**
	 * @author Swapnil.dravid This test case to add antitheft configuration
	 * 
	 */
	@Test(priority=1)
	public void verify_Add_Antitheft() throws Throwable {
		Result = Antitheft.add_antitheft();
		Assert.assertEquals(Result, "ok");
	}
//===================================================================================================================
	
	@Test(priority=2)
	public void Apply_Antitheft_Configuration() throws Throwable {
		Result = Antitheft.apply_antitheftConfiguration();
		Assert.assertEquals(Result, "ok");
	}
	
	
//===================================================================================================================	
	/**
	 * @author Swapnil.dravid This test case to update antitheft configuration
	 * 
	
	
	@Test(priority=2)
	public void verify_Update_Antitheft() throws Exception {
		Result = Antitheft.update_antitheft();
		Assert.assertEquals(Result, "ok");
	}*/
//===================================================================================================================
	
	/**
	 * @author Swapnil.dravid This test case  is  to delete  the updated antitheft configuration
	 * 
	 
	
	@Test(priority=3)
	public void verify_Delete_Anitheft() throws Exception {
		Result = Antitheft.delete_anitheft();
		Assert.assertEquals(Result, "ok");

	}*/
	
	
}
