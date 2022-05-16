package com.shushilpage;

import java.awt.Desktop;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Base64;

import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.time.StopWatch;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sushilpage {	
	public static WebDriver driver;
	public static ExtentTest extenttest ;
	public static ExtentReports reprtengine;
	static ExtentSparkReporter sparkreport_all;
	DateFormat dateFormat_report = new SimpleDateFormat("dd-mm-yyyy h-m-s");
	Date date_report = new Date();
	String filename_report;
	public static String encodedBase64=null;



	@BeforeSuite
	public void loadConfig(ITestContext context) throws IOException {

		String docTitile=context.getCurrentXmlTest().getName();
		filename_report = context.getSuite().getName();
		reprtengine = new ExtentReports();			
		sparkreport_all = new ExtentSparkReporter(System.getProperty("user.dir")+"\\SushilReports\\"+filename_report+"-"+dateFormat_report.format(date_report)+".html");
		sparkreport_all.config().setDocumentTitle(docTitile);
		sparkreport_all.config().setReportName("Naresh");
		sparkreport_all.loadXMLConfig("C:\\Users\\nbusireddy\\Selenium\\git\\extentReport-config.xml");
		reprtengine.attachReporter(sparkreport_all);	  
		reprtengine.setSystemInfo("OS", System.getProperty("os.name"));

	}

	@AfterSuite
	public void generateReports() throws IOException {		
		reprtengine.flush();
		Desktop.getDesktop().browse(new File(System.getProperty("user.dir")+"\\SushilReports\\"+filename_report+"-"+dateFormat_report.format(date_report)+".html").toURI());
	}

	@BeforeMethod
	public void beforeTest() {
		WebDriverManager.chromedriver().setup();		
		WebDriverListener customListener = new EventHandles();
		driver = new EventFiringDecorator(customListener).decorate(new ChromeDriver());		
	}

	@AfterMethod
	public void aftertest() {		
		driver.quit();
	}


	@Test(priority = 1)
	public static void taskPage() throws InterruptedException {	

		driver.get("https://codewithsushil.in/index.html");
		Thread.sleep(2000);
		driver.findElement(By.linkText("Start Level 1")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Click Here")).click();
		Thread.sleep(2000);
		driver.findElement(By.partialLinkText("Navigate")).click();
		Thread.sleep(2000);
		driver.findElement(By.partialLinkText("Next")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("namefield")).sendKeys("Naresh");
		Thread.sleep(2000);
		driver.findElement(By.partialLinkText("Next")).click();
		driver.findElement(By.id("agefield")).clear();
		driver.findElement(By.id("agefield")).sendKeys("30");
		driver.findElement(By.partialLinkText("Next")).click();
		Select s= new Select(driver.findElement(By.name("gender")));
		s.selectByValue("1");
		driver.findElement(By.partialLinkText("Next")).click();
		driver.findElement(By.name("married")).click();
		driver.findElement(By.partialLinkText("Next")).click();
		driver.findElement(By.xpath("//input[@id=\"1\"]")).click();
		driver.findElement(By.partialLinkText("Next")).click();
		driver.findElement(By.partialLinkText("Click")).click();
		driver.findElement(By.partialLinkText("Navigate")).click();
		driver.findElement(By.partialLinkText("Next")).click();
		String textt = driver.findElement(By.xpath("//div[@class=\"container\"]/h3")).getText();
		driver.findElement(By.id("copyandpaste")).sendKeys(textt);
		driver.findElement(By.partialLinkText("Next")).click();
		WebElement e=	driver.findElement(By.xpath("//div[@class=\"container\"]/select"));
		Select s1 = new Select(e);
		s1.selectByValue("1");
		s1.selectByValue("2");
		driver.findElement(By.partialLinkText("Next")).click();
		String parentwinow= driver.getWindowHandle();
		driver.findElement(By.xpath("//div[@class=\"container\"]/div/button")).click();		
		driver.findElement(By.xpath("//div[@class=\"dropdown\"]/div/a")).click();
		Set<String> childwindows = driver.getWindowHandles();
		for (String childwindow : childwindows) {
			if(!childwindow.equals(parentwinow)) {
				driver.switchTo().window(childwindow);
				Thread.sleep(3000);
				driver.close();
			}		
		}
		driver.switchTo().window(parentwinow);
		driver.findElement(By.partialLinkText("Next")).click();
		Actions act = new Actions(driver);
		WebElement ee=driver.findElement(By.xpath("//div[@class=\"form-inline\"]/button"));
		act.doubleClick(ee).perform();
		driver.findElement(By.partialLinkText("Next")).click();
		String imgAddress= driver.findElement(By.xpath("//div[@class=\"container\"]/img")).getAttribute("src");
		driver.findElement(By.id("address")).sendKeys(imgAddress);
		driver.findElement(By.partialLinkText("Next")).click();
		driver.findElement(By.xpath("//div[@class=\"container\"]/button[2]")).click();		
		Alert alert= driver.switchTo().alert();
		alert.sendKeys("Naresh");
		alert.accept();
		driver.findElement(By.partialLinkText("Next")).click();
		String pagetitle = driver.getTitle();
		driver.findElement(By.id("inputfield")).sendKeys(pagetitle);
		driver.findElement(By.partialLinkText("Next")).click();
		String url= driver.getCurrentUrl();
		driver.findElement(By.id("inputfield")).sendKeys(url);
		driver.findElement(By.partialLinkText("Next")).click();
		driver.findElement(By.name("pastebody")).sendKeys("test");
		driver.findElement(By.partialLinkText("Next")).click();

		//OS and Browser details

		Capabilities cap =((HasCapabilities) driver).getCapabilities();
		String browserName=cap.getBrowserName();
		String browserversion=cap.getBrowserVersion();
		String osname=System.getProperty("os.name");
		String osversion = System.getProperty("os.version");
		System.out.println(browserName);
		driver.findElement(By.id("osName")).sendKeys(osname);
		driver.findElement(By.id("os-version")).sendKeys(osversion);
		driver.findElement(By.id("browserName")).sendKeys(browserName);
		driver.findElement(By.id("browserVersion")).sendKeys(browserversion);
		driver.findElement(By.partialLinkText("Finish")).click();

	}





	@Test(priority = 2)
	public static void testmethod() throws InterruptedException {

		driver.get("http://codewithsushil.in/2.01alert.html");
		driver.findElement(By.xpath("//div[@class=\"container\"]/button[2]")).click();
		driver.switchTo().alert().accept();
		driver.findElement(By.partialLinkText("Next")).click();
		String parentwindow = driver.getWindowHandle();
		driver.findElement(By.xpath("//div[@class=\"container\"]/button[2]")).click();
		Set<String> childwindows = driver.getWindowHandles();
		for (String child : childwindows) {
			if(!child.equals(parentwindow)) {
				driver.switchTo().window(child);
				driver.close();
			}
		}

		driver.switchTo().window(parentwindow);
		driver.findElement(By.partialLinkText("Next")).click();

		driver.findElement(By.xpath("//body/div[2]/div[1]/iframe[1]")).click();
		driver.switchTo().alert().accept();
		driver.findElement(By.partialLinkText("Next")).click();
		String tooltip = driver.findElement(By.xpath("//div[@class=\"container\"]/h3/a")).getAttribute("title");
		driver.findElement(By.name("mouseovertext")).sendKeys(tooltip);
		driver.findElement(By.partialLinkText("Next")).click();

		Actions builder = new Actions(driver);
		WebElement element = driver.findElement(By.name("resizeArea"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].setAttribute('style', 'WIDTH:1259px;HEIGHT:150px');", element);
		driver.findElement(By.partialLinkText("Next")).click();

		int book1= driver.findElements(By.xpath("//ul[@id=\"books\"]/li[1]/ul/li")).size();
		int book2_chapter= driver.findElements(By.xpath("//ul[@id=\"books\"]/li[2]/ul/li")).size();
		int book2_Exersise = driver.findElements(By.xpath("//ul[@id=\"books\"]/li[2]/ul/ul/li")).size();
		int book3 = driver.findElements(By.xpath("//ul[@id=\"books\"]/li[3]/ul/li")).size();
		int totalchapeters = book1+book2_chapter+book3;
		driver.findElement(By.id("chapall")).sendKeys(String.valueOf(totalchapeters));
		driver.findElement(By.id("chapbook2")).sendKeys(String.valueOf(book2_chapter));
		Thread.sleep(5000);
		driver.findElement(By.partialLinkText("Next")).click();

		StopWatch s = new StopWatch();
		driver.findElement(By.xpath("//div[@class=\"container\"]/h3[2]/a")).click();		
		s.start();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(30000), Duration.ofMillis(500));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert  =driver.switchTo().alert();
		alert.accept();		
		s.stop();
		long totaltime = s.getTime(TimeUnit.SECONDS);
		driver.findElement(By.id("duration")).sendKeys(String.valueOf(totaltime));
		driver.findElement(By.partialLinkText("Next")).click();

		driver.findElement(By.xpath("//div[@class=\"container\"]/button[2]")).click();
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofMillis(20000), Duration.ofMillis(500));
		wait2.until(ExpectedConditions.elementToBeClickable(By.id("button2"))).click();
		driver.switchTo().alert().accept();
		driver.findElement(By.partialLinkText("Next")).click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementsByClassName('greenbox')[0].click()");
		Thread.sleep(5000);
		driver.switchTo().alert().accept();
		driver.findElement(By.partialLinkText("Next")).click();

		WebElement sourcee= driver.findElement(By.id("drag1"));
		WebElement targett= driver.findElement(By.id("div1"));		
		final String java_script =
				"var src=arguments[0],tgt=arguments[1];var dataTransfer={dropEffe" +
						"ct:'',effectAllowed:'all',files:[],items:{},types:[],setData:fun" +
						"ction(format,data){this.items[format]=data;this.types.append(for" +
						"mat);},getData:function(format){return this.items[format];},clea" +
						"rData:function(format){}};var emit=function(event,target){var ev" +
						"t=document.createEvent('Event');evt.initEvent(event,true,false);" +
						"evt.dataTransfer=dataTransfer;target.dispatchEvent(evt);};emit('" +
						"dragstart',src);emit('dragenter',tgt);emit('dragover',tgt);emit(" +
						"'drop',tgt);emit('dragend',src);";

		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript(java_script, sourcee, targett);

		driver.findElement(By.partialLinkText("Next")).click();
		WebElement sourceee= driver.findElement(By.xpath("//div[@class=\"container\"]/h3[2]/input"));
		Actions actions= new Actions(driver);
		actions.dragAndDropBy(sourceee, 250, 0).perform();
		driver.findElement(By.partialLinkText("Next")).click();
		String parentwindow1 = driver.getWindowHandle();
		driver.findElement(By.xpath("//div[@class=\"container\"]/button[2]")).click();		
		Set<String> childwindows1 = driver.getWindowHandles();
		for (String child : childwindows1) {
			if(!child.equals(parentwindow1)) {
				driver.switchTo().window(child);				
				System.out.println(driver.getTitle());
				driver.close();
			}
		}

		driver.switchTo().window(parentwindow1);
		driver.findElement(By.partialLinkText("Finish")).click();



	}




	//		@Test
	//		public void testm() throws InterruptedException {
	//			WebDriverManager.chromedriver().setup();
	//			WebDriver driver = new ChromeDriver();
	////			 WebDriverListener customListener = new EventHandles();
	////			 driver = new EventFiringDecorator(customListener).decorate(new ChromeDriver());		
	//			
	//			driver.get("https://codewithsushil.in/1.17PlatformInfo.html");
	//			Capabilities cap =((RemoteWebDriver)driver).getCapabilities();
	//			String browserName=cap.getBrowserName();
	//			String browserversion=cap.getBrowserVersion();
	//			String osname=System.getProperty("os.name");
	//			String osversion = System.getProperty("os.version");
	//			System.out.println(browserName);
	//			driver.findElement(By.id("osName")).sendKeys(osname);
	//			driver.findElement(By.id("os-version")).sendKeys(osversion);
	//			driver.findElement(By.id("browserName")).sendKeys(browserName);
	//			driver.findElement(By.id("browserVersion")).sendKeys(browserversion);
	//			driver.findElement(By.partialLinkText("Finish")).click();
	//			
	//			
	//		}

	public String screenShot() throws IOException {

		String encodedBase64=null;
		String filename ="naresh";
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		File destination = new File(System.getProperty("user.dir")+"\\Screenshots\\" + filename + "_" + dateName + ".png");	
		FileUtils.copyFile(source, destination);
		String destination1=destination.getAbsolutePath();
		System.out.println(destination1);
		try {			
			 
			byte[] fileContent = FileUtils.readFileToByteArray(source);
			encodedBase64 = "data:image/png;base64,"+Base64.getEncoder().encodeToString(fileContent);
			
		
		} catch (Exception e) {
			e.getMessage();
		}
		// This new path for jenkins
		//String newImageString = "http://localhost:8080/job/GitFrameWork/ws/FrameWork/Screenshots/"+ filename +"_"+dateName +".png";
		// return newImageString;
		
		
		//return destination.getAbsolutePath();
		return encodedBase64;

	}
}
