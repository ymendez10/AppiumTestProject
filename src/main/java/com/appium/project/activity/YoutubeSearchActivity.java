package com.appium.project.activity;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import java.util.List;


public class YoutubeSearchActivity extends BaseActivity{
	
	@AndroidFindBy(id="com.google.android.youtube:id/search_edit_text")
	private AndroidElement searchEditText;
	
	@AndroidFindAll(value = { @AndroidBy(id="com.google.android.youtube:id/text")})
	private List<AndroidElement> listSearchResults;
	

	public YoutubeSearchActivity(AppiumDriver<AndroidElement> driver) {
		super(driver);
	}
	
	public YoutubeSearchResultActivity searchYoutubeVideo(String text) {
		searchEditText.sendKeys(text);
		for (AndroidElement androidElement : listSearchResults) {
			if(androidElement.getText().equalsIgnoreCase(text)) {
				androidElement.click();
				break;
			}
		}
		return new YoutubeSearchResultActivity(getDriver());
	}

}
