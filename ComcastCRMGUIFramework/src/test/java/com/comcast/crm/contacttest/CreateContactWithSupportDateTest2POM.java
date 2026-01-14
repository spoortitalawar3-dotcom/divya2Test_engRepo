package com.comcast.crm.contacttest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.objectrepositoryutility.ContactPage;
import com.comcast.crm.objectrepositoryutility.CreateNewContactPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;

public class CreateContactWithSupportDateTest2POM {

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
		String lastName=Elib.getDataFromExcel("org", 4, 2)+Jlib.getRandomNumber();
		
		
		
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
		
		//navigate to CONTACT module
		HomePage hp=new HomePage(driver);
		hp.getContactLink().click();
		
		//click on create contact
CreateNewContactPage cncp=new CreateNewContactPage(driver);
		cncp.createContact1(lastName);
		cncp.standandend(Jlib.getSystemDateYYYYDDMM(), Jlib.getRequiredDataYYYYDDMM(30));
		
	//create system date and required date	
	String startdate1=Jlib.getSystemDateYYYYDDMM();
	String enddate1 = Jlib.getRequiredDataYYYYDDMM(30);
		
		
		
		//EXPECTATION=

				//verify StartDate
						
						String ActualStartDate= driver.findElement(By.id("dtlview_Support Start Date")).getText();
						if (ActualStartDate.equals(startdate1))
						{
							System.out.println(startdate1+"information is verified==PASS");	
						}
						else {
							System.out.println(startdate1+"information is not verified==FAIL");
							
						}

		//header EndDate
						String ActualEndDate= driver.findElement(By.id("dtlview_Support End Date")).getText();
						if (ActualEndDate.contains(enddate1))
						{
							System.out.println(enddate1+"information is verified==PASS");	
						}
						else {
							System.out.println(enddate1+"information is not verified==FAIL");
							
						}
		
		driver.quit();
		

	}

}
