/**
 * 
 */
package com.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actiondriver.ActionClass;
import com.baseclass.Base;

/**
 * @author nbusireddy
 * Here we have to verify the Whishlist and OrderHistory Details
 */
public class HomePage extends Base {
	ActionClass action = new ActionClass();
	
	@FindBy(xpath="//span[text()='My wishlists']")
			WebElement whishlistBtn;
	
	@FindBy(xpath="//span[text()='Order history and details']")
	WebElement orderHistoryDetailsBtn;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
		
	}
	
	public boolean validateWhishlist() {
		return action.isDisplayed(driver, whishlistBtn);
	}
	
	public boolean validateOrderHistoryBtn() {		
		return action.isDisplayed(driver, orderHistoryDetailsBtn);
	}
}
