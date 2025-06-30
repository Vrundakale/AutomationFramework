package Practice;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import generic_utilities.FileUtility;
import generic_utilities.SeleniumUtility;
import object_Repository.Login_Page;

public class AddToCartButton_usingDDT {
	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
		FileUtility fUtil= new FileUtility();
		SeleniumUtility sUtil = new SeleniumUtility();
		
		//Read data from property file
		
		
		
	String URL = fUtil.readDataFromPropertyFile("Url");
	String USERNAME = fUtil.readDataFromPropertyFile("Username");
	String PASSWORD = fUtil.readDataFromPropertyFile("Password");
	
	//Read data from excel file
	
	
	String PRODUCTNAME = fUtil.readDataFromExcelFileString("Products", 4,2);
	String FIRSTNAME = fUtil.readDataFromExcelFileString("Products", 4,3);
	String LASTNAME = fUtil.readDataFromExcelFileString("Products", 4,4);
	//Launch the browser
			WebDriver driver = new EdgeDriver();
			sUtil.maximizeWindow(driver);
			sUtil.addimpliciteWait(driver, 15);
			
	//Enter url
			driver.get(URL);
	//Login
			//driver.findElement(By.id("user-name")).sendKeys(USERNAME);
			//driver.findElement(By.id("password")).sendKeys(PASSWORD);
			//driver.findElement(By.id("login-button")).click();
			
			Login_Page lp= new Login_Page(driver);
			lp.getUsernameEdt().sendKeys(USERNAME);
			lp.getPasswordEdt().sendKeys(PASSWORD);
			lp.getLoginBtn().click();
			
	//Add product to cart directly
	driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
	Thread.sleep(2000);
	//navigate to cart
	driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
	Thread.sleep(2000);
	//Validate the item
	 String productIncart = driver.findElement(By.xpath("//div[@class='inventory_item_name']")).getText();

	if (productIncart.equals(PRODUCTNAME))
	{System.out.println(productIncart);
		System.out.println("Pass");

	}
	else
	{System.out.println("Fail");

	}
	Thread.sleep(2000);

	driver.findElement(By.id("checkout")).click();
	driver.findElement(By.id("first-name")).sendKeys(FIRSTNAME);
	driver.findElement(By.id("last-name")).sendKeys(LASTNAME);
	driver.findElement(By.id("postal-code")).sendKeys("123456");
	driver.findElement(By.id("continue")).click();
	driver.findElement(By.id("finish")).click();


		}

	
	
	
	}


