package com.tcs.rbc.appium.poc.automation.testStep;

import com.tcs.rbc.appium.poc.automation.pageobject.HomeScreen;
import com.tcs.rbc.appium.poc.automation.utils.LogLevel;
import com.tcs.rbc.appium.poc.automation.utils.LogManager;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class HomeScreenTestStep {
	AndroidDriver<MobileElement> driver=null;
	HomeScreen homeScreen = null;
	public HomeScreenTestStep(AndroidDriver<MobileElement> driver) {
		
		LogManager.getLogger().Log("initializing pageObject instance", LogLevel.INFO);
		this.driver=driver;
		homeScreen = new HomeScreen(this.driver);

	}
	public void navigateToHomeScreen() {
		homeScreen.clickSkipSignInButton();
	}
	
	public ElectronicsDepartmentTestStep navigateToElectronicsDepartment() {
		homeScreen.clickActionBarBurgerIcon();
		homeScreen.clickShopByDepartment();
		homeScreen.clickElectronicsDepartment();
		return new ElectronicsDepartmentTestStep(driver);
	}

}
