package com.pto.cta.util;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;

import com.pto.cta.framework.BaseTest;
import com.pto.cta.framework.Browser;





public class WaitUtil {
	
	/**
	 * 
	 * @param l - required time in milliseconds. 1000 ms === 1 second
	 * kind of explicit wait. Here we are hanging java Thread execution for the mentioned time and hence this is not recommended
	 */
	public static void applyWait(long milliSeconds) {
		try {
			Thread.sleep(milliSeconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// implicit wait for page load (whenever a new page or window or iframe loaded And in all navigation activities(back,forward,refresh,to,get) this timeout will be applied
	public static void applyPageLoadTimeOut(long seconds) {
		Browser.driver.manage().timeouts().pageLoadTimeout(seconds,TimeUnit.SECONDS);// This will be deprecated for higher version of selenium webdriver
//		Browser.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(seconds));// Available with higher version of selenium webdriver
		

	}
	// implicit wait for page elements (whenever we do findElement or findElements, this timeout will be applied)
	public static void implicitWaitOnWebElement(long seconds) { // this is not recommended. instead this , use explicit wait( webdriver wait or fluent wait)

		Browser.driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
		//BaseTest.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
		
	}
	/* Webdriver explicit wait */
	public static FluentWait<WebDriver> explicitWaitByFluentWait(long timeOutInSeconds, long pollDurationInMilli) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(Browser.driver).withTimeout(Duration.ofSeconds(timeOutInSeconds))
				.pollingEvery(Duration.ofMillis(pollDurationInMilli))
				.ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class)
		        .ignoring(ElementNotVisibleException.class);
		        
	return wait;
	}
}
