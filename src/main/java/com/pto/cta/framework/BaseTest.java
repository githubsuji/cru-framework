package com.pto.cta.framework;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.pto.cta.listeners.TestngListener;
import com.pto.cta.util.ScreenshotManager;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Listeners(TestngListener.class)
public abstract class BaseTest {
	protected String testCaseMethodName;
	long startTime = 0;
	long endTime = 0;
	
	@BeforeSuite
	public void rightAfterTestSuiteStarted(ITestContext iTestCxt) {
		
		startTime = System.currentTimeMillis();
		log.info("{} Execution Start Time ::: {}", iTestCxt.getSuite().getName(), startTime);
	}
	@AfterSuite
	public void justBeforeTestSuiteEnds(ITestContext iTestCxt) {
		endTime = System.currentTimeMillis();
		log.info("{} Execution End Time ::: {}",iTestCxt.getSuite().getName(), startTime);
		log.info("Total Time Taken to complete the  Testsuite {}::: {} " , iTestCxt.getSuite().getName(), (endTime-startTime));
	}
	@BeforeClass
	@Parameters({ "browserType" })
	public void beforeFirstCaseMethod(@Optional("chrome") String browser) {
		log.info("Executed Before First Test Case execution in Test Class");
		Browser.openBrowser(browser);
	}
	
	@BeforeMethod
	public void beforeTestCaseMethod() {
		log.info("Executed Before Test Method execution");
	}
	
	@AfterMethod
	public void afterTestCaseMethod(ITestResult result) {
		log.info("Executed After Test Case execution");
		if(null != testCaseMethodName) {
			result.setAttribute("testcaseName", testCaseMethodName);
			}else {
			result.setAttribute("testcaseName", result.getName());
			}
			ScreenshotManager.triggerScreenshot(Browser.driver, result);
	}
	
	@AfterClass
	@Parameters({ "browserType" })
	public void afterLastCaseMethod(@Optional("chrome") String browser) {
		log.info("Executed After Last Test Case execution in Test Class");
		Browser.closeAllBrowserWindows();
		log.info("All {} Browser windows closed ", browser);
	}
	/**
	 * 
	 * @param testMethodName
	 * override this method in TestClasses whenever we need to provide custom testcasename (ie. methodname)
	 * and uncomment the method body
	 */
	protected void setTestCaseMethodName(String testMethodName) {
		/*  
		 * super.testCaseMethodName = testMethodName;
		 * 
		 */
	}
}
