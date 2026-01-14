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

public class CreateOrganizationWithPhoneNumberTest {

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
		String phoneNumber =Elib.getDataFromExcel("org", 7, 4)+Jlib.getRandomNumber();
	 
		
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
		
		driver.findElement(By.name("user_name")).sendKeys(UN);
		driver.findElement(By.name("user_password")).sendKeys(PWD);
		driver.findElement(By.id("submitButton")).click();
		
		//navigate to organization module
		driver.findElement(By.linkText("Organizations")).click();
		//create organization button
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		//enter all the details and create new organization
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		driver.findElement(By.xpath("//input[@id='phone']")).sendKeys(phoneNumber);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//EXPECTATION=CHECK WETHER U CAN CREATE ORGANIZATION WITH INDUSTRIAL TYPE

				//verify header phone number
						
						String actualPhoneNum = driver.findElement(By.id("dtlview_Phone")).getText();
						if (actualPhoneNum.equals(phoneNumber))
						{
							System.out.println(phoneNumber+"information is verified==PASS");	
						}
						else {
							System.out.println(phoneNumber+"information is not verified==FAIL");
							
						}

		
		
		


	}

}
