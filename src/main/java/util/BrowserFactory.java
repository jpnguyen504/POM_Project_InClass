package util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BrowserFactory {

	static WebDriver driver;
	
	@Test
	public static WebDriver init() {
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.codefios.com/ebilling/login");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	//industry standard is 60 seconds
		return driver;	//make this returnType WebDriver so when it's invoked
						//the driver is brought over to the Test
	}
	
	public static void tearDown() {
		driver.close();
		driver.quit();
	}
}
