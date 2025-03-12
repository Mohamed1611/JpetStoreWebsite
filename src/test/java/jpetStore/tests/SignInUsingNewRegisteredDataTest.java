package jpetStore.tests;

import java.io.IOException;

import org.testng.annotations.Test;

import jpetStore.TestComponents.BaseTest;
import jpetStore.data.Generator;
import jpetStore.enums.REG;
import jpetStore.pageobjects.RegisterationPage;
import jpetStore.pageobjects.SignInPage;

public class SignInUsingNewRegisteredDataTest extends BaseTest {
String newUser;
	@Test
	public void signInUsingRegisterationData() throws IOException, InterruptedException {
		String password;
		SignInPage signInPage = new SignInPage(driver);
		RegisterationPage registerationPage = new RegisterationPage(driver);
		password = Generator.genRandomPassword();
		landingPage.clickSignIn();
		signInPage.clickRegisterBtn();
		newUser = RegisterationPage.typeUserID(Generator.genRandomString(REG.USER_ID.toString()));
		registerationPage.typePassword(password);
		registerationPage.typeRepeatedPassword(password);
		registerationPage.typeFirstName(Generator.genRandomString(REG.FIRST_NAME.toString()));
		registerationPage.typeLastName(Generator.genRandomString(REG.LAST_NAME.toString()));
		registerationPage.typeEmail(Generator.genRandomMail("mail"));
		registerationPage.typePhone("12345");
		registerationPage.typeaddress1(Generator.genRandomString(REG.ADDRESS_ONE.toString()));
		registerationPage.typeaddress2(Generator.genRandomString(REG.ADDRESS_TWO.toString()));
		registerationPage.typeCityField(Generator.genRandomString(REG.CITY.toString()));
		registerationPage.typeStateField(Generator.genRandomString(REG.STATE.toString()));
		registerationPage.typeZipField("123456");
		registerationPage.typeCountryField(Generator.genRandomString(REG.COUNTRY.toString()));
		registerationPage.selectLanguage("english");
		registerationPage.selectCategory("BIRDS");
		registerationPage.checkMyListCheckBox();
		registerationPage.checkMyBannerCheckBox();
		
		landingPage.clickSignIn();
		signInPage.loginApplication(newUser, password);
		//String welcomeMsg = driver.findElement(By.xpath("//div[@id='WelcomeContent']")).getText();
		//Assert.assertTrue(welcomeMsg.equalsIgnoreCase("Welcome mohameds!"));

	}

}
