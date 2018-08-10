package seqrite.mdm.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;

public class ExtentManager extends Setup {
	/*
	 * @Author- Rajat Goyal
	 * This method is used to take the screenshot and save it on the folder TakeScreenshot
	 * But this method will only be called when our test case get failed
	 * 
	 */
	
	private static ExtentReports extent;
	
	public static String getScreenshot(WebDriver driver, String screenshotName) throws Exception{
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		// after execution, you could see a folder "FailedTestsScreenshots"
		// under src folder
		String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/" + screenshotName + dateName
				+ ".png";
		File finalDestination = new File(destination);
		try {
		FileUtils.copyFile(source, finalDestination);
		}catch(IOException e) {
			
			System.out.println("Could not capture the screenshot");
			e.printStackTrace();
			
		}
		return destination;
	}

	
	
}
	
	
	
	
	
	
	



    
	
	
	
	

	
	
	












