package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProdInfoVtiger {
	@FindBy(name = "productname")
	private WebElement prodname;
	@FindBy(xpath =  "(//input[@class='crmbutton small save'])[1]")
	private WebElement savebtn;
	@FindBy(className = "lvtHeaderText")
	private WebElement prdmsg;
	public WebElement getProdname() {
		return prodname;
	}
	public WebElement getSavebtn() {
		return savebtn;
	}
	public WebElement getPrdmsg() {
		return prdmsg;
	}
	public ProdInfoVtiger(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
   public void createprod(String proname)
   {
	   prodname.sendKeys(proname);
	   savebtn.click();
   }

}
