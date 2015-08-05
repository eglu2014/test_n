package eglu.pages;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.ScreenshotException;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import eglu.applogic.ApplicationManager;
import eglu.applogicWork.ApplicationManagerWork;
import eglu.util.PropertyLoader;
import eglu.util.Browser;
import eglu.webdriver.WebDriverFactory;

/*
 * Base class for all the test classes
 * 
 * @author Sebastiano Armeli-Battana
 */

public class TestBase {

	  protected ApplicationManager app;

		@BeforeClass
		public void init() {
			app = new ApplicationManagerWork();
		}	

	}