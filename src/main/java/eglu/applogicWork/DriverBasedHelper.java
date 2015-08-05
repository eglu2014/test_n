package eglu.applogicWork;

import org.openqa.selenium.WebDriver;

import eglu.pages.PageManager;

public class DriverBasedHelper {
	
	protected WebDriver driver;
	protected PageManager pages;
	
	public DriverBasedHelper(WebDriver driver) {
	    this.driver = driver;
	    pages = new PageManager(driver);
	 }
	
	public boolean ÑomparisonTwoValues(String act, String exp) {
		
		boolean returnResult = false; 
		
		if (act.equals(exp)) {
			returnResult = true;
		}
		
		return returnResult; 
	}	
}
