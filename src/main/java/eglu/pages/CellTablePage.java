package eglu.pages;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class CellTablePage  extends InternalPage {
	//...................................................
	public CellTablePage(PageManager pages) {
		super(pages);
	}
	//...................................................
	public CellTablePage ensurePageLoaded() {
	    super.ensurePageLoaded();
	    wait.until(presenceOfElementLocated(By.cssSelector("tr > td > div.gwt-HTML")));
	    return this;
	  }
	//...................................................
	@FindBy(css="tr > td.GNHGC04CLH > img[aria-label='Last page']")
	private WebElement lastPageButton;
	
	@FindBy(css="tr > td.GNHGC04CLH > img[aria-label='Next page']")
	private WebElement nextPageButton;
	
	@FindBy(css="tr > td.GNHGC04CLH > img[aria-label='Previous page']")
	private WebElement previousPageButton;
	
	@FindBy(css="tr > td.GNHGC04CLH > img[aria-label='First page']")
	private WebElement firstPageButton;
	
	@FindBy(css="tr > td > div.gwt-HTML")
	private WebElement _countCellTable;
	//...................................................
	public List<String> getDataByIndexTableList(Integer _index) {
		
		List<String> result = new ArrayList<String>();
		
		String xpathClick = "//tr[@__gwt_row=" + Integer.toString(_index) + "]";
		
		String xpathFirstName = "//tr[@__gwt_row=" + Integer.toString(_index) + "]/td[2]/div";
		String xpathLastName = "//tr[@__gwt_row=" + Integer.toString(_index) + "]/td[3]/div";
		String xpathCategory = "//tr[@__gwt_row=" + Integer.toString(_index) + "]/td[4]/div/select/option[@selected='selected']";
		String xpathAddress = "//tr[@__gwt_row=" + Integer.toString(_index) + "]/td[5]/div";
				
		driver.findElement(By.xpath(xpathClick)).click();
		
		result.add(0, driver.findElement(By.xpath(xpathFirstName)).getText());
		result.add(1, driver.findElement(By.xpath(xpathLastName)).getText());
		result.add(2, driver.findElement(By.xpath(xpathCategory)).getText());
		result.add(3, driver.findElement(By.xpath(xpathAddress)).getText());
		
		return result;
	}	
	
	public String getCountCellTable() {
	    return _countCellTable.getText();
	}
	
	//..................................................
	// Page Buttons:
	//..................................................
	
	public void clickLastPageButton() {
		lastPageButton.click();
	}
	
	public void clickFirstPageButton() {
		firstPageButton.click();
	}
	
	public void clickNextPageButton() {
		nextPageButton.click();
	}
	
	public void clickPreviousPageButton() {
		previousPageButton.click();
	}
	
	public boolean getEnabledFirstPageButton() {
		return firstPageButton.isEnabled();
	}
	
	public boolean getEnabledPreviousPageButton() {
		return previousPageButton.isEnabled();
	}
	
	public boolean getEnabledNextPageButton() {
		return nextPageButton.isEnabled();
	}
	
	public boolean getEnabledLastPageButton() {
		return lastPageButton.isEnabled();
	}
	
}
