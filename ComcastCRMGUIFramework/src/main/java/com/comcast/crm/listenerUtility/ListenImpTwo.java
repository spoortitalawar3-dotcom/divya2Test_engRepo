package com.comcast.crm.listenerUtility;

import java.awt.event.ItemListener;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.crm.generic.baseutility.BaseClass;

public class ListenImpTwo implements ITestListener,ISuiteListener {
	public ExtentReports report;
	public static ExtentTest test;
	

	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		ISuiteListener.super.onFinish(suite);
	}

	@Override
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		ISuiteListener.super.onStart(suite);
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Report BackUp");
		report.flush();
	}

	@Override
	public void onStart(ITestContext context) {
		
		System.out.println("Report configuration");
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
        // STEP=Spark report config
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report_"+time+".html");//every execution generate report with different time stamp
		// using spark object configure the document
		spark.config().setDocumentTitle("CRM Test suite Results");// name
		spark.config().setReportName("CRM Report");// title
		spark.config().setTheme(Theme.DARK);// theme
		
		// STEP=ADD information AND CREATE TEST
				report = new ExtentReports();
				report.attachReporter(spark);// pass spark configuration
				report.setSystemInfo("OS", "Windows-10");// OPERATING SYSTEM INFO
				report.setSystemInfo("BROWSER", "Chrome-100");// Browser information
			
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("ITS-3");
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println("ITS-4");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testName=result.getMethod().getMethodName();
		TakesScreenshot edriver = (TakesScreenshot) BaseClass.sdriver;// give driver as Baseclass.sdriver
		String filepath = edriver.getScreenshotAs(OutputType.BASE64);
		
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		test.addScreenCaptureFromBase64String(filepath, testName+"_"+time);// multi
		test.log(Status.FAIL, result.getMethod().getMethodName()+"====>FAILED<====");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("ITS-6");
	}

	@Override
	public void onTestStart(ITestResult result) {
		
		System.out.println("========>" + result.getMethod().getMethodName() + "<====Start=====");
		 test = report.createTest(result.getMethod().getMethodName());//CAPTURE TESTCASE DURING RUNTIME
		 UtilityClassObject.setTest(test);
		 test.log(Status.INFO, result.getMethod().getMethodName()+"====>STARTED<====");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		System.out.println("========>" + result.getMethod().getMethodName() + "<====End=====");
		test.log(Status.PASS, result.getMethod().getMethodName()+"====>COMPLETED<====");
	}

}
