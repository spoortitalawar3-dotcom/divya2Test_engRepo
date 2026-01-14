package com.comcast.crm.contacttest;

import java.io.FileInputStream;
import java.time.Duration;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.objectrepositoryutility.HomeVtiger;
import com.comcast.crm.objectrepositoryutility.LoginVtiger;
import com.comcast.crm.objectrepositoryutility.OpportunityInfo;
import com.comcast.crm.objectrepositoryutility.OpportunityVtiger;
import com.comcast.crm.objectrepositoryutility.OrgInfoVtiger;
import com.comcast.crm.objectrepositoryutility.OrgVtiger;


public class Vtiger_Pom_Utility2 {
public static void main(String[] args) throws Throwable {
	FileUtility fu=new FileUtility();
	
	String url =fu.getDataFromPropertiesFile("url");
	String un = fu.getDataFromPropertiesFile("username");
	String pwd = fu.getDataFromPropertiesFile("password");
	JavaUtility ju=new JavaUtility();
	int n =ju.getRandomNumber();
	ExcelUtility eu1=new ExcelUtility();
	String orgname =eu1.getDataFromExcel("org",1,1)+n;
	String optname =eu1.getDataFromExcel("org",1,2)+n;
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
	driver.get(url);
	LoginVtiger lv=new LoginVtiger(driver);
	lv.logintoApp(un, pwd);
	HomeVtiger hv=new HomeVtiger(driver);
	hv.getOrglnk().click();
	//org should be created
	OrgInfoVtiger oit=new OrgInfoVtiger(driver);
	oit.createOrgname(orgname,"workspace");
	Thread.sleep(2000);
	OrgVtiger ov=new OrgVtiger(driver);
	
	String orgdata = ov.getHeadermsg().getText();
	System.out.println(orgdata);
	//verify orgname
	if(orgdata.contains(orgname))
	{
		System.out.println(orgname+"is created so ====PASS");
	}
	else
		System.out.println(orgname+"is created so=====FAIL");
	Thread.sleep(4000);
	
    //opportunity
	hv.getOpplink().click();
	OpportunityVtiger oppv=new OpportunityVtiger(driver);
	oppv.getCrtopp().click();
	OpportunityInfo oinfo=new OpportunityInfo(driver);
	oinfo.getOppname().sendKeys(optname);
	oinfo.getAddwin().click();
	oinfo.switchwindow(driver,"module=Accounts");
	oinfo.getSrchtxtf().sendKeys(orgname);
	oinfo.getSrchbtn().click();
	driver.findElement(By.xpath("//a[text()='"+orgname+"']")).click();
	oinfo.switchwindow(driver,"Potentials&action");
	Thread.sleep(2000);
	oinfo.getSavebtn().click();
	
	  //opptext = driver.findElement(By.id("mouseArea_Opportunity Name")).getText();
	  String headtext =oinfo.getHeadmsg().getText();
	  if(headtext.contains(optname)) { System.out.println("======pass==========");
	  } else System.out.println("===========fail=========");
	 
	
}
}
