package seqrite.mdm.client.utils;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;

public class StartMDMClientApp {
	
	protected static AndroidDriver driver;
	
//	@Test
	public static void lauch_mdm_client() throws Throwable {

//		File classpathRoot = new File(System.getProperty("user.dir"));
//		File appDir = new File(classpathRoot, "/Resources");
//		File app = new File(appDir, "MDMclient13517.apk");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "Nexus4-020170418b084fb1");
		capabilities.setCapability("platformVersion", "5.1.1");
		capabilities.setCapability("platformName", "Android");
//		capabilities.setCapability("app", app.getAbsolutePath());
		capabilities.setCapability("appPackage", "com.seqrite.client");
		capabilities.setCapability("appActivity", ".components.activities.DashboardLauncher");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		System.out.println("Application Launch Successfully");
//		Thread.sleep(10000);
//		driver.quit();

	}
}
