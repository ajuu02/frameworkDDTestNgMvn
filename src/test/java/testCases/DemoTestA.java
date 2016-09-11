package testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import base.Base;

public class DemoTestA extends Base {
	
	
	
	@Test
	public void A1(){
		openBrowser();
		test=rep.startTest("A1");
		reportPass("Test A Passed");
		
	}
	@Test
	public void A2(){
		test=rep.startTest("A2");
		reportFail();
		
	}
	//@Test
	public void A3(){
		
	}
	@AfterMethod
	public void quit(){
		
		rep.endTest(test);
		rep.flush();
	}
}
