package com.pto.cta.tests.run;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;
import org.testng.collections.Lists;

public class TestRunner {

	public static void main(String[] args) {

		TestNG tng = new TestNG();
		
		List<String> suites = new ArrayList<String>();
		// List<String> suites = Lists.newArrayList();
		//suites.add("master-testsuite.xml");
		suites.add("C:\\Users\\sujit\\eclipse-workspace-chinnu-batch\\cru-test-app\\src\\test\\resources\\test-suites\\master-testsuite.xml");
		tng.setTestSuites(suites);
		 tng.run();
	}

}
