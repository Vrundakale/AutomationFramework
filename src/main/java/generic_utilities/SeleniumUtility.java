package generic_utilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumUtility {
	
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
		
	}
	
	public void minimizeWindow(WebDriver driver) {
		driver.manage().window().minimize();
	}
	
	public void fullscreenWindow(WebDriver driver) {
		driver.manage().window().fullscreen();
	}
	
	public void addimpliciteWait(WebDriver driver,double time) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
 //Visibility of the element, element to be clickable
	
	public void ExpliciteWaitElementToBeClikable(WebDriver driver, WebElement element ) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
		
	}
	public void ExpliciteWaitElementToBeSelected(WebDriver driver, WebElement element ) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeSelected(element));
	}
	
	//method overloading
	
	public void handleDropdown (WebElement element, int index) {
		Select sel= new Select(element);
		sel.selectByIndex(0);
		
	}
	
	public void handleDropdown (String value,WebElement element ) {
		Select sel= new Select(element);
		sel.selectByValue(value);
	}
	
	public void handleDropdown (WebElement element, String visibletext) {
		Select sel= new Select(element);
		sel.selectByVisibleText(visibletext);
	}
	
	/**
	 * These methods can be used for mouse related actions
	 * @param element
	 * @param driver
	 */
	
	public void doubleClickAction (WebElement element, WebDriver driver ) {
		Actions act= new Actions(driver);
		act.doubleClick(element).perform();
		
	}
	
	
	public void rightClickAction (WebDriver driver, WebElement element ) {
		Actions act= new Actions(driver);
		act.contextClick(element).perform();
		
	}
	
	public void dragAndDropAction (WebDriver driver, WebElement sourceElement, WebElement targetElement) {
		Actions act= new Actions(driver);
		act.dragAndDrop(sourceElement, targetElement).perform();
		
	}
	
	public void clickAndHoldAction (WebDriver driver, WebElement element ) {
		Actions act= new Actions(driver);
		act.clickAndHold(element).perform();
		
	}
	public void releaseAction (WebDriver driver, WebElement element ) {
		Actions act= new Actions(driver);
		act.release(element).perform();
		
	}
	
	public void mousehoverAction(WebElement element, WebDriver driver ) {
		Actions act= new Actions(driver);
		act.moveToElement(element).perform();
		
	}
	
	public void srollAction(WebElement element, WebDriver driver ) {
		Actions act= new Actions(driver);
		act.scrollToElement(element).perform();
	}
	
	
	
	/**
	 * These methods can be used to witch to another frame
	 * @param driver
	 * @param frameIndex
	 */
	
	public void switchToFrame (WebDriver driver, int frameIndex) {
		driver.switchTo().frame(frameIndex);
}
	public void switchToFrame (WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}
	public void switchToFrame (WebDriver driver, String frameNameOrId) {
		driver.switchTo().frame(frameNameOrId);
	}
	
	/**
	 * These methods can be used to switch the driver control to another window
	 * @param driver
	 */
	
	public void switchToParentWindow (WebDriver driver) {
		driver.switchTo().parentFrame();
	}
	
	public void switchToMainWindow (WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	
	public void switchToWindow (WebDriver driver, String WindowId) {
		driver.switchTo().window(WindowId);
	}
	/**
	 * This method can be used to switch the driver control to alert
	 * @param driver
	 */
	
	public void acceptAlert (WebDriver driver) {
		driver.switchTo().alert().accept();
		
	}
	
	public void dismissAlert (WebDriver driver) {
		driver.switchTo().alert().dismiss();
		
	}
	
	public String getTextOfAlert (WebDriver driver, String text) {
		driver.switchTo().alert().getText();
		return text;
		
	}
	
	public void sendKeysInAlert (WebDriver driver, String data) {
		driver.switchTo().alert().sendKeys(data);
		
	}
	
	public void ScrollDownAction (WebDriver driver) {
		JavascriptExecutor jse= (JavascriptExecutor) driver;
		jse.executeScript("window.ScrollBy(0,500);", "");
		
		
	}
	
	public void ScrollUpAction (WebDriver driver) {
		JavascriptExecutor jse= (JavascriptExecutor) driver;
		jse.executeScript("window.ScrollBy(-200,1000);", "");
		
		
	}
	
	/**
	 * This method can be used to capture the screenshot of the web page
	 * @param driver
	 * @param ScreenShotName
	 * @return
	 * @throws IOException
	 */
	
	public String captureScreenShot (WebDriver driver, String ScreenShotName) throws IOException {
		TakesScreenshot ts= (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst= new File(".\\ScreenShots\\ "+ScreenShotName+".png");
		FileHandler.copy(src, dst);
		return dst.getAbsolutePath(); //for extent reports
		
	}
	
}
