package eglu.pages;

import eglu.pages.PageManager;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class CellListPage extends InternalPage {
	
	public CellListPage(PageManager pages) {
		super(pages);
	}	
	
	//.................................................................
	public CellListPage ensurePageLoaded() {
	    super.ensurePageLoaded();	   
	    return this;
	  }
		
	// For Update Contact, Create Contact, Generate50Contacts buttons: 
	@FindBy(css=".gwt-Button")
	private List<WebElement> AllButtons;
		
	// For Address:
	@FindBy(css="td > textarea.gwt-TextArea")
	private WebElement addressField;
	
	// For FirstName, LastName:
	@FindBy(css="tr > td > input.gwt-TextBox")
	private List<WebElement> AllFields;
	
	// Under CellList - counter:
	@FindBy(css="tr > td > div.gwt-HTML")
	WebElement countCellList;
	
	// for BirthDay:
	@FindBy(css="td > .gwt-DateBox")
	WebElement birthdayField;
	
	// for Calendar:
	@FindBy(css="td > div[class^='datePickerPreviousButton']")
	WebElement calendarPreviousButton;
	
	@FindBy(css="td > div[class^='datePickerNextButton']")
	WebElement calendarNextButton;
	
	@FindBy(css="td.datePickerMonth")
	WebElement calendarGetMonth;
	
	@FindBy(css="tr > td > div[class='GNHGC04CJJ']")
	WebElement cellListTotal;
	
	//.................................................................
	// work with Cell List element:
	//.................................................................
	public List<String> getDataByIndexCellList(Integer _index) {
		
		List<String> result = new ArrayList<String>();
			
		String xpathFirstName = "//div/div[@__idx=" + Integer.toString(_index) + "]/table//tr[1]/td[2]";
		String xpathAddress = "//div/div[@__idx=" + Integer.toString(_index) + "]/table//tr[2]";
				
		driver.findElement(By.xpath(xpathAddress)).click();
		
		result.add(0, driver.findElement(By.xpath(xpathFirstName)).getText());
		result.add(1, driver.findElement(By.xpath(xpathAddress)).getText());
		
		return result;
	}	
	public void downcellListTotal() {
		cellListTotal.sendKeys(Keys.END);		
	
	}
	
	public void upCellListTotal() {
		cellListTotal.sendKeys(Keys.HOME);		
	
	}
	
	public String getCountCellList() { // for counterCellList:
		return countCellList.getText();
	}
	
	//.................................................................
	// work with Birthday / Calendar:
	//.................................................................
	public void clearBirthdayField() {
		birthdayField.sendKeys(Keys.CONTROL + "a");
		birthdayField.sendKeys(Keys.DELETE);
	}	
	public void clickBirthdayField() {
		birthdayField.click();
	}	
	public void clickPreviousButtonInCalendar() {
		calendarPreviousButton.click();
	}	
	public void clickNextButtonInCalendar() {
		calendarNextButton.click();
	}	
	public String getMonthInCalendar() {
	    return calendarGetMonth.getText();
	}	
	public void clickCell33() {
		driver.findElement(By.cssSelector("table.datePickerDays"))
			.findElements(By.tagName("tr")).get(3)
			.findElements(By.cssSelector("td > div[class^='datePickerDay'")).get(3).click();		
	}	
	public String getBirthdayField() {
	    return birthdayField.getAttribute("value");
	}
	public String getColorBirthdayField() {
	    return birthdayField.getCssValue("background-color");
	}
	public CellListPage setBirthdayField(String text) {
		birthdayField.sendKeys(text);
		return this;
	}
	
	//.................................................................
	// ___ Work with Category:
	//.................................................................
	private Select CategoryDropdown() {
	    return new Select(driver.findElement(By.cssSelector("td.GNHGC04CFK ~ td > select.gwt-ListBox")));
	}
	public CellListPage setCategory(String text) {
		CategoryDropdown().selectByValue(text);
		return this;
	}
	
	//.................................................................
	// Work with button:
	//.................................................................
	public boolean checkOnEnabledButtons(String nameButton) {
		if (nameButton.equals("UpdateContact"))
			return AllButtons.get(0).isEnabled();
		else if (nameButton.equals("CreateContact"))
			return AllButtons.get(1).isEnabled();
		else if (nameButton.equals("Generate50Contacts"))
			return AllButtons.get(2).isEnabled();
		else
			return false;
	}	
	public void clickUpdateContactButton() {
		AllButtons.get(0).click();
	}	
	public void clickCreateContactButton() {
		AllButtons.get(1).click();
	}	
	public void clickGenerate50ContactsButton() {
		AllButtons.get(2).click();
	}			
	
	//.................................................................
	// for Address field:
	//.................................................................
	public String getAddressField() {
	    return addressField.getAttribute("value");
	}
	public CellListPage setAddressField(String text) {
		addressField.sendKeys(Keys.CONTROL + "a");
		addressField.sendKeys(Keys.DELETE);
		addressField.sendKeys(text);
	    return this;
	}
	public void clickAddressField() {
		addressField.click();
	}
	
	//.................................................................
	// for FirstName field:
	//.................................................................
	public String getFirstNameField() {
		return AllFields.get(0).getAttribute("value");
	}
	public CellListPage setFirstNameField(String text) {
		AllFields.get(0).sendKeys(Keys.CONTROL + "a");
		AllFields.get(0).sendKeys(Keys.DELETE);
		AllFields.get(0).sendKeys(text);
		return this;
	}
	
	//.................................................................
	// for LastName field:
	//.................................................................
	public String getLastNameField() {
		return AllFields.get(1).getAttribute("value");
	}
	public CellListPage setLastNameField(String text) {
		AllFields.get(1).sendKeys(Keys.CONTROL + "a");
		AllFields.get(1).sendKeys(Keys.DELETE);
		AllFields.get(1).sendKeys(text);
		return this;
	}
	//.................................................................
	

		
	

}
