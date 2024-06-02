package testcases.adminpanel.admins;

import base.BaseTest;
import base.data.UserRole;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.actions.Filter;
import pages.actions.Scopes;
import pages.actions.Sidebar;
import pages.actions.SignInPage;
import pages.locators.DashboardPageLocators;
import pages.locators.FilterLocators;
import pages.locators.SidebarLocators;
import pages.locators.TableLocators;

public class Admins extends BaseTest {

    private void login() {
        SignInPage page = new SignInPage(driver, UserRole.ADMIN);
        page.doLogin();
    }

    @Epic("Admin Panel")
    @Description("Admin Login test")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void loginByAdmin() {
        login();

        DashboardPageLocators dashboard = new DashboardPageLocators();
        Assert.assertTrue(dashboard.sidebar.isDisplayed());
    }

    @Epic("Admin Panel")
    @Description("Expanding Sidebar test")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void expandSidebar() {
        login();

        Sidebar sidebar = new Sidebar(driver);
        sidebar.expandSidebar();
        sidebar.clickOnTransactions();

        Assert.assertTrue(new SidebarLocators().payinsButton.isDisplayed());
    }

    @Epic("Admin Panel")
    @Description("Opening Payins page test")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void openPayins() {
        login();

        Sidebar sidebar = new Sidebar(driver);
        sidebar.expandSidebar();
        sidebar.gotoPayins();

        Assert.assertTrue(new FilterLocators().filterButton.isDisplayed());
    }

    @Epic("Admin Panel")
    @Description("Filtering payins by id")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void filterPayinsById() {
        login();

        Sidebar sidebar = new Sidebar(driver);
        sidebar.expandSidebar();
        sidebar.gotoPayins();

        Filter filter = new Filter(driver);
        filter.openFilter();

        Scopes scopes = new Scopes(driver);
        scopes.clickOnAllScope();

        filter.filterById();
        Assert.assertEquals(new TableLocators().getId(), filter.getPayinId());
    }
}
