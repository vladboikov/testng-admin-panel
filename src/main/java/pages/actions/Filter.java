package pages.actions;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.locators.FilterLocators;
import pages.locators.ScopesLocators;
import pages.locators.TableLocators;
import utils.BrowserUtils;

import java.time.Duration;

public class Filter extends BasePage {

    Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    public FilterLocators filter;
    public ScopesLocators scopes;
    public TableLocators table;
    public static final String payinId = "34c3bad1-581a-4e42-8ae3-5384900af9cc";

    public Filter(WebDriver driver) {
        super(driver);
        this.filter = new FilterLocators();
        this.scopes = new ScopesLocators();
        this.table = new TableLocators();
    }

    public void openFilter() {
        log.info("Clicking on Filters button");
        filter.filterButton.click();
    }

    public void filterById() {
        log.info("Filtering by payin id");
        filter.filterByIdInput.sendKeys(payinId);
        BrowserUtils.pressEnterKey();
        wait.until(d -> table.id.getText().equals(payinId));
    }

    public String getPayinId() {
        return payinId;
    }
}
