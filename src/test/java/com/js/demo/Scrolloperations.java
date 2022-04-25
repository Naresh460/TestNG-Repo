package com.js.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Scrolloperations extends StartBrowser{

	@Test
	public void scroll() throws InterruptedException {
		driver.get("https://www.hyrtutorials.com/");
		Thread.sleep(4000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// @ scroll to sepecific position
		//js.executeScript("window.scrollTo(0,1000);");
		
		//@scroll to Bottom
		//js.executeScript("window.scrollTo(0,3324);");
		//js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		
		//@Scroll to element
		
	WebElement element = driver.findElement(By.xpath("//a[normalize-space()='Recent Posts']"));
//		js.executeScript("window.scrollTo(arguments[0],arguments[1])", element.getLocation().x,element.getLocation().y);
		
		//@Scroll by
		//js.executeScript("window.scrollBy(0,500)");
		
		//Scroll to View
	//	js.executeScript("arguments[0].scrollIntoView()", element);
		
		//highlight the element
	js.executeScript("arguments[0].scrollIntoView()", element);
	js.executeScript("arguments[0].setAttribute('style', 'color:red; background:yellow')", element);
		
	}

}
