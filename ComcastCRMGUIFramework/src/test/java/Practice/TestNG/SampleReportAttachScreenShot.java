package Practice.TestNG;

import java.sql.SQLException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.crm.generic.baseutility.BaseClass;
@Listeners(com.comcast.crm.listenerUtility.ListenerImplementationClass.class)
public class SampleReportAttachScreenShot{
	ExtentReports report;
	
	@Test
	public void createContactTest() {
		
		WebDriver driver =new ChromeDriver();
		driver.get("http://localhost:8888");
		//take screenshot
		TakesScreenshot edriver=(TakesScreenshot) driver;
		String filepath = edriver.getScreenshotAs(OutputType.BASE64);
		ExtentTest test = report.createTest("CreateContactTest");//create testcase
		
		//BY USING TEST CREATE LOG
		test.log(Status.INFO,"login to app");
		test.log(Status.INFO,"navigate to contact page ");
		test.log(Status.INFO," create contact");
		if("HDFCdd".equals("HDFC"))//make it fail
		{
			test.log(Status.PASS,"Contact is created");//FOR PASS
		}
		else {
	test.addScreenCaptureFromBase64String(filepath, "ErrorFile");//erroe file is simply giving tag name
		}
	}
}