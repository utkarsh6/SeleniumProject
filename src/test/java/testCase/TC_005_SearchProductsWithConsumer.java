package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_005_SearchProductsWithConsumer extends BaseClass{
	

	@Test(groups = {"Sanity","Master"},priority = 1)
	public void test_product_search_with_consumer() {
		
		
	        
		logger.info("*** Starting TC_005_Search of product****");
		
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
		
		
		HomePage hm= new HomePage(driver);
		hm.setSearch(properties.getProperty("skuSearch"));
		hm.Searchicon();
		
		boolean afterProductSearch= hm.issearchProductSuccess();
		
		//Assert
		Assert.assertEquals(afterProductSearch, true);
		logger.info("*** Finished TC_005_Search of product****");
		
		
		
	}
	

}
