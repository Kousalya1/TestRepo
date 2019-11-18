package StepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Managers.PageObjectManager;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.MyProfilePage;
import PageObjects.NewPostPage;
import PageObjects.SettingsPage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinitions {

	WebDriver driver;
	PageObjectManager pageObjectManager;
	LoginPage loginPage;
	HomePage homePage;
	MyProfilePage myProfilePage;
	SettingsPage settingsPage;
	NewPostPage newPostPage;

	@Before
	public void before() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "src/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://react-redux.realworld.io");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		pageObjectManager = new PageObjectManager(driver);
		loginPage = pageObjectManager.getLoginPage();
		homePage = pageObjectManager.getHomePage();
		myProfilePage = pageObjectManager.getMyProfilePage();
		settingsPage = pageObjectManager.getSettingsPage();
		newPostPage = pageObjectManager.getNewPostPage();
		loginPage.verifyTitleSubtitle();
	}

	@Given("^I Sign in to the application$")
	public void Sign_in_to_the_application() throws Throwable {
		loginPage.clickSignInButton();
		loginPage.enterUserNamePassword("kousalyakanikannan@gmail.com", "qwertyui");
		loginPage.clickSubmit();
		homePage.verifyTitle();
	}

	@Given("^Your feed should get loaded if available$")
	public void Your_feed_should_get_loaded_if_available() throws Throwable {
		homePage.ensureYourFeedsLoaded();
	}

	@When("^I click on sign up button$")
	public void I_click_on_sign_up_button() throws Throwable {
		loginPage.clickSignUpButton();
	}

	@Then("^Sign up should get completed successfully$")
	public void Sign_up_should_get_completed_successfully() throws Throwable {
		loginPage.clickSignInButton();
		loginPage.enterUserNamePassword("kousalyakanikannan@gmail.com", "testtest");
		loginPage.clickSubmit();
		homePage.verifyTitle();
	}

	@Then("^Sign up with the existing account$")
	public void Sign_up_with_the_existing_account() throws Throwable {
		settingsPage.enterEmail("kousalyakanikannan@gmail.com");
		settingsPage.enterUsername("Kousalya");
		settingsPage.enterPassword("testtest");
		loginPage.clickSubmit();
	}

	@Then("^Email has already been taken error message should be displayed$")
	public void Email_has_already_been_taken_error_message_should_be_displayed() throws Throwable {
		loginPage.ensureEmailAlreadyExistMsgDisplayed();
	}

	@When("^I click on sign in button$")
	public void I_click_on_sign_in_button() throws Throwable {
		loginPage.clickSignInButton();
	}

	@When("^Enter the correct username and password details to sign in the application$")
	public void Enter_the_correct_username_and_password_details_to_sign_in_the_application() throws Throwable {
		loginPage.enterUserNamePassword("kousalyakanikannan@gmail.com", "qwertyui");
	}

	@Then("^Sign in should get completed successfully$")
	public void Sign_in_should_get_completed_successfully() throws Throwable {
		homePage.ensureLoginSucceeded();
	}

	@When("^Enter the wrong username and password details to sign in the application$")
	public void Enter_the_wrong_username_and_password_details_to_sign_in_the_application() throws Throwable {
		loginPage.enterUserNamePassword("jfwj@gmil.com", "hjhjh/hkw==");
	}

	@Then("^Sign in should get failed with an error message$")
	public void Sign_in_should_get_failed_with_an_error_message() throws Throwable {
		loginPage.ensureLoginFailed();
	}

	@When("^Enter invalid Email id \"([^\"]*)\"$")
	public void Enter_the_invalid_Email_id(String emailID) throws Throwable {
		settingsPage.enterEmail(emailID);
	}

	@Then("^It should display an error message to enter correct Email$")
	public void It_should_display_an_error_message_to_enter_correct_Email() throws Throwable {
		loginPage.ensureErroMsgDisplayed();
	}

	@When("^Enter Password \"([^\"]*)\" with less tham minimum allowed characters$")
	public void Enter_Password_with_less_tham_minimum_allowed_characters(String password) throws Throwable {
		settingsPage.enterPassword(password);
	}

	@When("^I click on the Global feed link$")
	public void I_click_on_the_Global_feed_link() throws Throwable {
		homePage.clickOnGlobalFeedLink();
	}

	@Then("^Global feed should get loaded$")
	public void Global_feed_should_get_loaded() throws Throwable {
		homePage.ensureGlobalFeedsLoaded();
	}

	@When("^Click on the like button, should be able to like the feed$")
	public void Click_on_the_like_button() throws Throwable {
		homePage.clickLikeButtonAndEnsure();
	}

	@When("^Click on the like button again, should be able to dislike the feed$")
	public void Click_on_the_like_button_to_dislike() throws Throwable {
		homePage.clickDisLikeAndEnsure();
	}

	@When("^Click on the read more link$")
	public void Click_on_the_read_more_link() throws Throwable {
		homePage.clickReadMoreLink();
	}

	@When("^Post a comment as \"([^\"]*)\" and ensure it is posted$")
	public void Write_a_comment_and_post(String comment) throws Throwable {
		homePage.writeCommentAndPost(comment);
	}

	@Then("^Delete the comment and ensure it is deleted$")
	public void delete_the_comment() throws Throwable {
		homePage.deleteCommentAndEnsure();
	}

	@When("^Click on the authorname in an article and ensure you are navigated to author's profile$")
	public void Click_on_the_authorname_in_an_article() throws Throwable {
		homePage.clickOnAuthorNameAndEnsure();
	}

	@When("^Click on the follow button of the author and ensure you are able to follow the user$")
	public void Click_on_the_follow_button_of_the_author() throws Throwable {
		homePage.clickOnFollowButtonAndEnsure();
	}

	@Then("^On Clicking on the Unfollow button, I should be able to Unfollow the author$")
	public void On_Clicking_on_the_Unfollow_button_I_should_be_able_to_Unfollow_the_author() throws Throwable {
		homePage.clickOnUnfollowButtonAndEnsure();
	}

	@When("^Click on the my articles link of the author$")
	public void Click_on_the_my_articles_link_of_the_author() throws Throwable {
		homePage.clickOnMyArticles();
	}

	@Then("^I should be able to view the articles of the author if available$")
	public void I_should_be_able_to_view_the_articles_of_the_author_if_available() throws Throwable {
		homePage.ensureMyArticlesLoaded();
	}

	@When("^Click on the favourite articles link$")
	public void Click_on_the_favourite_articles_link() throws Throwable {
		homePage.clickOnFavoriteArticles();
	}

	@Then("^I should be able to view the favourite articles of the author if available$")
	public void I_should_be_able_to_view_the_favourite_articles_of_the_author_if_available() throws Throwable {
		homePage.ensureFavoriteArticlesLoaded();
	}

	@When("^I click on the popular tags$")
	public void I_click_on_the_popular_tags() throws Throwable {
		homePage.clickOnpopularTag();
	}

	@Then("^The respective articles which contains the popular tag should get loaded$")
	public void The_respective_articles_which_contains_the_popular_tag_should_get_loaded() throws Throwable {
		homePage.ensurePopularTagFeedsLoaded();
	}

	@Given("^Click on My Profile link$")
	public void Click_on_My_Profile_link() throws Throwable {
		homePage.clickOnMyProfileLink();
	}

	@Then("^My Profile page should get loaded successfully$")
	public void My_Profile_page_should_get_loaded_successfully() throws Throwable {
		myProfilePage.ensureMyProfilePageLoaded();
	}

	@When("^I check for the profile picture, Username and Bio$")
	public void I_check_for_the_profile_picture_username_and_Bio() throws Throwable {

	}

	@Then("^The Profile picture should be displayed$")
	public void The_Profile_picture_should_be_displayed() throws Throwable {
		myProfilePage.ensureProfilePicDisplayed();
	}

	@Then("^The Username and Bio should be displayed$")
	public void The_username_and_Bio_should_be_displayed() throws Throwable {
		myProfilePage.ensureUsernameBioDisplayed();
	}

	@When("^I click on My Articles link$")
	public void I_click_on_My_Articles_link() throws Throwable {
		homePage.clickOnMyArticles();
	}

	@Then("^My articles should get loaded$")
	public void My_articles_should_get_loaded() throws Throwable {
		homePage.ensureMyArticlesLoaded();
	}

	@Then("^I should be able to view my favourite articles if available$")
	public void I_should_be_able_to_view_my_favourite_articles_if_available() throws Throwable {
		homePage.ensureFavoriteArticlesLoaded();
	}

	@When("^My favourite articles page should get loaded$")
	public void My_favourite_articles_page_should_get_loaded() throws Throwable {
		homePage.ensureFavoriteArticlesLoaded();
	}

	@When("^I click on the Edit profile settings button$")
	public void I_click_on_the_Edit_profile_settings_button() throws Throwable {
		myProfilePage.clickEditProfileSettingsButton();
	}

	@Given("^Click on New post link$")
	public void Click_on_New_post_link() throws Throwable {
		homePage.clickOnNewPostLink();
	}

	@Then("^New post page should get loaded successfully$")
	public void New_post_page_should_get_loaded_successfully() throws Throwable {
		newPostPage.ensureNewPostPageLoaded();
	}

	@When("^I enter the title \"([^\"]*)\" for an article$")
	public void I_enter_the_title_for_an_article(String title) throws Throwable {
		newPostPage.enterTitle(title);
	}

	@When("^Write the description \"([^\"]*)\" of an article$")
	public void Write_the_description_of_an_article(String description) throws Throwable {
		newPostPage.writeDescription(description);
	}

	@When("^Write the body \"([^\"]*)\" in detail$")
	public void Write_the_body_in_detail(String body) throws Throwable {
		newPostPage.writeBody(body);
	}

	@When("^Mention the tags \"([^\"]*)\"$")
	public void Mention_the_tags(String tags) throws Throwable {
		newPostPage.enterTags(tags);
	}

	@When("^Click on the Publish Article button$")
	public void Click_on_the_Publish_Article_button() throws Throwable {
		newPostPage.clickOnPublishArticle();
	}

	@Then("^The article should get published$")
	public void The_article_should_get_published() throws Throwable {
		newPostPage.ensureArticlePublished();
	}

	@Then("^The mandatory error messages should be displayed for the title, description and body$")
	public void The_mandatory_error_messages_should_be_displayed_for_the_title_description_and_body() throws Throwable {
		newPostPage.ensureMandateTitleErrorDisplayed();
		newPostPage.ensureMandateDescErrorDisplayed();
		newPostPage.ensureMandateBodyErrorDisplayed();
	}

	@Then("^The mandatory error messages should be displayed for description and body$")
	public void The_mandatory_error_messages_should_be_displayed_for_description_and_body() throws Throwable {
		newPostPage.ensureMandateDescErrorDisplayed();
		newPostPage.ensureMandateBodyErrorDisplayed();
	}

	@Then("^The mandatory error messages should be displayed only for body$")
	public void The_mandatory_error_messages_should_be_displayed_only_for_body_to() throws Throwable {
		newPostPage.ensureMandateBodyErrorDisplayed();
	}

	@When("^I click on edit article button$")
	public void I_click_on_edit_article_button() throws Throwable {
		newPostPage.clickOnEditArticle();
	}

	@When("^Edit the title \"([^\"]*)\"$")
	public void Edit_the_title(String title) throws Throwable {
		newPostPage.editTitle(title);
	}

	@When("^Edit the description \"([^\"]*)\"$")
	public void Edit_the_description(String desc) throws Throwable {
		newPostPage.editDescription(desc);
	}

	@When("^Edit the body \"([^\"]*)\"$")
	public void Edit_the_body(String body) throws Throwable {
		newPostPage.editBody(body);
	}

	@When("^Edit the tags \"([^\"]*)\"$")
	public void Edit_the_tags(String tag) throws Throwable {
		newPostPage.editTag(tag);
	}

	@Then("^On deleting the article, it should get deleted successfully$")
	public void On_deleting_the_article_it_should_get_deleted_successfully() throws Throwable {
		newPostPage.clickOnDeletetArticle();
	}

	@When("^I check the placeholder of title, description, body, tags$")
	public void I_check_the_placeholder_of_title_description_body_tags() throws Throwable {
	}

	@Then("^The placeholders should be displayed properly in New post page$")
	public void The_placeholders_should_be_displayed_properly() throws Throwable {
		newPostPage.ensurePlaceholdersDisplayed();
	}

	@Then("^The placeholders should be displayed properly in Settings page$")
	public void The_placeholders_should_be_displayed_properly_settings_page() throws Throwable {
		settingsPage.ensurePlaceholdersDisplayed();
	}

	@When("^I enter the title \"([^\"]*)\" for an article with the special characters$")
	public void I_enter_the_title_for_an_article_with_the_special_characters(String title) throws Throwable {
		newPostPage.enterTitle(title);
	}

	@When("^Write the description \"([^\"]*)\" of an article with the special characters$")
	public void Write_the_description_of_an_article_with_the_special_characters(String desc) throws Throwable {
		newPostPage.writeDescription(desc);
	}

	@When("^Write the body \"([^\"]*)\" in detail with the special characters$")
	public void Write_the_body_in_detail_with_the_special_characters(String body) throws Throwable {
		newPostPage.writeBody(body);
	}

	@When("^Mention the tags \"([^\"]*)\" with the special characters$")
	public void Mention_the_tags_with_the_special_characters(String tags) throws Throwable {
		newPostPage.enterTags(tags);
	}

	@Given("^Click on Settings link$")
	public void Click_on_Settings_link() throws Throwable {
		homePage.clickOnSettignsLink();
	}

	@Then("^Settings page should get loaded successfully$")
	public void Settings_page_should_get_loaded_successfully() throws Throwable {
		settingsPage.ensureSettingsPageDisplayed();
	}

	@When("^I check the placeholder of URL of profile picture, Username, Short bio, Email, and Password$")
	public void I_check_the_placeholder_of_URL_of_profile_picture_authorname_Short_bio_Email_and_Password()
			throws Throwable {

	}

	@Then("^The mandatory error messages should be displayed for Email and Username$")
	public void The_mandatory_error_messages_should_be_displayed_for_Email_and_authorname() throws Throwable {
		settingsPage.ensureMandateEmailErrorDisplayed();
		settingsPage.ensureMandateUsernameErrorDisplayed();
	}

	@Then("^The mandatory error messages should be displayed for Username$")
	public void The_mandatory_error_messages_should_be_displayed_for_authorname() throws Throwable {
		settingsPage.ensureMandateUsernameErrorDisplayed();
	}

	@When("^I edit URL \"([^\"]*)\" of the profile picture$")
	public void I_edit_URL_of_the_profile_picture(String urlOfPic) throws Throwable {
		settingsPage.editURLofPic(urlOfPic);
	}

	@When("^Edit Username \"([^\"]*)\"$")
	public void Edit_Username(String username) throws Throwable {
		settingsPage.editUsername(username);
	}

	@When("^Edit Short bio \"([^\"]*)\" about you$")
	public void Edit_Short_bio_about_you(String shortBio) throws Throwable {
		settingsPage.editShortBio(shortBio);
	}

	@When("^Edit Email \"([^\"]*)\" in the settings page$")
	public void Edit_Email_in_the_settings_page(String email) throws Throwable {
		settingsPage.editEmail(email);
	}

	@When("^Edit Password \"([^\"]*)\"$")
	public void Edit_Password(String password) throws Throwable {
		settingsPage.editPassword(password);
	}

	@When("^Enter Username \"([^\"]*)\" with the special character$")
	public void Enter_Username_with_the_special_character(String username) throws Throwable {
		settingsPage.enterUsername(username);
	}

	@When("^Enter Short bio \"([^\"]*)\" about you with the special character$")
	public void Enter_Short_bio_about_you_with_the_special_character(String shortBio) throws Throwable {
		settingsPage.enterShortBio(shortBio);
	}

	@When("^Enter Email \"([^\"]*)\" in the settings page with the special character$")
	public void Enter_Email_in_the_settings_page_with_the_special_character(String email) throws Throwable {
		settingsPage.enterEmail(email);
	}

	@When("^Enter Password \"([^\"]*)\" with the special character$")
	public void Enter_Password_with_the_special_character(String password) throws Throwable {
		settingsPage.enterPassword(password);
	}

	@When("^Edit Password \"([^\"]*)\" with less tham minimum allowed characters$")
	public void Edit_Password_with_less_tham_minimum_allowed_characters(String password) throws Throwable {
		settingsPage.enterPassword(password);
	}

	@Then("^The minimum allowed characters error message for password should be displayed$")
	public void The_minimum_allowed_characters_error_message_should_be_displayed() throws Throwable {
		settingsPage.ensureMinAllowedCharPasswordErrorDisplayed();
	}

	@When("^I click on logout$")
	public void I_click_on_logout() throws Throwable {
		settingsPage.clickLogoutButton();
	}

	@Then("^I should get logged out of the application$")
	public void I_should_get_logged_out_of_the_application() throws Throwable {
		settingsPage.ensureLoggedOut();
	}

	@When("^I enter URL \"([^\"]*)\" of the profile picture$")
	public void I_enter_URL_of_the_profile_picture(String urlOfPic) throws Throwable {
		settingsPage.enterURLofProfilePic(urlOfPic);
	}

	@When("^Enter Username \"([^\"]*)\"$")
	public void Enter_username(String username) throws Throwable {
		settingsPage.enterUsername(username);
	}

	@When("^Enter Short bio \"([^\"]*)\" about you$")
	public void Enter_Short_bio_about_you(String shortBio) throws Throwable {
		settingsPage.enterShortBio(shortBio);
	}

	@When("^Enter Email \"([^\"]*)\"$")
	public void Enter_Email(String email) throws Throwable {
		settingsPage.enterEmail(email);
	}

	@When("^Enter Password \"([^\"]*)\"$")
	public void Enter_Password(String password) throws Throwable {
		settingsPage.enterPassword(password);
	}

	@When("^Click Sign Up$")
	public void Click_sign_up() throws Throwable {
		loginPage.clickSubmit();
	}

	@When("^Click on the Update Settings button$")
	public void Click_on_the_Update_Settings_button() throws Throwable {
		settingsPage.clickUpdateSettingsButton();
	}

	@Then("^The settings should get updated$")
	public void The_settings_should_get_updated() throws Throwable {
		settingsPage.ensureSettingsUpdated();
	}

	@Then("^Navigate to next pages and ensure the articles which contains the popular tag are loaded$")
	public void Navigate_to_next_pages_and_ensure_the_articles_which_contains_the_popular_tag_are_loaded()
			throws Throwable {
		homePage.navigateToNextPageAndEnsureArticlesLoaded();
	}

	@Then("^Navigate to next pages and ensure the global feeds are loaded$")
	public void Navigate_to_next_pages_and_ensure_the_global_feeds_are_loaded() throws Throwable {
		homePage.navigateToNextPageAndEnsureArticlesLoaded();
	}

	@Then("^Global feed only should be available after launching the application$")
	public void Global_feed_only_should_be_available_after_launching_the_application() throws Throwable {
		homePage.ensureGlobalFeedsLoaded();
	}

	@When("^I click on the like button before sign in, should not be able to like the feed$")
	public void Click_on_the_like_button_should_not_be_able_to_like_feed() throws Throwable {
		loginPage.clickLikeAndEnsureCantLikeBeforeSignIn();
	}

	@Then("^A message should be displayed to Sign In Or Sign Up to add comment on article$")
	public void A_message_should_be_displayed_to_Sign_In_Or_Sign_Up_to_add_comment_on_article() throws Throwable {
		loginPage.ensureMsgDisplayedToSignIn();
	}

	@Then("^Ensure the tags are displayed$")
	public void Ensure_tags_are_displayed() throws Throwable {
		loginPage.ensureTagsDisplayed();
	}

	@Then("^Ensure the published dates are displayed for articles$")
	public void Ensure_the_published_dates_are_displayed_for_articles() throws Throwable {
		homePage.ensurePublishedDatesDisplayed();
	}
	
	@After
	public void cleanUp() {
		driver.close();
	}
}
