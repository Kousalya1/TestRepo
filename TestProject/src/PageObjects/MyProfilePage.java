package PageObjects;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class MyProfilePage {

	@FindBy(how = How.CLASS_NAME, using = "user-img")
	private WebElement profilePic;

	@FindBy(how = How.CLASS_NAME, using = "btn btn-sm btn-outline-secondary action-btn")
	private WebElement editProfileSettingsButton;

	@FindBy(how = How.XPATH, using = "//img[@class='user-img']//following::h4")
	private WebElement username;

	@FindBy(how = How.XPATH, using = "//img[@class='user-img']//following-sibling::p")
	private WebElement bio;

	WebDriver driver;

	public MyProfilePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void isSettingsPageDisplayed() {
		assertTrue("Profile Picture is not displayed.", profilePic.isDisplayed());
	}

	public void clickEditProfileSettingsButton() {
		editProfileSettingsButton.click();
	}

	public void ensureMyProfilePageLoaded() {
		assertTrue("My Profile page is not loaded.", profilePic.isDisplayed());
		assertTrue("My Profile page is not loaded.", username.isDisplayed());
		assertTrue("My Profile page is not loaded.", bio.isDisplayed());
	}

	public void ensureProfilePicDisplayed() {
		assertTrue("Profile picture is not displayed.", profilePic.isDisplayed());
	}

	public void ensureUsernameBioDisplayed() {
		assertTrue("Username is not displayed.", username.isDisplayed());
		assertTrue("Bio is not displayed.", bio.isDisplayed());
	}

}
