package seqrite.mdm.utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

	/**
	 * @author siddhant.raut This class is written to read objects from object
	 *         repository
	 */

 public class ORReader extends Setup {

	static Properties OR;
	static WebElement element;
	By lo;

	/**
	 * @author siddhant.raut To retrieve objects from our newly created
	 *         ORReader, we will define an ORReader with a constructor.
	 */

 public ORReader() {
		try {
			File OR_src = new File("./Configuration/object_repo.property");

			FileInputStream OR_fis = new FileInputStream(OR_src);
			OR = new Properties();
			try {
				OR.load(OR_fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

 
	/**
	 * @author siddhant.raut This method returns a By object
	 *         that is used by the Selenium browser driver object
	 */
 
	public By getlocator(String strElement) throws Exception {
		String locator = OR.getProperty(strElement);
		
		String locatorType = locator.split(":")[0];
		String locatorValue = locator.split(":")[1];

		// for testing and debugging purposes
		Log.info("Retrieving object " +strElement  +" type '" +locatorType + "' & value '" + locatorValue	+ "' from OR");

		// return a instance of the By class based on the type of the locator
		// this By can be used by the browser object in the actual test
			
		if (locatorType.toLowerCase().equals("id"))
			return By.id(locatorValue);
		else if (locatorType.toLowerCase().equals("name"))
			return By.name(locatorValue);
		else if ((locatorType.toLowerCase().equals("classname")) || (locatorType.toLowerCase().equals("class")))
			return By.className(locatorValue);
		else if ((locatorType.toLowerCase().equals("tagname")) || (locatorType.toLowerCase().equals("tag")))
			return By.className(locatorValue);
		else if ((locatorType.toLowerCase().equals("linktext")) || (locatorType.toLowerCase().equals("link")))
			return By.linkText(locatorValue);
		else if (locatorType.toLowerCase().equals("partiallinktext"))
			return By.partialLinkText(locatorValue);
		else if ((locatorType.toLowerCase().equals("cssselector")) || (locatorType.toLowerCase().equals("css")))
			return By.cssSelector(locatorValue);
		else if (locatorType.toLowerCase().equals("xpath"))
			return By.xpath(locatorValue);
		else
			throw new Exception("Unknown locator type '" + locatorType + "'");
	}
	

	/**
	 * @author siddhant.raut This method (is_element_present), which returns a WebElement
	 *         by verifying is element is enabled & is element display
	 * @throws Exception 
	 */

	public WebElement is_element_present(String strElement) throws Exception {

		By locator = getlocator(strElement);
		try {

			// Implicit wait implicit wait is to tell WebDriver to poll the DOM
			// for a certain amount of time when trying to find an element
			// or elements if they are not immediately available.
			
//			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			WebDriverWait wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.elementToBeClickable(locator));
			
			element = driver.findElement(locator);
			Log.info(strElement + " Element is found");
			

		} catch (NoSuchElementException e) {

			Log.info(strElement + " Element is not found");
			throw e;
		}

		Boolean isEnabled = element.isEnabled();
		Boolean isDisplayed = element.isDisplayed();

		if (isEnabled) {
			// Log.info(strElement + " Element is Enabled");
			Log.debug(strElement + " Element is Enabled");

		} else {
			Log.info(strElement + " Element is not Enabled");
		}

		if (isDisplayed) {
			// Log.info(strElement + " Element is Displayed");
			Log.debug(strElement + " Element is Displayed");

		} else {
			Log.info(strElement + " Element is not Displayed");
		}
		return element;
	}
	
//==========================================Select Value From Dropdown=============================================================
	/**
	 * @author siddhant.raut This method will select the element dropdown value
	 *         To use this method pass the String ddlist [dropdown list Object &
	 *         ddVlaue [dropdown value] to be select]
	 * @throws Exception
	 */

	public void selectValueFromDropdown(String ddList, String ddValue) throws Exception {

		List<WebElement> dropdown_list = null;

		Log.info("Dropdown Value to select is" + ddValue);

		By locator = getlocator(ddList);

		try {

			dropdown_list = driver.findElements(locator);
		}

		catch (NoSuchElementException e) {

			Log.info(ddList + " Element is not found");
			throw e;
		}

		Log.info("Number of Values in dropdown list is: " +dropdown_list.size());

		for (int i = 0; i < dropdown_list.size(); i++) {

			WebElement element = dropdown_list.get(i);
			
			// for Ref: http://stackoverflow.com/questions/10370204/how-can-get-the-text-of-a-div-tag-using-only-javascript-no-jquery
			//String textContent = element.getAttribute("textContent");
			String textContent = element.getText();
			if (textContent.contentEquals(ddValue)) {

				element.click();
				Log.info("Clicked On Dropdown Element" +textContent);
				break;
			}

			Log.info("Values from dropdown is: " +textContent);
		}
		 
//			for (int i = 0; i < dropdown_list.size(); i++) { 
//				System.out.println(dropdown_list.get(i).getText());
//				if(dropdown_list.get(i).getText().contains(ddValue))
//				{
//					dropdown_list.get(i).click();
//					break;
//				} 
//			}
						
			Log.info("Values from dropdown is: " +ddValue);

	}
	
//====================================================================================================================================
	/**
	 * @author siddhant.raut 
	 * 	This method will find multiple objects on and will click on all located objects.
	 *  
	 */
	public void selectCheckBox(String checkbox) throws Exception{

		List<WebElement> apps= null; 
		By locator= getlocator(checkbox);

			try{
				
				apps= driver.findElements(locator);
				
			    }
			
		catch (NoSuchElementException e) {

			Log.info(checkbox + " Element is not found");
			throw e;
		}
		
		int noOfCheckBoxes= apps.size();
		System.out.println(noOfCheckBoxes);
	
		for(int i=0; i<noOfCheckBoxes; i++)
		{
			WebElement element= apps.get(i);
			element.click();
//			Thread.sleep(100);
			String textContent=element.getAttribute("textContent");
			Log.info("CheckBox: " +textContent );
		}
	}
//===================================================================================================================================
	/**
	 * @author siddhant.raut 
	 * 	This method identifies the element on the page and perform the click action.
	 */
	
	public void clickOnElement(String strElement) throws Exception{
		
		element=is_element_present(strElement);
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().perform();

	}
//===================================================================================================================================

	
	public String[] selectdevicestatusKey(String stsNameKey) throws Exception{		
		List<WebElement> status_list = null;

	

	By locator = getlocator(stsNameKey);

	try {

			status_list = driver.findElements(locator);
		}

		catch (NoSuchElementException e) {

			Log.info(stsNameKey + " Element is not found");
			throw e;
		}

	Log.info("Number of Values to be verified on devices screen is: " +status_list.size());
	    WebElement element;
		String textContent = null;
		String keydata[]=new String[status_list.size()];
		
		
		for (int i = 0; i < status_list.size(); i++) {

			element = status_list.get(i);
			textContent = element.getText();
			//textContent = element.getAttribute("textContent");
			//Log.info("Values in textcontent : " +textContent);
		
				keydata[i]=textContent;	
			
	}
	
		return keydata;
		
		
		
	}
	
	
	
	
	//==================================================================================================
	
	public String[] selectdevicestatusValue(String stsNameVal) throws Exception{		
		List<WebElement> status_list = null;

	

	By locator = getlocator(stsNameVal);

	try {

			status_list = driver.findElements(locator);
		}

		catch (NoSuchElementException e) {

			Log.info(stsNameVal + " Element is not found");
			throw e;
		}

	Log.info("Number of Values to be verified on devices screen is: " +status_list.size());
	    WebElement element;
		String textContent = null;
		String valuedata[]=new String[status_list.size()];
		
		
		for (int i = 0; i < status_list.size(); i++) {

			element = status_list.get(i);
			textContent = element.getText();
			//textContent = element.getAttribute("textContent");
			//Log.info("Values in textcontent : " +textContent);
		
				valuedata[i]=textContent;	
			
	}
	
		return valuedata;
		
		
		
	}
    
	
//========================================================================================
	


	public String toString(String string) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//===================================================================================================================================
			/**
			 * @author Lavina jain 
			 * 	This method identifies the element on the page and perform the click action.
			 */
			
			public void hoverOnElement(String strElement) throws Exception{
				
				element=is_element_present(strElement);
				Actions actions = new Actions(driver);
				actions.moveToElement(element).build().perform();

			}
	
	
	
	
}
