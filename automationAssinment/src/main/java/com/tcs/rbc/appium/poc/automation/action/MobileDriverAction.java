package com.tcs.rbc.appium.poc.automation.action;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.tcs.rbc.appium.poc.automation.utils.LogLevel;
import com.tcs.rbc.appium.poc.automation.utils.LogManager;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class MobileDriverAction {

	public static boolean waitUntilElementLoad(AndroidDriver<MobileElement> driver, int waitTime,
			MobileElement mobElement) {
		boolean result = false;
		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		try {
			WebElement element = wait.until(ExpectedConditions.visibilityOf(mobElement));
			if (element != null) {
				result = true;
			}
		} catch (TimeoutException ex) {
			LogManager.getLogger().Log(ex, LogLevel.FATAL);
			ex.printStackTrace();
		}
		return result;
	}

	public static boolean scrollToElement(AndroidDriver<MobileElement> driver, MobileElement Element) {
		Dimension dimensions = driver.manage().window().getSize();
		int scrollCount = 0;
		boolean result = false;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException ex) {
			LogManager.getLogger().Log(ex, LogLevel.FATAL);
			ex.printStackTrace();
		}
		while (!result || scrollCount > 100) {
			scroll(driver, dimensions);
			scrollCount++;
			if (!(Element.getLocation().y > dimensions.height)) {
				result = true;
			}
		}
		return result;
	}

	private static void scroll(AndroidDriver<MobileElement> driver, Dimension dimensions) {

		int Startpoint = (int) (dimensions.getHeight() * 0.8);
		int scrollEnd = (int) (dimensions.getHeight() * 0.4);
		driver.swipe((int) (dimensions.width * 0.5), Startpoint, (int) (dimensions.width * 0.5), scrollEnd, 2000);
	}

	public static boolean click(MobileElement element) {
		if (element != null) {
			element.click();
			return true;
		} else {
			LogManager.getLogger().Log("Element not found", LogLevel.ERROR);
			return false;
		}

	}

	public static boolean verifyTextInElement(MobileElement element, String text) {
		if (element != null) {
			String elementText = element.getText();
			LogManager.getLogger().Log("Actual result : " + elementText, LogLevel.INFO);
			LogManager.getLogger().Log("Expected result : " + text, LogLevel.INFO);
			SoftAssert assertion = new SoftAssert();
			assertion.assertEquals(elementText, text);
			return true;
		} else {
			LogManager.getLogger().Log("Element not found", LogLevel.ERROR);
			return false;
		}
	}

	public static boolean assureTextInElement(MobileElement element, String text) {
		if (element != null) {
			String elementText = element.getText();
			LogManager.getLogger().Log("Actual result : " + elementText, LogLevel.INFO);
			LogManager.getLogger().Log("Expected result : " + text, LogLevel.INFO);
			assertEquals(elementText, text);
			return true;
		} else {
			LogManager.getLogger().Log("Element not found", LogLevel.ERROR);
			return false;
		}
	}

}
