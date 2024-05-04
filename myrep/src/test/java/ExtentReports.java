import base.TestBase;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class ExtentReports extends TestBase {

    @Test
    public void simpleTest() {
        test = extent.createTest("Simple Test");
        System.out.println("Executing Simple Test");
    }

    @Test
    public void anotherTest() {
        test = extent.createTest("Another Test");
        System.out.println("Executing Another Test");
    }

    @Test
    public void failTest() {
        driver.navigate().to("https://google.com");
        test = extent.createTest("Fail Test");
        Assert.fail("Test Failed");
        System.out.println("Executing Fail Test");
    }

    @Test
    public void skippedTest() {
        test = extent.createTest("Skipped Test");
        throw new SkipException("Skipping the Test Case");
    }
}
