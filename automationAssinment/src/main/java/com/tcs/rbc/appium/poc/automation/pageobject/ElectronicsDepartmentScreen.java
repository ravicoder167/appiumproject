package com.tcs.rbc.appium.poc.automation.pageobject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import com.tcs.rbc.appium.poc.automation.action.MobileDriverAction;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ElectronicsDepartmentScreen extends PageObjectBase {
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Kindle\")")
	private MobileElement Productelement;

	public ElectronicsDepartmentScreen(AndroidDriver<MobileElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(this.driver, 15, TimeUnit.SECONDS), this);
	}

	public void clickKindle() {
		isSuccess(MobileDriverAction.click(Productelement), "Select Kindle Step");
	}

	public void scrollToKindle() {
		isSuccess(MobileDriverAction.scrollToElement(driver, Productelement), "Scroll to Kindle Step");
	}

}
