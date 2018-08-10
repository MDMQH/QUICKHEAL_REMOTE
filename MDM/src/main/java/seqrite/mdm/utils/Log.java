package seqrite.mdm.utils;
import org.apache.log4j.Logger;


/**
 * This class contains methods for write logs in test of different levels All, fatal,debug,error,info,warning
 * also method to print log format staring with method name and end of method.
 * @author Shital.kumbhar
 *
 */
public class Log {

	// Initialize Log4j logs

	private static Logger Log = Logger.getLogger(Log.class.getName());
	 

	/**
	 * This is to print log for the beginning of the test case, as we usually
	 * run so many test cases as a test suite
	 * @author Shital.kumbhar
	 */
	
	public static void startTestCase(String TestCaseName) {

		Log.info("------------------------------------------");
		Log.info("EXECUTING  TEST CASE-->\t" +TestCaseName);
		Log.info("------------------------------------------");
	}
	
	/**
	 * This is to print log for the ending of the test case
	 * @author Shital.kumbhar
	 */

	public static void endTestCase(String TestCaseName) {
		Log.info("------------------------------------------");
		Log.info("END  OF TEST CASE-->\t"+ TestCaseName);
		Log.info("------------------------------------------");
	}

	// Need to create these methods, so that they can be called

	public static void info(String message) {
		Log.info(message);
	}

	public static void warn(String message) {
		Log.warn(message);
	}

	public static void error(String message) {
		Log.error(message);
	}

	public static void fatal(String message) {
		Log.fatal(message);
	}

	public static void debug(String message) {
		Log.debug(message);
	}
}