package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.AddCustomerPage;
import page.DashboardPage;
import page.ListCustomerPage;
import page.LoginPage;
import util.BrowserFactory;

public class AddCustomerTest {

	WebDriver driver;
	
//	Test Data
	String userName = "demo@codefios.com";
	String password = "abc123";
	String dashboardValidationText = "Dashboard";
	String addCustomerValidationText = "New Customer";
	String fullName = "JP Test";
	String companyVisibleText = "Techfios";
	String listCustomerValidationText = "Customer List";
	
	@Test
	public void userShouldBeAbleToAddCustomer() {
		driver = BrowserFactory.init();
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.insertUserName(userName);
		loginPage.insertPassword(password);
		loginPage.clickOnSignInButton();
		
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.validateDashboardPage(dashboardValidationText);
		dashboardPage.clickCustomerMenu();
		dashboardPage.clickAddCustomerMenu();
		
		AddCustomerPage addCustomerPage = PageFactory.initElements(driver, AddCustomerPage.class);
		addCustomerPage.validateAddCustomerPage(addCustomerValidationText);
		addCustomerPage.insertFullName(fullName);
		addCustomerPage.selectCompanyDropDown(companyVisibleText);
		addCustomerPage.insertEmail();
		addCustomerPage.insertPhoneNum();
		addCustomerPage.clickSaveButton();
		
		ListCustomerPage listCustomerPage = PageFactory.initElements(driver, ListCustomerPage.class);
		listCustomerPage.validateListCustomerPage(listCustomerValidationText);
	}
}
