package jpetStore.tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jpetStore.TestComponents.BaseTest;
import jpetStore.pageobjects.SignInPage;

public class SignIn extends BaseTest {

	@Test(dataProvider = "getData")
	public void addToCart(HashMap<String, String> input) throws IOException {

		SignInPage signInPage = new SignInPage(driver);
		

		landingPage.goTo();

		landingPage.clickSignIn();

		signInPage.loginApplication(input.get("username"), input.get("password"));
		AssertJUnit.assertTrue(driver.findElement(By.xpath("//div[@id='WelcomeContent']")).isDisplayed());

		

	}

	@DataProvider
	public Object[][] getData() throws IOException {
		

		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//jpetStore//data//LoginData.json");
		return new Object[][] {{ data.get(0)}};

	}
}
