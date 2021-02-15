package com.pto.cta.framework;

public class BrowserHistoryNavigation {
	
	public static void goToPage(String pageUrl) {
		Browser.driver.navigate().to(pageUrl);
	}
	
	public static void refreshPage() {
		Browser.driver.navigate().refresh();
	}
	public static void backToVisitedPage() {
		Browser.driver.navigate().back();
	}
	
	public static void forwardToVisitedPage() {
		Browser.driver.navigate().forward();
	}

}
