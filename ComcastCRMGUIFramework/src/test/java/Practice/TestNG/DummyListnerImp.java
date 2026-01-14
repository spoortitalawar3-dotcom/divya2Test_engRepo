package Practice.TestNG;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class DummyListnerImp implements ITestListener,ISuiteListener{

	@Override
	public void onFinish(ISuite suite) {
		System.out.println("onFinish(ISuite suite)");	
	}

	@Override
	public void onStart(ISuite suite) {
		System.out.println("onStart(ISuite suite)");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("onFinish(ITestContext context)");
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("onStart(ITestContext context)");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("onTestFailedButWithinSuccessPercentage(ITestResult result)");
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println("onTestFailedWithTimeout(ITestResult result)");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("onTestFailure(ITestResult result)");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("onTestSkipped(ITestResult result)");
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("onTestStart(ITestResult result)");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("onTestSuccess(ITestResult result)");
	}
	

}
