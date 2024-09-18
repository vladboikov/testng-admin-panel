package pages.actions;

import data.base.BasePage;
import org.openqa.selenium.WebDriver;
import pages.locators.ScopesLocators;
import utils.WaitUtils;

public class Scopes extends BasePage {

    public ScopesLocators scopes;

    public Scopes(WebDriver driver) {
        super(driver);
        this.scopes = new ScopesLocators();
    }

    public void clickOnAllScope() {
        scopes.allScope.click();
        WaitUtils.waitUntilElementDisplayed(scopes.selectedAllScope, 10);
    }
}
