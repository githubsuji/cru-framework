package com.pto.cta.framework;

import java.util.Arrays;
import java.util.Collections;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.pto.cta.util.WaitUtil;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Browser {
	public static WebDriver driver = null;

	public static void openBrowser(String browserTYpe) {
		log.info("openBrowser - browserTYpe{}", browserTYpe );
		log.debug("openBrowser - browserTYpe{}", browserTYpe );
		log.trace("openBrowser - browserTYpe{}", browserTYpe );
		log.error("openBrowser - browserTYpe{}", browserTYpe );
		log.warn("openBrowser - browserTYpe{}", browserTYpe );
		
		switch (browserTYpe) {
		case "chrome":
			/*  locating the driver.exe location from maven repo */
			WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
			openChrome();
			break;
		case "firefox":
			WebDriverManager.getInstance(DriverManagerType.FIREFOX).setup();
			openFirefox();
			break;
		default:
			break;
		}

	}

	private static void openChrome() {
		
		ChromeOptions chromeSettings = getChromeBrowserSettings();
		driver = new ChromeDriver(chromeSettings);
		log.info("Chrome Browser Opened ");
		WaitUtil.applyPageLoadTimeOut(120);// 120 seconds
		// WaitUtil.implicitWaitOnWebElement(5);// 5 seconds -- this is not recommended
		// instead we can go for explicit wait using Fluent Wait or Web Driver Wait
	}

	private static void openFirefox() {
		
		driver = new FirefoxDriver();
	}

	public static void closeAllBrowserWindows() {
		Browser.driver.quit();

	}

	public static void closeTheWindow() {
		Browser.driver.close();

	}

	private static ChromeOptions getChromeBrowserSettings() {
		// https://chromedriver.chromium.org/capabilities ---> chrome option arguments reference
		ChromeOptions options = new ChromeOptions();
		options.addArguments(Arrays.asList("--test-type", "test-type=browser", "--disable-default-apps",
				"--enable-precise-memory-info", "--js-flags=--expose-gc", "--disable-infobars", "--start-maximized",
				"--ignore-certificate-errors", "--disable-popup-blocking", "--allow-running-insecure-content",
				"--disable-notifications", "--disable-save-password", "--disable-translate",
				"--always-authorize-plugins", "--incognito"));
		options.setExperimentalOption("useAutomationExtension", false);
		// options.setExperimentalOption("excludeSwitches",
		// Arrays.asList("enable-automation"));
		options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
		return options;
	}
}
