package Practice.TestNG;


import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.generic.baseutility.BaseClass;
@Listeners(Practice.TestNG.DummyListnerImp.class)
public class SampleOrderofExcecution extends BaseClass {
	@Test
	public void orderOfExcecution01()
	{
		Assert.fail();
		System.out.println("testscript-01");
	}
	@Test(dependsOnMethods = "orderOfExcecution01")
	public void orderOfExcecution02()
	{
		
		System.out.println("testscript-01");
	}

}
