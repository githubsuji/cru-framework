package com.pto.cta.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ScreenshotManager {
	public static void triggerScreenshot(WebDriver driver,ITestResult result) {
		log.info("from teardown method " + result.getName());
		try {
		if (result.getStatus() == ITestResult.SUCCESS) {

		// Do something here
		log.info(result.getName() +"passed **********");
		}

		else if (result.getStatus() == ITestResult.FAILURE) {
		// Do something here
		log.info(result.getName() +"failed **********");
		String testCaseName = (String) result.getAttribute("testcaseName");
	//	captureScreenShot(testCaseName,"D:\\Automation\\Screenshots",driver);
		}

		else if (result.getStatus() == ITestResult.SKIP) {
		log.info(result.getName() +"skipped **********");


		}
		} catch (Exception e) {
		log.error("Exception happened in Teardown method (@AfterMethod)  of base Test", e);
		}
		}
		public static void captureScreenShot(String filename, String filepath, WebDriver driver) {

		log.info("Screenshot is captured in the folder");
		File directory = new File(filepath);
		log.info("Checking for directory" + filepath);
		if (!directory.exists()) {
		directory.mkdir();
		log.info("directory created succussfully");
		}

		log.info("Directory available for writing screenshot");
		File screenshotTargetFile = new File(directory + "/" + filename + ".png");
		TakesScreenshot ts = (TakesScreenshot) driver;
		File screenshotsrcfile = ts.getScreenshotAs(OutputType.FILE);
		try {
		FileUtils.copyFile(screenshotsrcfile,screenshotTargetFile);
		log.info("Screenshot is succussfully copied into corresponding target location");
		
		} catch (IOException e) {

		e.printStackTrace();
		}

		}
}
