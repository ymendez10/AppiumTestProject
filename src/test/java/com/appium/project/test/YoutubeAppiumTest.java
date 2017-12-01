package com.appium.project.test;

import org.testng.annotations.Test;

import com.appium.project.activity.YoutubeVideoViewerActivity;

import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.Parameters;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

public class YoutubeAppiumTest  extends BaseTest{
	
	@Test(enabled=true,description="Test Play Random Video")
	@Parameters({"videoTitle"})
	public void testPlayRandomVideo(String videoTitle) {
		YoutubeVideoViewerActivity viewer= getYoutubeHome()
			.clickSearchButton()
				.searchYoutubeVideo(videoTitle)
					.selectVideo(429, 1450, -429, -1430);
		assert(!StringUtils.isBlank(viewer.getVideoTitle()));
		assertTrue(StringUtils.containsIgnoreCase(viewer.getVideoTitle(), videoTitle));
	}

	@Test(enabled=true,description="Test Play Specific Video")
	@Parameters({"specificVideoTitle"})
	public void testPlaySpecificVideo(String specificVideoTitle) {
		YoutubeVideoViewerActivity viewer= getYoutubeHome()
				.clickSearchButton()
					.searchYoutubeVideo(specificVideoTitle)
						.selectVideo();
		assert(!StringUtils.isBlank(viewer.getVideoTitle()));
		assertEquals(viewer.getVideoTitle(), specificVideoTitle);
	}
	
	@Test(enabled=true,description="Test Pause Video")
	@Parameters({"videoTitle"})
	public void testPauseVideo(String videoTitle) {
		String content= getYoutubeHome()
			.clickSearchButton()
				.searchYoutubeVideo(videoTitle)
					.selectVideo()
					.pauseVideo();
		assertEquals(content, "Play Video");	
	}
}
