/**
 * 
 */
package seqrite.mdm.appmodules;

import org.testng.Assert;

import seqrite.mdm.utils.MDM;
import seqrite.mdm.utils.ORReader;

/**
 * @author siddhant.raut
 *
 */
public class Groups {

	static ORReader OR = new ORReader();
	
	public static String verify_create_group() throws Exception{
		MDM.login();
		MDM.gotoGroups();
		OR.is_element_present("ADD_DEVICEGROUP_BUTTON").click();
		OR.is_element_present("DEVICEGROUPS_NAME_TEXTFIELD").sendKeys("Automation Device Group I");
		OR.is_element_present("GROUP_DESCRIPTION_TEXTFIELD").sendKeys("Automation Group Description");
		OR.is_element_present("GROUP_SAVE_BUTTON").click();
		OR.is_element_present("OK_BUTTON").click();
		String GroupName= OR.is_element_present("GROUP_NAME_LABEL").getText();
		Assert.assertEquals(GroupName, "Automation Device Group I");
		return "ok";
	}
}
