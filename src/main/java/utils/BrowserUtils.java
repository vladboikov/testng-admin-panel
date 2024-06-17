package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.Set;

import static data.base.BasePage.driver;

public class BrowserUtils {

    public static String initialWindow;

    public static Set<String> getAllWindows() {
        return driver.getWindowHandles();
    }

    public static void switchToFirstNewWindow() {
        var newWindows = getAllWindows().stream().filter(w -> !w.equals(initialWindow)).toList();
        driver.switchTo().window(newWindows.stream().findFirst().get());
    }

    public void switchToWindow(String windowId) {
        driver.switchTo().window(windowId);
    }

    public static void clearAndSendKeys(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    public static void hover(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    public static void pressEnterKey() {
        Actions builder = new Actions(driver);
        builder.keyDown(Keys.ENTER).build().perform();
    }

    public static void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void doubleClick(WebElement element) {
        new Actions(driver).doubleClick(element).build().perform();
    }

    public static void selectCheckBox(WebElement element, boolean check) {
        if (check) {
            if (!element.isSelected()) {
                element.click();
            }
        } else {
            if (element.isSelected()) {
                element.click();
            }
        }
    }
}
