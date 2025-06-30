package Practice;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import generic_utilities.FileUtility;
import generic_utilities.SeleniumUtility;
import object_Repository.Login_Page;

public class RemoveProduct_usingDDT {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		
		FileUtility fUtil= new FileUtility();
		SeleniumUtility sUtil = new SeleniumUtility();
		
		//Read data from property file
		
		
		
	String URL = fUtil.readDataFromPropertyFile("Url");
	String USERNAME = fUtil.readDataFromPropertyFile("Username");
	String PASSWORD = fUtil.readDataFromPropertyFile("Password");
	
	//Read data from excel file
	
	
	String PRODUCTNAME = fUtil.readDataFromExcelFileString("Products", 11,2);
	String FIRSTNAME = fUtil.readDataFromExcelFileString("Products", 11,3);
	String LASTNAME = fUtil.readDataFromExcelFileString("Products", 11,4);
		//Launch the Browser
				WebDriver driver = new EdgeDriver();
				sUtil.maximizeWindow(driver);
				sUtil.addimpliciteWait(driver, 15);
				//Enter url
				driver.get(URL);
				
				//Login
			//	driver.findElement(By.id("user-name")).sendKeys(USERNAME);
				//driver.findElement(By.id("password")).sendKeys(PASSWORD);
				//driver.findElement(By.id("login-button")).click();
				
				Login_Page lp= new Login_Page(driver);
				lp.getUsernameEdt().sendKeys(USERNAME);
				lp.getPasswordEdt().sendKeys(PASSWORD);
				lp.getLoginBtn().click();
		Thread.sleep(2000);
				
				
				//Add the product to the cart directly
				
		driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
		Thread.sleep(2000);

		//Navigate to shopping cart page
		driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
		Thread.sleep(2000);

		//Validate the product in the cart
		String productIncart = driver.findElement(By.xpath("//div[@class='inventory_item_name']")).getText();

		if (productIncart.equals(PRODUCTNAME))
		{System.out.println(productIncart);
			System.out.println("Pass");

		}
		else
		{System.out.println("Fail");

		}
		Thread.sleep(2000);

		//remove the product from the cart
		driver.findElement(By.id("remove-sauce-labs-backpack")).click();

		//Navigate to Checkout
		driver.findElement(By.id("checkout")).click();

		//Enter Credentials for order
		driver.findElement(By.id("first-name")).sendKeys(FIRSTNAME);
		driver.findElement(By.id("last-name")).sendKeys(LASTNAME);
		driver.findElement(By.id("postal-code")).sendKeys("123456");

		//Navigate to overview
		driver.findElement(By.id("continue")).click();

		//Navigate to Overview page
		driver.findElement(By.id("finish")).click();
			}

		
	}


