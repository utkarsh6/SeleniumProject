package testCase;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass {
	
	
	
	
	@Test(groups = {"Regression","Master"})
	void Test_Account_Registration() throws InterruptedException {
		logger.info(" ****Starting TC_001_AccountRegistrationTest****");
	try {
	HomePage hp= new HomePage(driver);
	hp.clickMyAccount();
	logger.info("clicked on my account dropdown");
	hp.clickRegister();
	logger.info("clicked on Register");
	
	AccountRegistrationPage regpage= new AccountRegistrationPage(driver);
	
	logger.info("Providing consumer data ");
	regpage.setfirstName(randomString().toUpperCase());
	regpage.setlastName(randomString().toUpperCase());
	regpage.setEmail(randomString().toString()+"@gmail.com");
	regpage.setTelephoneNo(randomNumber());
	String password=randomAlphaNumeric();
	regpage.setPassword(password);
	regpage.confirmPassword(password);
	
//	regpage.setNewsletter();

	Thread.sleep(3000);
	regpage.setPolicy();
	logger.info("clicked on my continue");
	regpage.setContinue();
	
	String confirm_message=regpage.getAccountSuccessMsg();
	logger.info("Validating expected Message");
	Assert.assertEquals(confirm_message, "Your Account Has Been Created!");
		}	

	
	catch (Exception e) {
		logger.error("test faled");
		Assert.fail();
	}
	logger.info("*** Finished test case execution***");
	}
	
	

}
