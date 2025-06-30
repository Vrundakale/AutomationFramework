package object_Repository;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Inventory_Page {
	
//	@FindBy(xpath = "//div[contains(text(),'Sauce Labs Backpack')]")
	//private WebElement SauceLabsBackpackLnk;
	
	@FindBy (id = "add-to-cart-sauce-labs-backpack")
	private WebElement AddToCartSauceLabsBackpackBtn;
	
	//@FindBy (xpath = "//div[contains(text(),'Sauce Labs Bike Light')]")
	//private WebElement SauceLabsBikeLightLnk;
	
	@FindBy(id = "add-to-cart-sauce-labs-bike-light")
	private WebElement AddToCartSauceLabsBikeLightBtn;
	
	//@FindBy (xpath = "//div[contains(text(),'Sauce Labs Onesie')]")
	//private WebElement SauceLabsOnesieLnk;
	
	@FindBy (id = "add-to-cart-sauce-labs-onesie")
	private WebElement AddToCartSauceLabsOnesieBtn;
	
	@FindBy (id = "shopping_cart_container")
	private WebElement ShoppingCartContainerBtn;
	
	@FindBy (id = "react-burger-menu-btn")
	private WebElement menuBtn;
	
	@FindBy (id = "logout_sidebar_link")
	private WebElement logOutBtn;
	
	//Initialisation
	
	public Inventory_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
		}
///Give access by getters

	public WebElement getAddToCartSauceLabsBackpackBtn() {
		return AddToCartSauceLabsBackpackBtn;
	}


	public WebElement getAddToCartSauceLabsBikeLightBtn() {
		return AddToCartSauceLabsBikeLightBtn;
	}


	public WebElement getAddToCartSauceLabsOnesieBtn() {
		return AddToCartSauceLabsOnesieBtn;
	}


	public WebElement getShoppingCartContainerBtn() {
		return ShoppingCartContainerBtn;
	}


	public WebElement getMenuBtn() {
		return menuBtn;
	}
	
	public WebElement getLogOutBtn() {
		return logOutBtn;
	}
	
	
	//Business Libraries
	
	

	public void setLogOutBtn(WebElement logOutBtn) {
		this.logOutBtn = logOutBtn;
	}

	public void clickOnShoppingCartButton() {
		ShoppingCartContainerBtn.click();
		
	}
	
	public void logOutOfApp() {
		menuBtn.click();
		logOutBtn.click();
		
	}
	
	public void clickOnTheProductLink(WebDriver driver, String PRODUCTNAME) {
		
		driver.findElement(By.xpath("//div[.='"+PRODUCTNAME+"']")).click();
		
	}
	
	
	public void clickOnAddToCartSauceLabsBackpackBtn() {
		AddToCartSauceLabsBackpackBtn.click();
		
	}
	
	
	

}
