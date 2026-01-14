package com.comcast.crm.contacttest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.HomeVtiger;
import com.comcast.crm.objectrepositoryutility.LoginVtiger;
import com.comcast.crm.objectrepositoryutility.ServiceVtiger;
import com.comcast.crm.objectrepositoryutility.ServiceVtigerInfo;



public class Vtiger_Pom_Utility4 {
	public static void main(String[] args) throws Throwable  {
		FileUtility fu=new FileUtility();
		String url = fu.getDataFromPropertiesFile("url");
		String un = fu.getDataFromPropertiesFile("username");
		String pwd = fu.getDataFromPropertiesFile("password");
		JavaUtility ju=new JavaUtility();
		int n =ju.getRandomNumber();
		ExcelUtility eu=new ExcelUtility();
		String servname = eu.getDataFromExcel("Org",7,1)+n;
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		
		driver.get(url);
		LoginVtiger lv=new LoginVtiger(driver);
		lv.logintoApp(un, pwd);
		HomeVtiger hv=new HomeVtiger(driver);
		hv.navigateToService();
		hv.getSrvlnk().click();
	    ServiceVtiger sv=new ServiceVtiger(driver);
	    sv.getCretsrv().click();
		ServiceVtigerInfo svinf=new ServiceVtigerInfo(driver);
		svinf.getSrvnametxb().sendKeys(servname);
		WebElement ele1 = svinf.getSrvcatg();
		WebDriverUtility wdu=new WebDriverUtility();
		wdu.select(ele1,"Support");
		//driver.findElement(By.id("jscal_trigger_sales_end_date")).click();
		//(//tr[@class='headrow']/child::td)[19]
		//(//div[@class="calendar"])[7]//td[@class="button nav"][3]
		//driver.findElement(By.xpath("(//div[@class=\"calendar\"])[7]//td[@class=\"button nav\"][3]")).click();
		svinf.getSvbtn().click();
		
		String text1 = svinf.getMsg().getText();
		if(text1.contains(servname))
		{
			System.out.println("====pass=====");
		}
		else
			System.out.println("=====fail======");
		
	}

}
