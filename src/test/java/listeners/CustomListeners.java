package listeners;

import base.BaseTest;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class CustomListeners extends BaseTest implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        String methodName = result.getMethod().getMethodName();
        String logText = "<b>" + "TEST CASE: " + methodName.toUpperCase() + " PASSED" + "</b>";
        log.info(logText);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Allure.getLifecycle().addAttachment(
                "Screenshot", "image/png", "png",
                ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES)
        );
        log.info("TEST FAILED");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
    }

    @Override
    public void onFinish(ITestContext context) {
    }
}
