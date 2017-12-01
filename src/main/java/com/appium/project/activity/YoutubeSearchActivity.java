package com.appium.project.activity;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.pagefactory.AndroidFindBy;


public class YoutubeSearchActivity extends BaseActivity{
	
	@AndroidFindBy(id="com.google.android.youtube:id/search_edit_text")
	private AndroidElement searchEditText;
	
	public YoutubeSearchActivity(AppiumDriver<AndroidElement> driver) {
		super(driver);
	}
	
	public YoutubeSearchResultActivity searchYoutubeVideo(String text) {
		searchEditText.sendKeys(text);

		AndroidDriver<AndroidElement> androidDriver = (AndroidDriver<AndroidElement>) getDriver();
		androidDriver.pressKeyCode(AndroidKeyCode.ENTER);

		return new YoutubeSearchResultActivity(getDriver());
	}

}
