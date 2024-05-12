package testcases.adminpanel.admins;

import base.BaseTest;
import base.data.UserRole;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.actions.SignInPage;
import pages.locators.DashboardPageLocators;

public class Admins extends BaseTest {

    @Epic("Admin Panel")
    @Description("Admin Login Test")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void doLogin() {
        SignInPage page = new SignInPage(driver, UserRole.ADMIN);
        page.doLogin();

        DashboardPageLocators dashboard = new DashboardPageLocators();
        Assert.assertTrue(dashboard.sidebar.isDisplayed());
    }
}
