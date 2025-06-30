package Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class TestCase5_RemoveProduct {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//Launch the Browser
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		//Navigate to the web application
		driver.get("https://www.saucedemo.com/");
		
		//Login
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		
		//Add the product to the cart directly
		
driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
Thread.sleep(2000);

//Navigate to shopping cart page
driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
Thread.sleep(2000);

//Validate the product in the cart
String productIncart = driver.findElement(By.xpath("//div[@class='inventory_item_name']")).getText();

if (productIncart.equals("Sauce Labs Backpack"))
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
driver.findElement(By.id("first-name")).sendKeys("Vrunda");
driver.findElement(By.id("last-name")).sendKeys("Kale");
driver.findElement(By.id("postal-code")).sendKeys("123456");

//Navigate to overview
driver.findElement(By.id("continue")).click();

//Navigate to Overview page
driver.findElement(By.id("finish")).click();
	}

}
