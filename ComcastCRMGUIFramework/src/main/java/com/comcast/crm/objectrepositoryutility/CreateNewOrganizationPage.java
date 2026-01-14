package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateNewOrganizationPage {
	
WebDriver driver;
	
	//object initialization
	public CreateNewOrganizationPage(WebDriver driver) {
		this.driver=driver;//means during the time of initialization,store driver object adress into global driver
		PageFactory.initElements(driver, this);// this means current class object
	}
	
	@FindBy(name="accountname")
	private WebElement orgNameEdit;
	
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	@FindBy(name="industry")
	private WebElement industryDropdown;
	
	@FindBy(name="accounttype")
	private WebElement searchTypeDropdown;
	
	@FindBy(id="phone")
	private WebElement phoneEdit;
	
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement orgPlus;

	public WebElement getOrgPlus() {
		return orgPlus;
	}

	public WebElement getPhoneEdit() {
		return phoneEdit;
	}
	
	public WebElement getIndustryDropdown() {
		return industryDropdown;
	}

	public WebElement getSearchTypeDropdown() {
		return searchTypeDropdown;
	}

	public WebElement getShipEdit() {
		return shipEdit;
	}

	@FindBy(name="ship_street")
	private WebElement shipEdit;

	
	public WebElement getOrgNameEdit() {
		return orgNameEdit;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	public void createOrg(String orgName,String industry) {
		orgNameEdit.sendKeys(orgName);
		Select s=new Select(industryDropdown);
		s.selectByVisibleText(industry);
		saveBtn.click();
		
	}
	public void createOrg(String orgName,String industry,String type) {
		orgNameEdit.sendKeys(orgName);
		shipEdit.sendKeys("address");
		Select s=new Select(industryDropdown);
		s.selectByVisibleText(industry);
		Select s2=new Select(searchTypeDropdown);
		s2.selectByVisibleText(type);
		saveBtn.click();
		
	}
	public void createOrg(String orgName) {
		orgNameEdit.sendKeys(orgName);
		saveBtn.click();
	
	}
	public  void createNewOrgWithPhone(String orgName,String phone) {
		orgNameEdit.sendKeys(orgName);
		phoneEdit.sendKeys(phone);
		shipEdit.sendKeys("address");
		saveBtn.click();
		
	}
	
}
