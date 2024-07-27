package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ListCustomerPage extends BasePage{

	WebDriver driver;
	
	public ListCustomerPage(WebDriver driver) {
		this.driver = driver;
	}
	
//	Element List
	@FindBy(how = How.XPATH, using = "//strong[text()='Customer List']")
	WebElement LIST_CUSTOMER_HEADER_ELEMENT;
	
	public void validateListCustomerPage(String expectedText) {
		validateElement(LIST_CUSTOMER_HEADER_ELEMENT, expectedText, "List Customer Page Not Found");
	}
}
