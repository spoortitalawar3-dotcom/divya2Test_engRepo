package Practice.TestNG;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.crm.generic.baseutility.Baseclass2;

import junit.framework.Assert;

@Listeners(com.comcast.crm.listenerUtility.ListenImpTwo.class
		)
public class DummyScript extends Baseclass2{
	@Test
	public void createContactTest() {
		
		System.out.println("execute createContact with-->HDFC");

	}
	@Test(dependsOnMethods = "deleteContactTest")
	public void modifyContactTest() {

		System.out.println("execute modifyContactTest-->HDFC=>ICICI");
	}
	@Test(dependsOnMethods = "modifyContactTest")
	public void deleteContactTest() {
		
		System.out.println("execute deleteContactTest-->ICICI");
	}
	@Test
	public void createInvoiceTest() {
		System.out.println("execute createInvoiceTest ");
		String actTitle = driver.getTitle();
		Assert.assertEquals(actTitle, "login");//actually it is home not login
		System.out.println("step-1");
		System.out.println("step-2");
		System.out.println("step-3");
		System.out.println("step-4");
	
	}
	@Test
	public void createInvoicewithContactTest() {
		System.out.println("execute createInvoicewithContactTest ");
		System.out.println("step-1");
		System.out.println("step-2");
		System.out.println("step-3");
		System.out.println("step-4");
		
	}
	

}
