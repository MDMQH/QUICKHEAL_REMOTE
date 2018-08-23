/**
 * 
 */
package seqrite.mdm.test;
import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

import seqrite.mdm.appmodules.Devices;
import seqrite.mdm.utils.ExtentManager;
import seqrite.mdm.utils.Setup;
import seqrite.mdm.utils.TestNGListener;

/**
 * @author Siddhant.Raut
 * This class having test cases for device module for console UI and device side
 */

@Listeners(TestNGListener.class)
public class DevicesTest extends Setup {
	
	static String Result;
//====================================================================================================
	/**
	 * @author Siddhant.Raut
	 * This test veify add device to mdm
	 */
    //@Test(priority = 1)
	public void verify_Add_Device() throws Throwable {
    	
		Result = Devices.add_device();
		Assert.assertEquals(Result, "ok");
	}
//====================================================================================================
	/**
	 * @author Siddhant.Raut
	 *  This test case cover end to end to test case execution for rind command
	 */
	
	//@Test(priority = 2)
	public static void verify_ringcommands_on_device() throws Throwable {
		
     	Result = Devices.verify_ringcommands_on_device();
		Assert.assertEquals(Result, "ok");
	}
//====================================================================================================

	//@Test(priority = 3)
	public static void verify_synccommand_on_device() throws Throwable {
		Result = Devices.verify_Synccommand_on_device();
		Assert.assertEquals(Result, "ok");
	}
	//====================================================================================================
	
//	//  @Test(priority=4)
//	    public static void verify_device_details() throws Throwable {
//	    Result= Devices.device_details_success();
//		Assert.assertEquals(Result, "ok");
	
//      }

	//==================================================================================================
	
	   //@Test(priority=5)
		public static void verify_device_list_enroll_via_sms() throws Throwable {
			
			Result= Devices.device_list_enroll_via_sms();
			Assert.assertEquals(Result, "ok");	
	       }
	
	//===================================================================================================
	
		//@Test(priority=6)
		public static void verify_device_list_enroll_via_QR_code() throws Throwable {
			Result= Devices.device_list_enroll_via_QR_code();
			Assert.assertEquals(Result, "ok");	
	       }
	

	//===================================================================================================
		
		//@Test(priority=7)
		public static void verify_device_list_enroll_with_ADO() throws Throwable {
	    Result= Devices.device_list_enroll_with_ADO();
		Assert.assertEquals(Result, "ok");	
	    
		}
		
	//=================================================================================================	
		
		/**
		 * @author Lavina Jain
		 *  This test case verifies device_details on overview page
		 */
		//@Test(priority=8)
		public static void verify_device_details() throws Throwable {
			
			Result= Devices.check_device_details_success();
			Assert.assertEquals(Result, "ok");
		}


	//====================================================================================================
		/**
		 * @author Lavina Jain
		 *  This test case verifies by editing Device Details as Name, group,owner
		 */
		//@Test(priority=9)
		   public static void verify_edit_device_details() throws Exception {
			Result= Devices.check_edit_device_details();
			Assert.assertEquals(Result, "ok");
		}
		
		//====================================================================================================
			/**
			 * @author Lavina Jain
			 *  This test case verifies by assigning Configuration to the device from Edit Device and check assigned configuration saved.
			 * @throws Throwable 

			 */
			//@Test(priority=10)
			public static void verify_assign_Configuration_device() throws Throwable {
				
				Result= Devices.check_assign_Configuration_device();
				Assert.assertEquals(Result, "ok");
			}
			//====================================================================================================
			/**
			 * @author Lavina Jain
			 *  This test case verifies by Device App Inventory tab ,Check simple search functionality for an app
			 * @throws Exception 
			 */
			//@Test(priority=11)
			public static void verify_simple_search_app() throws Exception {
				
				Result= Devices.check_simple_search_app();
				Assert.assertEquals(Result, "ok");
			}
			
			//====================================================================================================
			/**
			 * @author Lavina Jain
			 *  This test case verifies by Device App Inventory tab ,Check advance search functionality for an app

			 * @throws Exception 
			 */
		//	@Test(priority=12)
			public static void verify_advance_search_app() throws Exception {
				
				Result= Devices.check_advance_search_app();
				Assert.assertEquals(Result, "ok");
			}		
			
