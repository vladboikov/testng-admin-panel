package pages.actions;

import data.base.BasePage;
import org.openqa.selenium.WebDriver;

public class Page extends BasePage {

    public Page(WebDriver driver) {
        super(driver);
    }

    public static String getUrl() {
        return driver.getCurrentUrl();
    }
}
