package eglu.pages;

import org.openqa.selenium.WebDriver;

import eglu.pages.PageManager;

public abstract class Page {

	protected WebDriver driver;
	protected PageManager pages;

	/*
	 * Constructor injecting the WebDriver interface
	 * 
	 * @param webDriver
	 */
	public Page(PageManager pages) {
		this.pages = pages;
	    driver = pages.getWebDriver();
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

}
