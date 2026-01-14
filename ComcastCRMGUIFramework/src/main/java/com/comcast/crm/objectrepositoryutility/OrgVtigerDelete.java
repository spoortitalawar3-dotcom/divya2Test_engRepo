package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgVtigerDelete {

	@FindBy(id="bas_searchfield")
	private WebElement srchdrpd;
	@FindBy(name="search_text")
	private WebElement sechtxf;
	@FindBy(xpath = "(//input[@value=' Search Now '])[1]")
	private WebElement srchnow;
	@FindBy(id = "selectCurrentPageRec")
	private WebElement srch;
	@FindBy(xpath = "(//input[@value='Delete'])[1]")
	private WebElement webele1;
	@FindBy(xpath = "//span[@class='genHeaderSmall']")
	private WebElement msg;
	public WebElement getMsg() {
		return msg;
	}
	public WebElement getWebele1() {
		return webele1;
	}
	public WebElement getSrch() {
		return srch;
	}
	public WebElement getSrchdrpd() {
		return srchdrpd;
	}
	public WebElement getSechtxf() {
		return sechtxf;
	}
	public WebElement getSrchnow() {
		return srchnow;
	}
	public OrgVtigerDelete(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
}
