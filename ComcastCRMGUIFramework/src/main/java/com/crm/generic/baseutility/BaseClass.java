package com.crm.generic.baseutility;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.generic.databaseutility.DataBaseUtility;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;

public class BaseClass {
	//create object
	public FileUtility Flib=new FileUtility();
	public ExcelUtility Elib=new ExcelUtility();
	public JavaUtility Jlib=new JavaUtility();
	public DataBaseUtility dbLib=new DataBaseUtility();
	public WebDriver driver=null;// driver variable declare globally, driver is non static
	
	public static WebDriver sdriver=null;//sdriver is static used as a temorary driver object for parallel execu
	
	@BeforeSuite(groups={"smokeTest","regressionTest"})
	//also can give(alwaysRun=true)
	public void configBS() throws SQLException {
	System.out.println("===connect to DB,Report Config===");
		dbLib.getDbconnection();
		
	}
	//@Parameters("BROWSER")
	@BeforeClass(groups={"smokeTest","regressionTest"})
	//public void configBC(String browser) throws Throwable {
		public void configBC() throws Throwable {
		System.out.println("===Launch the Browser===");
		//String BROWSER = browser;
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
		UtilityClassObject.setDriver(driver);//wherever u have sdriver use utility class object sdriver to trigger browser driver
	}
	
	@BeforeMethod(groups={"smokeTest","regressionTest"})
	public void configBM() throws Throwable {
				System.out.println("=Login=");
		String URL = Flib.getDataFromPropertiesFile("url");
		String USERNAME = Flib.getDataFromPropertiesFile("username");
		String PASSWORD= Flib.getDataFromPropertiesFile("password");
		driver.get(URL);
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(URL, USERNAME, PASSWORD);

	}
    @AfterMethod(groups={"smokeTest","regressionTest"})
	public void configAM() {
		System.out.println("=Logout=");
		HomePage hp=new HomePage(driver);
		hp.logout();
}
    @AfterClass(groups={"smokeTest","regressionTest"})
	public void configAC() {
		System.out.println("===Close the Browser===");
		driver.quit();
		
	}
    @AfterSuite(groups={"smokeTest","regressionTest"})
	public void configAS() {
		System.out.println("===close DB,Report backUp===");
		dbLib.closeDbaseConnection();
		
	}
   // @BeforeTest this condition is required when you want to do
    //any pre conditions before doing parallel execution.

}
