package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomeVtiger {
	WebDriver driver;
	@FindBy(linkText = "Products")
	private WebElement prodlnk;
	@FindBy(linkText = "Organizations")
	private WebElement orglnk;
	@FindBy(linkText = "Contacts")
	private WebElement contlink;
	@FindBy(linkText = "More")
	private WebElement morelnk;
	@FindBy(linkText = "Campaigns")
	private WebElement campgnlnk;
	@FindBy(css = "img[src='themes/softed/images/user.PNG']")
	private WebElement adminimg;
	@FindBy(xpath = "//a[text()='Sign Out']")
	private WebElement signoutlnk;
	@FindBy(linkText = "Opportunities")
	private WebElement opplink;
	@FindBy(linkText = "Services")
	private WebElement srvlnk;
	public WebElement getSrvlnk() {
		return srvlnk;
	}
	public WebElement getOpplink() {
		return opplink;
	}
	public HomeVtiger(WebDriver driver)
	{ this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public WebElement getProdlnk() {
		return prodlnk;
	}
	public WebElement getOrglnk() {
		return orglnk;
	}
	public WebElement getContlink() {
		return contlink;
	}
	public WebElement getMorelnk() {
		return morelnk;
	}
	public WebElement getCampgnlnk() {
		return campgnlnk;
	}
	public WebElement getAdminimg() {
		return adminimg;
	}
	public WebElement getSignoutlnk() {
		return signoutlnk;
	}
	public void navitoCampaign()
	{
	Actions a= new Actions(driver);
	a.moveToElement(morelnk).perform();
	campgnlnk.click();
	}
	public void navigateToService()
	{
		Actions a=new Actions(driver);
		a.moveToElement(morelnk).perform();
	}
	public void logout()
	{
	  Actions a=new Actions(driver);
	  a.moveToElement(adminimg).perform();
	  signoutlnk.click();
	}

}
