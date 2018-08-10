package seqrite.mdm.utils;


import java.util.Date;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/**
 *  * @author Rajat Goyal
 *  
 *    This class implement Interface 'ITestListener' which is a listener for test running
 *    OnTestStart : Invoked each time before a test will be invoked.
* 	  OnTestSuccess : Invoked each time a test succeeds.
*	  OnTestFailure : Invoked each time a test fails
*	  We can implement any logic that you want to do when a test fails, Normally most of them prefer taking screen shots when a test fails.
*     Here in this method we can add a logic to take the screen shot and the name of the test as screenshot name.
*     OnTestSkipped : Invoked each time a test is skipped.
*     OnTestFinish : Invoked after all the tests have run and all their Configuration methods have been called.
*     
*     Edit- The listeners will keep an eye on the execution activity and return the result likewise
*     inside the extent reports.it will also attach the screenshot of the failed test cases on the extent report.
*     the extent report generated will have the name ExtentReport_MDM.html in test-output Folder
*/


public class TestNGListener extends Setup implements ITestListener, ISuiteListener {

	public static ExtentReports extent;
	public static ExtentTest extentTest;
	String screenshotPath;
	Date d=new Date();
	String fileName=d.toString().replace(":", "_").replace(" ", "_")+".html";
	
	// This belongs to ITestListener and will execute before the main test start (@Test)
	public void onTestStart(ITestResult result) {
		Log.info("==========================================");
		Log.info("TEST_CASE_START: "+ result.getName());
		Log.info("==========================================");
	    extentTest=extent.startTest(result.getName());
		
	}

	// This belongs to ITestListener and will execute only when the test is pass
	public void onTestSuccess(ITestResult result) {
		Log.info("==========================================");
		Log.info("RESULT: TEST_CASE_PASS "+ result.getName());
		Log.info("==========================================");
		Log.info("END_OF_TEST_CASE: "+ result.getName());
		Log.info("==========================================");
		extentTest.log(LogStatus.PASS, "Test Case PASSED IS " + result.getTestClass()+"_"+result.getName());	
	}

	// This belongs to ITestListener and will execute only on the event of fail test
	public void onTestFailure(ITestResult result) {
		
		Log.info("==========================================");
		Log.info("RESULT: TEST_CASE_FAILED "+ result.getName());
		//String methodName = result.getName().toString().trim();
		extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS "+ result.getTestClass()+"_"+result.getName()); //to add name in extent report
		extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS "+ result.getTestClass()+"_"+result.getThrowable()); //to add error/exception in extent report
		
		try {
			//CommonUtils.takeScreenShot(methodName);
		    String screenshotPath = ExtentManager.getScreenshot(driver,result.getName());
			extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath)); //to add screenshot in extent report
			} catch (Exception e) {
			Log.info("Failed to Capture Screenshot");
			e.printStackTrace();
			} 
		
		Log.info("==========================================");
		Log.info("END_OF_TEST_CASE: "+ result.getName());
		Log.info("==========================================");
		
	}

	// This belongs to ITestListener and will execute only if any of the main test(@Test) get skipped
	public void onTestSkipped(ITestResult result) {
		Log.info("Test Case Skipped "+ result.getName());
		Log.info("==========================================");
		Log.info("TEST_CASE_SKIPPED: "+ result.getName());
		Log.info("==========================================");
		extentTest.log(LogStatus.SKIP, "Test Case SKIPPED IS "+ result.getTestClass()+"_" +result.getName());
		
		}
  
	
	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}
	
	

	public void onStart(ITestContext context) {
		
		extent = new ExtentReports(System.getProperty("user.dir")+"/test-output/"+"MDM_Automation_Extent"+fileName, false);
		extent.addSystemInfo("Host Name", "Local");
		extent.addSystemInfo("User Name", "QuickHeal");
		extent.addSystemInfo("Environment", "QA");
		
	}

	public void onFinish(ITestContext context) {
		
		extent.flush();
		//extent.endTest(extentTest);
		//extent.close();
	
	}

	// This belongs to ISuiteListener and will execute before the Suite start
	public void onStart(ISuite suite) {
		Log.info("STARTING" +suite.getName());
		
	}
	
	// This belongs to ISuiteListener and will execute, once the Suite is finished
	public void onFinish(ISuite suite) {
		Log.info("END OF:" +suite.getName());
		//extent.endTest(extentTest);
		//extent.close();
		
	}

	
	
	
	
	
	





	
	
	
	
}
