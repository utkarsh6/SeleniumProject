package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_007_EditProfile extends BaseClass {
	

	@Test(groups = {"Sanity","Master"})
	public void test_Edit_Profile() {
		
		
	        
		logger.info("*** Starting TC_007 ***");
		
		HomePage hp= new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		LoginPage lp= new LoginPage(driver);
		 lp.setEmail(properties.getProperty("email"));
	      lp.setPassword(properties.getProperty("password"));
		lp.clickLogin();
		
		MyAccountPage macc= new MyAccountPage(driver);
		macc.clickEditTab();
		
		macc.setTelephoneNo(randomNumber());
		macc.clickContinue();
		
		boolean editsuccessMsg= macc.isEditSuccess();
		Assert.assertEquals(editsuccessMsg, true);
		
		logger.info("*** Finished TC_007 ****");
		
	}
	

}
