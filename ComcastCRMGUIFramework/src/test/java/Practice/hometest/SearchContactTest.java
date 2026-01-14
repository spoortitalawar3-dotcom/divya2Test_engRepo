package Practice.hometest;

import org.testng.annotations.Test;

import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.crm.generic.baseutility.BaseClass;

/**
 * test class for contact module
 * @author Divya
 */

public class SearchContactTest extends BaseClass{
	/*
	 * Scenario:login==>navigateContact==>createContcat()==verify
	 */
	@Test
	public void searchContacTest() {
		/*Step:1 login to app */
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp("url", "username", "password");
	}

}
