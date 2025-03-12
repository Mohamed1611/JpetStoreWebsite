package jpetStore.stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import jpetStore.TestComponents.BaseTest;
import jpetStore.data.Generator;
import jpetStore.enums.REG;

public class StepDefinitionImpl extends BaseTest {
	public String password= Generator.genRandomPassword();

	

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
	public void I_login_with_username_and_password(String username, String password) throws InterruptedException
	{
		
		signInPage.loginApplication(username,password);;
		
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
	
	@Given ("I click on register btn")
	public void I_click_on_register_btn()
	{
		signInPage.clickRegisterBtn();
	}
	
	@And ("enter userid")
	public void enter_userid() throws InterruptedException
	{
		registerationPage.typeUserID(Generator.genRandomString(REG.USER_ID.toString()));
	}
	@And ("enter password")
	public void enter_password() throws InterruptedException
	{
		registerationPage.typePassword(password);
	}
	 @And ("enter repeat password")
	 public void enter_repeat_password() throws InterruptedException
	 {
		 registerationPage.typeRepeatedPassword(password);
	 }
	 @And ("enter first name")
	 public void enter_first_name() throws InterruptedException
	 {
		 registerationPage.typeFirstName(Generator.genRandomString(REG.FIRST_NAME.toString()));
	 }
	 @And ("enter last name")
	 public void enter_last_name()
	 {
		 registerationPage.typeLastName(Generator.genRandomString(REG.LAST_NAME.toString()));
	 }
	 @And ("enter email")
	 public void enter_email()
	 {
		 registerationPage.typeEmail(Generator.genRandomMail());
	 }
	 @And ("enter phone")
	 public void enter_phone()
	 {
		 registerationPage.typePhone(Generator.genRandomNumber(7));
	 }
	 @And ("enter address1")
	 public void enter_address1()
	 {
		 registerationPage.typeaddress1(Generator.genRandomString(REG.ADDRESS_ONE.toString()));
	 }
	 @And ("enter address2")
	 public void enter_address2()
	 {
		 registerationPage.typeaddress2(Generator.genRandomString(REG.ADDRESS_TWO.toString()));
	 }
	 @And ("enter city")
	 public void enter_city()
	 {
		 registerationPage.typeCityField(Generator.genRandomString(REG.CITY.toString()));
	 }
	@And ("enter state")
	public void enter_state()
	{
		registerationPage.typeStateField(Generator.genRandomString(REG.STATE.toString()));
	}
	@And ("enter zip")
	public void enter_zip()
	{
		registerationPage.typeZipField(Generator.genRandomNumber(4));
	}
	@And ("enter country")
	public void enter_country()
	{
		registerationPage.typeCountry(Generator.genRandomString(REG.COUNTRY.toString()));
	}
	@And ("select language")
	public void select_language()
	{
		registerationPage.selectLanguage("english");
	}
	@And ("select category")
	public void select_category()
	{
		registerationPage.selectCategory("BIRDS");
	}
	@And ("enable mylist")
	public void enable_mylist()
	{
		registerationPage.checkMyListCheckBox();
	}
	@And ("enable mybanner")
	public void enable_mybanner()
	{
		registerationPage.checkMyBannerCheckBox();
	}
	 @When ("click save account information btn")
	 public void click_save_account_information_btn()
	 {
		 registerationPage.clickSaveAccountInformationBtn();
	 }
	 @Then ("user registered successfully")
	 public void user_registered_successfully()
	 {
		 dashBoardPage.verifyFishOption();
		 driver.close();
	 }
	 
}
