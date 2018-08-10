package seqrite.mdm.utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author siddhant.raut
 * This class is written to read configuration AUT from  property file
 */

public class ConfigReader {

	static Properties pro;

	public ConfigReader() {
		try {

			File config_src = new File("./Configuration/config.property");
			FileInputStream appconfig_fis = new FileInputStream(config_src);
			pro = new Properties();
			pro.load(appconfig_fis);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//----------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	public String getbrowser()
	{
		String browser= pro.getProperty("Browser");
		return browser;
	}
	
	public String getsu_username()
	{
		String su_username= pro.getProperty("SU_username");
		return su_username;
	}
	
	public String getsu_password()
	{
		String su_password= pro.getProperty("SU_password");
		return su_password;
	}
	
	public String getDB_URL_Tenant()
	{
		String DB_URL_Tenant= pro.getProperty("DB_URL_TENANT");
		return DB_URL_Tenant;
	}
	
	public String getDB_User()
	{
		String DB_User= pro.getProperty("DB_USER");
		return DB_User;
	}
	
	public String getDB_Password()
	{
		String DB_Password= pro.getProperty("DB_PASSWORD");
		return DB_Password;
	}
	
	public String getMDM_AutomationServer_url(){
		String MDM_AutomationServer_url=pro.getProperty("MDM_AutomationServer_url");
		return MDM_AutomationServer_url;
		
	}
	
	public String get_DB_URL_Global(){
		String DB_URL_Global=pro.getProperty("DB_URL_Global");
		return DB_URL_Global;
		
	}
	
}