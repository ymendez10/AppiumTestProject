package com.appium.project.test;

import java.io.File;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.appium.project.activity.YoutubeHomeActivity;
import com.appium.project.driver.DriverHandler;
import com.appium.project.util.PropertiesUtil;


public class BaseTest {
	
	private DriverHandler driver;
	private PropertiesUtil properties;
	private YoutubeHomeActivity youtubeHome;
	@BeforeClass
	public void beforeClass() throws MalformedURLException {
		properties = new PropertiesUtil();
		
		File app = new File(properties.getProperty("youtube.apk.dir"));
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", properties.getProperty("appium.test.project.deviceName"));
		capabilities.setCapability("platformVersion", properties.getProperty("appium.test.project.platformVersion"));
		capabilities.setCapability("platformName", properties.getProperty("appium.test.project.platformName"));
		capabilities.setCapability("app", app.getAbsolutePath());
		capabilities.setCapability("appPackage", properties.getProperty("appium.test.project.appPackage"));
		capabilities.setCapability("appActivity", properties.getProperty("appium.test.project.appActivity"));
		
		driver = new DriverHandler(properties.getProperty("appium.test.project.urlHost"),properties.getProperty("appium.test.project.platformName"), capabilities);

//		driver.getDriver().manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		youtubeHome= new YoutubeHomeActivity(driver.getDriver());
		
	}
	
	
	@AfterClass
	public void afterClass() {
		youtubeHome.dispose();
	}

	public YoutubeHomeActivity getYoutubeHome() {
		return youtubeHome;
	}
	
}
