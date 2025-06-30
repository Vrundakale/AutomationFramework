package Practice;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import generic_utilities.FileUtility;
import generic_utilities.SeleniumUtility;
import object_Repository.Login_Page;

public class AddProductUsingDDT {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		FileUtility fUtil= new FileUtility();
		SeleniumUtility sUtil = new SeleniumUtility();
		
		//Read data from property file
		
		
		
	String URL = fUtil.readDataFromPropertyFile("Url");
	String USERNAME = fUtil.readDataFromPropertyFile("Username");
	String PASSWORD = fUtil.readDataFromPropertyFile("Password");
	
	
	//Read data from excel file
	
	
	String PRODUCTNAME = fUtil.readDataFromExcelFileString("Products", 1,2);
	String FIRSTNAME = fUtil.readDataFromExcelFileString("Products", 1,3);
	String LASTNAME = fUtil.readDataFromExcelFileString("Products", 1,4);
	
		//Launch the Browser
				WebDriver driver = new EdgeDriver();
				sUtil.maximizeWindow(driver); 
				sUtil.addimpliciteWait(driver, 15);
				//Enter url
				driver.get(URL);
				
				//Login
				//driver.findElement(By.id("user-name")).sendKeys(USERNAME);
				//driver.findElement(By.id("password")).sendKeys(PASSWORD);
				//driver.findElement(By.id("login-button")).click();
		Thread.sleep(2000);
				
		Login_Page lp= new Login_Page(driver);
		lp.getUsernameEdt().sendKeys(USERNAME);
		lp.getPasswordEdt().sendKeys(PASSWORD);
		lp.getLoginBtn().click();
				//navigate to the Product page
				
				driver.findElement(By.xpath("//div[.='"+PRODUCTNAME+"']")).click();
				
				
				Thread.sleep(2000);
				
				//Add the product to the cart
				driver.findElement(By.xpath("//button[contains(text(),'Add to cart')]")).click();
				Thread.sleep(2000);
				
				//Navigate to shopping cart page
				driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
				Thread.sleep(2000);
				
				//Validate the product in the cart
				String productIncart = driver.findElement(By.className("inventory_item_name")).getText();
				

				if (productIncart.equals(PRODUCTNAME))
				{System.out.println(productIncart);
					System.out.println("Pass");

				}
				else
				{System.out.println("Fail");

				}
				Thread.sleep(2000);
				
				//Navigate to Checkout
				driver.findElement(By.xpath("//button[contains(text(),'Checkout')]")).click();
				
				//Enter Credentials for order
				driver.findElement(By.id("first-name")).sendKeys(FIRSTNAME);
				driver.findElement(By.id("last-name")).sendKeys(LASTNAME);
				driver.findElement(By.id("postal-code")).sendKeys("1234");
				
				//Navigate to overview
				driver.findElement(By.id("continue")).click();
				
				//Navigate to Overview page
				driver.findElement(By.id("finish")).click();
				
			}

		
	}


