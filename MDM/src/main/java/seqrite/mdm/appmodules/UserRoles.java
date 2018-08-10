/**
 * 
 */
package seqrite.mdm.appmodules;

//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import seqrite.mdm.utils.Log;
import seqrite.mdm.utils.MDM;
import seqrite.mdm.utils.ORReader;
import seqrite.mdm.utils.Setup;

/**
 * @author siddhant.raut
 *
 */
public class UserRoles extends Setup {
	
//	static WebDriver driver;
	static ORReader OR = new ORReader();
	
//===========================================================================================
	public static String create_user_role() throws Exception{
		MDM.login();
		MDM.gotoUserRole();
		OR.is_element_present("ADD_USERROLE_BUTTON").click();
		OR.is_element_present("USERROLENAME_TEXTFIELD").sendKeys("Automation User");
		OR.is_element_present("DROPDOWN_SELECT_USERROLES").click();
		OR.selectValueFromDropdown("DROPDOWN_LIST_USERROLES", "Basic");
//		WebElement ele = OR.is_element_present("SAVE_USERROLE_BUTTON");
//		Thread.sleep(2000);
//		Actions actions = new Actions(driver);
//		actions.moveToElement(ele).click().perform();
//		OR.is_element_present("SAVE_USERROLE_BUTTON").click();
		Log.info("waiting for clicking emement");
		Thread.sleep(5000);
		OR.clickOnElement("SAVE_USERROLE_BUTTON");
		
		
		return "ok";
	}
//===========================================================================================	
}
