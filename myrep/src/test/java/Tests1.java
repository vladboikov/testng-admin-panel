import base.TestBase;
import org.apache.logging.log4j.LogManager;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Tests1 extends TestBase {


    @Test(priority = 2, groups = {"smoke", "login"})
    public void doLogin2() {
        System.setProperty("org.uncommons.reportng.escape-output", "false");
        Reporter.log("<a href=\"E:\\NewProject\\screenshot.jpg\" target=\"_blank\">Screenshot link");
        Reporter.log("<br>");
        Reporter.log("<a href=\"E:\\NewProject\\screenshot.jpg\" target=\"_blank\"><img height=150 width=150 src=\"E:\\NewProject\\screenshot.jpg\">");

        log = LogManager.getLogger(TestLog4J.class);

        SoftAssert softAssert = new SoftAssert();
        driver.navigate().to("https://staging3.dfpay.dev/users/sign_in");

        softAssert.assertEquals(16, 16);

        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "https://staging3.dfpay.dev/users/sign_in");

        softAssert.assertAll();
    }

    @Test(priority = 1,
            groups = {"smoke", "login"},
            dependsOnMethods = "doLogin2")
    public void doLogin1() {
        System.setProperty("org.uncommons.reportng.escape-output", "false");
        Reporter.log("<a href=\"E:\\NewProject\\screenshot.jpg\" target=\"_blank\">Screenshot link");
        Reporter.log("<br>");
        Reporter.log("<a href=\"E:\\NewProject\\screenshot.jpg\" target=\"_blank\"><img height=150 width=150 src=\"E:\\NewProject\\screenshot.jpg\">");
        SoftAssert softAssert = new SoftAssert();
        driver.navigate().to("https://staging3.dfpay.dev/users/sign_in");

        softAssert.assertEquals(16, 16);

        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "https://staging3.dfpay.dev/users/sign_in");

        softAssert.assertAll();
    }

    @Test(priority = 1,
            groups = {"smoke", "login"},
            alwaysRun = true)
    public void doLogin3() {
        log = LogManager.getLogger(TestLog4J.class);

        SoftAssert softAssert = new SoftAssert();
        driver.navigate().to("https://staging3.dfpay.dev/users/sign_in");

        softAssert.assertEquals(16, 16);

        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "https://staging3.dfpay.dev/users/sign_in");

        softAssert.assertAll();
    }
}
