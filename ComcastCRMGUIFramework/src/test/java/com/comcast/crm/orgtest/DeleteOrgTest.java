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

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.CreateNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationPage;

public class DeleteOrgTest {

	public static void main(String[] args) throws Throwable {
		//create object
		FileUtility Flib=new FileUtility();
		ExcelUtility Elib=new ExcelUtility();
		JavaUtility Jlib=new JavaUtility();
		WebDriverUtility wlib=new WebDriverUtility();
		
		//read data from properties file
		String BROWSER=Flib.getDataFromPropertiesFile("browser");
		String URL=Flib.getDataFromPropertiesFile("url");
		String UN=Flib.getDataFromPropertiesFile("username");
		String PWD=Flib.getDataFromPropertiesFile("password");	
		
		//read testscript data from excel
		String orgName=Elib.getDataFromExcel("org", 10, 2)+Jlib.getRandomNumber();
		
		
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
		//click on create organization button
		OrganizationPage cnp= new OrganizationPage(driver);
		cnp.getCreateNewOrgBtn().click();
		
		
		//enter all the details and create new organization
		CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
		cnop.createOrg(orgName);
		
		//Expectedresult=ORGANIZATION SHOULD BE CREATED AND DISPLAYED IN ORGANIZATION DETAILS PAGE AND
		//DISPLAY THE BELOW MESSAGE PAGE HEADER"[ORG**]****-Organization information"
		
		//verify header message expected result
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		String actOrgName=oip.getHeaderMsg().getText();
		if(actOrgName.contains(orgName)) {
			System.out.println(orgName+"name is verified==Pass");
		}
		else {
			System.out.println(orgName+"name is not verified==Fail");
		}
	//go back to organization Page
		hp.getOrgLink().click();
		
		//search for organization
		cnp.getSearchEdit().sendKeys(orgName);
		wlib.select(cnp.getSearchDropDown(), "Organization Name");
		cnp.getSearchBtn().click();
		
		//in dynamic web table select and delete org
		//This xpath getting condtructed during runtime
		//romove static data that is 'Deepak' and concatinate it to orgName to make it dynamic
		driver.findElement(By.xpath("//a[text()='"+orgName+"']/../../td[8]/a[text()='del']")).click();
		wlib.switchtoAlertAndAccept(driver);
		
		
		//logout
		hp.logout();
		driver.quit();
		
		
		
		
		
		

	}

}
