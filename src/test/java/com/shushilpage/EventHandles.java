package com.shushilpage;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

public class EventHandles extends Sushilpage implements WebDriverListener {
	
	 @Override
	    public void beforeClick(WebElement element) {
	        // TODO Auto-generated method stub
	       
	        try {
				screenShot(driver);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
 
//	 @Override
//	    public void afterFindElement(WebDriver driver, By locator, WebElement result) {
//	        // TODO Auto-generated method stub
//	        System.out.println("After Element find");
//	        try {
//				screenShot(driver);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//	    }
	 
	 public String screenShot(WebDriver driver) throws IOException {
		 String filename ="naresh";
			String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
			File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
			File destination = new File(System.getProperty("user.dir")+"\\Screenshots\\" + filename + "_" + dateName + ".png");	
			
			try {
				FileUtils.copyFile(source, destination);
			} catch (Exception e) {
				e.getMessage();
			}
			// This new path for jenkins
			//String newImageString = "http://localhost:8080/job/GitFrameWork/ws/FrameWork/Screenshots/"+ filename +"_"+dateName +".png";
		   // return newImageString;
		return destination.getAbsolutePath();
		
	}
}
 
	
	
