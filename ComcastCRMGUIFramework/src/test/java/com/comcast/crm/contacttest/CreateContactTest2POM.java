package com.comcast.crm.contacttest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
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
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.objectrepositoryutility.ContactInfoPage1;
import com.comcast.crm.objectrepositoryutility.ContactPage;
import com.comcast.crm.objectrepositoryutility.ContactWindowHandle;
import com.comcast.crm.objectrepositoryutility.CreateNewContactPage;
import com.comcast.crm.objectrepositoryutility.CreateNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.crm.generic.baseutility.BaseClass;
/*
 *@author Divya  
 */


public class CreateContactTest2POM extends BaseClass {
	@Test(groups="smokeTest")
	public void createContactTest() throws Throwable {
		 /*public static void main(String[] args) throws Throwable {
		 create object
		 FileUtility Flib=new FileUtility(); ExcelUtility Elib=new ExcelUtility();
		 JavaUtility Jlib=new JavaUtility();
		 */

		// read data from properties file
		/*
		 * String BROWSER=Flib.getDataFromPropertiesFile("browser"); String
		 * URL=Flib.getDataFromPropertiesFile("url"); String
		 * UN=Flib.getDataFromPropertiesFile("username"); String
		 * PWD=Flib.getDataFromPropertiesFile("password");
		 */

		// read testscript data from excel
		String lastName = Elib.getDataFromExcel("org", 4, 2) + Jlib.getRandomNumber();

		/*
		 * WebDriver driver=null;
		 * 
		 * if(BROWSER.equals("chrome")) { driver=new ChromeDriver(); } else
		 * if(BROWSER.equals("firefox")) { driver=new FirefoxDriver(); } else
		 * if(BROWSER.equals("edge")) { driver=new EdgeDriver(); } else { driver=new
		 * ChromeDriver(); }
		 */
		// LOGIN TO APP
		/*
		 * LoginPage lp=new LoginPage(driver); lp.loginToApp(url, username, password);
		 * //call the contructor fron login page,
		 */

		/* navigate to contact module*/
		HomePage hp = new HomePage(driver);// create object
		hp.getContactLink().click();
		Thread.sleep(2000);
		/*  click on create contact button*/
		ContactPage cp = new ContactPage(driver);
		cp.getCreateNewContactBtn().click();

		/*  enter all the details and create new contact */
		CreateNewContactPage cnp = new CreateNewContactPage(driver);
		cnp.createContact(lastName);

		/* verify header mandatory info=HARD ASSERT*/
		ContactInfoPage1 cip1 = new ContactInfoPage1(driver);
		String headerMsg = cip1.getContactHeaderMsg().getText();
	
		Boolean status=headerMsg.contains(lastName);
		Assert.assertEquals(status, true);
		
		/* verify LAST NAME NON-MANDATORY SOFT-ASSERT*/
		String actualLastname=cip1.getActualLastName().getText();
		SoftAssert soft= new SoftAssert();
		soft.assertEquals(actualLastname, lastName);
		soft.assertAll();
		

		/*
		 * if (headerMsg.contains(lastName)) { System.out.println(lastName +
		 * " information is verified==PASS"); } else { System.out.println(lastName +
		 * " information is not verified==FAIL");
		 * 
		 * }
		 */
		/*
		 * //logout hp.logout(); driver.quit();
		 */

	}

	
	@Test (groups="regressionTest")
	public void CreateContactWithSupportDateTest2POM() throws Throwable {
		
		/*read testscript data from excel*/
				String lastName=Elib.getDataFromExcel("org", 4, 2)+Jlib.getRandomNumber();
				//navigate to CONTACT module
				HomePage hp=new HomePage(driver);
				hp.getContactLink().click();
				
				/*click on create contact*/
		CreateNewContactPage cncp=new CreateNewContactPage(driver);
				cncp.createContact1(lastName);
				
				/*create system date and required date*/	
				String startdate1=Jlib.getSystemDateYYYYDDMM();
				String enddate1 = Jlib.getRequiredDataYYYYDDMM(30);
					
				cncp.standandend(startdate1,enddate1);
				ContactInfoPage1 cip1=new ContactInfoPage1(driver);
				
				//verify StartDate
				String ActEndDate=cip1.getActualStarDate().getText();
				SoftAssert soft= new SoftAssert();
				soft.assertEquals(ActEndDate,startdate1);
				
				//header EndDate
				String ActEndDAte=cip1.getActualEndDate().getText();
				SoftAssert soft1= new SoftAssert();
		        soft1.assertEquals(ActEndDAte,enddate1);
				soft1.assertAll();
	}
				/*
				 * //verify StartDate String ActualStartDate=
				 * driver.findElement(By.id("dtlview_Support Start Date")).getText(); if
				 * (ActualStartDate.equals(startdate1)) {
				 * System.out.println(startdate1+"information is verified==PASS"); } else {
				 * System.out.println(startdate1+"information is not verified==FAIL");
				 * 
				 * }
				 * 
				 * //header EndDate String ActualEndDate=
				 * driver.findElement(By.id("dtlview_Support End Date")).getText(); if
				 * (ActualEndDate.contains(enddate1)) {
				 * System.out.println(enddate1+"information is verified==PASS"); } else {
				 * System.out.println(enddate1+"information is not verified==FAIL");
				 * 
				 * }
				 */
				
	
	
	@Test(groups="regressionTest")
	public void CreateContactWithOrgTest2POM() throws Throwable {
		// read testscript data from excel
		String orgName = Elib.getDataFromExcel("org", 7, 2) + Jlib.getRandomNumber();
		String contactLastName = Elib.getDataFromExcel("org", 7, 3) + Jlib.getRandomNumber();
		// navigate to organization module
		HomePage hp = new HomePage(driver);// create object
		hp.getOrgLink().click();
		Thread.sleep(2000);
		// CLICK ON CREATE ORG BTN
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.getOrgPlus().click();
		// enter all the details and create new organization
		cnop.createOrg(orgName);
		Thread.sleep(2000);

		// navigate to contact module
		CreateNewContactPage cnp = new CreateNewContactPage(driver);
		cnp.getContactLink().click();
		// click on create contact btn
		cnp.getCreateNewContactBtn().click();
		cnp.createContact1(contactLastName);
		Thread.sleep(2000);
		ContactWindowHandle cwh = new ContactWindowHandle(driver);
		cwh.window(orgName, "Organization Name");

		// SINCE IT IS DYNAMIC WE HAVE TO PASS ORGNAME IN THE PALCE OF TEXT
		driver.findElement(By.xpath("//a[text()='" + orgName + "']")).click();

		cnp.window2();
		ContactInfoPage1 cip1 = new ContactInfoPage1(driver);
		String ActualConName = cip1.getContactHeaderMsg().getText();
		String ActualOrgName = cip1.getActualOrgName().getText();
		
		Assert.assertEquals(true, ActualConName.contains(contactLastName));
		Assert.assertEquals(true, ActualOrgName.contains(orgName));
		
		/*
		 * // verify header message
		 *  ContactInfoPage1 cip1 = new ContactInfoPage1(driver);
		 *  String ActualConName =cip1.getContactHeaderMsg().getText();
		 *  if
		 * (ActualConName.contains(contactLastName)) {
		 * System.out.println(contactLastName + " is verfied"); } else {
		 * System.out.println("Not verified"); } String ActualOrgName =
		 * cip1.getActualOrgName().getText(); if (ActualOrgName.contains(orgName)) {
		 * System.out.println(ActualOrgName + " is verfied"); } else {
		 * System.out.println("Not verified"); }
		 */

		

	}

}