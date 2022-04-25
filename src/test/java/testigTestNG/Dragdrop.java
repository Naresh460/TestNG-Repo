package testigTestNG;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dragdrop {
	
	@Test
	public void main() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions co = new ChromeOptions();
		co.addArguments("ignore-certificate-errors");
		WebDriver driver = new ChromeDriver(co);
		driver.manage().window().maximize();		
		driver.get("https://demo.guru99.com/test/drag_drop.html");		
		WebElement sourcee= driver.findElement(By.id("credit2"));
		WebElement targett= driver.findElement(By.id("bank"));	
		
		Actions action= new Actions(driver);
		action.dragAndDrop(sourcee, targett).build().perform();
		
     
		
//		final String java_script =
//                "var src=arguments[0],tgt=arguments[1];var dataTransfer={dropEffe" +
//                "ct:'',effectAllowed:'all',files:[],items:{},types:[],setData:fun" +
//                "ction(format,data){this.items[format]=data;this.types.append(for" +
//                "mat);},getData:function(format){return this.items[format];},clea" +
//                "rData:function(format){}};var emit=function(event,target){var ev" +
//                "t=document.createEvent('Event');evt.initEvent(event,true,false);" +
//                "evt.dataTransfer=dataTransfer;target.dispatchEvent(evt);};emit('" +
//                "dragstart',src);emit('dragenter',tgt);emit('dragover',tgt);emit(" +
//                "'drop',tgt);emit('dragend',src);";
//        
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript(java_script, sourcee, targett);		
		
		
	}

}
