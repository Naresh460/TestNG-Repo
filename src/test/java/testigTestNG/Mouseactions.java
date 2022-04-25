package testigTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Mouseactions {
	
	@Test
	public void main() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.findElement(By.id("txtUsername")).sendKeys("admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		Thread.sleep(3000);
		Actions actions = new Actions(driver);
		actions
		.moveToElement(driver.findElement(By.id("menu_admin_viewAdminModule"))) //menu_admin_viewSystemUsers
		.moveToElement(driver.findElement(By.id("menu_admin_UserManagement")))
		.moveToElement(driver.findElement(By.id("menu_admin_viewSystemUsers")))
		.click()
		.perform();
		
		
		
		
	}

}
