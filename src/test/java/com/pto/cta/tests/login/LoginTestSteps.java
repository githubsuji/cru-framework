package com.pto.cta.tests.login;

import com.pto.cta.constants.WebSiteURL;
import com.pto.cta.framework.Browser;

public class LoginTestSteps  {

	public static void openWebsite() {
		 Browser.driver.get(WebSiteURL.SELENIUM_PRACTICE_WEBSITE);
	}

}
