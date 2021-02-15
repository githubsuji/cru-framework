package com.pto.cta.framework;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class BrowserKeyActions {
	
	public static void pressEnterkey() {
		Actions builder = new Actions(Browser.driver);        
		builder.sendKeys(Keys.ENTER);
		builder.perform();

	}

	public static void pressEnterkeyByElement(WebElement webEle ) {
		Actions builder = new Actions(Browser.driver);        
		builder.sendKeys(webEle,Keys.ENTER);
		builder.perform();
	}
	

}
