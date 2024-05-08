package regression;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class regTests1 extends BaseTest {

    @Test(priority = 1, groups = "rty", enabled = false)
    public void doLogin() {
        SoftAssert softAssert = new SoftAssert();
        driver.navigate().to("https://staging3.dfpay.dev/users/sign_in");

        softAssert.assertEquals(15, 16);

        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "https://staging3.dfpay.dev/users/sign_in");

        softAssert.assertAll();
    }
}
