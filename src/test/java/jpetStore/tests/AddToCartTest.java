package jpetStore.tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jpetStore.TestComponents.BaseTest;
import jpetStore.pageobjects.AngelFishPage;
import jpetStore.pageobjects.DashBoardPage;
import jpetStore.pageobjects.FishPage;
import jpetStore.pageobjects.SignInPage;

public class AddToCartTest extends BaseTest {

	@Test(dataProvider = "getData")
	public void addToCart(HashMap<String, String> input) throws IOException, InterruptedException {

		SignInPage signInPage = new SignInPage(driver);
		DashBoardPage dashBoardPage = new DashBoardPage(driver);
		FishPage fishPage = new FishPage(driver);
		AngelFishPage angelFishPage = new AngelFishPage(driver);

		landingPage.goTo();
		

		landingPage.clickSignIn();

		signInPage.loginApplication(input.get("username"), input.get("password"));
		Assert.assertTrue(driver.findElement(By.xpath("//div[@id='WelcomeContent']")).isDisplayed());

		dashBoardPage.selectFishOption();
		Assert.assertEquals(driver.findElement(By.xpath("(//h2[normalize-space()='Fish'])[1]")).getText(), "Fish");

		fishPage.selectAngelFish();

		Assert.assertEquals(driver.findElement(By.xpath("//h2[normalize-space()='Angelfish']")).getText(),
				"Angelfish");

		angelFishPage.clickAddToCart();
		Assert
				.assertTrue(driver.findElement(By.xpath("//a[normalize-space()='Proceed to Checkout']")).isDisplayed());
		Assert.assertEquals(driver.findElement(By.xpath("//h2[normalize-space()='Shopping Cart']")).getText(),
				"Shopping Cart");

	}

	@DataProvider
	public Object[][] getData() throws IOException {
		

		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//jpetStore//data//LoginData.json");
		return new Object[][] {{ data.get(0)}};

	}
}
