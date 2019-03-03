import model.Article;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class CommentCountTest {
    private final String URL = "http://rus.delfi.lv";

    private final By ARTICLE = By.tagName("article");
    private final By TITLE = By.tagName("h1");
    private final By COMMENT_COUNTER = By.xpath(".//a[contains(@class, 'text-red')]");

    @Test
    public void commentCountCheck() {
        System.setProperty("webdriver.gecko.driver", "c:/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();

        driver.get(URL);

        List<WebElement> articles = driver.findElements(ARTICLE);

        Article article = getArticle(articles, 5);
    }

    private Article getArticle(List<WebElement> elements, int i) {
        WebElement article = elements.get(i);

        Article currentArticle = new Article();
        currentArticle.setTitle(article.findElement(TITLE).getText());

        List<WebElement> commentCounters = article.findElements(COMMENT_COUNTER);

        if (commentCounters.isEmpty()) {
            currentArticle.setCommentCount(0);
        } else {
            currentArticle.setCommentCount(commentCounters.get(0).getText());
        }

        return currentArticle;
    }
}
