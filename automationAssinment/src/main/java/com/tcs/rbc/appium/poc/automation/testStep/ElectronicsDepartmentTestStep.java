package com.tcs.rbc.appium.poc.automation.testStep;



import com.tcs.rbc.appium.poc.automation.pageobject.ElectronicsDepartmentScreen;
import com.tcs.rbc.appium.poc.automation.utils.LogLevel;
import com.tcs.rbc.appium.poc.automation.utils.LogManager;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class ElectronicsDepartmentTestStep {
	AndroidDriver<MobileElement> driver=null;
	ElectronicsDepartmentScreen elcDptScreen = null;
	
	
	public  ElectronicsDepartmentTestStep(AndroidDriver<MobileElement> driver) {
		LogManager.getLogger().Log("initializing pageObject instance", LogLevel.INFO);
		this.driver=driver;
		elcDptScreen = new ElectronicsDepartmentScreen(this.driver);
	}
	
	public ProductDescriptionTestStep selectKindleProduct() {
		elcDptScreen.scrollToKindle();
		elcDptScreen.clickKindle();
		return new ProductDescriptionTestStep(driver);
	}

}
