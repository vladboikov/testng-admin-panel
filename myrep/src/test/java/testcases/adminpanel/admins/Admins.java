package testcases.adminpanel.admins;

import base.BaseTest;
import base.data.Roles;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.actions.SignInPage;
import pages.locators.DashboardPageLocators;

public class Admins extends BaseTest {

    @Epic("Admin Panel")
    @Description("Admin Login Test")
    @Test
    public void doLogin() {
        SignInPage page = new SignInPage(driver, Roles.ADMIN);
        page.doLogin();
        DashboardPageLocators dashboard = new DashboardPageLocators();
        Assert.assertTrue(dashboard.sidebar.isDisplayed());
    }
}
