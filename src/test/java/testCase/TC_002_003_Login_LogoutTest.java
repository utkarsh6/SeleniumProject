package testCase;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.bouncycastle.operator.MacCalculator;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.LogoutPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_003_Login_LogoutTest extends BaseClass {
	
	
	@Test(groups = {"Sanity","Master"},priority = 1)
	public void test_login() {
		
		
	        
		logger.info("*** Starting TC_002_LoginTest****");
		
		HomePage hp= new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		LoginPage lp= new LoginPage(driver);
		 lp.setEmail(properties.getProperty("email"));
	      lp.setPassword(properties.getProperty("password"));
		lp.clickLogin();
		
		//Assert
		MyAccountPage macc= new MyAccountPage(driver);
		boolean afterlogin= macc.isLoginSucces();
		
		Assert.assertEquals(afterlogin, true);
		
		logger.info("*** Finished TC_002_LoginTest****");
		
	}
	
	@Test(groups = {"Sanity","Regression","Master"},priority = 2)
	public void LogoutTest() {
		
		
		logger.info("***TC_003_LogoutTest Started****");
		MyAccountPage mac= new MyAccountPage(driver);
		mac.clickLogout();
		
		LogoutPage lo= new LogoutPage(driver);
		
		//Assert
		boolean afterLogout= lo.isLogoutSuccess();
		
		Assert.assertEquals(afterLogout, true);
		
		logger.info("***TC_003_LogoutTest Finished****");
		
	}
	

}
