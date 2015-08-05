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
	 @Override
	  public void openPage(String url) {
	    driver.get(baseUrl + url);
	    driver.manage().window().maximize();
	 }
	//..............................................................
	 @Override
	 public void gotoCellListPage() {
	   pages.internalPage.ensurePageLoaded().clickCellListLink();
	 }
	 
	 @Override
	 public void gotoCellTablePage() {
	   pages.internalPage.ensurePageLoaded().clickCellTableLink();
	 }
	 
	 
	@Override
	public boolean ÑomparisonTwoValues(String act, String exp) {
			
			boolean returnResult = false; 
			
			if (act.equals(exp)) {
				returnResult = true;
			}
			
			return returnResult; 
	}
	
	@Override
	public boolean ÑomparisonTwoValues(Integer act, Integer exp) {
			
			boolean returnResult = false; 
			
			if (act == exp) {
				returnResult = true;
			}
			
			return returnResult;
	}
}
