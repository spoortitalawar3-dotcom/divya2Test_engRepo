package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProdVtiger {
	@FindBy(css = "img[alt='Create Product...']")
	private WebElement cretprod;
	public ProdVtiger(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	public WebElement getCretprod() {
		return cretprod;
	}
   
	
}
