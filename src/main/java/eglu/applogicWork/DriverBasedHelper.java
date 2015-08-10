package eglu.applogicWork;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import eglu.pages.PageManager;

public class DriverBasedHelper {
	
	protected WebDriver driver;
	protected PageManager pages;
	protected WebDriverWait wait;
	
	public DriverBasedHelper(WebDriver driver) {
	    this.driver = driver;
	    pages = new PageManager(driver);
	    wait = new WebDriverWait(driver, 10);
	 }
	
	protected boolean ComparisonTwoValues(String act, String exp) {
		
		boolean returnResult = false; 
		
		if (act.equals(exp)) {
			returnResult = true;
		}
		
		return returnResult; 
	}	
}
