
package com.comcast.crm.generic.webdriverutility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {

	public void waitForPageLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	
}

	public void waitForElementPresent(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void switchToTabOnURL(WebDriver driver,String partialURL) {
		
		Set<String> set = driver.getWindowHandles();//random order it stores data
	    Iterator<String> itr = set.iterator();//ceate iterator object
	    while(itr.hasNext())   // to capture first data from set collection
	    	{
	    	String windowID=itr.next();//capture the window id
	    	driver.switchTo().window(windowID);//switch to first window

			String actUrl = driver.getCurrentUrl();//get title of the window
	    	if(actUrl.contains(partialURL)) {
	    		break;//if window contain my chidwindow name switch to that and i got my window, break it.
	    	}
	    	}}
public void switchToTabOnTitle(WebDriver driver,String partialTitle) {
		
		Set<String> set = driver.getWindowHandles();//random order it stores data
	    Iterator<String> itr = set.iterator();//ceate iterator object
	    while(itr.hasNext())   // to capture first data from set collection
	    	{
	    	String windowID=itr.next();//capture the window id
	    	driver.switchTo().window(windowID);//switch to first window

			String actUrl = driver.getTitle();//get title of the window
	    	if(actUrl.contains(partialTitle)) {
	    		break;//if window contain my chidwindow name switch to that and i got my window, break it.
	    	}
}
}
public void switchtoFrame(WebDriver driver,int index) {
	driver.switchTo().frame(index);
}

public void switchtoFrame(WebDriver driver,String nameID) {
	driver.switchTo().frame(nameID);
}

public void switchtoFrame(WebDriver driver,WebElement element) {
	driver.switchTo().frame(element);
}
public void switchtoAlertAndAccept(WebDriver driver) {
	driver.switchTo().alert().accept();
}

public void switchtoAlertAndCancel(WebDriver driver) {
	driver.switchTo().alert().dismiss();
}

public void select(WebElement element,String text) {
	
	Select s=new Select(element);
	s.selectByVisibleText(text);
}

public void select(WebElement element,int index) {
	
	Select s=new Select(element);
	s.selectByIndex(index);
}

public void mouseMoveOnElement(WebDriver driver,WebElement element)
{
	Actions act=new Actions(driver);
	act.moveToElement(element).perform();
}
public void doubleClick(WebDriver driver,WebElement element)
{
	Actions act=new Actions(driver);
	act.doubleClick(element).perform();
}

}

