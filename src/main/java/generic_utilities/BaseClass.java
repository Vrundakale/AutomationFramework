package generic_utilities;

import java.io.IOException;


import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import object_Repository.Inventory_Page;
import object_Repository.Login_Page;

public class BaseClass {
	
	public FileUtility fUtil= new FileUtility();
	public SeleniumUtility sUtil= new SeleniumUtility();
	public WebDriver driver;
	public static WebDriver takescreenshotdriver; 
	
	@BeforeSuite (alwaysRun= true)
	public void bsConfig() {
		System.out.println("------Database connected successfully-----");
		
	}
	//@Parameters("Browser")
	//@BeforeTest
	@BeforeClass (alwaysRun= true)
	//public void bcConfig(vValue) throws IOException {
	public void bcConfig()throws IOException {
		String URL = fUtil.readDataFromPropertyFile("Url");
		driver = new FirefoxDriver();
		
		
		//if (vValue.equals("edge")) 
		//{
			//driver = new EdgeDriver();
			
//	}
	
		//else if(vValue.equals("firefox"))
		//{
			
			//driver = new FirefoxDriver();
		//}
			//else
			//{
			//	driver = new EdgeDriver();
		//	}
		sUtil.maximizeWindow(driver);
		sUtil.addimpliciteWait(driver, 15);
		driver.get(URL);
		takescreenshotdriver=driver; 
		System.out.println("'------Browser launched successfully-----");
			}
	
	@BeforeMethod (alwaysRun= true)
	public void bmConfig() throws IOException {
		String USERNAME = fUtil.readDataFromPropertyFile("Username");
		String PASSWORD = fUtil.readDataFromPropertyFile("Password");
	
		Login_Page lp = new Login_Page(driver);
		lp.LoginToApp(USERNAME, PASSWORD);
		System.out.println("'------Loggged in to the Application successfully-----");
		
	}
	
	@AfterMethod (alwaysRun= true)
	public void amConfig() {
		
		Inventory_Page ip= new Inventory_Page(driver);
		ip.logOutOfApp();
		System.out.println("'------Loggged out from the Application successfully-----");
	}
	//@AfterTest
	@AfterClass (alwaysRun= true)
	public void acConfig() {
		driver.quit();
	System.out.println("------Browser Closure Successfull----");
	}

	@AfterSuite (alwaysRun= true)
	public void asConfig() {
		System.out.println("------Database Closure Successfull----");
	}
}
