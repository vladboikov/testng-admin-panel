package pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static data.base.BasePage.driver;

public class DashboardPageLocators {

    public DashboardPageLocators() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@id='sidebar']")
    public WebElement sidebar;
}
