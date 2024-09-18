package pages.actions;

import data.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.locators.SidebarLocators;
import utils.WaitUtils;

import java.time.Duration;

public class Sidebar extends BasePage {
    public SidebarLocators sidebar;

    public Sidebar(WebDriver driver) {
        super(driver);
        this.sidebar = new SidebarLocators();
    }

    public void clickOnTransactions() {
        sidebar.transactionsButton.click();
    }

    public void gotoPayins() {
        log.info("Clicking on Transactions ---> Payins");
        sidebar.transactionsButton.click();
        sidebar.payinsButton.click();

        try {
            WaitUtils.waitUntilUrlContains("payins", 5);
        } catch (Throwable t) {
            log.info("Exception caught in Catch block");
        } finally {
            log.info("Redirected to: {}", Page.getUrl());
        }
    }

    public void expandSidebar() {
        log.info("Clicking on expand sidebar button");
        sidebar.expandSidebarButton.click();
        WaitUtils.waitUntilElementDisplayed(sidebar.expandedSidebar, 7);
    }
}
