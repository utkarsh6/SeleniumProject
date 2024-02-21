package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutPage extends BasePage{
	public LogoutPage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(xpath="//*[@id=\"content\"]/h1")
	WebElement SuccessLogoutMsg;
	public boolean isLogoutSuccess() {
		try {
			return(SuccessLogoutMsg.isDisplayed());
		}
		catch(Exception e) {
			System.out.println("Error is "+e);
			return false;
			
		}
	}
	

}
