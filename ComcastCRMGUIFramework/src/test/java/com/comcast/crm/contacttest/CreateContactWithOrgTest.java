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

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CreateContactWithOrgTest {

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
			Wlib.waitForPageLoad(driver);
				driver.get(URL);
				
				driver.findElement(By.name("user_name")).sendKeys(UN);
				driver.findElement(By.name("user_password")).sendKeys(PWD);
				driver.findElement(By.id("submitButton")).click();
				
				//step:2 navigate to organization module
				driver.findElement(By.linkText("Organizations")).click();
				//step:3 click on organization button
				driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
				
				//step:4 enter all the details and create new organization
				driver.findElement(By.name("accountname")).sendKeys(orgName);
				
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

				//Expectedresult=ORGANIZATION SHOULD BE CREATED AND DISPLAYED IN ORGANIZATION DETAILS PAGE AND
				//DISPLAY THE BELOW MESSAGE PAGE HEADER"[ORG**]****-Organization information
				
				// verify header orgName info Expected Result
				String headerInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
				if(headerInfo.contains(orgName))//when u r using partial value
					{
					System.out.println(orgName+"is created==PASS");	
				}
				else {
					System.out.println(orgName+"is not created==FAIL");
					}
				//step:5 navigate to contact module 
			     driver.findElement(By.linkText("Contacts")).click();
				//step:6 click on create organization button
				driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
				
				//step:7 enter all the details and create new organization
				driver.findElement(By.name("lastname")).sendKeys(contactLastName);
				driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();//following sibling xpath	
				
				//switch to childWindow
			Wlib.switchToTabOnURL(driver, "module=Accounts");	
				
			    driver.findElement(By.name("search_text")).sendKeys(orgName);
				driver.findElement(By.name("search")).click();
				driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();//dynamic xpath
			
				
				//TO COME BACK TO PARENT WINDOW
				Wlib.switchToTabOnURL(driver, "Contacts&action");	    
				
//			    Iterator<String> itr1= set1.iterator();//ceate iterator object
//			    while(itr.hasNext())   // to capture first data from set collection
//			    	{
//			    	String windowId=itr1.next();//capture the window id
//			    	driver.switchTo().window(windowId);//switch to first window
//	
//					String actUrl = driver.getCurrentUrl();//get title of the window
//			    	if(actUrl.contains("Contacts&action")) {
//			    		break;//if window contain my Parentwindow name switch to that and i got my window, break it.
//			    	}
//			    	}
			    Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
								
	             //verify header message expected result
				 headerInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
				if(headerInfo.contains(contactLastName))//when u r using partial value
					{
					System.out.println(contactLastName+"is created==PASS");	
				}
				else {
					System.out.println(contactLastName+"is not created==FAIL");
					}
				//verify header orgName info Expected Result
				String actualOrgName = driver.findElement(By.id("mouseArea_Organization Name")).getText();
				System.out.println(actualOrgName);
				if (actualOrgName.trim().equals(orgName))
				{
					System.out.println(orgName+"is created==PASS");	
				}
				else {
					System.out.println(orgName+"is not created==FAIL");
					
				}

		driver.quit();

	}
	}


