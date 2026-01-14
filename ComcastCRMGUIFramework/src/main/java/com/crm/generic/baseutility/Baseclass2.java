package com.crm.generic.baseutility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generic.databaseutility.DataBaseUtility;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;

public class Baseclass2 {
	public FileUtility Flib=new FileUtility();
	public ExcelUtility Elib=new ExcelUtility();
	public JavaUtility Jlib=new JavaUtility();
	public DataBaseUtility dbLib=new DataBaseUtility();
	public WebDriver driver=null;
	public static WebDriver sdriver=null;
	
	public void BS() {
		System.out.println("BS====connect to DB,Report Config===");
	}
	public void BT() {
		System.out.println("execute Before Test");
	}
	public void BC() throws Throwable {
		System.out.println("BC===Launch the Browser==");
		String BROWSER=Flib.getDataFromPropertiesFile("browser");
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
		
	
	sdriver=driver;
	UtilityClassObject.setDriver(driver);}
	
	public void BM() throws Throwable {
		System.out.println("=Login=");
		String URL = Flib.getDataFromPropertiesFile("url");
		String USERNAME = Flib.getDataFromPropertiesFile("username");
		String PASSWORD= Flib.getDataFromPropertiesFile("password");
		driver.get(URL);
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(URL, USERNAME, PASSWORD);

		System.out.println("login");
	}
	public void AM() {
		System.out.println("=Logout=");
		HomePage hp=new HomePage(driver);
		hp.logout();

		System.out.println("logout");
	}
	public void AC() {
		System.out.println("AC===Close the Browser===");
		driver.quit();
		
	}

	public void At() {
		System.out.println("execute After Test");
	}

	public void AS() {
		System.out.println("BS====connect to DB,Report Config===");
	}

}
