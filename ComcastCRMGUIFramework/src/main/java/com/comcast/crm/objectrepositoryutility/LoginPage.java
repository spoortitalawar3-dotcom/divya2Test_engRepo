package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
/**
 * containsLogin Page elements
 * @author Divya
 */

public class LoginPage extends WebDriverUtility {
	
	//Rule:1= create a separate java class
	//Rule:2=Object creation(Identify all the elements using @FindBy Annotation
	
	WebDriver driver;//make driver global
	
	//Rule:3=to simplify object initializarion,create constructor and inside that provide implementation.
		//ADVANTAGE IS AT THE TIME OF CREATION OF THE OBJECT ENG NO NEED TO WORRY ABOUT INITIALIZATION,
		//BECAUSE I AM CALLING THE CONSTRUCTOR IN TESTSCRIPT,THAT WILL TAKE CARE OF INTIALIZATION
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;//means during the time of initialization,store driver object adress into global driver
		PageFactory.initElements(driver, this);// this means current class object
	}
	
	
	@FindBy(name="user_name")
	public WebElement usernameEdit;//if it is public other automation eng try to modify and reinitialise this, so make it private
	
	@FindBy(name="user_password")
	public WebElement passwordEdit;
	
	@FindBy(id="submitButton")
	public WebElement loginBtn;

	
	//Rule:4 object Encapsulation(right click source, select getters and setters ,select get and generate)
	//and utilization
	public WebElement getUsernameEdit() {
		return usernameEdit;
	}

	public WebElement getPasswordEdit() {
		return passwordEdit;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	//Rule:5=Provide Action[IT IS A BUSINESS LIBRARY,CAN NOT USE FOR OTHER APPLICATION, IT IS SPECIFIC TO ONE APP]
	public void loginToApp(String username,String Password) {
		waitForPageLoad(driver);
		driver.manage().window().maximize();
		usernameEdit.sendKeys(username);
		passwordEdit.sendKeys(Password);
		loginBtn.click();
		
	}
	/**
	 * login to application based on username,password,url arguments
	 * @param url
	 * @param username
	 * @param password
	 */
	public void loginToApp(String url,String username,String password) {
		waitForPageLoad(driver);
		driver.manage().window().maximize();
		driver.get(url);
		usernameEdit.sendKeys(username);
		passwordEdit.sendKeys(password);
		loginBtn.click();

}}
