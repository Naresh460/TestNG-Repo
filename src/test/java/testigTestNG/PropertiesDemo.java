package testigTestNG;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PropertiesDemo {
	Properties prop;
	
	@Test  (priority = 1)
	public void readPropertyfile() throws IOException {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/configuration/prop.properties");
		prop= new Properties();
		prop.load(fis);
	}   
	

	@Test (priority = 2)
	public void propertiesDemo() throws IOException {
		readPropertyfile();
		WebDriverManager.chromedriver().setup();
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("headless");
		WebDriver driver = new ChromeDriver();		
		driver.get(prop.getProperty("url"));
		driver.findElement(By.xpath(prop.getProperty("userxpath"))).sendKeys(prop.getProperty("username"));
		driver.findElement(By.xpath(prop.getProperty("passwordxpath"))).sendKeys(prop.getProperty("password"));
		driver.findElement(By.id(prop.getProperty("loginbtn"))).click();
	}


}
