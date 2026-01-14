package Practice.TestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContact_UsingDataProviderTest2 {
	@Test(dataProvider = "getData")
	public void createContactTest(String firstName,String lastName,long phoneNumber) {
		System.out.println
		("Firstname:"+firstName+",Lastname:"+lastName+",Phonenumber:"+phoneNumber);
	}
	
	@DataProvider
	public Object[][] getData(){
		Object[][] objArr=new Object[3][3];
		objArr[0][0]="Divya";
		objArr[0][1]="shree";
		objArr[0][2]=7899636409L;//long keep L at the end
		
		objArr[1][0]="Nanju";
		objArr[1][1]="Guliga";
		objArr[1][2]=1234567890L;
		
		objArr[2][0]="Yashu";
		objArr[2][1]="N";
		objArr[2][2]=90066254098L;
		return objArr;
	}
}
