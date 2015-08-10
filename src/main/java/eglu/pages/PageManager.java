package eglu.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import eglu.pages.InternalPage;


public class PageManager {

	private WebDriver driver;
	public InternalPage internalPage;
	
	public CellListPage cellListPage;
	public CellTablePage cellTablePage;
	
	public PageManager(WebDriver driver) {
	    this.driver = driver;
	    internalPage = initElements(new InternalPage(this));
	    cellListPage = initElements(new CellListPage(this));
	    cellTablePage = initElements(new CellTablePage(this));
	}	
	
	
	private <T extends Page> T initElements(T page) {
	    PageFactory.initElements(new DisplayedElementLocatorFactory(driver, 15), page);
	    return page;
	  }
	
	
	public WebDriver getWebDriver() {
	    return driver;
	}
	
}
