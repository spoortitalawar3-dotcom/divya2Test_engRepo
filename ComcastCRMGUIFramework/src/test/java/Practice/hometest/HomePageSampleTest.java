package Practice.hometest;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;



public class HomePageSampleTest {
	//if scripts fails testNGreports says pass but logs says its fail,problem with java (if else statement)is,it can not fail testcase.
	@Test
	public void HomePageTest(Method mtd) {
		System.out.println(mtd.getName()+"Test Start");
		String expectedPage="Home Page";
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://localhost:8888");
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		//verify
		
		String actualTitle=driver.findElement(By.xpath("//a[contains(text(),'Home')]")).getText();
		//HardAssert
		Assert.assertEquals(actualTitle, expectedPage);//select string arguments
		//to remove space we use trim
		/*
		 * if(actualTitle.trim().equals(expectedPage)) {
		 * System.out.println(expectedPage+"page is verified==PASS"); } else {
		 * System.out.println(expectedPage+"page is verified==FAIL"); }
		 */
	driver.close();
    System.out.println(mtd.getName()+"Test End");
	}
	@Test
	public void VerifyLogoHomePageTest(Method mtd) {
		System.out.println(mtd.getName()+"Test Start");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://localhost:8888");
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		//verify
		boolean status=driver.findElement(By.xpath("//img[contains(@title,'vtiger-crm')]")).isDisplayed();
		//HardAssert
		Assert.assertEquals(true, status);// Assert.assertTrue(status);select boolean arguments.
		/*
		 * if(status) { System.out.println(status+"Logo is verified==PASS"); } else {
		 * System.out.println(status+"Logo is verified==FAIL"); }
		 */
		driver.close();
		System.out.println(mtd.getName()+"Test End");
	}
		
	}
	


