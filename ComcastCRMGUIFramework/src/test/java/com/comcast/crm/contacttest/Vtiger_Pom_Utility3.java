package com.comcast.crm.contacttest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.fileutility.JasonUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.HomeVtiger;
import com.comcast.crm.objectrepositoryutility.LoginVtiger;
import com.comcast.crm.objectrepositoryutility.OrgInfoVtiger;
import com.comcast.crm.objectrepositoryutility.OrgVtigerDelete;

public class Vtiger_Pom_Utility3 {
	public static void main(String[] args) throws Throwable {
		FileUtility fu=new FileUtility();
		String url =fu.getDataFromPropertiesFile("url");
		String un = fu.getDataFromPropertiesFile("username");
		String pwd = fu.getDataFromPropertiesFile("password");
		JavaUtility ju=new JavaUtility();
		
		ExcelUtility eu=new ExcelUtility();
		String orgname =eu.getDataFromExcel("Org",7, 1)+ju.getRandomNumber();
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		driver.get(url);
		LoginVtiger lv=new LoginVtiger(driver);
		lv.logintoApp(un, pwd);
		HomeVtiger hv=new HomeVtiger(driver);
		hv.getOrglnk().click();
		OrgInfoVtiger oinfo=new OrgInfoVtiger(driver);
		oinfo.createOrgname(orgname,"workspace");
		Thread.sleep(2000);
		hv.getOrglnk().click();
		//org should be created
		Thread.sleep(2000);
		OrgVtigerDelete ovd=new OrgVtigerDelete(driver);
		
		WebElement ele1 =ovd.getSrchdrpd();
		WebDriverUtility wdu=new WebDriverUtility();
		wdu.select(ele1, 1);
		ovd.getSechtxf().sendKeys(orgname);
		ovd.getSrchnow().click();
		Thread.sleep(2000);
		ovd.getSrch().click();
		Thread.sleep(2000);
		ovd.getWebele1().click();
		Thread.sleep(2000);
		wdu.switchtoAlertAndAccept(driver);
		String text = ovd.getMsg().getText();
		System.out.println(text);
		
		
	}

}
