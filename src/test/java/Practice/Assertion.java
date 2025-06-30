package Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Assertion {

	@Test
	public void hardassertpractice(){
		System.out.println("Step1");
		System.out.println("Step2");
		System.out.println("Step3");
		
		Assert.assertEquals(0, 1);
		
		System.out.println("Step4");
		System.out.println("Step5");
	}
}
