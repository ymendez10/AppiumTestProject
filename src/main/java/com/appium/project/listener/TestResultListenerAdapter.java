package com.appium.project.listener;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.appium.project.test.BaseTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;

public class TestResultListenerAdapter extends TestListenerAdapter {

    @Override
    public void onStart(ITestContext tc) {
        super.onStart(tc);
    }

    @Override
    public void onTestSkipped(ITestResult tr) {
        System.out.println("DEBUG: " + tr.getInstanceName() + "." + tr.getMethod().getMethodName() + " -> Skipped");
        runAfterMethod(tr);
        super.onTestSkipped(tr);
    }

    @Override
    public void onTestFailure(ITestResult tr) {
        System.out.println("DEBUG: " + tr.getInstanceName() + "." + tr.getMethod().getMethodName() + " -> Failed");
        takeScreenshot(tr);
        super.onTestFailure(tr);
    }

    private void runAfterMethod(ITestResult tr) {
        BaseTest testInstance = (BaseTest) tr.getMethod().getInstance();
        testInstance.afterMethod();
    }

    @Override
    public void onTestSuccess(ITestResult tr) {
        System.out.println("DEBUG: " + tr.getInstanceName() + "." + tr.getMethod().getMethodName() + " -> Success");
        super.onTestSuccess(tr);
    }

    @Override
    public void onFinish(ITestContext tc) {
        super.onFinish(tc);
    }

    private void takeScreenshot(ITestResult tr) {
        try {
            AppiumDriver<AndroidElement> driver = ((BaseTest)tr.getMethod().getInstance()).getDriver().getDriver();

            if (driver instanceof AndroidDriver || driver instanceof IOSDriver) {
                System.out.println("DEBUG: Taking screenshot...");
                File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                String filePath = "target/surefire-reports" + "/screenshots/"
                        + tr.getInstanceName() + tr.getMethod().getMethodName() + "_" + tr.getStatus() + ".png";
                File screenshotInPath = new File(filePath);
                FileUtils.copyFile(screenshot, screenshotInPath);
            } else {
                System.out.println("DEBUG: Skipping screenshot.");
            }
        } catch(Exception exception) {
            exception.printStackTrace();
        } finally {
            runAfterMethod(tr);
        }
    }

}
