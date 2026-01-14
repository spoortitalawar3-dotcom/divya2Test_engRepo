package Practice.TestNG;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

public class SampleTestForScreenshot {
	@Test
	public void amazonTest() throws IOException {
WebDriver driver= new ChromeDriver();
	driver.get("http://amazon.com");
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	
	//step-1 create an object to Eventfiring webdriver
	EventFiringWebDriver edriver=new EventFiringWebDriver(driver);
	
	//step-2 use getScreenshotAs method to capture the screenshot in runtime
	File source = edriver.getScreenshotAs(OutputType.FILE);
	
	//step-3 store screenshot in local variable
	FileUtils.copyFile(source, new File("./screenshot/test1.png"));
	driver.quit();

	}
	
}
