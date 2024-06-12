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
    DashboardPageLocators dashboard;
    Sidebar sidebar;
    Filter filter;
    Scopes scopes;

    @BeforeMethod
    public void beforeMethodActions() {
        SignInPage.doLogin(driver, UserRole.ADMIN);
    }

    @Epic("Admin Panel")
    @Description("Admin Login test")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void loginByAdmin() {
        dashboard = new DashboardPageLocators();
        Assert.assertTrue(dashboard.sidebar.isDisplayed());
    }

    @Epic("Admin Panel")
    @Description("Expanding Sidebar test")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void expandSidebar() {
        sidebar = new Sidebar(driver);
        sidebar.expandSidebar();
        sidebar.clickOnTransactions();

        Assert.assertTrue(new SidebarLocators().payinsButton.isDisplayed());
    }

    @Epic("Admin Panel")
    @Description("Opening Payins page test")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void openPayins() {
        sidebar = new Sidebar(driver);
        sidebar.expandSidebar();
        sidebar.gotoPayins();

        Assert.assertTrue(new FilterLocators().filterButton.isDisplayed());
    }

    @Epic("Admin Panel")
    @Description("Filtering payins by id")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void filterPayinsById() {
        sidebar = new Sidebar(driver);
        filter = new Filter(driver);
        scopes = new Scopes(driver);

        sidebar.expandSidebar();
        sidebar.gotoPayins();
        filter.openFilter();
        scopes.clickOnAllScope();
        filter.filterById();

        Assert.assertEquals(new TableLocators().getId(), filter.getPayinId());
    }
}
