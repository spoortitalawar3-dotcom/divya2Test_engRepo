package com.comcast.crm.contacttest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.objectrepositoryutility.HomeVtiger;
import com.comcast.crm.objectrepositoryutility.LoginVtiger;
import com.comcast.crm.objectrepositoryutility.ProdInfoVtiger;
import com.comcast.crm.objectrepositoryutility.ProdVtiger;




public class Vtiger_Pom_Utility {
	public static void main(String[] args) throws Throwable {
		FileUtility fu=new FileUtility();
		String url = fu.getDataFromPropertiesFile("url");
		String un = fu.getDataFromPropertiesFile("username");
		String pwd = fu.getDataFromPropertiesFile("password");
		JavaUtility ju=new JavaUtility();
		int n = ju.getRandomNumber();
		ExcelUtility eu1=new ExcelUtility();
		String prodname =eu1.getDataFromExcel("org",4, 1).toString()+n;
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		driver.get(url);
		LoginVtiger lv=new LoginVtiger(driver);
		lv.logintoApp(un, pwd);
		HomeVtiger hv=new HomeVtiger(driver);
		hv.getProdlnk().click();
		ProdVtiger ov=new ProdVtiger(driver);
		ov.getCretprod().click();
		ProdInfoVtiger oinfo=new ProdInfoVtiger(driver);
		oinfo.createprod(prodname);
		String prodtext = oinfo.getPrdmsg().getText();
		if(prodtext.contains(prodname))
		{
			System.out.println("====pass==");
		}
		else
			System.out.println("=====fail=====");
	}

}
