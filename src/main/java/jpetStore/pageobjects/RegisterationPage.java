package jpetStore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegisterationPage {

	WebDriver driver;

	public RegisterationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "input[name='username']")

	WebElement userIDField;

	@FindBy(css = "input[name='password']")
	WebElement newPasswordField;

	@FindBy(css = "input[name='repeatedPassword']")
	WebElement repeatedPasswordField;

	@FindBy(css = "input[name='account.firstName']")
	WebElement firstNameField;

	@FindBy(css = "input[name='account.lastName']")
	WebElement lastNameField;

	@FindBy(css = "input[name='account.email']")
	WebElement emailField;

	@FindBy(css = "input[name='account.phone']")
	WebElement phoneField;

	@FindBy(css = "input[name='account.address1']")
	WebElement address1Field;

	@FindBy(css = "input[name='account.address2']")
	WebElement address2Field;

	@FindBy(css = "input[name='account.city']")
	WebElement cityField;

	@FindBy(css = "input[name='account.state']")
	WebElement stateField;

	@FindBy(css = "input[name='account.zip']")
	WebElement zipField;

	@FindBy(css = "input[name='account.country']")
	WebElement countryField;

	@FindBy(css = "select[name='account.languagePreference']")
	WebElement languageDropDownList;

	@FindBy(css = "select[name='account.favouriteCategoryId']")
	WebElement favouritCategoryDropDownList;

	@FindBy(css = "input[name='account.listOption']")
	WebElement enableMyListCheckBox;

	@FindBy(css = "input[name='account.bannerOption']")
	WebElement enableMyBannerCheckBox;

	@FindBy(css = "input[name='newAccount']")
	WebElement saveAccountInformationBtn;

	/**
	 * @description type userID
	 * @param userID
	 * @return
	 */
	public String typeUserID(String userid) throws InterruptedException {
		userIDField.sendKeys(userid);

		return userid;

	}

	/**
	 * @description type password
	 * @param password
	 */
	public void typePassword(String password) throws InterruptedException {
		newPasswordField.sendKeys(password);

	}

	public void typeRepeatedPassword(String password) throws InterruptedException {
		newPasswordField.sendKeys(password);

	}

	/**
	 * @description type first name
	 * @param firstName
	 */
	public void typeFirstName(String firstName) throws InterruptedException {
		firstNameField.sendKeys(firstName);

	}

	/**
	 * @description type last name
	 * @param lastName
	 */
	public void typeLastName(String lastname) {
		lastNameField.sendKeys(lastname);
	}

	/**
	 * @description type email
	 * @param email
	 */
	public void typeEmail(String email) {
		emailField.sendKeys(email);
	}

	/**
	 * @description type phone
	 * @param phone
	 */

	public void typePhone(String num) {
		phoneField.sendKeys(num);
	}

	/**
	 * @description type address1
	 * @param address1
	 */
	public void typeaddress1(String address1) {
		address1Field.sendKeys(address1);
	}

	/**
	 * @description type address2
	 * @param address2
	 */
	public void typeaddress2(String address2) {
		address2Field.sendKeys(address2);
	}

	/**
	 * @description type city
	 * @param cityfield
	 */
	public void typeCityField(String cityfield) {
		cityField.sendKeys(cityfield);
	}

	/**
	 * @description type state field
	 * @param statefield
	 */
	public void typeStateField(String statefield) {
		stateField.sendKeys(statefield);
	}

	/**
	 * @description type zip field
	 * @param string
	 */
	public void typeZipField(String zipnum) {
		zipField.sendKeys(zipnum);
	}

	/**
	 * @description type country
	 * @param countryfield
	 */
	public void typeCountry(String countryfield) {
		countryField.sendKeys(countryfield);
	}

	/**
	 * @description type language
	 * @param lang
	 */
	public void selectLanguage(String lang) {
		Select langDropDownList = new Select(languageDropDownList);
		langDropDownList.selectByValue(lang);

	}

	/**
	 * @description type category
	 * @param category
	 */
	public void selectCategory(String category) {
		Select favouritCategoryList = new Select(favouritCategoryDropDownList);
		favouritCategoryList.selectByValue(category);

	}

	/**
	 * @description click check my list
	 * @param mylistcheckbox
	 */
	public void checkMyListCheckBox() {
		enableMyListCheckBox.click();

	}

	/**
	 * @description click check my banner
	 * @param mybannercheckbox
	 */
	public void checkMyBannerCheckBox() {
		enableMyBannerCheckBox.click();

	}

	/**
	 * @description click save button
	 * @param savebutton
	 */
	public void clickSaveAccountInformationBtn() {
		saveAccountInformationBtn.click();

	}

}
