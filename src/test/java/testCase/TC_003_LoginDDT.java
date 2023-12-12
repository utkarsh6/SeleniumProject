package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDDT  extends BaseClass{
	
	
	@Test(dataProvider = "LoginData",dataProviderClass = DataProviders.class)
	public void test_login_DDT(String email, String password,String expected) {
		logger.info("**** TC_003 Started ****");
		try {
	
			
			HomePage hp= new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();
			
			LoginPage lp= new LoginPage(driver);
			lp.setEmail(email);
		    lp.setPassword(password);
			lp.clickLogin();
			
			//Assert
					MyAccountPage macc= new MyAccountPage(driver);
					boolean afterlogin= macc.isLoginSucces();
					
					Assert.assertEquals(afterlogin, true);
					
					
					
					if(expected.equals("Valid")) {
						
						if(afterlogin==true) {
							macc.clickLogout();
							Assert.assertTrue(true);
						}
						else {
							Assert.assertTrue(false);
						}
						
						
					}
					if(expected.equals("Invalid")) {
						if(afterlogin==true) {
							macc.clickLogout();
							Assert.assertTrue(false);
						}
						else {
							Assert.assertTrue(true);
						}
						
					}			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		logger.info("*** Finished TC_003_test_login_DDT****");
		
		
		
		
	}
	
	

}
