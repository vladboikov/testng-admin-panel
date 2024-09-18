package base;

import data.InstanceData;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class BaseTest {
    public static WebDriver driver;
    public static Logger log = LogManager.getLogger(BaseTest.class.getName());

    private static ChromeOptions getChromeOptions() {
        var options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("enable-automation");
        options.addArguments("--no-sandbox");
        options.addArguments("disable-dev-shm-usage");
        options.addArguments("--headless=chrome");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("disable-infobars");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--ignore-ssl-errors=yes");
        options.addArguments("disable-browser-side-navigation");
        options.addArguments("disable-gpu");
        options.addArguments("--disable-notifications");
        options.setImplicitWaitTimeout(Duration.ofSeconds(10));
        options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.IGNORE);
        return options;
    }

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        switch (InstanceData.BROWSER) {
            case "chrome":
                log.debug("Launching Chrome Browser");
                WebDriverManager.chromedriver().setup();
                Map<String, Object> prefs = new HashMap<String, Object>();
                prefs.put("profile.default_content_setting_values.notifications", 2);
                prefs.put("credentials_enable_service", false);
                prefs.put("profile.password_manager_enabled", false);
                var options = getChromeOptions();
                driver = new ChromeDriver(options);
                BrowserUtils.initialWindow = driver.getWindowHandle();
                log.debug("Chrome Browser launched successfully");
                break;
            case "firefox":
                log.debug("Launching Firefox Browser");
                WebDriverManager.firefoxdriver().setup();
                log.debug("Firefox Browser launched successfully");
                break;
            case "ie":
                log.debug("Launching IE Browser");
                WebDriverManager.iedriver().setup();
                log.debug("IE Browser launched successfully");
        }
        driver.manage().window().maximize();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }
}
