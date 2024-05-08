package regression;

import base.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

@Epic("epic name")
@Feature("feature name")
public class AllureTest extends BaseTest {

    @Test
    @Description("Main Test")
    @Severity(SeverityLevel.CRITICAL)
    @Story("The very important test case")
    public void allureMainTest()  {
        System.out.println("Passed");
    }

    @Test
    public void allureTestSkip() {
        throw new SkipException("Skipping Test Case");
    }

    @Test
    public void allureTestFail() {
        Assert.fail("Test Failed");
    }

    @Test
    public void allureTestFail2() {
        Assert.fail("Another Test Failed");
    }
}
