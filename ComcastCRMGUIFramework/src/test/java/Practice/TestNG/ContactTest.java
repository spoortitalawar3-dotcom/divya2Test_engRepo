package Practice.TestNG;

import org.testng.annotations.Test;

public class ContactTest {
	@Test//within one test annotation write complete one test case code
	public void createContactTest() {
		System.out.println("execute login");
		System.out.println("execute navigate to contact");
		System.out.println("execute create Contact");
		System.out.println("execute verify Contact");
		System.out.println("execute logout");
	}
	@Test
	public void createCintactWIthMobileNUmberTest() {
		System.out.println("executr createCintactWIthMobileNUmberTest");
	}
	

}
