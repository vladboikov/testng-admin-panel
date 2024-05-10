package pages.actions;

import base.BasePage;
import base.data.Credentials;
import base.data.Roles;
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
        } else if (this.role.equals(Roles.PAYIN_OPERATOR)) {
            signInLocators.emailInput.sendKeys(Credentials.PayinOperatorEmail);
            signInLocators.passwordInput.sendKeys(Credentials.PayinOperatorPassword);
        } else if (this.role.equals(Roles.PAYOUT_OPERATOR)) {
            signInLocators.emailInput.sendKeys(Credentials.PayoutOperatorEmail);
            signInLocators.passwordInput.sendKeys(Credentials.PayoutOperatorPassword);
        } else if (this.role.equals(Roles.OFFICE_ADMIN)) {
            signInLocators.emailInput.sendKeys(Credentials.OfficeAdminEmail);
            signInLocators.passwordInput.sendKeys(Credentials.OfficeAdminPassword);
        } else if (this.role.equals(Roles.MERCHANT)) {
            signInLocators.emailInput.sendKeys(Credentials.MerchantEmail);
            signInLocators.passwordInput.sendKeys(Credentials.MerchantPassword);
        } else if (this.role.equals(Roles.SUPPORT)) {
            signInLocators.emailInput.sendKeys(Credentials.SupportEmail);
            signInLocators.passwordInput.sendKeys(Credentials.SupportPassword);
        }
        signInLocators.signInButton.click();
    }
}
