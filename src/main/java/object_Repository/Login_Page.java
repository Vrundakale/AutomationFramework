package object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page {//Rule1
	
	//Rule 2
	//Declaration
	@FindBy(id="user-name")
	private WebElement usernameEdt;
	
	@FindBy(name ="password")
	private WebElement passwordEdt;
	
	@FindBy(id = "login-button")
	private WebElement loginBtn;
	
	
	//Locate Single WE with multiple operators
	//Works like OR operator
	//@FindAll({@FindBy (id= "user-name"), @FindBy (name ="username")})
	//private WebElement usernameEdt;
	
	//locate Single WE with multiple operators
	//Works like And operator
	//@FindBys ({@FindBy (id= "user-name"), @FindBy (name ="username")})
	//private WebElement usernameEdt;
	
	
	//Rule3
	//Initialization
	
	public Login_Page(WebDriver driver) {
	PageFactory.initElements(driver, this);
	}
	
	//Rule4
		//Give access by getters

	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	//Business library
	
	public void LoginToApp(String USERNAME, String PASSWORD) {
		
		usernameEdt.sendKeys(USERNAME);
		passwordEdt.sendKeys(PASSWORD);
		loginBtn.click();
	}
	
	
	
	

	
}
