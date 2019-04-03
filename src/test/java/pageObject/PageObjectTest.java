package pageObject;

import org.junit.jupiter.api.Test;
import pageObject.pages.BaseFunk;
import pageObject.pages.HomePage;

public class PageObjectTest {

    private BaseFunk baseFunk = new BaseFunk();
    private final String URL = "delfi.lv";

    @Test
    public void pageObjectCheck() {
        baseFunk.goToUrl(URL);

        HomePage homePage = new HomePage(baseFunk);
        homePage.openArticleById(5);
    }
}
