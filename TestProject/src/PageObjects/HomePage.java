package PageObjects;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	@FindBy(how = How.XPATH, using = "//div[@class='tag-list']//a")
	private WebElement tagsList;

	@FindBy(how = How.XPATH, using = "//p[text()='Popular Tags']")
	private WebElement popularTags;

	@FindBy(how = How.XPATH, using = "//a[@class='nav-link' and text()='Home']")
	private WebElement homeLink;

	@FindBy(how = How.XPATH, using = "//img[@class='user-pic']")
	private WebElement userPic;

	@FindBy(how = How.XPATH, using = "//a[@class='nav-link active']")
	private WebElement yourFeed;

	@FindBy(how = How.XPATH, using = "//a[@class='nav-link' and text()='Global Feed']")
	private WebElement globalFeed;

	@FindBy(how = How.XPATH, using = "//textarea[@class='form-control']")
	private WebElement commentForm;

	@FindBy(how = How.XPATH, using = "//button[@type='submit']")
	private WebElement postComment;

	@FindBy(how = How.XPATH, using = "//div[@class='container']//h1")
	private WebElement articleName;

	@FindBy(how = How.CLASS_NAME, using = "article-preview")
	private List<WebElement> articlePreview;

	@FindBy(how = How.CLASS_NAME, using = "btn btn-sm btn-outline-primary")
	private List<WebElement> likeButton;

	@FindBy(how = How.XPATH, using = "//span[text()='Read more...']")
	private WebElement readMoreLink;

	@FindBy(how = How.CLASS_NAME, using = "form-control")
	private WebElement commentTextBox;

	@FindBy(how = How.CLASS_NAME, using = "card-block")
	private List<WebElement> commentsBlock;

	@FindBy(how = How.CLASS_NAME, using = "ion-trash-a")
	private WebElement deleteComment;

	@FindBy(how = How.CLASS_NAME, using = "author")
	private WebElement authorNameLink;

	@FindBy(how = How.CLASS_NAME, using = "ion-plus-round")
	private WebElement followButton;

	@FindBy(how = How.XPATH, using = "//a[text()='My Articles']")
	private WebElement myArticlesLink;

	@FindBy(how = How.XPATH, using = "//a[text()='Favorited Articles']")
	private WebElement favoriteArticles;

	@FindBy(how = How.CLASS_NAME, using = "user-info")
	private WebElement userInfo;

	@FindBy(how = How.CLASS_NAME, using = "tag-default tag-pill")
	private WebElement popularTag;

	@FindBy(how = How.XPATH, using = "//a[text()='conduit']")
	private WebElement appTitle;

	@FindBy(how = How.XPATH, using = "//a[@class='nav-link' and contains(text(),'New Post')]")
	private WebElement newPostLink;

	@FindBy(how = How.XPATH, using = "//a[@class='nav-link' and contains(text(),'Settings')]")
	private WebElement settingsLink;

	@FindBy(how = How.XPATH, using = "//a[contains(@href,'#@')]")
	private WebElement myProfileLink;

	@FindBy(how = How.CLASS_NAME, using = "page-link")
	private List<WebElement> nextPages;

	@FindBy(how = How.XPATH, using = "//a[text()='Your Feed']//following::div[@class='article-preview']")
	private List<WebElement> yourFeeds;

	@FindBy(how = How.XPATH, using = "//a[text()='Global Feed']//following::div[@class='article-preview']")
	private List<WebElement> globalFeeds;

	@FindBy(how = How.XPATH, using = "//i[@class='ion-pound']//following::div[@class='article-preview']")
	private List<WebElement> popularTagFeeds;

	@FindBy(how = How.XPATH, using = "//a[text()='My Articles']//following::div[@class='article-preview']")
	private List<WebElement> myArticles;

	@FindBy(how = How.XPATH, using = "//a[text()='Favorited Articles']//following::div[@class='article-preview']")
	private List<WebElement> favoriteArticlesList;

	@FindBy(how = How.CLASS_NAME, using = "date")
	private List<WebElement> dates;

	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void verifyTitle() {
		assertTrue("Application title is not displayed.", appTitle.isDisplayed());
	}

	public void ensureFeedsLoaded() {
		assertTrue("Feeds are not displayed.", articlePreview.size() > 0);
	}

	public void ensureMyArticlesLoaded() {
		assertTrue("Articles under My articles section are not displayed.", myArticles.size() > 0);
	}

	public void ensureFavoriteArticlesLoaded() {
		assertTrue("Articles under Favourite articles section are not displayed.", favoriteArticlesList.size() > 0);
	}

	public void ensureYourFeedsLoaded() {
		assertTrue("Articles under Your feeds section are not displayed.", yourFeeds.size() > 0);
	}

	public void ensureGlobalFeedsLoaded() {
		assertTrue("Articles under Global feeds section are not displayed.", globalFeeds.size() > 0);
	}

	public void ensurePopularTagFeedsLoaded() {
		assertTrue("Articles under Popular tags section are not displayed.", popularTagFeeds.size() > 0);
	}

	public void clickDisLikeAndEnsure() {
		for (WebElement element : likeButton) {
			int currentLikeCount = Integer.parseInt(element.getText());
			element.click();
			assertTrue(Integer.parseInt(element.getText()) == currentLikeCount - 1);
		}
	}

	public void clickLikeButtonAndEnsure() {
		for (WebElement element : likeButton) {
			int currentLikeCount = Integer.parseInt(element.getText());
			element.click();
			assertTrue(Integer.parseInt(element.getText()) == currentLikeCount + 1);
		}
	}

	public void clickReadMoreLink() {
		readMoreLink.click();
	}

	public void writeCommentAndPost(String comment) {
		int commentsCount = commentsBlock.size();
		commentTextBox.sendKeys(comment);
		postComment.click();
		assertTrue("Comment is not posted.", commentsBlock.size() == commentsCount + 1);
	}

	public void clickOnGlobalFeedLink() {
		globalFeed.click();
	}

	public void deleteCommentAndEnsure() {
		int commentsCount = commentsBlock.size();
		deleteComment.click();
		assertTrue("Comment is not deleted.", commentsBlock.size() == commentsCount - 1);
	}

	public void clickOnAuthorNameAndEnsure() {
		String authorName = authorNameLink.getText();
		authorNameLink.click();
		assertTrue("You might not navigated to author's profile.", userInfo.getText().contains(authorName));
	}

	public void clickOnMyArticles() {
		myArticlesLink.click();
	}

	public void clickOnFavoriteArticles() {
		favoriteArticles.click();
	}

	public void clickOnFollowButtonAndEnsure() {
		followButton.click();
		assertTrue(followButton.getText().contains("Unfollow"));
	}

	public void clickOnUnfollowButtonAndEnsure() {
		followButton.click();
		assertTrue(followButton.getText().contains("Follow"));
	}

	public void clickOnpopularTag() {
		popularTag.click();
	}

	public void clickOnNewPostLink() {
		newPostLink.click();
	}

	public void clickOnSettignsLink() {
		settingsLink.click();
	}

	public void clickOnMyProfileLink() {
		myProfileLink.click();
	}

	public void ensureLoginSucceeded() {
		assertTrue("Login is not succeeded.", myProfileLink.isDisplayed());
	}

	public void navigateToNextPageAndEnsureArticlesLoaded() {
		for (WebElement element : nextPages) {
			element.click();
			ensureFeedsLoaded();
		}
	}

	public void ensurePublishedDatesDisplayed() {
		for (WebElement element : dates) {
			assertTrue("The published date is not displayed for Article.", element.isDisplayed());
		}
	}
}
