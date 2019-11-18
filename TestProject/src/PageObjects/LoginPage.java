package PageObjects;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	@FindBy(how = How.XPATH, using = "//a[text()='Sign up']")
	private WebElement signUpButton;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Username']")
	private WebElement userNameToSignUp;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Email']")
	private WebElement emailToSignIn;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Password']")
	private WebElement passwordToSignUp;

	@FindBy(how = How.XPATH, using = "//button[@type='submit']")
	private WebElement submit;

	@FindBy(how = How.XPATH, using = "//a[text()='Sign in']")
	private WebElement signInButton;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Username']")
	private WebElement userNameToSignIn;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Password']")
	private WebElement passwordToSignIn;

	@FindBy(how = How.XPATH, using = "//ul[@class='error-messages']")
	private WebElement errorMessage;

	@FindBy(how = How.CLASS_NAME, using = "error-messages")
	private WebElement errorMessages;

	@FindBy(how = How.XPATH, using = "//div[@class='container']//h1[@class='logo-font' and text()='conduit']")
	private WebElement appTitle;

	@FindBy(how = How.XPATH, using = "//div[@class='container']//p[text()='A place to share your knowledge.']")
	private WebElement subTitle;

	@FindBy(how = How.XPATH, using = "//div[@class='article-actions']//following::a[text()='Sign in']")
	private WebElement signInToAddComment;

	@FindBy(how = How.XPATH, using = "//a[text()='sign up']")
	private WebElement signUpToAddComment;

	@FindBy(how = How.CLASS_NAME, using = "tag-default tag-pill tag-outline")
	private List<WebElement> tags;

	@FindBy(how = How.CLASS_NAME, using = "btn btn-sm btn-outline-primary")
	private List<WebElement> likeButton;

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickSignInButton() {
		signInButton.click();
	}

	public void clickSignUpButton() {
		signUpButton.click();
	}

	public void signup(String userName, String email, String password) {
		userNameToSignUp.sendKeys(userName);
	}

	public void enterUserNamePassword(String userName, String password) {
		emailToSignIn.sendKeys(userName);
		passwordToSignIn.sendKeys(password);
		clickSubmit();
	}

	public void clickSubmit() {
		submit.click();
	}

	public void ensureLoginFailed() {
		assertTrue("Login failed.", errorMessages.isDisplayed());
	}

	public void ensureEmailAlreadyExistMsgDisplayed() {
		assertTrue("Email has already been taken error message is not displayed.", errorMessages.isDisplayed());
	}

	public void ensureErroMsgDisplayed() {
		assertTrue("Error message is not displayed.", errorMessages.isDisplayed());
	}

	public void verifyTitleSubtitle() {
		assertTrue("Application Title is not displayed.", appTitle.isDisplayed());
		assertTrue("Application subtitle is not displayed.", subTitle.isDisplayed());
	}

	public void clickLikeAndEnsureCantLikeBeforeSignIn() {
		for (WebElement element : likeButton) {
			int currentLikeCount = Integer.parseInt(element.getText());
			element.click();
			assertTrue(Integer.parseInt(element.getText()) == currentLikeCount);
		}
	}

	public void ensureMsgDisplayedToSignIn() {
		assertTrue("Message to Sign In to add comments on articles is not displayed.",
				signInToAddComment.isDisplayed());
		assertTrue("Message to Sign Up to add comments on articles is not displayed.",
				signUpToAddComment.isDisplayed());
	}

	public void ensureTagsDisplayed() {
		assertTrue("Tags are not displayed.", tags.size() > 0);
	}

}
