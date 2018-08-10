package seqrite.mdm.test;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import seqrite.mdm.appmodules.Users;
import seqrite.mdm.utils.Setup;
import seqrite.mdm.utils.TestNGListener;

@Listeners(TestNGListener.class)
public class UserTest extends Setup {

	String Result;
	
	/**
	 * @author Poonam.Wani
	 * This test case is to add new user in an MDM application.
	 * 
	 */
	 
	//@Test(priority = 1) 
	public void verify_Add_New_User() throws Exception{
		Result = Users.check_add_new_user();
		Assert.assertEquals(Result,"ok");    
	}
	
//===================================================================================================================	
	
	/**
	 * @author Poonam.Wani
	 * This test case is to update the user in an MDM application.
	 * 
	 */
	//@Test(priority = 2) 
//	public void verify_Update_User() throws Exception{
//		Result = Users.check_edit_user();
//		Assert.assertEquals(Result,"ok");
//	}
//===================================================================================================================	
	
	/**
	 * @author Poonam.Wani
	 * This test case is to delete the user in an MDM application.
	 * 
	 */	
	//@Test(priority = 3)
	public void verify_Delete_User() throws Exception{
	Result= Users.check_user_delete();
		Assert.assertEquals(Result, "ok");
	}
//===================================================================================================================	
	
	/**
	 * @author Poonam.Wani
	 * This test case is to assign the admin priviledge to added user in an MDM application.
	 * 
	 */
		
	//@Test(priority = 4)
	public void verify_Assign_Admin_Priviledge_To_User() throws Exception{
	Result= Users.check_assign_admin_priviledge_to_user();
		Assert.assertEquals(Result, "ok");
	}
	
//===================================================================================================================	
	
	/**
	 * @author Poonam.Wani
	 * This test case is to delete the user from with selected option in an MDM application.
	 * 
	 */
			
	//@Test(priority = 5)
	public void verify_Delete_User_From_With_Selected_Option() throws Exception{
		Result= Users.check_user_delete_With_Selected_Option();		
		Assert.assertEquals(Result, "ok");
	}
//===================================================================================================================	

   // @Test(priority= 6)
    public void verify_check_send_enrollment_request()throws Exception {
	Result= Users.check_send_enrollment_request();
	Assert.assertEquals(Result, "ok");
}

//=========================================================================================================
      // @Test(priority=7)
       //public void verify_check_send_enrollment_request_via_overview()throws Exception {
	   //Result= Users.check_send_enrollment_request_via_overview();
	  // Assert.assertEquals(Result, "ok");
      //     }
       
//=========================================================================================================
       
     //@Test(priority=7)
       public void Verify_check_send_enrollment_request_via_overview_QRcode()throws Exception {
	   Result= Users.check_send_enrollment_request_via_overview_QRcode();
	   Assert.assertEquals(Result, "ok");
 
     }
       
//=========================================================================================================
     //@Test(priority=8)
     public void Verify_check_send_enrollment_request_via_overview_ADO()throws Exception {
	   Result= Users.check_send_enrollment_request_via_overview_ADO();
	   Assert.assertEquals(Result, "ok");

   }
     
     
       
	
       //=================================================================================================
       //@Test(priority=9)
       public void verify_check_user_admin_request()throws Exception {
	   Result= Users.check_user_admin_request();
	   Assert.assertEquals(Result, "ok");   
       }
       
       
//========================================================================================================       
       
       //@Test(priority=10,dependsOnMethods="verify_check_user_admin_request")
       public void verify_revoke_user_admin_request()throws Exception {
	   Result= Users.revoke_user_admin_request();
	   Assert.assertEquals(Result, "ok");   
       }
       
 //====================================================================================================
       
       @Test(priority=11)
       public void verify_check_Enroll_New_Device_via_overview()throws Exception {
    	   Result= Users.check_Enroll_New_Device_via_overview();
    	   Assert.assertEquals(Result, "ok");     
    	   
       }
       
     //===================================================================================================================	
     		/**
     		 * @author Lavina Jain
     		 * This test case is to import the csv file & add users data from it into MDM application.
     		 * 
     		 */
     				
     		//@Test(priority = 12)
     		public void verify_import_user() throws Exception{
     			Result= Users.check_import_user();
     			Assert.assertEquals(Result, "ok");
     		}
     		//===================================================================================================================	
     		/**
     		 * @author Lavina Jain
     		 * This test case is to export the csv file & add users data from it into MDM application.
     		 * 
     		 */
     				
     		//@Test(priority = 13)
     		public void verify_export_user() throws Exception{
     			Result= Users.check_export_user();
     			Assert.assertEquals(Result, "ok");
     		}
     		
     		//===================================================================================================================	
     				/**
     				 * @author Lavina Jain
     				 * This test case is to check the search functionality by user name,email id, Mobile No. in MDM application.
     				 * 
     				 */		
     		//@Test(priority = 14)
     				public void verify_simple_search_user() throws Exception{
     					Result= Users.check_simple_search_user();
     					Assert.assertEquals(Result, "ok");
     				}
     				//===================================================================================================================	
     				/**
     				 * @author Lavina Jain
     				 * This test case is to check the advanced search functionality by selecting the user role as super user in MDM application.
     				 * 
     				 */		
     		//@Test(priority = 15)
     				public void verify_advance_search_user() throws Exception{
     					Result= Users.check_advance_search_user();
     					Assert.assertEquals(Result, "ok");
     				}
     		//===================================================================================================================	
     		/**
     		 * @author Lavina Jain
     		 * This test case is to check the Filter Column functionality by ID,Department,email id, Mobile No. in MDM application.
     		 * 
     		 */		
     //@Test(priority = 16)
     		public void verify_Filter_Column() throws Exception{
     			Result= Users.check_Filter_Column();
     			Assert.assertEquals(Result, "ok");
     		}
     		
     		//===================================================================================================================	
     				/**
     				 * @author Lavina Jain
     				 * This test case is to Check Column header sorting on User List Page in MDM application.
     				 * 
     				 */		
     		@Test(priority = 17)
     				public void verify_column_header_sorting() throws Exception{
     					Result= Users.check_column_header_sorting();
     					Assert.assertEquals(Result, "ok");
     				}     
       

}

