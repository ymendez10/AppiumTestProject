package com.appium.project.activity;

import java.util.List;

import org.openqa.selenium.support.ui.ExpectedConditions;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class YoutubeVideoViewerActivity extends BaseActivity{
	
	@AndroidFindBy(id="com.google.android.youtube:id/title")
	private AndroidElement videoTitle;
	
	@AndroidFindBy(id="com.google.android.youtube:id/player_fragment_container")
	private AndroidElement videoContent;

	@AndroidFindBy(id="com.google.android.youtube:id/player_control_play_pause_replay_button")
	private AndroidElement play_pause_replay_button;

	@AndroidFindBy(id="com.google.android.youtube:id/skip_ad_button")
	private AndroidElement skip_ad_button;
	
	@AndroidFindBy(id="com.google.android.youtube:id/ad_timer_text")
	private AndroidElement ad_timer_text;
	
	@AndroidFindBy(id="com.google.android.youtube:id/countdown_text")
	private AndroidElement countdown_text;
	
	@AndroidFindAll(value = { @AndroidBy(id="com.google.android.youtube:id/player_fragment_container")})
	private List<AndroidElement> listVideoControls;
	
	
	
	public YoutubeVideoViewerActivity(AppiumDriver<AndroidElement> driver) {
		super(driver);
	}
	
	public String getVideoTitle() {
		getWait().until(ExpectedConditions.visibilityOf(videoTitle));
		return videoTitle.getText();
	}
	
	public String pauseVideo() {
		getWait().until(ExpectedConditions.visibilityOf(videoTitle));
		videoContent.click();//activate buttons
		videoContent.click();//pause video
		
		for (AndroidElement androidElement : listVideoControls) {
			System.out.println("control: "+androidElement.getAttribute("content-desc") +" - "+androidElement.isEnabled());
		}
		
		String desc=play_pause_replay_button.getAttribute("content-desc");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		if (null!=countdown_text && countdown_text.isDisplayed()) {
//			getWait().until(ExpectedConditions.elementToBeClickable(skip_ad_button));
//			skip_ad_button.click();
//		}else {
//			getWait().until(ExpectedConditions.invisibilityOf(skip_ad_button));
			
//		}
		
		return desc;
	}

}
