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

public class CreateOrganizationWithIndustriesTest2POM {

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
				String orgName=Elib.getDataFromExcel("org", 1, 2)+Jlib.getRandomNumber();
		String industry = Elib.getDataFromExcel("org", 4, 3);
	    String type =Elib.getDataFromExcel("org", 4, 4);
		
		
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
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(URL);
		
		//object initialization
				LoginPage lp=new LoginPage(driver);//call the contructor fron login page,
				lp.loginToApp(UN, PWD);
		
		//navigate to organization module
				HomePage hp=new HomePage(driver);//create object
				hp.getOrgLink().click();
				Thread.sleep(2000);	
		//create organization button
				OrganizationPage cnp= new OrganizationPage(driver);
				cnp.getCreateNewOrgBtn().click();
				Thread.sleep(2000);	
		
		//enter all the details and create new organization
				CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
				cnop.createOrg(orgName,industry,type);
				OrganizationInfoPage oip=new OrganizationInfoPage(driver);
				String actualIndustry=oip.getIndustrymsg().getText();
				String actualType=oip.getTypemsg().getText();
				System.out.println(industry);
				System.out.println(actualIndustry);
					
		//EXPECTATION=CHECK WETHER U CAN CREATE ORGANIZATION WITH INDUSTRIAL TYPE

				//Verify the industries and type info
						
						if (actualIndustry.equals(industry))
						{
							System.out.println(industry+"information is verified==PASS");	
						}
						else {
							System.out.println(industry+"information is not verified==FAIL");
							
						}
						
						
						if (actualType.contains(type))
						{
							System.out.println(type+"information is verified==PASS");	
						}
						else {
							System.out.println(type+"information is not verified==FAIL");
							
						}

		
		hp.logout();
		driver.quit();
		

	}

}
