package com.tcs.rbc.appium.poc.automation.report;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.LogStatus;
import com.tcs.rbc.appium.poc.automation.testcases.TestBase;
import com.tcs.rbc.appium.poc.automation.utils.LogLevel;
import com.tcs.rbc.appium.poc.automation.utils.LogManager;
import com.tcs.rbc.appium.poc.automation.utils.SendReportInEmail;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class TestListener extends TestBase implements ITestListener {

	private static String getTestMethodName(ITestResult iTestResult) {
		return iTestResult.getMethod().getConstructorOrMethod().getName();
	}

	public void onStart(ITestContext iTestContext) {
		LogManager.getLogger().Log("I am in onStart method " + iTestContext.getName(), LogLevel.INFO);
		iTestContext.setAttribute("WebDriver", this.driver);
	}

	public void onFinish(ITestContext iTestContext) {
		LogManager.getLogger().Log("I am in onFinish method " + iTestContext.getName(), LogLevel.INFO);
		ExtentTestManager.endTest();
		ExtentManager.getReporter().flush();
		SendReportInEmail.sendMail();
	}

	public void onTestStart(ITestResult iTestResult) {
		LogManager.getLogger().Log("I am in onTestStart method " + getTestMethodName(iTestResult) + " start",
				LogLevel.INFO);
		ExtentTestManager.startTest(iTestResult.getMethod().getMethodName(), "");
	}

	public void onTestSuccess(ITestResult iTestResult) {
		LogManager.getLogger().Log("I am in onTestSuccess method " + getTestMethodName(iTestResult) + " succeed",
				LogLevel.INFO);
		ExtentTestManager.getTest().log(LogStatus.PASS, "Test passed");
	}

	public void onTestFailure(ITestResult iTestResult) {
		LogManager.getLogger().Log("I am in onTestFailure method " + getTestMethodName(iTestResult) + " failed",
				LogLevel.INFO);

		Object testClass = iTestResult.getInstance();
		AndroidDriver<MobileElement> webDriver = ((TestBase) testClass).getDriver();

		String base64Screenshot = "data:image/png;base64,"
				+ ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BASE64);

		ExtentTestManager.getTest().log(LogStatus.FAIL, "Test Failed",
				ExtentTestManager.getTest().addBase64ScreenShot(base64Screenshot));
	}

	public void onTestSkipped(ITestResult iTestResult) {
		LogManager.getLogger().Log("I am in onTestSkipped method " + getTestMethodName(iTestResult) + " skipped",
				LogLevel.INFO);
		ExtentTestManager.getTest().log(LogStatus.SKIP, "Test Skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
		LogManager.getLogger().Log("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult),
				LogLevel.INFO);
	}

}
