package com.comcast.crm.objectrepositoryutility;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunityInfo {
	WebDriver driver;
@FindBy(name = "potentialname")
private WebElement oppname;
@FindBy(xpath = "(//img[@title='Select'])[1]")
private WebElement addwin;
@FindBy(id = "search_txt")
private WebElement srchtxtf;
@FindBy(name = "search")
private WebElement srchbtn;
@FindBy(xpath = "(//input[@type='submit'])[1]")
private WebElement savebtn;
@FindBy(xpath ="//span[@class='dvHeaderText']")
private WebElement headmsg;
public WebElement getHeadmsg() {
	return headmsg;
}
public WebElement getSavebtn() {
	return savebtn;
}
public OpportunityInfo(WebDriver driver)
{
this.driver=driver;
PageFactory.initElements(driver,this);
}
public WebElement getOppname() {
	return oppname;
}
public WebElement getAddwin() {
	return addwin;
}

public WebElement getSrchtxtf() {
	return srchtxtf;
}
public WebElement getSrchbtn() {
	return srchbtn;
}
public void switchwindow(WebDriver driver,String partialurl)
{
	Set<String> allwin = driver.getWindowHandles();
	for (String win : allwin) {
		driver.switchTo().window(win);
		String acturl = driver.getCurrentUrl();
		if(acturl.contains(partialurl))
		{
			break;
		}
		
	}
}



}
