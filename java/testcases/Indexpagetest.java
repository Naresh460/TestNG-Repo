/**
 * 
 */
package com.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.baseclass.Base;
import com.pageobjects.IndexPage;

/**
 * @author nbusireddy
 *
 */
public class Indexpagetest extends Base{
	IndexPage indexpage = new IndexPage();
	
	@BeforeMethod
	public void browsersetup() {
		launchApp();		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();		
	}
	
	@Test
	public void verifylogo() {
		boolean result = indexpage.getlogo();		
		Assert.assertTrue(result);
		
	}
	
	@Test
	public void verifyTitle() {
		String actualresult = indexpage.getTitle();	
		String expectedresult = "My Store";
		Assert.assertEquals(actualresult, expectedresult);
		
	}
	
	


}
