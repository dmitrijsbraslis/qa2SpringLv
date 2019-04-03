package pageObject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage {

    private final By ARTICLE_LINK = By.xpath(".//a[@class = 'text-mine-shaft']");
    private BaseFunk baseFunk;

    public HomePage(BaseFunk baseFunk) {
        this.baseFunk = baseFunk;
    }

    public void openArticleById(int id) {
        List<WebElement> article = baseFunk.getElements(ARTICLE_LINK);
        article.get(id).click();
    }
}
