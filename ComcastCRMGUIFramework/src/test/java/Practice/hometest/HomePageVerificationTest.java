package Practice.hometest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;



public class HomePageVerificationTest {
	
	@Test
	public void HomePageTest(Method mtd) {
		Reporter.log(mtd.getName()+"Test Start",true);
		//softassert create object
		SoftAssert assertObj=new SoftAssert();
		Reporter.log("step-1",true);
		Reporter.log("step-2",true);
		//assertObj.assertEquals("Home","Home-Page");//soft assert used to store exception occurred during execution.
		Assert.assertEquals("Home", "Home");//Home page is mandatory use hard assert,Assert should be capital
	//above line should fail bcz home and home page is not equal	
		Reporter.log("step-3",true);
	assertObj.assertEquals("Title","Title-1");//not mandatory use softassert
	//Assert.assertEquals("Home-CRM","Home-CRM");
	Reporter.log("step-4",true);
		assertObj.assertAll();//to print exception occurred during execution
		Reporter.log(mtd.getName()+"Test End",true);
	}
	
	@Test
	public void VerifyLogoHomePageTest(Method mtd) {
		Reporter.log(mtd.getName()+"Test Start",true);
		SoftAssert assertObj=new SoftAssert();
		Reporter.log("step-1",true);
		Reporter.log("step-2",true);
		assertObj.assertTrue(true);
		//Assert.assertTrue(true);
		Reporter.log("step-3",true);
		Reporter.log("step-4",true);
		assertObj.assertAll();
		Reporter.log(mtd.getName()+"Test End",true);
	}
		
	}
	


