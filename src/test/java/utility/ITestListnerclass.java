package utility;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ITestListnerclass extends Extentreports_Base implements ITestListener{
	


	@Override
	public void onTestFailure(ITestResult result) {
		try {
			String path = screnshotbase69(result.getMethod().getMethodName());
			extenttest.addScreenCaptureFromPath(path);
			extenttest.fail(result.getThrowable());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSuccess(ITestResult result) {     //screenshot for pass test
		try {
			String path = screnshotbase69(result.getMethod().getMethodName());
			extenttest.addScreenCaptureFromPath(path);
			extenttest.pass("Test passed");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
