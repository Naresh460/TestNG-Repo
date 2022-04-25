import org.testng.annotations.Test;

public class DependenciesTestNG {
	String trackingnumber = null;
	
	@Test 
	public void createTrackingNum() {
		//System.out.println(10/0);
		trackingnumber = "ABCD1234";
		
		System.out.println("Traking id is ===> " +trackingnumber);
	}
	
	@Test (priority = 1, dependsOnMethods = {"createTrackingNum"})
	public void trackstatus() throws Throwable {
		if(trackingnumber != null) {
			System.out.println("Traking status is");
			}
		else
		{
			throw new Exception("Tracking Number not valid");
		}
	}
	
	@Test  (priority = 2,dependsOnMethods = {"createTrackingNum"})
	public void cacelTracking() throws Throwable {
		
		if(trackingnumber!=null) {
			System.out.println("Order Cacelled");}
		else
		{
			throw new Exception("Tracking Number not available");
		}
		
	}

}


