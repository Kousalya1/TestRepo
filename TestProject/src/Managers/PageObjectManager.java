package Managers;

import org.openqa.selenium.WebDriver;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.MyProfilePage;
import PageObjects.NewPostPage;
import PageObjects.SettingsPage;

public class PageObjectManager {

	private WebDriver driver;
	private LoginPage loginPage;
	private HomePage homePage;
	private SettingsPage settingsPage;
	private MyProfilePage myProfilePage;
	private NewPostPage newPostPage;

	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}

	public LoginPage getLoginPage() {
		return (loginPage == null) ? loginPage = new LoginPage(driver) : loginPage;
	}

	public HomePage getHomePage() {
		return (homePage == null) ? homePage = new HomePage(driver) : homePage;
	}

	public SettingsPage getSettingsPage() {
		return (settingsPage == null) ? settingsPage = new SettingsPage(driver) : settingsPage;
	}

	public MyProfilePage getMyProfilePage() {
		return (myProfilePage == null) ? myProfilePage = new MyProfilePage(driver) : myProfilePage;
	}

	public NewPostPage getNewPostPage() {
		return (newPostPage == null) ? newPostPage = new NewPostPage(driver) : newPostPage;
	}
}
