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
 *
 */
public class AddtoCartPage extends Base {
	ActionClass action = new ActionClass();
	
	@FindBy(id="quantity_wanted")
	WebElement quantity;
	
	@FindBy(id="group_1")
	WebElement sizeoftheproduct;
	
	@FindBy(name="Submit")
	WebElement addtoCartBtn;
	
	@FindBy(xpath="//*[@id=\"layer_cart\"]/div[1]/div[1]/h2/i")
	WebElement cartSuccessMessage;
	
	@FindBy(xpath="//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a")
	WebElement clicktoCheckout;
	
	public AddtoCartPage() {
		PageFactory.initElements(driver, this);

	}
	
	public void addquantity(String qnty) {
		action.type(quantity, qnty);
		
	}
	
	public void selectSize(String size) {
		action.selectByVisibleText(size, sizeoftheproduct);		
	}
	
	public void clickAddtoCart() {
		action.click(driver, addtoCartBtn);
		
	}
	
	public boolean validateAddtoCart() {
		return action.isDisplayed(driver, cartSuccessMessage);
		
	}
	
	public OrderPage clicktoCheckout() {		
		//action.click(driver, clicktoCheckout);
		action.JSClick(driver, clicktoCheckout);
		return new OrderPage();
	}
	
}
