package utils;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import static base.BasePage.driver;

public class Utils {

    public static void pressEnterKey() {
        Actions builder = new Actions(driver);
        builder.keyDown(Keys.ENTER).build().perform();
    }
}
