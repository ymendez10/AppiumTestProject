package com.appium.project.activity;

import org.openqa.selenium.support.ui.ExpectedConditions;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class YoutubeHomeActivity extends BaseActivity{
	
	@AndroidFindBy(id="com.google.android.youtube:id/menu_search")
	private AndroidElement searchButton;

	public YoutubeHomeActivity(AppiumDriver<AndroidElement> driver) {
		super(driver);
	}

	public YoutubeSearchActivity clickSearchButton() {
		getWait().until(ExpectedConditions.visibilityOf(searchButton));
		searchButton.click();
		return new YoutubeSearchActivity(getDriver());
	}
}
