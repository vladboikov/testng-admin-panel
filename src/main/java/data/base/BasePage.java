package data.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    public static WebDriver driver;
    public static Logger log = LogManager.getLogger(BasePage.class.getName());


    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
        PageFactory.initElements(driver,this);
    }
}
