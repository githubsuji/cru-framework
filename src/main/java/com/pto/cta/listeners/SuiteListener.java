package com.pto.cta.listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class SuiteListener implements ISuiteListener {
	long startTime = 0;
	long endTime = 0;

	@Override
	public void onFinish(ISuite suite) {
		endTime = System.currentTimeMillis();
		log.info("{} Execution End Time ::: {}", suite.getName(), startTime);
		log.info("Total Time Taken to complete the  Testsuite {}::: {} " , suite.getName(), (endTime-startTime));
	}

	@Override
	public void onStart(ISuite suite) {
		startTime = System.currentTimeMillis();
		log.info("{} Execution Start Time ::: {}", suite.getName(), startTime);
	}

}