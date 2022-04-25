package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.js.demo.StartBrowser;

public class AccessGoogle {
 
 
 @Test
	public  void accessGoogles() {	
		
		WebDriver driver = new ChromeDriver();
				
				driver.get("https://www.google.com/");		

	}

}
