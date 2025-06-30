package Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class TestCase4_AddTwoProducts {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//Launch the Browser
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		//Navigate to Web application
		driver.get("https://www.saucedemo.com/");
	
		//Login
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		
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

if (productIncart.equals("Sauce Labs Backpack"))
{System.out.println(productIncart);
	System.out.println("Pass");

}
else
{System.out.println("Fail");

}
Thread.sleep(2000);
String productIncart2 = driver.findElement(By.xpath("//div[contains(text(),'Sauce Labs Bike Light')]")).getText();

if (productIncart2.equals("Sauce Labs Bike Light"))
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
driver.findElement(By.id("first-name")).sendKeys("Vrunda");
driver.findElement(By.id("last-name")).sendKeys("Kale");
driver.findElement(By.id("postal-code")).sendKeys("123456");

//navigate to overview page
driver.findElement(By.id("continue")).click();

//navigate to complete page
driver.findElement(By.id("finish")).click();

	}

}
