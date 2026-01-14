package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ServiceVtiger {

	@FindBy(css = "img[title='Create Service...']")
	private WebElement cretsrv;

	public WebElement getCretsrv() {
		return cretsrv;
	}
	public ServiceVtiger(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
}
