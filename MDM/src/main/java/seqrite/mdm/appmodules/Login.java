package seqrite.mdm.appmodules;
import org.testng.Assert;
import seqrite.mdm.utils.Setup;
import seqrite.mdm.utils.CommonUtils;
import seqrite.mdm.utils.ConfigReader;
import seqrite.mdm.utils.Log;
import seqrite.mdm.utils.ORReader;

/**
 * @author Siddhant.Raut
 * This class contains the test case for login functionality of mdm application
 * 
 */

public class Login extends Setup {

	static ORReader OR = new ORReader();
	static ConfigReader cr = new ConfigReader();
	
	/**
	 * @author Siddhant.Raut
	 * This method is will login to mdm application with valid user credentials
	 * 
	 */
	
	public static String valid_user_login() throws Throwable {
		try{
			OR.is_element_present("LOGIN_USERNAME").sendKeys(cr.getsu_username());
			OR.is_element_present("LOGIN_PASSWORD").sendKeys(cr.getsu_password());
			OR.is_element_present("LOGIN_BUTTON").click();
			
			Assert.assertEquals(driver.getTitle(), "Dashboard", "Dashboard title not matched");
			}
		catch (Throwable t){
		CommonUtils.takeScreenShot("valid_user_login");
			Log.info(t.getMessage());
			throw t;
			}
			return "ok";
	}
	
	/**
	 * @author Siddhant.Raut
	 * This method will try to login with invalid password
	 * 
	 */
	
	public static String invalid_user_login_password() throws Throwable {
		try{
			OR.is_element_present("LOGIN_USERNAME").sendKeys("qhqa01@gmail.com");
			OR.is_element_present("LOGIN_PASSWORD").sendKeys("Quick@1234");
			OR.is_element_present("LOGIN_BUTTON").click();
			String Error = OR.is_element_present("LOGIN_ERROR").getText();
			Assert.assertEquals(Error, "Please ;;;;;;enter valid Email and password.");
		}
		
		catch (Throwable t){
//			CommonUtils.takeScreenShot("invalid_user_login");
			Log.info(t.getMessage());
			throw t;
			
			}
			return "ok";
	}
	
	/**
	 * @author Siddhant.Raut
	 * This method will try to login with invalid username [username which is not exist in System]
	 * 
	 */
	
	public static String invalid_user_login_username() throws Throwable {
		try{
			OR.is_element_present("LOGIN_USERNAME").sendKeys("qhqa00@gmail.com");
			OR.is_element_present("LOGIN_PASSWORD").sendKeys("Quick@123");
			OR.is_element_present("LOGIN_BUTTON").click();
			String Error = OR.is_element_present("LOGIN_ERROR").getText();
			Assert.assertEquals(Error, "Please enter valid Email and password.");
		}
		
		catch (Throwable t){
			CommonUtils.takeScreenShot("invalid_user_login");
			Log.info(t.getMessage());
			throw t;
			
			}
			return "ok";
	}

}
