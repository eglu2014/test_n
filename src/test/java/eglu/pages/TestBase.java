package eglu.pages;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import eglu.applogic.ApplicationManager;
import eglu.applogicWork.ApplicationManagerWork;

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

	@AfterSuite
	public void stop() {
		app.stop();
	}

}