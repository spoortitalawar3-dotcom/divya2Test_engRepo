package Practice.TestNG;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.generic.baseutility.BaseClass;

import junit.framework.Assert;
//@Listeners(com.comcast.crm.listenerUtility.ListenerImplementationClass.class)//fully qualified name
public class InvoiceTest extends BaseClass  {
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
