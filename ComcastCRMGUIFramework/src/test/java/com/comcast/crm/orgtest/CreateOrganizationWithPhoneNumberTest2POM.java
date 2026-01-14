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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.objectrepositoryutility.CreateNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationPage;

public class CreateOrganizationWithPhoneNumberTest2POM {

	public static void main(String[] args) throws Throwable {
		//create object
		FileUtility Flib=new FileUtility();
		ExcelUtility Elib=new ExcelUtility();
		JavaUtility Jlib=new JavaUtility();
		
		//read data from properties file
		String BROWSER=Flib.getDataFromPropertiesFile("browser");
		String URL=Flib.getDataFromPropertiesFile("url");
		String UN=Flib.getDataFromPropertiesFile("username");
		String PWD=Flib.getDataFromPropertiesFile("password");	
		
		//read testscript data from excel
		String orgName=Elib.getDataFromExcel("org", 7, 2)+Jlib.getRandomNumber();
		String phone =Elib.getDataFromExcel("org", 7, 4)+Jlib.getRandomNumber();
	 
		
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
		//LOGIN TO APP
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(URL, UN, PWD);
		

		//navigate to organization module
				HomePage hp=new HomePage(driver);//create object
				hp.getOrgLink().click();
				Thread.sleep(2000);	
		//create organization button
				OrganizationPage cnp= new OrganizationPage(driver);
				cnp.getCreateNewOrgBtn().click();
				Thread.sleep(2000);	
	
		//create organization button
	 //enter all the details and create new organization
		CreateNewOrganizationPage cnp1=new CreateNewOrganizationPage(driver);
		cnp1.createNewOrgWithPhone(orgName,phone);
		
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		String actualPhoneNum=oip.getPhoneMsg().getText();
		
		//EXPECTATION=CHECK WETHER U CAN CREATE ORGANIZATION WITH INDUSTRIAL TYPE

				//verify header phone number
						
						if (actualPhoneNum.equals(phone))
						{
							System.out.println(phone+"information is verified==PASS");	
						}
						else {
							System.out.println(phone+"information is not verified==FAIL");
							
						}

						hp.logout();
						driver.quit();
		
		


	}

}
