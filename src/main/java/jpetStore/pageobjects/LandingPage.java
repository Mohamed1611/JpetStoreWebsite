package jpetStore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	WebDriver driver;

	// constructor
	public LandingPage(WebDriver driver) {
		// init the driver
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	public void goTo()
	{
		driver.get("https://petstore.octoperf.com/actions/Catalog.action");
	}

     
	@FindBy(xpath="//a[normalize-space()='Sign In']")
	WebElement signIn;
	
	public void clickSignIn()
	{
		signIn.click();
	}
	
	
	
}
