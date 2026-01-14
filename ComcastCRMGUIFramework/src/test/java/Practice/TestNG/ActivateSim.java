package Practice.TestNG;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.generic.baseutility.BaseClass;

import junit.framework.Assert;

public class ActivateSim  {
@Test(retryAnalyzer =com.comcast.crm.listenerUtility.RetryListenerImp.class)
	public void activatesim() {
		System.out.println("execute activatesim ");
		Assert.assertEquals("", "login");//actually it is empty not login
		System.out.println("step-1");
		System.out.println("step-2");
		System.out.println("step-3");
		System.out.println("step-4");
	
	}
@Test(retryAnalyzer =com.comcast.crm.listenerUtility.RetryListenerImp.class)
public void activatesim1() {
	System.out.println("execute activatesim1 ");
	Assert.assertEquals("login", "login");
	System.out.println("step-1");
	System.out.println("step-2");
	System.out.println("step-3");
	System.out.println("step-4");

}
}