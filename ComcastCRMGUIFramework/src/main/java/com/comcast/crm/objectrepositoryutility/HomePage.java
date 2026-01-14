package com.comcast.crm.objectrepositoryutility;

import java.security.PrivateKey;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	
	//object initialization
	public HomePage(WebDriver driver) {
		this.driver=driver;//means during the time of initialization,store driver object adress into global driver
		PageFactory.initElements(driver, this);// this means current class object
	}
	
	@FindBy(linkText="Organizations")
	private WebElement orgLink;
	
	@FindBy(linkText="Contacts")
	private WebElement contactLink;

	@FindBy(linkText = "Campaigns")
	private WebElement campaignLink;
	
	@FindBy(linkText = "More")
	private WebElement moreLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminImg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signOutLink;

	//encapsulation
	public WebElement getOrgLink() {
		return orgLink;
	}

	public WebElement getContactLink() {
		return contactLink;
	}

	
	public WebElement getCampaignLink() {
		return campaignLink;
	}

	public WebElement getMoreLink() {
		return moreLink;
	}
	
	public void navigateToCamppaignPage() {
		Actions a=new Actions(driver);
		a.moveToElement(moreLink).perform();
		campaignLink.click();
	}
	public void logout() {
		Actions a=new Actions(driver);
		a.moveToElement(adminImg).perform();
		signOutLink.click();
	}

}
