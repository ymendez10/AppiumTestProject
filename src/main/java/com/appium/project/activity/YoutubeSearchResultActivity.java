package com.appium.project.activity;

import java.util.ArrayList;
import java.util.List;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;

public class YoutubeSearchResultActivity extends BaseActivity{
	
	@AndroidFindAll(value = { @AndroidBy(id="com.google.android.youtube:id/title")})
	private List<AndroidElement> resultsList;
	
	@AndroidFindAll(value = { @AndroidBy(id="com.google.android.youtube:id/title")})
	private List<WebElement> elements;

	public YoutubeSearchResultActivity(AppiumDriver<AndroidElement> driver) {
		super(driver);
	}
	
	public List<String> getVideoTitle(){
		List<String> titles= new ArrayList<String>();
		for (AndroidElement element : resultsList) {
			titles.add(element.getText());
		}

		return titles;
	}
	
	public YoutubeVideoViewerActivity selectVideo() {
		getWait().until(ExpectedConditions.visibilityOfAllElements(elements));
		//choose first video
		elements.get(0).click();
		
		return new YoutubeVideoViewerActivity(getDriver());
		
	}
	public YoutubeVideoViewerActivity selectVideo(int startX, int startY, int endX, int endY) {
		getWait().until(ExpectedConditions.visibilityOfAllElements(elements));
		TouchAction touchAction = new TouchAction(getDriver()).press(startX, startY).moveTo(endX, endY).release();
		getDriver().performTouchAction(touchAction);

		//choose random video
		elements.get(2).click();
		
		return new YoutubeVideoViewerActivity(getDriver());
		
	}
}
