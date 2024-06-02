package pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import static base.BasePage.driver;

public class FilterLocators {

    public FilterLocators() {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    @FindBy(xpath = "//button[text()='Фильтры']")
    public WebElement filterButton;

    @FindBy(xpath = "//input[@id='q_id_eq']")
    public WebElement filterByIdInput;
}
