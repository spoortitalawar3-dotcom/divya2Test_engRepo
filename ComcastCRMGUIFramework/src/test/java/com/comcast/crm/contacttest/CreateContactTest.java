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

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.crm.generic.baseutility.BaseClass;

public class CreateContactTest extends BaseClass {

	public static void main(String[] args) throws Throwable {
		
				//read testscript data from excel
				String lastName=Elib.getDataFromExcel("org", 4, 2)+Jlib.getRandomNumber();
				
		driver.findElement(By.name("user_name")).sendKeys(UN);
		driver.findElement(By.name("user_password")).sendKeys(PWD);
		driver.findElement(By.id("submitButton")).click();
		
		//navigate to organization module
		driver.findElement(By.linkText("Contacts")).click();
		//create organization button
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
		//step;4 enter all the details and create new organization
		driver.findElement(By.name("lastname")).sendKeys(lastName);

		
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
	
		//verify Header phone Number info Expected Result
		String actLastName=driver.findElement(By.id("dtlview_Last Name")).getText();
		if(actLastName.equals(lastName)) {
			System.out.println(lastName+"information is verified as==PASS");}
		
	else {System.out.println(lastName+"information is verified as==FAIL");}
	
}
driver.quit;}}
		
		