package pages.actions;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import pages.locators.FilterLocators;

public class Filter extends BasePage {

    public FilterLocators filter;

    public Filter(WebDriver driver) {
        super(driver);
        this.filter = new FilterLocators();
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    @FindBy(xpath = "//button[text()='Фильтры']")
    public WebElement filterButton;
}
