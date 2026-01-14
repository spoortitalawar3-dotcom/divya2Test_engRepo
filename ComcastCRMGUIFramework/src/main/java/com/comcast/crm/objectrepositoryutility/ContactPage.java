package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
WebDriver driver;//make driver global
	
	//Rule:3=to simplify object initializarion,create constructor and inside that provide implementation.
		//ADVANTAGE IS AT THE TIME OF CREATION OF THE OBJECT ENG NO NEED TO WORRY ABOUT INITIALIZATION,
		//BECAUSE I AM CALLING THE CONSTRUCTOR IN TESTSCRIPT,THAT WILL TAKE CARE OF INTIALIZATION
	
	public ContactPage(WebDriver driver) {
		this.driver=driver;//means during the time of initialization,store driver object adress into global driver
		PageFactory.initElements(driver, this);// this means current class object
	}
@FindBy(xpath="//img[@title='Create Contact...']")
private WebElement createNewContactBtn;

public WebElement getCreateNewContactBtn() {
	return createNewContactBtn;
}
}
