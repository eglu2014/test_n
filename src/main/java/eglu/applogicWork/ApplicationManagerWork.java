package eglu.applogicWork;

import java.util.concurrent.TimeUnit;

import eglu.util.Browser;
import eglu.util.PropertyLoader;
import eglu.webdriver.WebDriverFactory;
import eglu.applogic.CellListHelper;
import eglu.applogic.NavigationHelper;
import eglu.applogic.CellTableHelper;
import eglu.applogic.ApplicationManager;

import org.openqa.selenium.WebDriver;


public class ApplicationManagerWork implements ApplicationManager {
	
	private CellListHelper cellListHelper;
	private CellTableHelper cellTableHelper;
	private NavigationHelper navHelper;
	
	private WebDriver driver;
	private String baseUrl;
	
	public ApplicationManagerWork() {
		baseUrl = PropertyLoader.loadProperty("site.url");
		String gridHubUrl = PropertyLoader.loadProperty("grid2.hub");

		Browser browser = new Browser();
		browser.setName(PropertyLoader.loadProperty("browser.name"));
		browser.setVersion(PropertyLoader.loadProperty("browser.version"));
		browser.setPlatform(PropertyLoader.loadProperty("browser.platform"));

		String username = PropertyLoader.loadProperty("user.username");
		String password = PropertyLoader.loadProperty("user.password");
		    
		driver = WebDriverFactory.getInstance(gridHubUrl, browser, username, password);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		    
		cellListHelper = new CellListHelperWork(this);
		cellTableHelper = new CellTableHelperWork(this);
		navHelper = new NavigationHelperWork(this);
		    
	 }
	 
	 @Override
	  public CellListHelper getCellListHelper() {
	    return cellListHelper;
	  }
	 
	 @Override
	  public CellTableHelper getCellTableHelper() {
	    return cellTableHelper;
	  }
	 
	 @Override
	  public NavigationHelper getNavigationHelper() {
	    return navHelper;
	  }
	 
	  @Override
	  public void stop() {
	    if (driver != null) {
	      driver.quit();
	    }
	  }

	  protected WebDriver getWebDriver() {
		    return driver;
		  }

		  protected String getBaseUrl() {
		    return baseUrl;
		  }
		  
		  
}
