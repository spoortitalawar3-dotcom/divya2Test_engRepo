package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunityVtiger {
@FindBy(css = "img[alt='Create Opportunity...']")
private WebElement crtopp;
public OpportunityVtiger(WebDriver driver)
{
	PageFactory.initElements(driver,this);
}
public WebElement getCrtopp() {
	return crtopp;
}

}
