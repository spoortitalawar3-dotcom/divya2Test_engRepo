package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class OrgInfoVtiger {
	@FindBy(css = "img[alt='Create Organization...']")
	private WebElement createneworglnk;
	public WebElement getCreateneworglnk() {
		return createneworglnk;
	}
	public WebElement getIndustryselect() {
		return industryselect;
	}
	@FindBy(name = "accountname")
	private WebElement orgnametxfd;
	@FindBy(name="ship_street")
	private WebElement shipaddtxf;
	@FindBy(xpath = "(//input[@type='button'])[1]")
	private WebElement savebtn;
	@FindBy(name = "industry")
	private WebElement industryselect;
	public OrgInfoVtiger(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	public WebElement getOrgnametxfd() {
		return orgnametxfd;
	}
	public WebElement getShipaddtxf() {
		return shipaddtxf;
	}
	public WebElement getSavebtn() {
		return savebtn;
	}
	public void createOrg(String orgname)
	{
		orgnametxfd.sendKeys(orgname);
		savebtn.click();
	}
	public void createOrg(String orgname,String industrytxf)
	{
		orgnametxfd.sendKeys(orgname);
		Select s=new Select(industryselect);
		s.selectByVisibleText(industrytxf);
		savebtn.click();
	}
	public void createOrgname(String orgname,String shippadress)
	{
		createneworglnk.click();
		orgnametxfd.sendKeys(orgname);
		shipaddtxf.sendKeys(shippadress);
		savebtn.click();
	}
}
