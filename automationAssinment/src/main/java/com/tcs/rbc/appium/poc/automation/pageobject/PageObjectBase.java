package com.tcs.rbc.appium.poc.automation.pageobject;


import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;

import com.tcs.rbc.appium.poc.automation.model.TestConfigModel;
import com.tcs.rbc.appium.poc.automation.utils.LogLevel;
import com.tcs.rbc.appium.poc.automation.utils.LogManager;
import com.tcs.rbc.appium.poc.automation.utils.Utils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class PageObjectBase {
	protected static TestConfigModel testConfigModel;
	protected AndroidDriver<MobileElement> driver;

	protected PageObjectBase() {
		final File config = new File(System.getProperty("user.dir") + "/resources/Config/config.properties");
		testConfigModel = new TestConfigModel();
		testConfigModel.setExecutionConfig(Utils.loadPropertyFile(config));
	}

	protected void isSuccess(boolean result, String msg) {
		if(result) {
		    LogManager.getLogger().Log(msg+" successful", LogLevel.INFO); 
		}
		    else {
			    LogManager.getLogger().Log(msg+" unsucessful", LogLevel.ERROR); 
 	
		    }
		assertTrue(result, msg);

	}

	protected String getTempScreen(AndroidDriver<MobileElement> driver) {

		File dir = new File(System.getProperty("user.dir") + "/temp");
		if (!dir.exists()) {
			 LogManager.getLogger().Log("creating directory: " + dir.getName(),LogLevel.INFO);
			try {
				dir.mkdir();
			} catch (SecurityException ex) {
				 LogManager.getLogger().Log(ex,LogLevel.FATAL);
			}

		}
		String tempFilePath = dir.getAbsolutePath() + "/" + Thread.currentThread().getName() + ".png";
		File tempFile = new File(tempFilePath);
		if (tempFile.exists()) {
			tempFile.deleteOnExit();
		}
		File srcFile = driver.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, tempFile);
		} catch (IOException ex) {
			 LogManager.getLogger().Log(ex,LogLevel.FATAL);
			ex.printStackTrace();
		}
		return tempFile.getAbsolutePath();

	}
}
