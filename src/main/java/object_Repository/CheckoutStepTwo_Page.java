package object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutStepTwo_Page {
@FindBy (id = "finish")
private WebElement finishBtn;



//initialization

public CheckoutStepTwo_Page(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

//Getter
public WebElement getFinishBtn() {
	return finishBtn;
}

//Business Libraries

public void clickOnfinishBtn() {
	finishBtn.click();
}

}