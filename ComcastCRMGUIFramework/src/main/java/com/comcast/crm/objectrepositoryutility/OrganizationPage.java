package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {
WebDriver driver;
	
	//object initialization
	public OrganizationPage(WebDriver driver) {
		this.driver=driver;//means during the time of initialization,store driver object adress into global driver
		PageFactory.initElements(driver,this);// this means current class object
	}
	@FindBy(name="search_text")
	private WebElement searchEdit;
	
	@FindBy(name="search_field")
	private WebElement searchDropDown;
	
	@FindBy(name="submit")
	private WebElement searchBtn;


	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getSearchEdit() {
		return searchEdit;
	}

	public WebElement getSearchDropDown() {
		return searchDropDown;
	}
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement createNewOrgBtn;

	public WebElement getCreateNewOrgBtn() {
		return createNewOrgBtn;
	}
	
	

}
