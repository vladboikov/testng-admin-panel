package pages.actions;

import data.base.BasePage;
import org.openqa.selenium.WebDriver;
import pages.locators.DashboardPageLocators;

public class DashboardPage extends BasePage {

    public DashboardPageLocators dashboardLocators;

    public DashboardPage(WebDriver driver) {
        super(driver);
        this.dashboardLocators = new DashboardPageLocators();
    }
}
