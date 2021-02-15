package com.pto.cta.tests.login;

import org.testng.annotations.Test;

import com.pto.cta.framework.BaseTest;

public class LoginTest extends BaseTest{
	
	@Test
	public void rightCredentialsTest() {
		LoginTestSteps.openWebsite();
	}
	@Test
	public void wrongCredentialsTest() {
		LoginTestSteps.openWebsite();
	}
}
