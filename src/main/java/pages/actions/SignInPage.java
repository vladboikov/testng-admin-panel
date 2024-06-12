package pages.actions;

import base.BasePage;
import base.data.Credentials;
import base.data.UserRole;
import org.openqa.selenium.WebDriver;
import pages.locators.SignInPageLocators;

public class SignInPage extends BasePage {

    public static SignInPageLocators signInLocators;

    public SignInPage(WebDriver driver) {
        super(driver);
        signInLocators = new SignInPageLocators();
    }

    public static void doLogin(WebDriver driver, UserRole role) {
        new SignInPage(driver);
        if(role.equals(UserRole.ADMIN)) {
            signInLocators.emailInput.sendKeys(Credentials.AdminEmail);
            signInLocators.passwordInput.sendKeys(Credentials.AdminPassword);
        } else if (role.equals(UserRole.PAYIN_OPERATOR)) {
            signInLocators.emailInput.sendKeys(Credentials.PayinOperatorEmail);
            signInLocators.passwordInput.sendKeys(Credentials.PayinOperatorPassword);
        } else if (role.equals(UserRole.PAYOUT_OPERATOR)) {
            signInLocators.emailInput.sendKeys(Credentials.PayoutOperatorEmail);
            signInLocators.passwordInput.sendKeys(Credentials.PayoutOperatorPassword);
        } else if (role.equals(UserRole.OFFICE_ADMIN)) {
            signInLocators.emailInput.sendKeys(Credentials.OfficeAdminEmail);
            signInLocators.passwordInput.sendKeys(Credentials.OfficeAdminPassword);
        } else if (role.equals(UserRole.MERCHANT)) {
            signInLocators.emailInput.sendKeys(Credentials.MerchantEmail);
            signInLocators.passwordInput.sendKeys(Credentials.MerchantPassword);
        } else if (role.equals(UserRole.SUPPORT)) {
            signInLocators.emailInput.sendKeys(Credentials.SupportEmail);
            signInLocators.passwordInput.sendKeys(Credentials.SupportPassword);
        }
        signInLocators.signInButton.click();
    }
}
