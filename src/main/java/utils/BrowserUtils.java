package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;

import static data.base.BasePage.driver;
import static data.base.BasePage.log;

public class BrowserUtils {
    public static String initialWindow;

    public static void switchToWindow(int index) {
        log.info("Switching to window");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(index));
    }

    public static void openNewTab(WebDriver driver) {
        log.info("Opening a new browser tab");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open('about:blank','_blank');");
    }

    public static void closeBrowserTab() {
        log.info("Closing current tab");
        driver.close();
    }

    public static void closeAllExceptCurrentTab(WebDriver driver) {
        log.info("Closing all tabs except current tab");
        String currentHandle = driver.getWindowHandle();

        for (String handle : driver.getWindowHandles()) {
            try {
                driver.switchTo().window(handle);
                if (!handle.equals(currentHandle)) {
                    driver.close();
                }
            } catch (Exception e) {
                //
            }
        }
        driver.switchTo().window(currentHandle);
    }

    public static void clearAndSendKeys(WebElement element, String text) {
        log.info("Clearing input");
        element.clear();
        log.info("Entering new text: {}", text);
        element.sendKeys(text);
    }

    public static void hover(WebElement element, WebDriver driver) {
        log.info("Hover at {}", element);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    public static void pressEnterKey() {
        log.info("Pressing ENTER key");
        Actions builder = new Actions(driver);
        builder.keyDown(Keys.ENTER).build().perform();
    }

    public static void refreshPage() {
        log.info("Refreshing current page");
        driver.navigate().refresh();
    }

    public static void scrollToElement(WebElement element) {
        log.info("Scrolling to element: {}", element);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void doubleClick(WebElement element) {
        log.info("Performing DOUBLE CLICK");
        new Actions(driver).doubleClick(element).build().perform();
    }

    public static void selectCheckBox(WebElement element, boolean check) {
        log.info("Selecting Checkbox");
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
