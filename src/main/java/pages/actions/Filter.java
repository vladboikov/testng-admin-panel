package pages.actions;

import data.base.BasePage;
import org.openqa.selenium.WebDriver;
import pages.locators.FilterLocators;
import pages.locators.ScopesLocators;
import pages.locators.TableLocators;
import utils.BrowserUtils;
import utils.WaitUtils;


public class Filter extends BasePage {

    public FilterLocators filter;
    public ScopesLocators scopes;
    public TableLocators table;
    private static final String payinId = "34c3bad1-581a-4e42-8ae3-5384900af9cc";

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
        log.info("Filtering payin by id: {}", payinId);
        filter.filterByIdInput.sendKeys(payinId);
        BrowserUtils.pressEnterKey();
        WaitUtils.waitForTextToBeEqual(table.payinIdList.get(0), payinId, 10);
        log.info("Successfully filtered by id: {}", table.payinIdList.get(0).getText());
    }

    public String getPayinId() {
        return payinId;
    }
}
