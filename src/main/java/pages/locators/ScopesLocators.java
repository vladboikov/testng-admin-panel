package pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import static data.base.BasePage.driver;

public class ScopesLocators {

    public ScopesLocators() {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    @FindBy(xpath = "//a[text()='Все']")
    public WebElement allScope;

    @FindBy(xpath = "//a[contains(@class,'text-indigo-500') and text()='Все']")
    public WebElement selectedAllScope;
}
