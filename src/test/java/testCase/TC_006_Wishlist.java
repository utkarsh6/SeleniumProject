package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_006_Wishlist extends BaseClass{
	
	@Test(groups = {"Regression","Master"})
	public void Wishlist() {
		
		logger.info("****TC_006 Wishlist started ****");
		
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
		hm.setSearch(properties.getProperty("WishList"));
		hm.Searchicon();
		
		SearchPage sp= new SearchPage(driver);
		sp.clickWishlistIcon();
		
		//Assert 
		boolean addingWishlist = sp.isWishlistAddSuccess();
		Assert.assertEquals(addingWishlist, true);
		
		logger.info("****TC_006 Wishlist finished ****");
	}

}
