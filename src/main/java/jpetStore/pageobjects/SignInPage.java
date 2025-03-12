package jpetStore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
	
	WebDriver driver;

	// constructor
	public SignInPage(WebDriver driver) {
		// init the driver
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath = "//input[@name='username']")
	WebElement userNameField;
	
	@FindBy(xpath = "//input[@name='password']")
	WebElement passwordField;
	
	@FindBy(xpath = "//input[@name='signon']")
	WebElement loginBtn;
	
	
	@FindBy(xpath = "//a[normalize-space()='Register Now!']")
	WebElement registerNowBtn;
	
	public void loginApplication(String username,String password)
	{
		userNameField.clear();
		userNameField.sendKeys(username);
		passwordField.clear();
		passwordField.sendKeys(password);
		loginBtn.click();
		
	}
	
	public void clickRegisterBtn()
	{
		registerNowBtn.click();
	}

}
