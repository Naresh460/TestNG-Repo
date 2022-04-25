package testigTestNG;

import org.testng.annotations.Test;

public class Grouping {


	@Test (groups = {"sanity","smoke","regression"})
	public void login() {		
		System.out.println("login page");
	}
	@Test (groups = {"sanity","smoke","windows.smoke","ios.smoke"})
	public void selectItem() {
		System.out.println("selectItem page");
	}
	
	@Test (groups = {"sanity"})
	public void cartandBook() {
		System.out.println("cartandBook page");
	}
	
	@Test  (groups = {"smoke","regression"})
	public void myAccount() {
		System.out.println("myAccount page");
	}
	
	@Test (groups = {"smoke","regression"})
	public void profile() {
		System.out.println("profile page");
	}
	@Test (groups = {"sanity","smoke","regression"})
	public void logout() {
		System.out.println("profile page");
	}


}
