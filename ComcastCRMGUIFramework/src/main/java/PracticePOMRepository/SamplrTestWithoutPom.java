package PracticePOMRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SamplrTestWithoutPom {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888/");
		WebElement ele1=driver.findElement(By.name("user_name"));
		WebElement ele2=driver.findElement(By.name("user_password"));
		WebElement ele3=driver.findElement(By.id("submitButton"));
		
		ele1.sendKeys("admin");
		ele2.sendKeys("admin");
		
		driver.navigate().refresh();//STALE ELEMENT REFRESH EXCEPTION AFTER REFRESH
		
		ele1.sendKeys("admin");//ELEMENT ADDRESS CHANGED CAN NOT SEND VALUE TO OLD ADDRESS
		ele2.sendKeys("admin");
		
		ele3.click();
		

	}

}
