package jpetStore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FishPage {
	
	WebDriver driver;
	public FishPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//a[normalize-space()='FI-SW-01']")
	WebElement angelFishSelection;
	
	public void selectAngelFish()
	{
		angelFishSelection.click();
	}

}
