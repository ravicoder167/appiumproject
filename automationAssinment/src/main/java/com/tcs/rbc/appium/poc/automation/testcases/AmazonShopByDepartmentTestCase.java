package com.tcs.rbc.appium.poc.automation.testcases;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tcs.rbc.appium.poc.automation.testStep.ElectronicsDepartmentTestStep;
import com.tcs.rbc.appium.poc.automation.testStep.HomeScreenTestStep;
import com.tcs.rbc.appium.poc.automation.testStep.ProductDescriptionTestStep;
import com.tcs.rbc.appium.poc.automation.utils.LogLevel;
import com.tcs.rbc.appium.poc.automation.utils.LogManager;

public class AmazonShopByDepartmentTestCase extends TestBase {

	HomeScreenTestStep homeScreenTestStep=null;
	@BeforeMethod
	protected void testOnStart(Method method) {
		LogManager.getLogger().Log("", LogLevel.INFO);
		homeScreenTestStep=new HomeScreenTestStep(driver);
	}

	@Test
	public void sampeTest() {
		homeScreenTestStep.navigateToHomeScreen();
		ElectronicsDepartmentTestStep edTestStep=homeScreenTestStep.navigateToElectronicsDepartment();
		 ProductDescriptionTestStep pdTestStep = edTestStep.selectKindleProduct();
		pdTestStep.verifyProduct();
		pdTestStep.navigateBackToHome();

	}

}
