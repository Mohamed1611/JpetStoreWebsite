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
import jpetStore.pageobjects.AngelFishPage;
import jpetStore.pageobjects.DashBoardPage;
import jpetStore.pageobjects.FishPage;
import jpetStore.pageobjects.RegisterationPage;
import jpetStore.pageobjects.SignInPage;

public class StepDefinitionImpl extends BaseTest {
	public String password= Generator.genRandomPassword();

	
	public SignInPage signInPage;
	 public DashBoardPage dashBoardPage;
	 public  FishPage fishPage;
	 public  AngelFishPage angelFishPage;
	 public RegisterationPage registerationPage;
	

    
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
		//System.out.println("username = "+ username);
		//System.out.println("password = "+ password);
		Thread.sleep(3000);
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
	
	@When ("enter userid")
	public void enter_userid() throws InterruptedException
	{
		registerationPage.typeUserID(Generator.genRandomString(REG.USER_ID.toString()));
	}
	@When ("enter password")
	public void enter_password() throws InterruptedException
	{
		registerationPage.typePassword(password);
	}
	 @When ("enter repeat password")
	 public void enter_repeat_password() throws InterruptedException
	 {
		 registerationPage.typeRepeatedPassword(password);
	 }
	 @When ("enter first name")
	 public void enter_first_name() throws InterruptedException
	 {
		 registerationPage.typeFirstName(Generator.genRandomString(REG.FIRST_NAME.toString()));
	 }
	 @When ("enter last name")
	 public void enter_last_name()
	 {
		 registerationPage.typeLastName(Generator.genRandomString(REG.LAST_NAME.toString()));
	 }
	 @When ("enter email ")
	 public void enter_email()
	 {
		 registerationPage.typeEmail(Generator.genRandomMail("mail"));
	 }
	 @When ("enter phone")
	 public void enter_phone()
	 {
		 registerationPage.typePhone("123456");
	 }
	 @When ("enter address1")
	 public void enter_address1()
	 {
		 registerationPage.typeaddress1(Generator.genRandomString(REG.ADDRESS_ONE.toString()));
	 }
	 @When ("enter address2")
	 public void enter_address2()
	 {
		 registerationPage.typeaddress2(Generator.genRandomString(REG.ADDRESS_TWO.toString()));
	 }
	 @When ("enter city")
	 public void enter_city()
	 {
		 registerationPage.typeCityField(Generator.genRandomString(REG.CITY.toString()));
	 }
	@When ("enter state")
	public void enter_state()
	{
		registerationPage.typeStateField(Generator.genRandomString(REG.STATE.toString()));
	}
	@When ("enter zip")
	public void enter_zip()
	{
		registerationPage.typeZipField("0000");
	}
	@When ("enter country")
	public void enter_country()
	{
		registerationPage.typeCountry(Generator.genRandomString(REG.COUNTRY.toString()));
	}
	@When ("select language")
	public void select_language()
	{
		registerationPage.selectLanguage("english");
	}
	@When ("select category")
	public void select_category()
	{
		registerationPage.selectCategory("BIRDS");
	}
	@When ("enable mylist")
	public void enable_mylist()
	{
		registerationPage.checkMyListCheckBox();
	}
	@When ("enable mybanner")
	public void enable_mybanner()
	{
		registerationPage.checkMyBannerCheckBox();
	}
	 @And ("click save account information btn")
	 public void click_save_account_information_btn()
	 {
		 registerationPage.clickSaveAccountInformationBtn();
	 }
	 @Then ("user registered successfully")
	 public void user_registered_successfully()
	 {
		 dashBoardPage.verifyFishOption();
	 }
	 
}
