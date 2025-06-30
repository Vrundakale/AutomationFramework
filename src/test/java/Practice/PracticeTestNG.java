package Practice;

import org.testng.annotations.Test;

public class PracticeTestNG {
	
	@Test (invocationCount = 2, enabled = true)
	public void add() {
		System.out.println("delete");
	}

	@Test (enabled= false)
	public void create() {
		System.out.println("create");
	}
	
	@Test (dependsOnMethods= "create")
	public void modify() {
		System.out.println("modify");
	}
	
	
	
}
