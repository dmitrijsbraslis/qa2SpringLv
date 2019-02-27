import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ArticleTitleTest {
    private final String URL = "http://delfi.lv";

    private final By HOME_PAGE_TITLE = By.xpath(".//h1[contains(@class, 'headline__title')]");
    private final By ARTICLE_PAGE_TITLE = By.xpath(".//h1[contains(@class, 'd-inline')]");
    private final By COMMENT_COUNT = By.xpath(".//a[contains(@class, '28')]");
    private final By COMMENT_PAGE_TITLE = By.xpath(".//h1[@class = 'article-title']/a");

    private WebDriver driver;

    @Test
    public void titleCheck() {
        //Define driver path
        System.setProperty("webdriver.gecko.driver", "c:/geckodriver.exe");

        //Open Browser
        driver = new FirefoxDriver();
        driver.manage().window().maximize();

        //Open home page
        driver.get(URL);

        //Find first title
        WebElement title = driver.findElement(HOME_PAGE_TITLE);

        //Save first title
        String titleText = title.getText();

        //Click to title
        title.click();

        //Find title //Save title
        String articlePageTitle = driver.findElement(ARTICLE_PAGE_TITLE).getText();

        //Check title
        Assertions.assertEquals(titleText, articlePageTitle, "Wrong article page title!!!");

        //Find comment count //Click on it
        driver.findElement(COMMENT_COUNT).click();

        //Find title //Save title
        String commentPageTitle = driver.findElement(COMMENT_PAGE_TITLE).getText();

        //Check title
        Assertions.assertEquals(titleText, commentPageTitle, "Wrong comment page title!!!");

        //Close browser
    }

    @AfterEach
    public void closeBrowser() {
        driver.close();
    }
}
