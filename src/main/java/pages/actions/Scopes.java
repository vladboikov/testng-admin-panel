package pages.actions;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.locators.ScopesLocators;

import java.time.Duration;

public class Scopes extends BasePage {

    Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    public ScopesLocators scopes;

    public Scopes(WebDriver driver) {
        super(driver);
        this.scopes = new ScopesLocators();
    }

    public void clickOnAllScope() {
        scopes.allScope.click();
        wait.until(d -> scopes.selectedAllScope.isDisplayed());
    }
}
