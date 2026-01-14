package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
	
	
WebDriver driver;
	
	//object initialization
	public OrganizationInfoPage(WebDriver driver) {
		this.driver=driver;//means during the time of initialization,store driver object adress into global driver
		PageFactory.initElements(driver, this);// this means current class object
	}
	
@FindBy(className="dvHeaderText")
private WebElement headerMsg;

@FindBy(id="dtlview_Industry")
private WebElement industrymsg;

@FindBy(id="dtlview_Phone")
private WebElement phoneMsg;

public WebElement getPhoneMsg() {
	return phoneMsg;
}

public WebElement getIndustrymsg() {
	return industrymsg;
}

public WebElement getTypemsg() {
	return typemsg;
}

@FindBy(id="dtlview_Type")
private WebElement typemsg;

public WebElement getHeaderMsg() {
	return headerMsg;
}

}

