import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UploadFiles {
	
	
	@Test
public void uploadFiles() {
	
	WebDriverManager.chromedriver().setup();
	WebDriver driver =new ChromeDriver();
	driver.get("http://omayo.blogspot.com/");
	//driver.findElement(By.id("uploadfile")).sendKeys("C:\\Users\\Naresh\\Selenium\\TestNGProject\\sample.xlsx");
	
	//We can upload file from project directory
	String filepath=System.getProperty("user.dir");
	driver.findElement(By.id("uploadfile")).sendKeys(filepath+"\\Documents\\sample.xlsx");
}
}
