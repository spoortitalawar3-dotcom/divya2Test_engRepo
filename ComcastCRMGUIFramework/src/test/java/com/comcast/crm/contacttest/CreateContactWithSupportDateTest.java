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

public class CreateContactWithSupportDateTest {

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
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(URL);
		
		driver.findElement(By.name("user_name")).sendKeys(UN);
		driver.findElement(By.name("user_password")).sendKeys(PWD);
		driver.findElement(By.id("submitButton")).click();
		
		//navigate to organization module
		driver.findElement(By.linkText("Contacts")).click();
		//create organization button
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
	//create system date and required date	
	String startDate=Jlib.getSystemDateYYYYDDMM();
	String endDate = Jlib.getRequiredDataYYYYDDMM(30);
		
		driver.findElement(By.name("lastname")).sendKeys(lastName);
		driver.findElement(By.name("support_start_date")).clear();
		driver.findElement(By.name("support_start_date")).sendKeys(startDate);
		
		driver.findElement(By.name("support_end_date")).clear();
		driver.findElement(By.name("support_end_date")).sendKeys(endDate);
		
		
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//EXPECTATION=

				//verify StartDate
						
						String ActualStartDate= driver.findElement(By.id("dtlview_Support Start Date")).getText();
						if (ActualStartDate.equals(startDate))
						{
							System.out.println(startDate+"information is verified==PASS");	
						}
						else {
							System.out.println(startDate+"information is not verified==FAIL");
							
						}

		//header EndDate
						String ActualEndDate= driver.findElement(By.id("dtlview_Support End Date")).getText();
						if (ActualEndDate.contains(endDate))
						{
							System.out.println(endDate+"information is verified==PASS");	
						}
						else {
							System.out.println(endDate+"information is not verified==FAIL");
							
						}
		
		driver.quit();
		

	}

}
