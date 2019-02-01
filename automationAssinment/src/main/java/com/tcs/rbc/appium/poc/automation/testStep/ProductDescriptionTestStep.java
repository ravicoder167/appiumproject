package com.tcs.rbc.appium.poc.automation.testStep;

import com.tcs.rbc.appium.poc.automation.pageobject.ProductDescriptionScreen;
import com.tcs.rbc.appium.poc.automation.utils.DeviceOperation;
import com.tcs.rbc.appium.poc.automation.utils.LogLevel;
import com.tcs.rbc.appium.poc.automation.utils.LogManager;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class ProductDescriptionTestStep {
	ProductDescriptionScreen prdDescScreen = null;
	AndroidDriver<MobileElement> driver=null;
	public ProductDescriptionTestStep(AndroidDriver<MobileElement> driver) {
		LogManager.getLogger().Log("initializing pageObject instance", LogLevel.INFO);
		this.driver=driver;
		prdDescScreen = new ProductDescriptionScreen(this.driver);

	}
	public void verifyProduct() {
		prdDescScreen.waitForKindleToLoad();
		prdDescScreen.verifyProductTitle();
		prdDescScreen.verifyProductInStock();
	}
	public void navigateBackToHome(){
		DeviceOperation.clickBackMultipleTime(driver, 2);
	}


}