			//====================================================================================================
			/**
			 * @author Lavina Jain
			 *  This test case verifies by Device Location Tab, Check by sending Locate Command and verify its status 
			 *  in Activity Tab.
			 * @throws Throwable 
			 */
			//@Test(priority=13)
			public static void verify_device_location() throws Throwable {
				
				Result= Devices.check_device_location();
				Assert.assertEquals(Result, "ok");
			}
			
	//====================================================================================================
			/**
			 * @author Lavina Jain
			 *  This test case  Check by sending Trace ON Command on Device Location Tab, and verify it status
			 *   in Activity Tab.

			 * @throws Throwable 
			 */
			//@Test(priority=14)
			public static void verify_device_trace_on() throws Throwable {
				
				Result= Devices.check_device_trace_on();
				Assert.assertEquals(Result, "ok");
			}
			
			//====================================================================================================
			/**
			 * @author Lavina Jain
			 *  This test case verifies Data Plan Details on Network Configuration Tab of Device
			 * @throws Throwable 
			 */
			//@Test(priority=15)
			public static void verify_data_plan_details() throws Throwable {
				
				Result= Devices.check_data_plan_details();
				Assert.assertEquals(Result, "ok");
			}
			
			//====================================================================================================
			/**
			 * @author Lavina Jain
			 *  This test case verifies Simple Search On Device list Page

			 * @throws Exception 
			 */
			//@Test(priority=16)
			public static void verify_simple_search_device() throws Exception {
				
				Result= Devices.check_simple_search_device();
				Assert.assertEquals(Result, "ok");
			}
	
			//====================================================================================================
			/**
			 * @author Lavina Jain
			 *  This test case verifies advanced Search On Device list Page

			 * @throws Exception 
			 */
			//@Test(priority=17)
			public static void verify_advance_search_device() throws Exception {
				
				Result= Devices.check_advance_search_device();
				Assert.assertEquals(Result, "ok");
			}	
		
		
		//====================================================================================================
			
			//@Test(priority=18)
			public static void verify_check_app_inventory_app_block()throws Throwable{
			Result=Devices.check_app_inventory_app_block();
			Assert.assertEquals(Result, "ok");
				
				}
			
       //====================================================================================================
			
			//@Test(priority=19)
			public static void verify_check_app_inventory_app_whitelist()throws Throwable{
			Result=Devices.check_app_inventory_app_whitelist();
			Assert.assertEquals(Result, "ok");
				
				}
	//==========================================================================================================
			//@Test(priority=20)
			public static void verify_check_app_inventory_app_uninstall()throws Throwable{
			Result=Devices.check_app_inventory_app_uninstall();
			Assert.assertEquals(Result, "ok");
				
				}
			
	//==========================================================================================================
			//@Test(priority=21)
			public static void verify_check_add_app()throws Throwable{
			Result=Devices.check_add_app();
			Assert.assertEquals(Result, "ok");
				
				}		
	
   //==========================================================================================================
			//@Test(priority=22)
			public static void verify_check_add_app_custom_url()throws Throwable{
			Result=Devices.check_add_app_custom_url();
			Assert.assertEquals(Result, "ok");
				
			}		
	
  //==========================================================================================================
			//@Test(priority=23)
			public static void verify_check_add_app_custom_upload_apk()throws Throwable{
			Result=Devices.check_add_app_custom_upload_apk();
			Assert.assertEquals(Result, "ok");
				
			}			
			
