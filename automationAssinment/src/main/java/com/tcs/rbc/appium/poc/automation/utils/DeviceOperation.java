package com.tcs.rbc.appium.poc.automation.utils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class DeviceOperation {
// This class will have operation on device like click home button,vol up vol down power off etc.

	public static void clickBackMultipleTime(AndroidDriver<MobileElement> driver,int count) {
		for(int i=0;i<count;i++) 
		{
			driver.navigate().back();
		}
	}


}
