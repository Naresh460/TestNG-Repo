package utility;

import org.testng.annotations.Test;

public class TestPage extends Extentreports_Base {

	@Test
	public void accessGoogle() {
		driver.get("https://www.google.com/");	
		extenttest.pass("Passed");
	}
	@Test
	public void accessFacebbok() {
		
		driver.get("https://ww.fa.com/");	
		extenttest.pass("Passed");
	}
	@Test
	public void accessGmail() {

		driver.get("https://www.g.com/");	
		extenttest.pass("Passed");
	}

}
