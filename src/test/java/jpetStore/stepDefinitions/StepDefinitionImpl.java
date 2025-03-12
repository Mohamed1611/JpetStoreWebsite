package jpetStore.stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import jpetStore.TestComponents.BaseTest;
import jpetStore.pageobjects.AngelFishPage;
import jpetStore.pageobjects.DashBoardPage;
import jpetStore.pageobjects.FishPage;
import jpetStore.pageobjects.SignInPage;

public class StepDefinitionImpl extends BaseTest {

	//public LandingPage landingPage;
	public SignInPage signInPage;
	public DashBoardPage dashBoardPage;
	public FishPage fishPage;
	public AngelFishPage angelFishPage;

	@Given("I landded on Jpetstore Website")
	public void I_landded_on_Jpetstore_Website() throws IOException 
	{
		
		launchApplication();
		

	}
	@Given("I click on signin button")
	public void I_click_on_signin_button() 
	{
		
		landingPage.clickSignIn();
		

	}
	
	

	@When("^I login with username (.+) and password (.+)$")
	public void I_login_with_username_and_password(String username, String password) throws Throwable  {
		
		signInPage.loginApplication(username,password);
	}
	
	@Then("I land on the dashboard screen")
	public void I_land_on_the_dashboard_screen()
	{
		dashBoardPage.verifyLogin();
	}

		
	@When("I select category of product from dashboard")
	public void I_select_category_of_product_from_dashboard() {
		dashBoardPage.selectFishOption();
	}

	@And("I select the product id from products page")
	public void I_select_the_product_id_from_products_page() {
		fishPage.selectAngelFish();
	}

	@And("I click on add to cart")
	public void I_click_on_add_to_cart() {
		angelFishPage.clickAddToCart();
	}

	@Then("I land on the shopping cart page with the selected product")
	public void I_land_on_shopping_cart_with_selected_product() {
		Assert.assertTrue(driver.findElement(By.xpath("//a[normalize-space()='Proceed to Checkout']")).isDisplayed());
		Assert.assertEquals(driver.findElement(By.xpath("//h2[normalize-space()='Shopping Cart']")).getText(),
				"Shopping Cart");
		driver.close();

	}
}
