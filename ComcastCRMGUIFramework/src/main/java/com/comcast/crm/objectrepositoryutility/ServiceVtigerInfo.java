package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ServiceVtigerInfo {
@FindBy(name = "servicename")
private WebElement srvnametxb;
@FindBy(name = "servicecategory")
private WebElement srvcatg;
@FindBy(xpath = "(//input[@class='crmbutton small save'])[1]")
private WebElement svbtn;
@FindBy(xpath ="//span[@class='lvtHeaderText']")
private WebElement msg;

public WebElement getMsg() {
	return msg;
}
public WebElement getSvbtn() {
	return svbtn;
}
public WebElement getSrvcatg() {
	return srvcatg;
}
public WebElement getSrvnametxb() {
	return srvnametxb;
}
public ServiceVtigerInfo(WebDriver driver)
{
 PageFactory.initElements(driver,this);	
}

}
