package com.baseclass;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import com.actiondriver.*;

public class Base {
	ActionClass action = new ActionClass();
	Properties prop;
	public  WebDriver driver;
	


	@BeforeTest
	public void loadConfig() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:/Users/nbusireddy/Selenium/MyFrameWork/configuration/prop.properties");
			prop.load(ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public void launchApp() {
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();

//		String browserrname = prop.getProperty("browser");
//		
//		switch (browserrname) {
//		  case "Chrome":
//		WebDriverManager.chromedriver().setup();
//		   driver = new ChromeDriver();
//		    break;
//		  case "FireFox":
//			  WebDriverManager.firefoxdriver().setup();
//			  driver = new FirefoxDriver();
//		    break;
		  
	//}
		
		driver.get("url");	
		

	}


	
}
