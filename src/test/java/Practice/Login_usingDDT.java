package Practice;



import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import generic_utilities.FileUtility;
import generic_utilities.SeleniumUtility;
import object_Repository.Login_Page;

public class Login_usingDDT {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
		FileUtility fUtil= new FileUtility();
		SeleniumUtility sUtil = new SeleniumUtility();
		
		//Read data from property files
		String URL = fUtil.readDataFromPropertyFile("Url");
		String USERNAME = fUtil.readDataFromPropertyFile("Username");
		String PASSWORD = fUtil.readDataFromPropertyFile("Password");
	
		// Launch the browser
WebDriver driver = new EdgeDriver();
sUtil.maximizeWindow(driver);
sUtil.addimpliciteWait(driver, 15);




//enter url
driver.get(URL);
//Enter the User name
//driver.findElement(By.id("user-name")).sendKeys(USERNAME);
//Enter password
//driver.findElement(By.id("password")).sendKeys(PASSWORD);
//Click on login button
//driver.findElement(By.id("login-button")).click();

Login_Page lp= new Login_Page(driver);
//lp.getUsernameEdt().sendKeys(USERNAME);
//lp.getPasswordEdt().sendKeys(PASSWORD);
//lp.getLoginBtn().click();

// using Business library
lp.LoginToApp(USERNAME, PASSWORD);

		
	
	}

}
