package com.pto.cta.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class TestListener extends SuiteListener implements ITestListener {
	@Override
	public void onFinish(ITestContext arg0) {
		log.info(arg0.getName() + "Test  finished");

// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext arg0) {
		log.info(arg0.getName() + "test on start");
// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {

		log.info(arg0.getName() + " test on failed");
		log.info(arg0.getTestName());
// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailure(ITestResult result) {
		log.info(result.getName() + "failure");
		log.info(result.getTestName());
		if (result.getStatus() == ITestResult.FAILURE) {
// Do something here
			log.info("Failed ***********");
			String testcasename = result.getName();
			log.info(testcasename);
		}

	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		log.info(arg0.getName() + "on testskipped");
// TODO Auto-generated method stub
		log.info(arg0.getTestName());
	}

	@Override
	public void onTestStart(ITestResult arg0) {
		log.info(arg0.getName() + "onstarted");
// TODO Auto-generated method stub
		log.info(arg0.getTestName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		log.info(result.getName() + "on test success");
// TODO Auto-generated method stub
		log.info(result.getTestName());

		try {
			if (result.getStatus() == ITestResult.SUCCESS) {

// Do something here
				log.info("passed **********");
				String testcasename = result.getName();
				log.info(testcasename);

			}

		} catch (Exception e) {

		}

	}
}
