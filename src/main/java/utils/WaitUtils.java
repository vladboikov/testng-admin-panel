package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import static data.base.BasePage.driver;

public class WaitUtils  {

    public static void waitForTextToBeEqual(WebElement element, String text, int timeout) {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        try {
            wait.until(d -> element.getText().equals(text));
        } catch (Exception ignored) {
        }
    }

    public static void waitUntilElementDisplayed(WebElement element, int timeout) {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(d -> element.isDisplayed());
    }

    public static void waitUntilUrlContains(String expectedSubstring, int timeout) {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));

        wait.until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return driver.getCurrentUrl().contains(expectedSubstring);
            }
        });
    }


}
