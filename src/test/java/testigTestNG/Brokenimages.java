package testigTestNG;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Brokenimages {
	
	@Test
	public void brokenimg() throws IOException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("https://www.theworldsworstwebsiteever.com/");
		List<WebElement> imges = driver.findElements(By.tagName("img"));
		for (WebElement image : imges) {			
			String imageaddress = image.getAttribute("src");
			URL url = new URL(imageaddress);
			URLConnection urlconnection =url.openConnection();
			HttpURLConnection httpconnection = (HttpURLConnection) urlconnection;
			httpconnection.connect();	
			
			if(httpconnection.getResponseCode()==200) {
				
			System.out.println(imageaddress+"-->"+httpconnection.getResponseCode()+"--->"+httpconnection.getResponseMessage());	
			}else
			{
				System.err.println(imageaddress+"-->"+httpconnection.getResponseCode()+"--->"+httpconnection.getResponseMessage());
			}
			
			httpconnection.disconnect();
			
		}
		
		driver.quit();
	}

}
