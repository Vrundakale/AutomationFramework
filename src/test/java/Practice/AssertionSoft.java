package Practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionSoft {
	@Test
	public void softassertpractice() {
		SoftAssert sa= new SoftAssert();
		
		System.out.println("Step1");
		System.out.println("Step2");
		sa.assertEquals(0, 0);
		System.out.println("Step3");
		
		sa.assertEquals(0, 1);
		
		System.out.println("Step4");
		sa.assertEquals(2, 2);
		
		System.out.println("Step5");
		sa.assertAll();
	}

}
