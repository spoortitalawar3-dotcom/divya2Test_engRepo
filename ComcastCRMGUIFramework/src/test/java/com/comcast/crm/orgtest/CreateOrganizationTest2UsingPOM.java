package com.comcast.crm.orgtest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.listenerUtility.ListenerImplementationClass;
import com.comcast.crm.objectrepositoryutility.CreateNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationPage;
import com.crm.generic.baseutility.BaseClass;
@Listeners(com.comcast.crm.listenerUtility.ListenerImplementationClass.class)
public class CreateOrganizationTest2UsingPOM extends BaseClass {
@Test(groups="smokeTest")	
public  void CreateOrganizationTest2UsingPOMTest() throws Throwable {
	//read testscript data from excel
	UtilityClassObject.getTest().log(Status.INFO,"read data from excel");// to print result on advance report we use status.log statement,
	//we can fetch the test reference from listenerimplementationclass or utility class object.
	String orgName=Elib.getDataFromExcel("org", 1, 2)+Jlib.getRandomNumber();	
		//create object
		/*
		 * FileUtility Flib=new FileUtility(); ExcelUtility Elib=new ExcelUtility();
		 * JavaUtility Jlib=new JavaUtility(); WebDriverUtility wlib=new
		 * WebDriverUtility();
		 * 
		 * //read data from properties file String
		 * BROWSER=Flib.getDataFromPropertiesFile("browser"); String
		 * URL=Flib.getDataFromPropertiesFile("url"); String
		 * UN=Flib.getDataFromPropertiesFile("username"); String
		 * PWD=Flib.getDataFromPropertiesFile("password");
		 */
		/*
		 * WebDriver driver=null;
		 * 
		 * if(BROWSER.equals("chrome")) { driver=new ChromeDriver(); } else
		 * if(BROWSER.equals("firefox")) { driver=new FirefoxDriver(); } else
		 * if(BROWSER.equals("edge")) { driver=new EdgeDriver(); } else { driver=new
		 * ChromeDriver(); }
		 */
		//LOGIN TO APP
		/*
		 * LoginPage lp=new LoginPage(driver); lp.loginToApp(URL, UN, PWD)//call the
		 * contructor fron login page,
		 */		
		
		//navigate to organization module
	UtilityClassObject.getTest().log(Status.INFO,"navigate to create org page");
		//ListenerImplementationClass.test.log(Status.INFO,"navigate to org page");
		HomePage hp=new HomePage(driver);//create object
		hp.getOrgLink().click();
		Thread.sleep(2000);	
	
		//enter all the details and create new organization
		UtilityClassObject.getTest().log(Status.INFO,"create new org");
		CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
		cnop.getOrgPlus().click();
		
		cnop.createOrg(orgName);
		UtilityClassObject.getTest().log(Status.INFO,orgName+"=====>create a new org");
		
		//Expectedresult=ORGANIZATION SHOULD BE CREATED AND DISPLAYED IN ORGANIZATION DETAILS PAGE AND
		//DISPLAY THE BELOW MESSAGE PAGE HEADER"[ORG**]****-Organization information"
		
		//verify header message expected result
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		String actOrgName=oip.getHeaderMsg().getText();
		Assert.assertEquals(true, actOrgName.contains(orgName));
		/*if(actOrgName.contains(orgName)) {
			System.out.println(orgName+"name is verified==Pass");
		}
		else {
			System.out.println(orgName+"name is not verified==Fail");
		}
		//verify header orgName info Expected Result	
		//logout
		hp.logout();
		driver.quit();*/
		
	}

	@Test(groups = "regressionTest")
	public void CreateOrganizationWithIndustriesTest2POM() throws Throwable {

		// read testscript data from excel
		String orgName = Elib.getDataFromExcel("org", 1, 2) + Jlib.getRandomNumber();
		String industry = Elib.getDataFromExcel("org", 4, 3);
		String type = Elib.getDataFromExcel("org", 4, 4);

		// navigate to organization module
		HomePage hp = new HomePage(driver);// create object
		hp.getOrgLink().click();
		Thread.sleep(2000);
		// create organization button
		OrganizationPage cnp = new OrganizationPage(driver);
		cnp.getCreateNewOrgBtn().click();
		Thread.sleep(2000);

		// enter all the details and create new organization
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createOrg(orgName, industry, type);
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actualIndustry = oip.getIndustrymsg().getText();
		String actualType = oip.getTypemsg().getText();
		System.out.println(industry);
		System.out.println(actualIndustry);

		// EXPECTATION=CHECK WETHER U CAN CREATE ORGANIZATION WITH INDUSTRIAL TYPE

		// Verify the industries and type info
		Assert.assertEquals(actualIndustry, industry);
		Assert.assertEquals(true,actualIndustry.contains(industry));

		/*
		 * if (actualIndustry.equals(industry)) { System.out.println(industry +
		 * "information is verified==PASS"); } else { System.out.println(industry +
		 * "information is not verified==FAIL");
		 * 
		 * }
		 * 
		 * if (actualType.contains(type)) { System.out.println(type +
		 * "information is verified==PASS"); } else { System.out.println(type +
		 * "information is not verified==FAIL");
		 * 
		 * }
		 */
	}

	@Test(groups = "regressionTest")
	public void CreateOrganizationWithPhoneNumberTest2POM() throws Throwable {

		// read testscript data from excel
		String orgName = Elib.getDataFromExcel("org", 7, 2) + Jlib.getRandomNumber();
		String phone = Elib.getDataFromExcel("org", 7, 4) + Jlib.getRandomNumber();

		// navigate to organization module
		HomePage hp = new HomePage(driver);// create object
		hp.getOrgLink().click();
		Thread.sleep(2000);
		// create organization button
		OrganizationPage cnp = new OrganizationPage(driver);
		cnp.getCreateNewOrgBtn().click();
		Thread.sleep(2000);

		// create organization button
		// enter all the details and create new organization
		CreateNewOrganizationPage cnp1 = new CreateNewOrganizationPage(driver);
		cnp1.createNewOrgWithPhone(orgName, phone);

		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actualPhoneNum = oip.getPhoneMsg().getText();

		// EXPECTATION=CHECK WETHER U CAN CREATE ORGANIZATION WITH INDUSTRIAL TYPE

		// verify header phone number
		Assert.assertEquals(actualPhoneNum,phone);
		/*
		 * if (actualPhoneNum.equals(phone)) { System.out.println(phone +
		 * "information is verified==PASS"); } else { System.out.println(phone +
		 * "information is not verified==FAIL"); }
		 */

	}

}
