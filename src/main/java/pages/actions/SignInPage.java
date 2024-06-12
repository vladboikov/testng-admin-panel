package pages.actions;

import base.BasePage;
import base.data.Credentials;
import base.data.UserRole;
import org.openqa.selenium.WebDriver;
import pages.locators.SignInPageLocators;

public class SignInPage extends BasePage {

    static SignInPageLocators signInLocators;

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public static void doLogin(WebDriver driver, UserRole role) {
        new SignInPage(driver);
        signInLocators = new SignInPageLocators();

        switch (role) {
            case ADMIN:
                signInLocators.emailInput.sendKeys(Credentials.AdminEmail);
                signInLocators.passwordInput.sendKeys(Credentials.AdminPassword);
                break;
            case PAYIN_OPERATOR:
                signInLocators.emailInput.sendKeys(Credentials.PayinOperatorEmail);
                signInLocators.passwordInput.sendKeys(Credentials.PayinOperatorPassword);
                break;
            case PAYOUT_OPERATOR:
                signInLocators.emailInput.sendKeys(Credentials.PayoutOperatorEmail);
                signInLocators.passwordInput.sendKeys(Credentials.PayoutOperatorPassword);
                break;
            case OFFICE_ADMIN:
                signInLocators.emailInput.sendKeys(Credentials.OfficeAdminEmail);
                signInLocators.passwordInput.sendKeys(Credentials.OfficeAdminPassword);
                break;
            case MERCHANT:
                signInLocators.emailInput.sendKeys(Credentials.MerchantEmail);
                signInLocators.passwordInput.sendKeys(Credentials.MerchantPassword);
                break;
            case SUPPORT:
                signInLocators.emailInput.sendKeys(Credentials.SupportEmail);
                signInLocators.passwordInput.sendKeys(Credentials.SupportPassword);
                break;
        }
        signInLocators.signInButton.click();
    }
}
