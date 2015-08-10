package eglu.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import eglu.pages.InternalPage;
import eglu.pages.CellListPage;
import eglu.pages.CellTablePage;
import eglu.pages.PageManager;
import eglu.pages.AnyPage;

public class InternalPage extends AnyPage {
	
	//....................................................................
	public InternalPage(PageManager pages) {
		super(pages);
	}
	
	public InternalPage ensurePageLoaded() {
	    super.ensurePageLoaded();
	    return this;
	} 
	
	//....................................................................
	@FindBy(xpath = "//div[contains(text(), 'Cell Table')]")
	private WebElement cellTableLink;
	
	@FindBy(xpath = "//div[contains(text(), 'Cell List')]")
	private WebElement cellListLink;
	//....................................................................
	public CellListPage clickCellListLink() {
		cellListLink.click();
	    return pages.cellListPage;
	}
	
	public CellTablePage clickCellTableLink() {
		cellTableLink.click();
	    return pages.cellTablePage;
	}
	
	
}
