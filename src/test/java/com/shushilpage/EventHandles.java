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
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;

import com.aventstack.extentreports.AnalysisStrategy;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.service.ExtentService;
import com.aventstack.extentreports.service.ExtentTestManager;
import com.aventstack.extentreports.testng.listener.commons.ExtentTestCommons;


public class EventHandles extends Sushilpage implements WebDriverListener {
	
	@Override
	public void beforeClick(WebElement element) {
	        // TODO Auto-generated method stub
	       
	        try {
	        	System.out.println("Before Clcik");
			String path = screenShot();
				
				//extenttest.addScreenCaptureFromPath(path);
			extenttest.addScreenCaptureFromBase64String(path);
			
				
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
	 
	 
}
 
	
	
