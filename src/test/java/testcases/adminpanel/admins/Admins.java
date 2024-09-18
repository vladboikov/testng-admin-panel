package testcases.adminpanel.admins;

import base.BaseTest;
import data.UserRole;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.actions.Filter;
import pages.actions.Scopes;
import pages.actions.Sidebar;
import pages.locators.DashboardPageLocators;
import pages.locators.FilterLocators;
import pages.locators.SidebarLocators;
import pages.locators.TableLocators;
import static pages.actions.SignInPage.doLogin;

public class Admins extends BaseTest {

    @BeforeMethod
    public void beforeMethodActions() {
        doLogin(driver, UserRole.ADMIN);
    }

    @Epic("Admin Panel")
    @Description("Admin Login test")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void loginByAdmin() {
        DashboardPageLocators dashboard = new DashboardPageLocators();
        Assert.assertTrue(dashboard.sidebar.isDisplayed());
    }

    @Epic("Admin Panel")
    @Description("Expanding Sidebar test")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void expandSidebar() {
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
        Sidebar sidebar = new Sidebar(driver);
        Filter filter = new Filter(driver);
        Scopes scopes = new Scopes(driver);

        sidebar.expandSidebar();
        sidebar.gotoPayins();
        filter.openFilter();
        scopes.clickOnAllScope();
        filter.filterById();

        Assert.assertEquals(new TableLocators().getId(0), filter.getPayinId());
    }
}
