package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.Base;

public class DemoTestA extends Base {

	
	@Test
	public void A1(){
		openBrowser();
		
	}
	//@Test
	public void A2(){
		Assert.fail();
		
	}
	//@Test
	public void A3(){
		
	}
}
