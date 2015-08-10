package eglu.applogicWork;

import eglu.applogicWork.DriverBasedHelper;
import eglu.applogicWork.ApplicationManagerWork;
import eglu.applogic.NavigationHelper;

public class NavigationHelperWork extends DriverBasedHelper implements NavigationHelper {

	private String baseUrl;
	
	public NavigationHelperWork(ApplicationManagerWork manager) {
	    super(manager.getWebDriver());
	    this.baseUrl = manager.getBaseUrl();
	  }
	//..............................................................
	 
	  public void openPage(String url) {
	    driver.get(baseUrl + url);
	    driver.manage().window().maximize();
	 }
	//..............................................................
	 
	 public void gotoCellListPage() {
	   pages.internalPage.ensurePageLoaded().clickCellListLink();
	 }
	 
	 public void gotoCellTablePage() {
	   pages.internalPage.ensurePageLoaded().clickCellTableLink();
	 }
	 
	 
	public boolean ComparisonTwoValues(String act, String exp) {
			
			boolean returnResult = false; 
			
			if (act.equals(exp)) {
				returnResult = true;
			}
			
			return returnResult; 
	}
	
	public boolean ComparisonTwoValues(int act, int exp) {
			
			boolean returnResult = false; 
			
			if (act == exp) {
				returnResult = true;
			}
			
			return returnResult;
	}
}
