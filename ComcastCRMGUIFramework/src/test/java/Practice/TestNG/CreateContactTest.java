package Practice.TestNG;

import org.testng.annotations.Test;
//In real time we dont give priority,and all test cases are independent. 
//INSERT CONTACT DIRECTLY FROM DB,INSTEAD OF CREATING CONATCT ONE MORE TIME.
public class CreateContactTest {
	@Test
	public void createContactTest() {
		System.out.println("execute createContact with-->HDFC");

	}
	@Test
	public void modifyContactTest() {
		System.out.println("execute query insert contact in DB-->ICICI");
		System.out.println("execute modifyContactTest-->ICICI=>ICICI_1");
	}
	@Test
	public void deleteContactTest() {
		System.out.println("execute query insert contact in DB-->UPI");
		System.out.println("execute deleteContactTest-->UPI");
	}
	

}
