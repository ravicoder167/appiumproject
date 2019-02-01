package com.tcs.rbc.appium.poc.automation.pageobject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import com.tcs.rbc.appium.poc.automation.action.MobileDriverAction;
import com.tcs.rbc.appium.poc.automation.utils.Constants;
import com.tcs.rbc.appium.poc.automation.utils.Utils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductDescriptionScreen extends PageObjectBase {
	@AndroidFindBy(xpath = "//*[@resource-id='title']")
	private MobileElement itemTitle;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"In Stock.\")")
	private MobileElement lableStock;

	public ProductDescriptionScreen(AndroidDriver<MobileElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(this.driver, 15, TimeUnit.SECONDS), this);
	}

	public void waitForKindleToLoad() {
		isSuccess(MobileDriverAction.waitUntilElementLoad(driver, 10, itemTitle), "Wait Kindle Product To Load");
	}

	public void verifyProductTitle() {
		isSuccess(MobileDriverAction.assureTextInElement(itemTitle, Constants.TITLE_TEXT), "Verify Product Title");
	}

	public void verifyProductInStock() {
		MobileDriverAction.scrollToElement(driver, lableStock);
		isSuccess(MobileDriverAction.verifyTextInElement(lableStock, Constants.INSTOCK_TEXT), "Verify Stock Availability");
	}

}
