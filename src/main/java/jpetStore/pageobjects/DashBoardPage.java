package jpetStore.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoardPage {
	
	WebDriver driver;
	public DashBoardPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//div[@id='QuickLinks']//a[1]")
	WebElement fishSelection;
	
	
	@FindBy(xpath = "//div[@id='WelcomeContent']")
	WebElement welcomeMsg;
	
	
	
	
	
	public void selectFishOption()
	{
		fishSelection.click();
	}
	
	public void verifyLogin()
	{
		welcomeMsg.isDisplayed();

	}
	
	

}
