package pages.actions;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import pages.locators.SignInPageLocators;

public class SignInPage extends BasePage {

    public SignInPageLocators signInLocators;

    public SignInPage(WebDriver driver) {
        super(driver);
        this.signInLocators = new SignInPageLocators();
    }

    public void doLogin() {
        signInLocators.emailInput.sendKeys("admin@admin.admin");
        signInLocators.passwordInput.sendKeys("12345678");
        signInLocators.signInButton.click();
    }
}
