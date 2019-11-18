package PageObjects;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SettingsPage {

	@FindBy(how = How.XPATH, using = "//input[@placeholder='URL of profile picture']")
	private WebElement urlOfProfilePic;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Username']")
	private WebElement userName;

	@FindBy(how = How.XPATH, using = "//textarea[@placeholder='Short bio about you']")
	private WebElement shortBio;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Email']")
	private WebElement email;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='New Password']")
	private WebElement newPassword;

	@FindBy(how = How.XPATH, using = "//h1[@class='text-xs-center' and text()='Your Settings']")
	private WebElement yourSettingsText;

	@FindBy(how = How.CLASS_NAME, using = "btn btn-outline-danger")
	private WebElement logoutButton;

	@FindBy(how = How.XPATH, using = "//button[@type='submit']")
	private WebElement updateSettingsButton;

	@FindBy(how = How.XPATH, using = "//li[text()='email']")
	private WebElement emailErrorMsg;

	@FindBy(how = How.XPATH, using = "//li[text()='username']")
	private WebElement usernameErrorMsg;

	@FindBy(how = How.XPATH, using = "//li[text()='password']")
	private WebElement passwordErrorMsg;

	@FindBy(how = How.XPATH, using = "//a[text()='Your Feed']")
	private WebElement yourFeed;

	@FindBy(how = How.XPATH, using = "//a[@href='#login']")
	private WebElement signIn;

	WebDriver driver;

	public SettingsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void ensureSettingsPageDisplayed() {
		assertTrue("Settings page is not displayed.", yourSettingsText.isDisplayed());
	}

	public void clickLogoutButton() {
		logoutButton.click();
	}

	public void clickUpdateSettingsButton() {
		updateSettingsButton.click();
	}

	public void ensurePlaceholdersDisplayed() {
		assertTrue("The placeholder for 'URL of profile picture' is not displayed.", urlOfProfilePic.isDisplayed());
		assertTrue("The placeholder for 'Username' title is not displayed.", userName.isDisplayed());
		assertTrue("The placeholder for 'Short bio about you' is not displayed.", shortBio.isDisplayed());
		assertTrue("The placeholder for 'Email' is not displayed.", email.isDisplayed());
		assertTrue("The placeholder for 'Password' is not displayed.", newPassword.isDisplayed());
	}

	public void ensureMandateEmailErrorDisplayed() {
		assertTrue("The mandatory error message for Email is not displayed.", emailErrorMsg.isDisplayed());
	}

	public void ensureMandateUsernameErrorDisplayed() {
		assertTrue("The mandatory error message for Username is not displayed.", usernameErrorMsg.isDisplayed());
	}

	public void ensureMinAllowedCharPasswordErrorDisplayed() {
		assertTrue("The minimum allowed character error message for Password is not displayed.",
				passwordErrorMsg.isDisplayed());
	}

	public void enterURLofProfilePic(String url) {
		urlOfProfilePic.sendKeys(url);
	}

	public void enterUsername(String name) {
		userName.sendKeys(name);
	}

	public void enterShortBio(String bio) {
		shortBio.sendKeys(bio);
	}

	public void enterEmail(String emailID) {
		email.sendKeys(emailID);
	}

	public void enterPassword(String password) {
		newPassword.sendKeys(password);
	}

	public void editURLofPic(String urlOfPic) {
		urlOfProfilePic.clear();
		urlOfProfilePic.sendKeys(urlOfPic);
	}

	public void editUsername(String name) {
		userName.clear();
		userName.sendKeys(name);
	}

	public void editPassword(String password) {
		newPassword.clear();
		newPassword.sendKeys(password);
	}

	public void editEmail(String emailID) {
		email.clear();
		email.sendKeys(emailID);
	}

	public void editShortBio(String bio) {
		shortBio.clear();
		shortBio.sendKeys(bio);
	}

	public void ensureSettingsUpdated() {
		assertTrue("The Settings got updated.", yourFeed.isDisplayed());
	}

	public void ensureLoggedOut() {
		assertTrue("You are not logged out of the application.", signIn.isDisplayed());
	}
}
