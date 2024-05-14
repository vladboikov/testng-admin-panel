package base;

import base.data.InstanceData;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class BaseTest {

    public static WebDriver driver;
    public static String initialWindow;
    public static Logger log = LogManager.getLogger(BaseTest.class.getName());


    public static Set<String> getAllWindows() {
        return driver.getWindowHandles();
    }

    public static void switchToFirstNewWindow() {
        var newWindows = getAllWindows().stream().filter(w -> !w.equals(initialWindow)).collect(Collectors.toList());
        driver.switchTo().window(newWindows.stream().findFirst().get());
    }

    public void switchToWindow(String windowId) {
        driver.switchTo().window(windowId);
    }

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        if (InstanceData.BROWSER.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            log.debug("Launching Firefox Browser");
        } else if (InstanceData.BROWSER.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            Map<String, Object> prefs = new HashMap<String, Object>();
            prefs.put("profile.default_content_setting_values.notifications", 2);
            prefs.put("credentials_enable_service", false);
            prefs.put("profile.password_manager_enabled", false);

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
            options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.IGNORE);
            driver = new ChromeDriver(options);
            initialWindow = driver.getWindowHandle();
            for (String winHandle : driver.getWindowHandles()) {
                driver.switchTo().window(winHandle);
            }
            log.debug("Launching Chrome Browser");
        } else if (InstanceData.BROWSER.equals("ie")) {
            WebDriverManager.iedriver().setup();
            log.debug("Launching IE Browser");
        }
        driver.manage().window().maximize();
        driver.get(InstanceData.TEST_SUITE_URL);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}
