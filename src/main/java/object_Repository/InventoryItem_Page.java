package object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryItem_Page {

@FindBy (id = "add-to-cart")
private WebElement AddToCartBtn;

@FindBy (id = "back-to-products")
private WebElement backToProductsBtn;



//Initialization
	
	public InventoryItem_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
		}
//Rule4
	//Give access by getters
	
	public WebElement getAddToCartBtn() {
		return AddToCartBtn;
	}

	public WebElement getBackToProductsBtn() {
		return backToProductsBtn;
	}
	
	
	
	
	
	

	// Business Libraries
	public void clickOnAddToCartBtn () {
		AddToCartBtn.click();
	}

	public void clickOnBackToProductsBtn() {
		backToProductsBtn.click();
		
	}
	
	
}

