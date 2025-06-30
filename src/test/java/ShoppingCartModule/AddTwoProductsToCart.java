package ShoppingCartModule;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import generic_utilities.BaseClass;
import generic_utilities.FileUtility;
import generic_utilities.SeleniumUtility;
import object_Repository.Login_Page;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import object_Repository.Cart_Page;
import object_Repository.CheckoutStepTwo_Page;
import object_Repository.Checkout_page;
import object_Repository.InventoryItem_Page;
import object_Repository.Inventory_Page;
public class AddTwoProductsToCart extends BaseClass {
	@Test
	
	public void tc_004AddtwoProductToCartTest()
			 throws InterruptedException, IOException{
	FileUtility fUtil= new FileUtility();
	SeleniumUtility sUtil1 = new SeleniumUtility();
	
	//Read data from property file
		

//Read data from excel file


String PRODUCTNAME1 = fUtil.readDataFromExcelFileString("Products", 7,2);
String PRODUCTNAME2 = fUtil.readDataFromExcelFileString("Products", 8,2);
String FIRSTNAME = fUtil.readDataFromExcelFileString("Products", 7,3);
String LASTNAME = fUtil.readDataFromExcelFileString("Products", 7,4);

	//Launch the Browser
		
			
			//Enter url
			
			
			//Login
		
	
			//Clock on first product link
	Inventory_Page ip = new Inventory_Page(driver);
	ip.clickOnTheProductLink(driver, PRODUCTNAME1);
	
	//click on add to cart button
	InventoryItem_Page iip = new InventoryItem_Page(driver);
	iip.clickOnAddToCartBtn();
	
	//Navigate back to Products page
	iip.clickOnBackToProductsBtn();
	
	Thread.sleep(2000);

	//Click on second product link
	
	ip.clickOnTheProductLink(driver, PRODUCTNAME2);
	
	Thread.sleep(2000);
// Click on Add product to cart button
	iip.clickOnAddToCartBtn();
	
	
	//navigate to shopping cart page
	ip.clickOnShoppingCartButton();
	
	//Validate first Itemname 
Cart_Page cp = new Cart_Page(driver);
String productIncart1 =cp.CaptureProductInCart(driver, PRODUCTNAME1);
Assert.assertEquals(PRODUCTNAME1, productIncart1);

//Validate second Itemname2
String productIncart2 =cp.CaptureProductInCart(driver, PRODUCTNAME2);
Assert.assertEquals(PRODUCTNAME2, productIncart2);

Thread.sleep(2000);

	//navigate to checkout

	cp.clickOnCheckOutBtn(); 
	
	// Enter valid credentials on CheckOut page
	
	Checkout_page chp = new Checkout_page(driver);
	chp.enterFirstName(FIRSTNAME);
chp.enterLastName(LASTNAME);
chp.enterPostalCode("1234");
	
	//navigate to overview page
chp.clickOnContinueBtn();

// Click on finish button
CheckoutStepTwo_Page chp1= new CheckoutStepTwo_Page(driver);
chp1.clickOnfinishBtn();
	

		}

	
}


