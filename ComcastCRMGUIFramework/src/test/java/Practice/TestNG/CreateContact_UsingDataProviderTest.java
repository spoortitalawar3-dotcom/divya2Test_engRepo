package Practice.TestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContact_UsingDataProviderTest {
	@Test(dataProvider = "getData")
	public void createContactTest(String firstName,String lastName) {
		System.out.println("Firstname:"+firstName+",Lastname:"+lastName);
	}
	
	@DataProvider
	public Object[][] getData(){
		Object[][] objArr=new Object[3][2];
		objArr[0][0]="Divya";
		objArr[0][1]="shree";
		objArr[1][0]="Nanju";
		objArr[1][1]="Guliga";
		objArr[2][0]="Yashu";
		objArr[2][1]="N";
		return objArr;
	}
}
