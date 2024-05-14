package pages.actions;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.locators.SidebarLocators;

import java.time.Duration;

public class Sidebar extends BasePage {

    Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    public SidebarLocators sidebar;

    public Sidebar(WebDriver driver) {
        super(driver);
        this.sidebar = new SidebarLocators();

    }

    public void nothing() {
        
    }

    public void clickOnTransactions() {
        sidebar.transactionsButton.click();
    }

    public void gotoPayins() {
        log.info("Clicking on Transactions ---> Payins");
        sidebar.transactionsButton.click();
        sidebar.payinsButton.click();

        try {
            wait.until(d -> Page.getUrl().contains("payins"));
        } catch (Throwable t) {
            log.info("Exception caught in Catch block");
        } finally {
            log.info("Redirected to: " + Page.getUrl());
        }
    }

    public void expandSidebar() {
        log.info("Clicking on expand sidebar button");
        sidebar.expandSidebarButton.click();
    }
}
