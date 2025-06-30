package InventoryModule;

import java.io.IOException;


import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import generic_utilities.BaseClass;
import generic_utilities.FileUtility;
import generic_utilities.SeleniumUtility;
import object_Repository.Cart_Page;
import object_Repository.CheckoutStepTwo_Page;
import object_Repository.Checkout_page;
import object_Repository.Inventory_Page;
import object_Repository.Login_Page;
@Listeners (generic_utilities.ListenerImplementationUtility.class)
public class AddToCartButton extends BaseClass{
	@Test 
	public void tc_003AddToCartButtonTest()

	 throws InterruptedException, IOException {
		
	
		// TODO Auto-generated method stub
	
		
		//Read data from property file
		
		
		
	
	
	//Read data from excel file
	
	
	String PRODUCTNAME = fUtil.readDataFromExcelFileString("Products", 4,2);
	String FIRSTNAME = fUtil.readDataFromExcelFileString("Products", 4,3);
	String LASTNAME = fUtil.readDataFromExcelFileString("Products", 4,4);
	
		//Launch the Browser
				
				
				
		//Login
				
		
		
				//Click On Add to cart button
		Inventory_Page ip = new Inventory_Page(driver);
		
		ip.clickOnAddToCartSauceLabsBackpackBtn();
		Thread.sleep(2000);
				
		//Navigate to shopping cart page
				
				ip.clickOnShoppingCartButton();
				
				Thread.sleep(2000);
				
				//Validate the product in the cart
				Cart_Page cp= new Cart_Page(driver);
				String productIncart = cp.CapturItemName();
				Assert.assertEquals(productIncart, PRODUCTNAME);
				
			
				
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

	
	@Test (groups = "RegressionTest")
	public void vrunda() {
		System.out.println("Demo");
	}
		
	}


