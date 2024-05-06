package listeners;

import io.qameta.allure.Allure;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;


public class CustomListeners implements ITestListener {
    public InputStream is;

    @Override
    public void onTestStart(ITestResult result) {
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        String methodName = result.getMethod().getMethodName();
        String logText = "<b>" + "TEST CASE: " + methodName.toUpperCase() + " PASSED" + "</b>";
    }

    @Override
    public void onTestFailure(ITestResult result) {
        try {
            is = new FileInputStream("E:\\NewProject\\screenshot.jpg");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Allure.addAttachment("Screenshot", is);
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
