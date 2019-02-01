package com.tcs.rbc.appium.poc.automation.report;

import java.io.File;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.NetworkMode;
import com.tcs.rbc.appium.poc.automation.utils.Constants;
import com.tcs.rbc.appium.poc.automation.utils.Utils;

public class ExtentManager {
	 
    private static ExtentReports extent;
 
    public synchronized static ExtentReports getReporter(){
        if(extent == null){
            //Set HTML reporting file location
            final File config = new File(System.getProperty("user.dir")+"/resources/Config/config.properties");
            extent = new ExtentReports(Utils.loadPropertyFile(config).getProperty(Constants.TEST_RESULT_PATH)+"/ExtentReportResults.html", true,NetworkMode.OFFLINE);
        }
        return extent;
    }
}
