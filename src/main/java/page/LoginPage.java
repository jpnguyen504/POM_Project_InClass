package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) { //this is here for the PageFactory connection
		this.driver = driver;
	}
	
//	Element List
//	By USER_NAME_FIELD = By.xpath("//input[@id='user_name']");
//	WebElement USER_NAME_ELEMENT = driver.findElement(By.xpath("//input[@id='user_name']"));
	@FindBy(how = How.XPATH, using = "//input[@id='user_name']")
	WebElement USER_NAME_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@id='password']")
	WebElement PASSWORD_ELEMENT;
	@FindBy(how = How.XPATH, using = "//button[@id='login_submit']")
	WebElement SIGN_IN_BUTTON_ELEMENT;
	
//	individual method: hard to create, easy maintenance
	public void insertUserName(String userName) {
		USER_NAME_ELEMENT.sendKeys(userName);
	}
	
	public void insertPassword(String password) {
		PASSWORD_ELEMENT.sendKeys(password);
	}
	
	public void clickOnSignInButton() {
		SIGN_IN_BUTTON_ELEMENT.click();
	}

//	combined method: easy to create, hard maintenance
	public void performLogin(String userName, String password) {
		USER_NAME_ELEMENT.sendKeys(userName);
		PASSWORD_ELEMENT.sendKeys(password);
		SIGN_IN_BUTTON_ELEMENT.click();
	}
}
