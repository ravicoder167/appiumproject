package com.tcs.rbc.appium.poc.automation.report;

import com.relevantcodes.extentreports.LogStatus;
import com.tcs.rbc.appium.poc.automation.testcases.TestBase;
import com.tcs.rbc.appium.poc.automation.utils.Constants;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
 
public class RetryHandler implements IRetryAnalyzer {
 
    private int count = 0;
 
    public boolean retry(ITestResult iTestResult) {
        if (!iTestResult.isSuccess()) {                     
            if (count < Constants.RETRY_COUNT) {                            
                count++;                                    
                iTestResult.setStatus(ITestResult.FAILURE);  
                extendReportsFailOperations(iTestResult);    
                return true;                                 
            }
        } else {
            iTestResult.setStatus(ITestResult.SUCCESS);      
        }
        return false;
    }
 
    public void extendReportsFailOperations (ITestResult iTestResult) {
        Object testClass = iTestResult.getInstance();
        AndroidDriver<MobileElement> webDriver = ((TestBase) testClass).getDriver();
        String base64Screenshot = "data:image/png;base64,"+((TakesScreenshot)webDriver).getScreenshotAs(OutputType.BASE64);
        ExtentTestManager.getTest().log(LogStatus.FAIL,"Test Failed",
                ExtentTestManager.getTest().addBase64ScreenShot(base64Screenshot));
    }
}
