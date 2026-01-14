package com.pac1;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class PickDateTest {
	@Test
	public void timePickerTest() throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://demoapps.qspiders.com/ui/timePick/timeClock?sublist=1");
 	    driver.findElement(By.id(":r1:")).click();
		Actions a=new Actions(driver);
		WebElement eleHour = driver.findElement(By.xpath("//div[@class='MuiClockPointer-root css-7lip4c']"));
	    WebElement eleHour1 = driver.findElement(By.xpath("//span[@aria-label='6 hours']"));
	    a.dragAndDrop(eleHour, eleHour1).build().perform();
	    WebElement eleMinute = driver.findElement(By.xpath("//div[@class='MuiClockPointer-root css-a1rc6s']"));
	    WebElement eleMinute1 = driver.findElement(By.xpath("//span[@aria-label='30 minutes']"));
	    a.dragAndDrop(eleMinute, eleMinute1).build().perform();
	    driver.findElement(By.xpath("//span[@class='MuiTypography-root MuiTypography-subtitle2 MuiTimePickerToolbar-ampmLabel MuiPickersToolbarText-root css-n4qtc0']")).click();
	    driver.findElement(By.xpath("//button[text()='OK']")).click();
		String givenTime = driver.findElement(By.id(":r1:")).getAttribute("value");
	    System.out.println(givenTime);
		
	    driver.quit();
		
	}

}