 //==========================================================================================================
			//@Test(priority=24)
			public static void verify_check_add_app_repository()throws Throwable{
			Result=Devices.check_add_app_repository();
			Assert.assertEquals(Result, "ok");
				
			}
			
			
//==========================================================================================================
			//@Test(priority=25)
			public static void verify_check_enabling_call_sms()throws Throwable{
			Result=Devices.check_enabling_call_sms();
			Assert.assertEquals(Result, "ok");
				
			}		
			
//==========================================================================================================
			//@Test(priority=26)
			public static void verify_check_device_action_sync()throws Throwable{
			Result=Devices.check_device_action_sync();
			Assert.assertEquals(Result, "ok");
				
			}
			
			
//==========================================================================================================
			//@Test(priority=27)
			public static void verify_check_device_action_locate()throws Throwable{
			Result=Devices.check_device_action_locate();
			Assert.assertEquals(Result, "ok");
				
			}			
			
//==========================================================================================================
			//@Test(priority=28)
			public static void verify_check_device_action_trace_on()throws Throwable{
			Result=Devices.check_device_action_trace_on();
			Assert.assertEquals(Result, "ok");
				
			}
			
//==========================================================================================================
			//@Test(priority=29)
			public static void verify_check_device_action_trace_off()throws Throwable{
			Result=Devices.check_device_action_trace_off();
			Assert.assertEquals(Result, "ok");
				
			}				
			
//==========================================================================================================
			//@Test(priority=30)
			public static void verify_check_device_action_scan()throws Throwable{
			Result=Devices.check_device_action_scan();
			Assert.assertEquals(Result, "ok");
				
			}			

//==========================================================================================================
			//@Test(priority=31)
			public static void verify_check_device_action_broadcast_message()throws Throwable{
			Result=Devices.check_device_action_broadcast_message();
			Assert.assertEquals(Result, "ok");
				
			}			
	
//==========================================================================================================
			//@Test(priority=32)
			public static void verify_check_device_action_enabling_call_sms()throws Throwable{
			Result=Devices.check_device_action_enabling_call_sms();
			Assert.assertEquals(Result, "ok");
				
			}
			
//==========================================================================================================
			//@Test(priority=33)
			public static void verify_check_device_action_disabling_call_sms()throws Throwable{
			Result=Devices.check_device_action_disabling_call_sms();
			Assert.assertEquals(Result, "ok");
				
			}
			
			
//==========================================================================================================
			//@Test(priority=34)
			public static void verify_check_device_move_to_group()throws Throwable{
			Result=Devices.check_device_move_to_group();
			Assert.assertEquals(Result, "ok");
			}
			
			
			
//==========================================================================================================
			//@Test(priority=35)
			public static void verify_check_device_apply_configuration_antitheft()throws Throwable{
			Result=Devices.check_device_apply_configuration_antitheft();
			Assert.assertEquals(Result, "ok");
				
			}			
	
			
//==========================================================================================================
			//@Test(priority=36)
			public static void verify_check_device_apply_configuration_websecurity()throws Throwable{
			Result=Devices.check_device_apply_configuration_websecurity();
			Assert.assertEquals(Result, "ok");
				
			}
			
//==========================================================================================================
			//@Test(priority=37)
			public static void verify_check_device_apply_configuration_wifi()throws Throwable{
			Result=Devices.check_device_apply_configuration_wifi();
			Assert.assertEquals(Result, "ok");
				
			}			
	
//==========================================================================================================
			//@Test(priority=38)
			public static void verify_check_device_apply_configuration_schedule_scan()throws Throwable{
			Result=Devices.check_device_apply_configuration_schedule_scan();
			Assert.assertEquals(Result, "ok");
				
			}			
	
//==========================================================================================================
			//@Test(priority=39)
			public static void verify_check_device_apply_configuration_app_configuration()throws Throwable{
			Result=Devices.check_device_apply_configuration_app_configuration();
			Assert.assertEquals(Result, "ok");
				
			}			
			
//==========================================================================================================
			//@Test(priority=40)
			public static void verify_check_device_apply_configuration_network_usage()throws Throwable{
			Result=Devices.check_device_apply_configuration_network_usage();
			Assert.assertEquals(Result, "ok");
				
			}	
			
//==========================================================================================================
			//@Test(priority=41)
			public static void verify_check_device_locate_on_map()throws Throwable{
			Result=Devices.check_device_locate_on_map();
			Assert.assertEquals(Result, "ok");
				
			}	
	
//==========================================================================================================
			//@Test(priority=42)
			public static void verify_check_search_command_policy_config_on_activity_tab()throws Throwable{
			Result=Devices.check_search_command_policy_config_on_activity_tab();
			Assert.assertEquals(Result, "ok");
				
			}	
			
//==========================================================================================================
			//@Test(priority=43)
			public static void verify_check_activity_tab_compliance_report()throws Throwable{
			Result=Devices.check_activity_tab_compliance_report();
			Assert.assertEquals(Result, "ok");
				
			}			


			
			
			
	}
