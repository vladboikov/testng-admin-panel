package pages.actions;

import base.BasePage;
import base.Credentials;
import base.Roles;
import org.openqa.selenium.WebDriver;
import pages.locators.SignInPageLocators;

public class SignInPage extends BasePage {

    public SignInPageLocators signInLocators;
    public final Roles role;

    public SignInPage(WebDriver driver, Roles role) {
        super(driver);
        this.role = role;
        this.signInLocators = new SignInPageLocators();
    }

    public void doLogin() {
        if(this.role.equals(Roles.ADMIN)) {
            signInLocators.emailInput.sendKeys(Credentials.AdminEmail);
            signInLocators.passwordInput.sendKeys(Credentials.AdminPassword);
            signInLocators.signInButton.click();
        }
    }
}
