package com.tcs.rbc.appium.poc.automation.testcases;

import java.io.File;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.tcs.rbc.appium.poc.automation.utils.LogLevel;
import com.tcs.rbc.appium.poc.automation.utils.LogManager;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class TestBase {

	protected AndroidDriver<MobileElement> driver;
	@Parameters(value = { "browserName", "platform", "udid", "URL", "deviceName", "appActivity", "appPackage" })
	@BeforeClass
	protected void createAppiumDriver(String browserName, String platform, String udid, String URL, String deviceName,
			String appActivity, String appPackage) throws MalformedURLException, InterruptedException {

		final File app = new File(System.getProperty("user.dir") + "/resources/Apps/Amazon.apk");
		LogManager.getLogger().Log("Ceatting Driver", LogLevel.INFO);
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.BROWSER_NAME, browserName);
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, platform);
		caps.setCapability(MobileCapabilityType.UDID, udid);
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
		caps.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, appPackage);
		caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, appActivity);
		LogManager.getLogger().Log("initializing driver object", LogLevel.INFO);
		driver = new AndroidDriver<MobileElement>(new URL(URL), caps);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		LogManager.getLogger().Log("initializing driver object successful", LogLevel.INFO);

	}

	@AfterClass
	protected void tearDown() {
		LogManager.getLogger().Log("quiting driver", LogLevel.INFO);
		driver.quit();
		LogManager.getLogger().Log("quiting driver successful", LogLevel.INFO);
	}

	public AndroidDriver<MobileElement> getDriver() {
		return driver;
	}

	

	@AfterMethod
	protected void testOnFinish(Method method) {
		LogManager.getLogger().Log(method.getName() + " execution completed", LogLevel.INFO);
	}

}
