package object_Repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Cart_Page {
	
	
	@FindBy (className = "inventory_item_name")
	private WebElement itemName;
	
	@FindBy (xpath = "//button[contains(text(),'Remove')]")
	private WebElement removeBtn;
	
	@FindBy (id = "continue-shopping")
	private WebElement continueShoppingBtn;
	
	@FindBy (id = "checkout")
	private WebElement checkOutBtn;
	
	//@FindBy (xpath = "//div[contains(text(),'Sauce Labs Backpack')]")
	//private WebElement itemname1;
	
	//@FindBy (xpath = "//div[contains(text(),'Sauce Labs Bike Light')]")
	//private WebElement itemname2;
	
	//Initialisation
	
		public Cart_Page(WebDriver driver) {
			PageFactory.initElements(driver, this);
			}
		
		//Getters
		public WebElement getItemName() {
			return itemName;
		}
		
		
	
public WebElement getRemoveBtn() {
			return removeBtn;
		}

		
public WebElement getContinueShoppingBtn() {
	return continueShoppingBtn;
}



public WebElement getCheckOutBtn() {
	return checkOutBtn;
}



//public WebElement getItemname1() {
	//return itemname1;
//}




//public WebElement getItemname2() {
	//return itemname2;
//}



//Business Library
public String CapturItemName() {
		
		return itemName.getText();
		
	}

//public String CapturItemName1() {
	
	//return itemname1.getText();
	
//}

//public String CapturItemName2() {
	
	//return itemname2.getText();
	
//}
public void clickOnRemoveBtn() {
	removeBtn.click();
}

public void clickOnContinueShoppingBtn() {
	continueShoppingBtn.click();
}

public void clickOnCheckOutBtn() {
	checkOutBtn.click();
}
public String CaptureProductInCart(WebDriver driver, String PRODUCTNAME) {
	
	return driver.findElement(By.xpath("//div[.='"+PRODUCTNAME+"']")).getText();
	
	
}



}
