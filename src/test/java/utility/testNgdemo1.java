package utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class testNgdemo1 extends Extentreports_Base {
	

	@Test (dataProvider = "excel2dataprovider", dataProviderClass = ExcelreadDattaprovider.class)
	public  void enterCredentials(String Username, String Password) throws InterruptedException {	
		
		driver.get("https://www.saucedemo.com/");		
         Thread.sleep(2000);
		driver.findElement(By.id("user-name")).sendKeys(Username);
		driver.findElement(By.id("password")).sendKeys(Password);
		driver.findElement(By.id("login-button")).click();
		
	}
	
}
