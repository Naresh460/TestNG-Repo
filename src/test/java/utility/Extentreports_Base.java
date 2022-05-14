package utility;

import java.awt.Desktop;
import java.util.Date;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Extentreports_Base {
	static WebDriver driver;
	static ExtentReports reprtengine;
	static ExtentSparkReporter sparkreport_all;
	static ExtentTest extenttest; 
	DateFormat dateFormat_report = new SimpleDateFormat("dd-mm-yyyy h-m-s");
	Date date_report = new Date();
	 String filename_report;
	static String subFolder;

	@BeforeTest
	public void setup(ITestContext context) {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		Capabilities Browsername = ((RemoteWebDriver) driver).getCapabilities();
		String Device=Browsername.getBrowserName()+""+Browsername.getBrowserVersion();
		extenttest=reprtengine.createTest(context.getName());                     //get the name of test from xml file
		extenttest.assignAuthor("reddy");
		extenttest.assignCategory(Device);


	}

	@AfterTest
	public void tearDown() {		
		driver.quit();
	}

	@BeforeSuite
	public  void initialiseReport(ITestContext context)  {		
		filename_report = context.getSuite().getName();
		reprtengine = new ExtentReports();			
		sparkreport_all = new ExtentSparkReporter("C:\\Users\\Naresh\\git\\TestNG-Repo\\TestNGProject\\test-output\\ExtentReports\\"+filename_report+"-"+dateFormat_report.format(date_report)+".html");
		reprtengine.attachReporter(sparkreport_all);	  
		reprtengine.setSystemInfo("OS", System.getProperty("os.name"));
	}
	@AfterSuite
	public void generateReports() throws IOException {		
		reprtengine.flush();
		Desktop.getDesktop().browse(new File("C:\\Users\\Naresh\\git\\TestNG-Repo\\TestNGProject\\test-output\\ExtentReports\\"+filename_report+"-"+dateFormat_report.format(date_report)+".html").toURI());
	}

	//@AfterMethod
	//	public void checkStatusandaddingScreenshots(ITestResult results, Method m) throws IOException {
	//		String name = m.getName();
	//		String path=screnshotbase69(name);
	//		if(results.getStatus() ==ITestResult.FAILURE ) {//			
	//			extenttest.addScreenCaptureFromPath(path);
	//			extenttest.fail(results.getThrowable());
	//		}else if(results.getStatus() ==ITestResult.SUCCESS) {		
	//			
	//			extenttest.addScreenCaptureFromPath(path);
	//			//			String base64= screnshotbase69();
	//			//			extenttest.addScreenCaptureFromBase64String(base64);
	//			extenttest.pass(m.getName()+ "Passed");
	//			
	//		}
	//	}

	public  String screnshotbase69(String filename) throws IOException {
		DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy h-m-s");
		Date date = new Date();
		if(subFolder==null) {                                                 //Creating folder every run			
			subFolder=dateFormat.format(date);

		}
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile=new File("F:\\sample\\"+subFolder+"\\"+filename+"-"+dateFormat.format(date)+".png");
		FileUtils.copyFile(SrcFile, DestFile);
		return DestFile.getAbsolutePath();

	}



}
