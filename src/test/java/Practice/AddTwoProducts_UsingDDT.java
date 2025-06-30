package Practice;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import generic_utilities.FileUtility;
import generic_utilities.SeleniumUtility;
import object_Repository.Login_Page;

public class AddTwoProducts_UsingDDT {

	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		
		
		FileUtility fUtil= new FileUtility();
		SeleniumUtility sUtil = new SeleniumUtility();
		
		//Read data from property file
			
	String URL = fUtil.readDataFromPropertyFile("Url");
	String USERNAME = fUtil.readDataFromPropertyFile("Username");
	String PASSWORD = fUtil.readDataFromPropertyFile("Password");
	
	//Read data from excel file
	
	
	String PRODUCTNAME = fUtil.readDataFromExcelFileString("Products", 7,2);
	String PRODUCTNAME1 = fUtil.readDataFromExcelFileString("Products", 8,2);
	String FIRSTNAME = fUtil.readDataFromExcelFileString("Products", 7,3);
	String LASTNAME = fUtil.readDataFromExcelFileString("Products", 7,4);
	
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
				//Add the product backpack to the cart directly
		driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
		Thread.sleep(2000);

		//navigate to cart page
		driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
		Thread.sleep(2000);

		//navigate to all products page
		driver.findElement(By.id("continue-shopping")).click();

		//add product bike light to the cart
		driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
		//navigate to the cart page
		driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
		Thread.sleep(2000);

		//validate the products in the cart 
		String productIncart = driver.findElement(By.xpath("//div[contains(text(),'Sauce Labs Backpack')]")).getText();

		if (productIncart.equals(PRODUCTNAME))
		{System.out.println(productIncart);
			System.out.println("Pass");

		}
		else
		{System.out.println("Fail");

		}
		Thread.sleep(2000);
		String productIncart2 = driver.findElement(By.xpath("//div[contains(text(),'Sauce Labs Bike Light')]")).getText();

		if (productIncart2.equals(PRODUCTNAME1))
		{System.out.println(productIncart2);
			System.out.println("Pass");

		}
		else
		{System.out.println("Fail");

		}
		Thread.sleep(2000);

		//navigate to checkout

		driver.findElement(By.id("checkout")).click();

		//enter credentials for order
		driver.findElement(By.id("first-name")).sendKeys(FIRSTNAME);
		driver.findElement(By.id("last-name")).sendKeys(LASTNAME);
		driver.findElement(By.id("postal-code")).sendKeys("1234");
		//navigate to overview page
		driver.findElement(By.id("continue")).click();

		//navigate to complete page
		driver.findElement(By.id("finish")).click();

			}

		
	}


