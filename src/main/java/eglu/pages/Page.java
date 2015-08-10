package eglu.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.TimeoutException;

import eglu.pages.PageManager;

public abstract class Page {

	protected WebDriver driver;
	protected PageManager pages;
	protected WebDriverWait wait;

	/*
	 * Constructor injecting the WebDriver interface
	 * 
	 * @param webDriver
	 */
	public Page(PageManager pages) {
		this.pages = pages;
	    driver = pages.getWebDriver();
	    wait= new WebDriverWait(driver, 10);
	}

	public WebDriver getWebDriver() {
		return driver;
	}
	
	public Page ensurePageLoaded() {
		  return this;
	}

	public String getTitle() {
		return driver.getTitle();
	}
	
	public boolean waitPageLoaded() {
	    try {
	      ensurePageLoaded();
	      return true;
	    } catch (TimeoutException to) {
	      return false;
	    }
	}

}
