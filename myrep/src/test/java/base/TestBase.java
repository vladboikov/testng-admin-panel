package base;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.github.bonigarcia.wdm.WebDriverManager;
import listeners.ExtentManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.Set;
import java.util.concurrent.TimeUnit;
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

    public ExtentSparkReporter htmlReporter;
    public com.aventstack.extentreports.ExtentReports extent;
    public ExtentTest test;

    @BeforeTest
    public void setReport() {
        htmlReporter = new ExtentSparkReporter("./reports/extent.html");
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setDocumentTitle("My report title");
        htmlReporter.config().setReportName("Automation Test Results");
        htmlReporter.config().setTheme(Theme.DARK);

        extent = new com.aventstack.extentreports.ExtentReports();
        extent.attachReporter(htmlReporter);

        extent.setSystemInfo("Automation Tester", "Vlad");
        extent.setSystemInfo("Organization", "Learning");
        extent.setSystemInfo("Build No", "1.0.0");
    }

    @AfterTest
    public void endReport() {
        extent.flush();
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {
        if(result.getStatus() == ITestResult.FAILURE) {
            String exceptionMessage = Arrays.toString(result.getThrowable().getStackTrace());
            test.fail("<details>" + "<summary>" + "<b>" + "<font color=" + "red>" + "Exception Occured: Click to see"
                    + "</font>" + "</b>" + "</summary>" + exceptionMessage.replaceAll(",", "<br>") + "</details>"
                    + " \n");
            String failureLogg = "TEST CASE FAILED";
            Markup m = MarkupHelper.createLabel(failureLogg, ExtentColor.RED);
            test.log(Status.FAIL, m);
//            test.log(Status.INFO, MediaEntityBuilder.createScreenCaptureFromBase64String(ExtentManager.takeBase64Screenshot(), "Title").build());

            String methodName = result.getName().trim();
            test.log(Status.INFO, MediaEntityBuilder.createScreenCaptureFromPath(ExtentManager.captureScreenshot(methodName), "Another Title").build());
        } else if(result.getStatus() == ITestResult.SKIP) {
            String methodName = result.getMethod().getMethodName();
            String logText = "<b>" + "TEST CASE: " + methodName.toUpperCase() + " SKIPPED" + "</b>";
            Markup m = MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
            test.skip(m);
        } else if(result.getStatus() == ITestResult.SUCCESS) {
            String methodName = result.getMethod().getMethodName();
            String logText = "<b>" + "TEST CASE: " + methodName.toUpperCase() + " PASSED" + "</b>";
            Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
            test.pass(m);
        }
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
