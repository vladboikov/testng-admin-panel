package pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static data.base.BasePage.driver;

public class FilterLocators {

    public FilterLocators() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[text()='Фильтры']")
    public WebElement filterButton;

    @FindBy(xpath = "//input[@id='q_id_eq']")
    public WebElement filterByIdInput;
}
