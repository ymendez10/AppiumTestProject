package com.appium.project.test;

import org.testng.annotations.Test;

import com.appium.project.activity.YoutubeVideoViewerActivity;

import org.testng.annotations.Parameters;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

public class YoutubeAppiumTest  extends BaseTest{

	@Test(enabled=false)
	@Parameters({"videoTitle"})
	public void testSerchVideo(String videoTitle) {
		List<String> results = getYoutubeHome()
			.clickSearchButton()
				.searchYoutubeVideo(videoTitle)
					.getVideoTitle();

		assertTrue(results.iterator().next().contains(videoTitle));	
	}
	@Test(enabled=false)
	@Parameters({"videoTitle","numberOfVideo"})
	public void testPlayVideo(String videoTitle, int numberOfVideo) {
		YoutubeVideoViewerActivity viewer= getYoutubeHome()
			.clickSearchButton()
				.searchYoutubeVideo(videoTitle)
					.selectVideo(429, 1450, -429, -1430, numberOfVideo);
		System.out.println("Final selected video : "+viewer.getVideoTitle());
		assertTrue(viewer.getVideoTitle().contains(videoTitle));	
	}
	
	@Test
	@Parameters({"videoTitle","numberOfVideo"})
	public void testPauseVideo(String videoTitle, int numberOfVideo) {
		String content= getYoutubeHome()
			.clickSearchButton()
				.searchYoutubeVideo(videoTitle)
					.selectVideo(429, 1450, -429, -1430, numberOfVideo)
					.pauseVideo();
		assertEquals(content, "Play Video");	
	}
}
