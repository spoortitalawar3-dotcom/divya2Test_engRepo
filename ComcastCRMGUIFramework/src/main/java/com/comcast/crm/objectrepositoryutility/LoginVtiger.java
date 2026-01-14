package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginVtiger {

	@FindBy(name="user_name")
	private WebElement untxtf;
	@FindBy (name="user_password")
	private WebElement pwdtxtf;
	@FindBy(id="submitButton")
	private WebElement logbtn;
	public LoginVtiger(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	public WebElement getUntxtf() {
		return untxtf;
	}
	public WebElement getPwdtxtf() {
		return pwdtxtf;
	}
	public WebElement getLogbtn() {
		return logbtn;
	}
	public void logintoApp(String un,String pwd)
	{
		untxtf.sendKeys(un);
		pwdtxtf.sendKeys(pwd);
		logbtn.click();
	}
	
}
