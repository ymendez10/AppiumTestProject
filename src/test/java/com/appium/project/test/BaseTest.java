package com.appium.project.test;

import java.io.File;
import java.net.MalformedURLException;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.appium.project.activity.YoutubeHomeActivity;
import com.appium.project.driver.DriverHandler;
import com.appium.project.util.PropertiesUtil;


public class BaseTest {
	
	private DriverHandler driver;
	private PropertiesUtil properties;
	private YoutubeHomeActivity youtubeHome;
	@BeforeMethod
	@Parameters({"port_"})
	public void beforeMethod(String port) throws MalformedURLException {
		properties = new PropertiesUtil();
		
		File app = new File(properties.getProperty("youtube.apk.dir"));
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", properties.getProperty("appium.test.project.deviceName"));
		capabilities.setCapability("platformVersion", properties.getProperty("appium.test.project.platformVersion"));
		capabilities.setCapability("platformName", properties.getProperty("appium.test.project.platformName"));
		capabilities.setCapability("app", app.getAbsolutePath());
		capabilities.setCapability("appPackage", properties.getProperty("appium.test.project.appPackage"));
		capabilities.setCapability("appActivity", properties.getProperty("appium.test.project.appActivity"));
				
		String URL=properties.getProperty("appium.test.project.urlHost");
		URL = URL.replace("_port", port);// replace with port parameter
		driver = new DriverHandler(URL,properties.getProperty("appium.test.project.platformName"), capabilities);

//		driver.getDriver().manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		youtubeHome= new YoutubeHomeActivity(driver.getDriver());
		
	}
	
	
	@AfterMethod
	public void afterMethod() {
		youtubeHome.dispose();
	}

	public YoutubeHomeActivity getYoutubeHome() {
		return youtubeHome;
	}
	public DriverHandler getDriver() {
		return driver;
	}
}
