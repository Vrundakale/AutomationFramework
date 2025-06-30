package Practice;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import generic_utilities.FileUtility;
import generic_utilities.SeleniumUtility;

public class Login {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//launch the browser
		FileUtility fUtil= new FileUtility();
		SeleniumUtility sUtil = new SeleniumUtility();
		
WebDriver driver = new EdgeDriver();
sUtil.maximizeWindow(driver);
sUtil.addimpliciteWait(driver, 15);

String URL = fUtil.readDataFromPropertyFile("Url");


//enter url
driver.get(URL);
//Enter the User name
driver.findElement(By.id("user-name")).sendKeys("standard_user");
//Enter password
driver.findElement(By.id("password")).sendKeys("secret_sauce");
//Click on login button
driver.findElement(By.id("login-button")).click();
		
	}
	

}
