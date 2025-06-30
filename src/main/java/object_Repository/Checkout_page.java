package object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Checkout_page {
@FindBy (id = "first-name")
private WebElement firstNameEdt;

@FindBy (id = "last-name")
	private WebElement lastNameEdt;

@FindBy (id = "postal-code")
private WebElement postalCodeEdt;

@FindBy (id = "continue")
private WebElement continueBtn;

@FindBy (id = "cancel")
private WebElement cancelBtn;

//initialization

public Checkout_page(WebDriver driver) {
	PageFactory.initElements(driver, this);
	
}

//Getters

public WebElement getFirstNameEdt() {
	return firstNameEdt;
}

public WebElement getLastNameEdt() {
	return lastNameEdt;
}

public WebElement getPostalCodeEdt() {
	return postalCodeEdt;
}

public WebElement getContinueBtn() {
	return continueBtn;
}

public WebElement getCancelBtn() {
	return cancelBtn;
}

//Business Libraries 

public void enterFirstName(String FIRSTNAME) {
	firstNameEdt.sendKeys(FIRSTNAME);
	
}
public void enterLastName(String LASTNAME) {
	lastNameEdt.sendKeys(LASTNAME);

}
public void enterPostalCode(String POSTALCODE) {
	postalCodeEdt.sendKeys(POSTALCODE);
}

public void clickOnContinueBtn() {
	continueBtn.click();
}

public void clickOnCancelBtn() {
	cancelBtn.click();
}


}

