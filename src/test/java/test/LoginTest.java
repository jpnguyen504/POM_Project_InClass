package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;

public class LoginTest {

	WebDriver driver;
	
//	TestData
	String userName = "demo@codefios.com";
	String password = "abc123";
	String dashboardValidationText = "Dashboard";
	
	@Test
	public void validUserShouldBeAbleToLogin() {
//		ways to call a method from another package
//		object	//by class name
		driver = BrowserFactory.init();	//set as driver = so we can establish a 
										//relationship between the global driver
										//and the driver from the BrowserFactory
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
										//using PageFactory, the driver is being 
										//passed through into the LoginPage
										//establishing a relationship between the two
		loginPage.insertUserName(userName);
		loginPage.insertPassword(password);
		loginPage.clickOnSignInButton();
		
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		
		dashboardPage.validateDashboardPage(dashboardValidationText);
		
		BrowserFactory.tearDown();
	}
}
