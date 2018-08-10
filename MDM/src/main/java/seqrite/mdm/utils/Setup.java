package seqrite.mdm.utils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ISuite;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import seqrite.mdm.utils.CommonUtils;
import seqrite.mdm.utils.ConfigReader;
import seqrite.mdm.utils.Constants;
import seqrite.mdm.utils.Log;

public class Setup {
	
	/**
	 * @author siddhant.raut
	 * This class contains the SetUp methods  
	 */	

 public static ConfigReader cr = new ConfigReader();
 public static WebDriver driver;
 public static String browser=cr.getbrowser();
 public static String MDM_url=cr.getMDM_AutomationServer_url();
 static ITestContext context;
 static ISuite suite;

 public static ExtentReports extent;
 public static ExtentTest extentTest;
 //===================================================================================================================================
 	/**
	 * @author siddhant.raut
	 * This method is used to Setup browser and initialize driver  
	 * */	 
 
	public static void BrowserSetup(String browser)
	{
		if(browser.equals("Firefox"))
		{	
			Log.info("Loading Firefox Driver");
			System.setProperty(Constants.FirefoxDriver_Key, Constants.FirefoxDriver_Path);
			Log.info("FireFox Browser Loaded, Initilizing Firefox Browser");
			driver= new FirefoxDriver();
			CommonUtils.maximize_browser_window(driver);
			Log.info("Firefox Browser Launch Successfully");
		}
		
		else if(browser.equals("Chrome"))
		{
			Log.info("Loading Chrome Driver");
			System.setProperty(Constants.ChromeDriver_key, Constants.ChromeDriver_Path);
			Log.info("Chrome Browser Loaded, Initializing Chrome Browser" );
			driver= new ChromeDriver();
			CommonUtils.maximize_browser_window(driver);
			Log.info("Chrome Browser Launch Successfully");
			
	    	driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		}
	}
// ====================================================================================================================================
	@BeforeSuite
	public static void loading_configurations() {
		try {
			DOMConfigurator.configure("Configuration\\log4j.xml");
			Log.info("----------------------------------------------------------");
			Log.info("Test Suit Name: Default Suit");
			Log.info("----------------------------------------------------------");
			Log.info("Providing Log4j configuration settings");
		} catch (Exception e) {
			System.out.println("Error in loading loding log4j.xml file");
		}
	}

	
	
	
	//======================================================================================
	
	@BeforeMethod
	public static void LaunchApp() throws InterruptedException {

		Log.info("Initializing Application Setup");
		BrowserSetup(browser);
		System.out.println(MDM_url);
		driver.get(MDM_url);
		Log.info("Application URL Found \t" + Constants.MDM_AutomationServer_url);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Log.info("Waiting for all the elements to appear");
		Thread.sleep(2000);
	}
//==========================================================================================
	@AfterMethod()
	public void CloseApp(ITestResult result) throws Exception {
		Log.info("Closing Application");
		driver.quit();
	}
		
//=============================================================================================	
	
	@AfterSuite
	public void end_of_test_suit() throws IOException {
		CommonUtils.execute_batch();
		Log.info("I am in after suite, Batch file executed successfully");
	}

//=====================================================================================================================================

	
	
	
	
	
	
	
	
}	

