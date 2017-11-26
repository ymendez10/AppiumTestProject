package com.appium.project.activity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public abstract class BaseActivity {

	private AppiumDriver<AndroidElement> driver;
	private FluentWait<WebDriver> wait;
	protected static final By TextView = By.className("android.widget.TextView");
	
	public BaseActivity(AppiumDriver<AndroidElement> driver) {
		 PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		 wait = new WebDriverWait(driver, 10);
		 this.driver=driver;
		
	}
	
	public AppiumDriver<AndroidElement> getDriver() {
		return driver;
	}

	public FluentWait<WebDriver> getWait() {
		return wait;
	}

	public void dispose() {
		if(driver!=null) driver.quit();
	}	
}
