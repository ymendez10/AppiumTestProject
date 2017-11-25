package com.appium.project.test;

import java.io.File;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


import com.appium.project.driver.DriverHandler;
import com.appium.project.util.PropertiesUtil;


public class BaseTest {
	
	private DriverHandler driver;
	private PropertiesUtil properties;
	@BeforeClass
	public void beforeClass() throws MalformedURLException {
		properties = new PropertiesUtil();
		
		File app = new File(properties.getProperty("selendroid.apk.dir"));
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.BROWSER_NAME, properties.getProperty("appium.test.project.browserName"));
		capabilities.setCapability("deviceName", properties.getProperty("appium.test.project.deviceName"));
		capabilities.setCapability("platformVersion", properties.getProperty("appium.test.project.platformVersion"));
		capabilities.setCapability("platformName", properties.getProperty("appium.test.project.platformName"));
		capabilities.setCapability("app", app.getAbsolutePath());
		capabilities.setCapability("appPackage", properties.getProperty("appium.test.project.appPackage"));
		capabilities.setCapability("appActivity", properties.getProperty("appium.test.project.appActivity"));
		
		driver = new DriverHandler(properties.getProperty("appium.test.project.urlHost"),properties.getProperty("appium.test.project.platformName"), capabilities);

		System.out.println("path : "+app.getAbsolutePath());


		driver.getDriver().manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		
	}
	
	
	@AfterClass
	public void afterClass() {
		driver.getDriver().quit();
	}
	
}
