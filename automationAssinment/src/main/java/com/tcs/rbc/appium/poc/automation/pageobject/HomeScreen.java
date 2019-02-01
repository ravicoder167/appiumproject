package com.tcs.rbc.appium.poc.automation.pageobject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import com.tcs.rbc.appium.poc.automation.action.MobileDriverAction;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomeScreen extends PageObjectBase {
	private AndroidDriver<MobileElement> driver;
	@AndroidFindBy(id = "com.amazon.mShop.android.shopping:id/skip_sign_in_button")
	private MobileElement skipSignInButton;
	@AndroidFindBy(id = "com.amazon.mShop.android.shopping:id/action_bar_burger_icon")
	private MobileElement actionBarBurgorIcon;
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Shop by Department\")")
	private MobileElement shopByDepartmentLbl;
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Electronics\")")
	private MobileElement electronicDepartmentLbl;

	public HomeScreen(AndroidDriver<MobileElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(this.driver, 15, TimeUnit.SECONDS), this);
	}

	public void clickSkipSignInButton() {
		isSuccess(MobileDriverAction.click(skipSignInButton), "Click skip Sign In Step");
	}

	public void clickActionBarBurgerIcon() {
		isSuccess(MobileDriverAction.click(actionBarBurgorIcon), "Click Burger Icon Step");

	}

	public void clickShopByDepartment() {
		isSuccess(MobileDriverAction.click(shopByDepartmentLbl), "Click Shop By Department Step");
	}

	public void clickElectronicsDepartment() {
		isSuccess(MobileDriverAction.click(electronicDepartmentLbl), "Click Electronics Department Step");

	}

}
