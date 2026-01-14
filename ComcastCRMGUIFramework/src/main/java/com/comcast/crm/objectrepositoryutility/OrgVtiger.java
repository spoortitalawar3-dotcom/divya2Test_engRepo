package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgVtiger {
	WebDriver driver;
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement headermsg;
	public OrgVtiger(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public WebElement getHeadermsg() {
		return headermsg;
	}
}
