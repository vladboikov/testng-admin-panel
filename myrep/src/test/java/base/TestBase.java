package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.Set;
import java.util.stream.Collectors;

public class TestBase {
    protected static WebDriver driver;
    protected WebDriverWait wait;
    public static String initialWindow;
    public static Logger log;

    public WebDriver getDriver(String browser) {
        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        return driver;
    }

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

    @BeforeSuite(alwaysRun = true)
    public void setUp() throws InterruptedException {
        var options = new ChromeOptions();

        options.addArguments("start-maximized");
        options.addArguments("enable-automation");
        options.addArguments("--no-sandbox");
        options.addArguments("disable-dev-shm-usage");
//        options.addArguments("--headless=chrome");
//        options.addArguments("--window-size=2560,1440");
        options.addArguments("disable-infobars");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("disable-browser-side-navigation");
        options.addArguments("disable-gpu");
        options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.IGNORE);
        driver = new ChromeDriver(options);
        initialWindow = driver.getWindowHandle();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        Thread.sleep(2000);
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
//        Thread.sleep(2000);
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
