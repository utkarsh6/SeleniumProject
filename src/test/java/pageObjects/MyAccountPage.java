package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{
	
	public MyAccountPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath="//*[@id=\"content\"]/h2[1]")
	WebElement SuccessMsg;
	
	@FindBy(xpath="//*[@id=\"column-right\"]/div/a[13]")
	WebElement logoutBtn;
	
	@FindBy(xpath = "//*[@id=\"search\"]/span/button/i")
	WebElement SearchIcon;
	
	// Account Edit Locator
	
	@FindBy(xpath="//*[@id=\"column-right\"]/div/a[2]")
	WebElement EditAccountTab;
	// Continue to edit profile
	@FindBy(xpath="//*[@id=\"content\"]/form/div/div[2]/input")
	WebElement ContinueBtn ;
	
	@FindBy (id="input-telephone")
	WebElement telephoneno;
	
	@FindBy(xpath="//*[@id=\"account-account\"]/div[1]")
	WebElement EditSuccessMsg;

	
	public boolean isLoginSucces() {
		try {
			return(SuccessMsg.isDisplayed());
		}
		catch (Exception e) {
			
			// TODO: handle exception
			return false;
			
		}
		
	}
	
	public boolean isEditSuccess() {
		try {
			return(EditSuccessMsg.isDisplayed());
		}
		catch (Exception e) {
			
			// TODO: handle exception
			return false;
			
		}
		
	}
	

	
	public void clickLogout() {
		logoutBtn.click();
	}
	public void clickSearchIcon() {
		SearchIcon.click();
	}
	
	public void clickEditTab() {
		EditAccountTab.click();
	}
	
	public void clickContinue() {
		ContinueBtn.click();
	}
	public void setTelephoneNo(String telno) {
		telephoneno.sendKeys(telno);
	}
	

}
