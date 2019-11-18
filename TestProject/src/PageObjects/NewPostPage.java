package PageObjects;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class NewPostPage {

	@FindBy(how = How.XPATH, using = "//input[contains(@placeholder,'Article Title')]")
	private WebElement articleTitle;

	@FindBy(how = How.XPATH, using = "//input[contains(@placeholder,'this article about')]")
	private WebElement description;

	@FindBy(how = How.XPATH, using = "//textarea[contains(@placeholder,'Write your article')]")
	private WebElement writeArticleTextArea;

	@FindBy(how = How.XPATH, using = "//input[contains(@placeholder,'Enter tags')]")
	private WebElement enterTags;

	@FindBy(how = How.CLASS_NAME, using = "btn btn-lg pull-xs-right btn-primary")
	private WebElement publishArticle;

	@FindBy(how = How.CLASS_NAME, using = "btn btn-outline-secondary btn-sm")
	private WebElement editArticle;

	@FindBy(how = How.CLASS_NAME, using = "btn btn-outline-danger btn-sm")
	private WebElement deleteArticle;

	@FindBy(how = How.XPATH, using = "//li[text()='body']")
	private WebElement bodyErrorMsg;

	@FindBy(how = How.XPATH, using = "//li[text()='title']")
	private WebElement titleErrorMsg;

	@FindBy(how = How.XPATH, using = "//li[text()='description']")
	private WebElement descriptionErrorMsg;

	WebDriver driver;

	public NewPostPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void ensureNewPostPageLoaded() {
		assertTrue("New Post page is not loaded.", articleTitle.isDisplayed());
	}

	public void enterTitle(String title) {
		articleTitle.sendKeys(title);
	}

	public void writeDescription(String desc) {
		description.sendKeys(desc);
	}

	public void writeBody(String body) {
		articleTitle.sendKeys(body);
	}

	public void enterTags(String tags) {
		articleTitle.sendKeys(tags);
	}

	public void clickOnPublishArticle() {
		publishArticle.click();
	}

	public void ensureArticlePublished() {
		assertTrue("New Article is not published.", editArticle.isDisplayed());
	}

	public void ensureMandateTitleErrorDisplayed() {
		assertTrue("The mandatory error message for article title is not displayed.", titleErrorMsg.isDisplayed());
	}

	public void ensureMandateDescErrorDisplayed() {
		assertTrue("The mandatory error message for article description is not displayed.",
				descriptionErrorMsg.isDisplayed());
	}

	public void ensureMandateBodyErrorDisplayed() {
		assertTrue("The mandatory error message for article body is not displayed.", bodyErrorMsg.isDisplayed());
	}

	public void clickOnEditArticle() {
		editArticle.click();
	}

	public void clickOnDeletetArticle() {
		deleteArticle.click();
	}

	public void editTitle(String title) {
		articleTitle.clear();
		articleTitle.sendKeys(title);
	}

	public void editDescription(String desc) {
		description.clear();
		description.sendKeys(desc);
	}

	public void editBody(String body) {
		writeArticleTextArea.clear();
		writeArticleTextArea.sendKeys(body);
	}

	public void editTag(String tag) {
		enterTags.clear();
		enterTags.sendKeys(tag);
	}

	public void ensurePlaceholdersDisplayed() {
		assertTrue("The placeholder for Article title is not displayed.", articleTitle.isDisplayed());
		assertTrue("The placeholder for Article description is not displayed.", description.isDisplayed());
		assertTrue("The placeholder for Body of Article is not displayed.", writeArticleTextArea.isDisplayed());
		assertTrue("The placeholder for Enter tags is not displayed.", enterTags.isDisplayed());
	}
}
