package jpetStore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AngelFishPage {
	WebDriver driver;
	public AngelFishPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "(//a[@class='Button'][normalize-space()='Add to Cart'])[1]")
	WebElement addToCartBtn;
	
	public void clickAddToCart()
	{
		addToCartBtn.click();
		
	}

}
