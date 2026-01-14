package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CreateNewContactPage {
WebDriver driver;

//object initialization
	public CreateNewContactPage(WebDriver driver) {
		this.driver=driver;//means during the time of initialization,store driver object adress into global driver
		PageFactory.initElements(driver, this);// this means current class object
	}
	@FindBy(linkText="Contacts")
	private WebElement contactLink;
	
@FindBy(name="lastname")
private WebElement lastnameEdit;

@FindBy(xpath="//input[@title='Save [Alt+S]']")
private WebElement saveBtn;

@FindBy(xpath="//img[@title='Create Contact...']")
private WebElement createNewContactBtn;

@FindBy(xpath="//input[@title='Save [Alt+S]']")
private WebElement ConLastSaveBtn;

@FindBy(name="support_start_date")
private WebElement startdate;

@FindBy(name="support_end_date")
private WebElement enddate;

@FindBy(xpath="//input[@title='Save [Alt+S]']")
private WebElement saveBtn1;

public WebElement getSaveBtn1() {
	return saveBtn1;
}

public WebElement getStartdate() {
	return startdate;
}

public WebElement getEnddate() {
	return enddate;
}

public WebElement getConLastSaveBtn() {
	return ConLastSaveBtn;
}

public WebElement getContactLink() {
	return contactLink;
}

public WebElement getLastnameEdit() {
	return lastnameEdit;
}

public WebElement getSaveBtn() {
	return saveBtn;
}
public WebElement getCreateNewContactBtn() {
	return createNewContactBtn;
}
	
public void createContact(String lastName) {
	createNewContactBtn.click();
	lastnameEdit.sendKeys(lastName);
	saveBtn.click();
}
public void createContact1(String lastName) {
	createNewContactBtn.click();
	lastnameEdit.sendKeys(lastName);
	
}
public void window2() {
	WebDriverUtility wu1=new WebDriverUtility();
	wu1.switchToTabOnTitle(driver, "module=Contacts&action");
	ConLastSaveBtn.click();

}

public void standandend(String startdate1,String enddate1) {
startdate.clear();
startdate.sendKeys(startdate1);
enddate.clear();
enddate.sendKeys(enddate1);
saveBtn1.click();

}
	
	
	

	
}

