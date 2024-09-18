package pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import static data.base.BasePage.driver;

public class SidebarLocators {

    public SidebarLocators() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()= \"Транзакции\"]/ancestor::a")
    public WebElement transactionsButton;

    @FindBy(xpath = "//li[contains(@class,\"cursor-pointer\")]//div/ul[not(contains(@class, 'hidden'))]//span[text()='Платежи']")
    public WebElement payinsButton;

    @FindBy(xpath = "//span[contains(text(), 'Expand')]/ancestor::button")
    public WebElement expandSidebarButton;

    @FindBy(xpath = "//body[contains(@class, 'sidebar-expanded')]")
    public WebElement expandedSidebar;
}
