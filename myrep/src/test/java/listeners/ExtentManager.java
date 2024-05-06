package listeners;

import base.TestBase;
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class ExtentManager extends TestBase {

//	private static ExtentReports extent;
//
//	public static ExtentReports createInstance(String fileName) {
//		ExtentSparkReporter htmlReporter = new ExtentSparkReporter(fileName);
//		htmlReporter.config().setEncoding("utf-8");
//		htmlReporter.config().setDocumentTitle(fileName);
//		htmlReporter.config().setReportName(fileName);
//		htmlReporter.config().setTheme(Theme.DARK);
//
//		extent = new ExtentReports();
//		extent.attachReporter(htmlReporter);
//		extent.setSystemInfo("Automation Tester", "Vlad");
//		extent.setSystemInfo("Organization", "Learning");
//		extent.setSystemInfo("Build No", "1.0.0");
//
//		return extent;
//	}

	public static String captureScreenshot(String methodName) throws IOException {

		Calendar cal = new GregorianCalendar();
		int month = cal.get(Calendar.MONTH);
		int year = cal.get(Calendar.YEAR);
		int sec = cal.get(Calendar.SECOND);
		int min = cal.get(Calendar.MINUTE);
		int date = cal.get(Calendar.DATE);
		int day = cal.get(Calendar.HOUR_OF_DAY);

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		File screenshotFile = new File(System.getProperty("user.dir") + "\\screenshot\\" + methodName + "_"
				+ year + "_" + date + "_" + (month + 1) + "_" + day + "_" + min + "_" + sec + ".jpeg");
		FileUtils.copyFile(scrFile, screenshotFile);
		return screenshotFile.getAbsolutePath();
	}

	public static String takeBase64Screenshot() {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	}
}