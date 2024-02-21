package testCase;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.BasePage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_004_SearchProductsWithoutConsumer extends BaseClass {
	
	@Test
	public void testSearchWithoutConsumer() {
		
		logger.info("***TC004 Started****");
		HomePage hm= new HomePage(driver);
		hm.setSearch(properties.getProperty("skuSearch"));
		hm.Searchicon();
		
		boolean afterProductSearch= hm.issearchProductSuccess();
		
		//Assert
		Assert.assertEquals(afterProductSearch, true);
		logger.info("***TC004 finished****");
		
	
	}


	

}
