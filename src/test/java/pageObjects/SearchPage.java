package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage  extends BasePage{

	public SearchPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//*[@id=\"content\"]/div[3]/div/div/div[2]/div[2]/button[2]")
	WebElement WishlistIcon;
	
	@FindBy(xpath="//*[@id=\"product-search\"]/div[1]")
	WebElement wishlistSuccess;
	
	
	
	public void clickWishlistIcon() {
		WishlistIcon.click();
	}
	
	
	
	public boolean isWishlistAddSuccess() {
		try {
			return(wishlistSuccess.isDisplayed());
		}
		catch (Exception e) {
			
			// TODO: handle exception
			return false;
			
		}
		
	}

	
	

}
