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
 *Just im verifing is this class in account creation page or not
 */
public class AccountCreationPage extends Base {
ActionClass action = new ActionClass();

	@FindBy(xpath="//div[@id=\"noSlide\"]/h1")
	WebElement createAccountHeader;

	public AccountCreationPage() {
		PageFactory.initElements(driver, this);

	}
	
	public boolean verifyHeader() {
		return action.isDisplayed(driver, createAccountHeader);
		
	}

}
