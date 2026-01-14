package com.comcast.crm.objectrepositoryutility;

import org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument.Field.Xpath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class ContactWindowHandle {
	
WebDriver driver;
	
	//object initialization
	public ContactWindowHandle(WebDriver driver) {
		this.driver=driver;//means during the time of initialization,store driver object adress into global driver
		PageFactory.initElements(driver, this);// this means current class object
	}
	
	@FindBy(xpath="//input[@name='account_id']/following-sibling::img")
	private WebElement contactSubPlus;
	
	@FindBy(xpath="//input[@id='search_txt']")
	private WebElement searchBox;
	
	@FindBy(xpath="//input[@name='search']")
	private WebElement searchBtn;
	
	@FindBy(name="search_field")
	private WebElement searchConDP;

	public WebElement getContactSubPlus() {
		return contactSubPlus;
	}



	public WebElement getSearchBox() {
		return searchBox;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getSearchConDP() {
		return searchConDP;
	}

public void window(String orgName,String OrganizationName ) {
	contactSubPlus.click();
		WebDriverUtility wu=new WebDriverUtility();
		wu.switchToTabOnTitle(driver, "module=Accounts&action");
		searchBox.sendKeys(orgName);
	Select s=new Select(searchConDP);
	s.selectByVisibleText(OrganizationName);
	searchBtn.click();
	}
}
