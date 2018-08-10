package seqrite.mdm.test;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import seqrite.mdm.appmodules.Login;
import seqrite.mdm.utils.Setup;
import seqrite.mdm.utils.TestNGListener;

/**
 * @author Siddhant.Raut
 * This class contains the test cases for login module
 */

@Listeners(TestNGListener.class)
public class LoginTest extends Setup {
	
	String Result;
	public ExtentReports extent;
	public ExtentTest extentTest;
	//==================================================================================================================================================
	/**
	 * @author Siddhant.Raut
	 * This method is will login to mdm application with valid user credentials
	 * 
	 */
	@Test(priority=1)
	
	public void verify_valid_user_login() throws Throwable {
		
		Result = Login.valid_user_login();
		Assert.assertEquals(Result,"ok");
		
	    
	
		}
//===================================================================================================================		
	/**
	 * @author Siddhant.Raut
	 * This method will try to login with invalid password
	 * 
	 */
	
	@Test(priority=2) 
	public void verify_invalid_user_login_password() throws Throwable {
		
		Result = Login.invalid_user_login_password();
		Assert.assertEquals(Result,"ok");
		
		}
//===================================================================================================================
	/**
	 * @author Siddhant.Raut
	 * This method will try to login with invalid username [username which is not exist in System]
	 * 
	 */
	
	@Test(priority=3)
	public void verify_invalid_user_login_username() throws Throwable {
		
		Result = Login.invalid_user_login_username();
		Assert.assertEquals(Result,"ok");
		
		}
//===================================================================================================================

	
	
	
	
	
	
	
	
	
	
	
	}