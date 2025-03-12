package jpetStore.tests;

import java.io.IOException;

import org.testng.annotations.Test;

import jpetStore.TestComponents.BaseTest;
import jpetStore.data.Generator;
import jpetStore.enums.REG;
import jpetStore.pageobjects.RegisterationPage;
import jpetStore.pageobjects.SignInPage;


public class RegisterationTest extends BaseTest {
	String password;
	@Test()
	public void registerationTest() throws IOException, InterruptedException {

		password = Generator.genRandomPassword();
		SignInPage signInPage = new SignInPage(driver);
		RegisterationPage registerationPage = new RegisterationPage(driver);

		landingPage.goTo();
		landingPage.clickSignIn();
		signInPage.clickRegisterBtn();
		registerationPage.typeUserID(Generator.genRandomString(REG.USER_ID.toString()));
		registerationPage.typePassword(password);
		registerationPage.typeRepeatedPassword(password);
		registerationPage.typeFirstName(Generator.genRandomString(REG.FIRST_NAME.toString()));
		registerationPage.typeLastName(Generator.genRandomString(REG.LAST_NAME.toString()));
		registerationPage.typeEmail(Generator.genRandomMail());
		registerationPage.typePhone("123456");
		registerationPage.typeaddress1(Generator.genRandomString(REG.ADDRESS_ONE.toString()));
		registerationPage.typeaddress2(Generator.genRandomString(REG.ADDRESS_TWO.toString()));
		registerationPage.typeCityField(Generator.genRandomString(REG.CITY.toString()));
		registerationPage.typeStateField(Generator.genRandomString(REG.STATE.toString()));
		registerationPage.typeZipField("12345");
		registerationPage.typeCountry(Generator.genRandomString(REG.COUNTRY.toString()));
		registerationPage.selectLanguage("english");
		registerationPage.selectCategory("BIRDS");
		registerationPage.checkMyListCheckBox();
		registerationPage.checkMyBannerCheckBox();
		registerationPage.clickSaveAccountInformationBtn();
		
		//Assert.assertEquals(driver.getCurrentUrl(), "https://petstore.octoperf.com/actions/Catalog.action");


	}

	
}
