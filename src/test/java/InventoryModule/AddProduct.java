package InventoryModule;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import generic_utilities.BaseClass;
import object_Repository.Cart_Page;
import object_Repository.CheckoutStepTwo_Page;
import object_Repository.Checkout_page;
import object_Repository.InventoryItem_Page;
import object_Repository.Inventory_Page;
@Listeners(generic_utilities.ListenerImplementationUtility.class)
public class AddProduct extends BaseClass {
	
@Test (groups = "SmokeTest")
public void tc_002AddProductTest()
	 throws InterruptedException, IOException {
	
	
		
		//Read data from property file
	
	//Read data from excel file
	

	String PRODUCTNAME = fUtil.readDataFromExcelFileString("Products", 1,2);
	String FIRSTNAME = fUtil.readDataFromExcelFileString("Products", 1,3);
	String LASTNAME = fUtil.readDataFromExcelFileString("Products", 1,4);
	
		//Launch the Browser
				
		//Login
				
		//Click On the product name
		Inventory_Page ip = new Inventory_Page(driver);
		
		ip.clickOnTheProductLink(driver, PRODUCTNAME);
		

				
		Thread.sleep(2000);
				
				//Click on Add the product to the cart
		
		InventoryItem_Page iip= new InventoryItem_Page(driver);
		iip.clickOnAddToCartBtn();
				
				Thread.sleep(2000);
				
				//Navigate to shopping cart page
				
				ip.clickOnShoppingCartButton();
				
				Thread.sleep(2000);
				
				//Validate the product in the cart
				Cart_Page cp= new Cart_Page(driver);
				
				String productIncart = cp.CapturItemName();
				Assert.assertEquals(PRODUCTNAME, productIncart);

				
				Thread.sleep(2000);
				
				//Click on checkout button
				cp.clickOnCheckOutBtn();
				
					//Enter Credentials in checkout page
				Checkout_page chp= new Checkout_page(driver);
				chp.enterFirstName(FIRSTNAME);
				chp.enterLastName(LASTNAME);
				driver.findElement(By.id("postal-code")).sendKeys("1234");
				chp.clickOnContinueBtn();
				
				
			
				
				//Click on finish button
				CheckoutStepTwo_Page chp1 = new CheckoutStepTwo_Page(driver);
				chp1.clickOnfinishBtn();
			}

@Test 
public void sample() {
	System.out.println("Demo");
	
}

		
	}




