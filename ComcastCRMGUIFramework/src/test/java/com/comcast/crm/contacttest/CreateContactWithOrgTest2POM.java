package com.comcast.crm.contacttest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.ContactInfoPage1;
import com.comcast.crm.objectrepositoryutility.ContactWindowHandle;
import com.comcast.crm.objectrepositoryutility.CreateNewContactPage;
import com.comcast.crm.objectrepositoryutility.CreateNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;

public class CreateContactWithOrgTest2POM {

	public static void main(String[] args) throws Throwable {
		//IT IS A INTEGRATION TESTCASE,DURING AUTOMSTION OF INTEGRATION TESTCASE,CONSIDER PRECONDITON
		//PRE CONDITIN = ATKEAST ONE ORGANIZATION SHOULD BE CREATED
		//DURING EXECUTION OF NEW BUILD DATA IS EMPTY
		
// I HAVE TO CREATE CONTACT BUT DURING CREATION I NEED TO TAKE ORGANIZATION FROM LOOKUP
		//create object
		FileUtility Flib=new FileUtility();
		ExcelUtility Elib=new ExcelUtility();
		JavaUtility Jlib=new JavaUtility();
		WebDriverUtility Wlib=new WebDriverUtility();
		
		//read data from properties file
		String BROWSER=Flib.getDataFromPropertiesFile("browser");
		String URL=Flib.getDataFromPropertiesFile("url");
		String UN=Flib.getDataFromPropertiesFile("username");
		String PWD=Flib.getDataFromPropertiesFile("password");	
		
		//read testscript data from excel
		String orgName=Elib.getDataFromExcel("org", 7, 2)+Jlib.getRandomNumber();
		String contactLastName=Elib.getDataFromExcel("org", 7, 3)+Jlib.getRandomNumber();
	
				WebDriver driver=null;
				
				if(BROWSER.equals("chrome")) {
					driver=new ChromeDriver();
				}
				else if(BROWSER.equals("firefox")) {
					driver=new FirefoxDriver();
				}
				else if(BROWSER.equals("edge")) {
					driver=new EdgeDriver();
				}
				else {
					driver=new ChromeDriver();
				}
				//step:1 LOGIN TO APP
			
			
				LoginPage lp=new LoginPage(driver);
				lp.loginToApp(URL, UN, PWD);
				
				//navigate to organization module
				HomePage hp=new HomePage(driver);//create object
				hp.getOrgLink().click();
				Thread.sleep(2000);	
		
				//enter all the details and create new organization
				CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
				cnop.getOrgPlus().click();
				cnop.createOrg(orgName);
				Thread.sleep(2000);
		
				
			CreateNewContactPage cnp=new CreateNewContactPage(driver);
			cnp.getContactLink().click();
			cnp.getCreateNewContactBtn().click();
			cnp.createContact1(contactLastName);
			Thread.sleep(2000);
			
			
			ContactWindowHandle cwh=new ContactWindowHandle(driver);
			cwh.window(orgName, "Organization Name");
			
			
			//SINCE IT IS DYNAMIC WE HAVE TO PASS ORGNAME IN THE PALCE OF TEXT
			driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
			
		
			cnp.window2();
			 //verify header message
			ContactInfoPage1 cip1=new ContactInfoPage1(driver);
			String ActualConName=cip1.getContactHeaderMsg().getText();
			if(ActualConName.contains(contactLastName)) {
				System.out.println(contactLastName+" is verfied");
			}
			else {
				System.out.println("Not verified");
			}
				
				
				String ActualOrgName=cip1.getActualOrgName().getText();	
				if(ActualOrgName.contains(orgName)) {	System.out.println(ActualOrgName+" is verfied");
				}
				else {
					System.out.println("Not verified");
				}

	             
		driver.quit();

	}
	}


