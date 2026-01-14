package com.pac1;

import java.awt.Window;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class pickDateTest2 {
	@Test
	public void pickEveningDate() {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://demoapps.qspiders.com/ui/timePick/timeClock?sublist=1");
		driver.findElement(By.xpath("//input[@id=':r1:']")).click();
		Actions a=new Actions(driver);
		WebElement ele1 = driver.findElement(By.xpath("//div[@class='MuiClockPointer-thumb css-118whkv']"));
		WebElement ele2=driver.findElement(By.xpath("//span[@aria-label='3 hours']"));
		a.dragAndDrop(ele1, ele2).build().perform();
		WebElement min1=driver.findElement(By.xpath("//div[@class='MuiClockPointer-thumb css-118whkv']"));
		WebElement min2=driver.findElement(By.xpath("//span[@aria-label='10 minutes']"));
		a.dragAndDrop(min1, min2).build().perform();
		
		
		
		
		
		
	}


}
