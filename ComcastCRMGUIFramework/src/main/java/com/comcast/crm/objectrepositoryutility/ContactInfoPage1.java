package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class ContactInfoPage1 {
WebDriver driver;
	
	//object initialization
	public ContactInfoPage1(WebDriver driver) {
		this.driver=driver;//means during the time of initialization,store driver object adress into global driver
		PageFactory.initElements(driver, this);// this means current class object
	}

	@FindBy(className ="dvHeaderText")
	private WebElement contactHeaderMsg;
	
	@FindBy(xpath="//td[@class='dvtCellInfo']/a")
	private WebElement actualOrgName;

	public WebElement getActualOrgName() {
		return actualOrgName;
	}
	@FindBy(id="dtlview_Last Name")
	private WebElement actualLastName;
	
	@FindBy(id="dtlview_Support Start Date")
	private WebElement actualStarDate;
	
	@FindBy(id="dtlview_Support End Date")
	private WebElement actualEndDate;
	

	public WebElement getActualEndDate() {
		return actualEndDate;
	}

	public void setActualEndDate(WebElement actualEndDate) {
		this.actualEndDate = actualEndDate;
	}

	public WebElement getActualStarDate() {
		return actualStarDate;
	}

	public WebElement getActualLastName() {
		return actualLastName;
	}

	public WebElement getContactHeaderMsg() {
		return contactHeaderMsg;
	}

public void window2() {
	WebDriverUtility wu1=new WebDriverUtility();
	wu1.switchToTabOnTitle(driver, "module=Contacts&action");
	

}
}