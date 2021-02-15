package com.pto.cta.listeners;



import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

import lombok.extern.slf4j.Slf4j;



@Slf4j
public abstract class TestCaseMethodListener extends TestListener implements IInvokedMethodListener {

@Override
public void afterInvocation(IInvokedMethod arg0, ITestResult arg1) {
ITestNGMethod method =arg0.getTestMethod();
log.info(method.getMethodName()+ " has been invoked");
log.info(method.getDescription());



}

@Override
public void beforeInvocation(IInvokedMethod arg0, ITestResult arg1) {
ITestNGMethod method =arg0.getTestMethod();
log.info(method.getMethodName()+ " is going to be invoked");
log.info(method.getDescription());





}

}
