package pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static data.base.BasePage.driver;

public class TableLocators {

    public TableLocators() {
        PageFactory.initElements(driver, this);}

    @FindBy(xpath = "//tbody/tr//span[@class='id ']")
    public List<WebElement> payinIdList;

    public String getId(int index) {
        return payinIdList.get(index).getText();
    }
}
