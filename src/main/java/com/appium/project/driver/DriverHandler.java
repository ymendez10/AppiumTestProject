package com.appium.project.driver;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class DriverHandler {

	private AppiumDriver driver;
	
	public DriverHandler(String urlHost,String platformName, DesiredCapabilities capabilities) throws MalformedURLException {
		switch (platformName) {
		case "Android":
		
			driver = new AndroidDriver(new URL(urlHost),capabilities);
			
			break;
		default:
			break;
		}
	}

	public AppiumDriver getDriver() {
		return driver;
	}
}
