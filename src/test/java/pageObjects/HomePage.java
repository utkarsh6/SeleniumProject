package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByLinkText;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
//Elements 
	@FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")
	WebElement linkDropddown;
	
	@FindBy(linkText="Register")
	WebElement register;
	
	@FindBy(xpath="//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a")
	WebElement login;
	
	@FindBy(name="search")
	WebElement SearchBar;
	
	@FindBy(xpath="//*[@id=\"search\"]/span/button")
	WebElement SearchIcon;
	
	@FindBy(xpath="//*[@id=\"content\"]/div[4]/div[2]")
	WebElement SearchSuccessMsg;
	
	
	

	//Action Method


public void clickMyAccount() {
	linkDropddown.click();
}

public void clickRegister() {
	register.click();
}
public void clickLogin() {
	login.click();		
}
public void setSearch(String product) {
	SearchBar.sendKeys(product);
}
public void Searchicon() {
	SearchIcon.click();

}
public boolean issearchProductSuccess() {
	try {
		return(SearchSuccessMsg.isDisplayed());
		
		
	}
	catch (Exception e) {
		
		// TODO: handle exception
		return false;
		
	}
	
}

}
 	

