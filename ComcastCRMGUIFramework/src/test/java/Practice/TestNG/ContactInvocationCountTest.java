package Practice.TestNG;

import org.testng.annotations.Test;

public class ContactInvocationCountTest {
	@Test(invocationCount = 10)
	public void createContactTest() {
		System.out.println("execute createContactTest");
	}
	@Test(enabled=false)
	public void createCintactWIthMobileNUmberTest() {
		System.out.println("executr createCintactWIthMobileNUmberTest");
	}
	

}
