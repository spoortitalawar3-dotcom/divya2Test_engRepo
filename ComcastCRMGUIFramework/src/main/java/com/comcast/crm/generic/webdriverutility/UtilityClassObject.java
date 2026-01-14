package com.comcast.crm.generic.webdriverutility;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

public class UtilityClassObject {
	public static ThreadLocal<ExtentTest> test=new ThreadLocal<ExtentTest>();// static variable only use for sequential exe,
	//to make static variable also use for parallel exe provide threads(provide object of that class) so that it will work in parallel methods also
	public static ThreadLocal<WebDriver> driver=new ThreadLocal<WebDriver>();
	
	
	//provide getter and setter methods to use those
	public static ExtentTest getTest() {
		return test.get();	
	}
	public static void setTest(ExtentTest actTest) {
		 test.set(actTest);
	}
	public static WebDriver getDriver(){
	   return driver.get();
		
	}
	public static void setDriver(WebDriver actDriver) {
		 driver.set(actDriver);
		
	}


}
