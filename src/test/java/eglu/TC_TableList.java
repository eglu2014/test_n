package eglu;

import java.util.ArrayList;
import java.util.List;

import org.testng.*;
import org.testng.annotations.*;

import eglu.model.CellList;


public class TC_TableList extends eglu.pages.TestBase {
	
	//*****************************************************************************
	// Variables:
	String actRes, expRes; 
	boolean getResult;
	int index, getValue1, getValue2;
	boolean stopTCWnenError = false;
	List<String> newDateUser = new ArrayList<String>();
	CellList cellList = new CellList();	
	//*****************************************************************************
	@BeforeMethod
	public void OpenPage() {
		
		app.getNavigationHelper().openPage("/samples/Showcase/Showcase.html#!CwCellList"); 
	 }
	//*****************************************************************************
	// ---------- TestCase: TL_0001 ----------
	// The intent of this test case is to check the addition of a new record to the Cell Table..
	@Test
	public void TestCase_CL_0001() throws Exception {
		
		//*****************************************************************************	
		// step #1
		// Description: Access Cell Widgets/Cell List
		// Expected Results: Cell List page is loaded
		//*****************************************************************************
		
		app.getNavigationHelper().gotoCellListPage();
		//*****************************************************************************
		// step #2
		// Description: Enter any 'First Name' (FirstName1), 'Last Name' (LastName1), 
		// 'Address' (Address1) and any past date (Date1) in the 'Birthday' field, change the 'Category' to 'Businesses'. 
		// Click 'Create Contact'
		// Expected Results: Record counter under the Cell List reads is increased by 1
		//*****************************************************************************
		newDateUser.add("Natasha");
		newDateUser.add("Zhold");
		newDateUser.add("Businesses");
		newDateUser.add("10, Marksa St. Simferopol");
		cellList = new CellList()
			.setFirstName(newDateUser.get(0))
			.setLastName(newDateUser.get(1))
			.setCategory(newDateUser.get(2))
			.setAddress(newDateUser.get(3));
		app.getCellListHelper().SetAllFields(cellList);
		app.getCellListHelper().CheckAddNewRecordCellList(stopTCWnenError, true, "[TestCase_CL_0001] [STEP #2]");
		//*****************************************************************************
		// step #3
		// Description: Access Cell Widgets/Cell Table
		// Expected Results: Cell Table page is loaded
		//*****************************************************************************
		app.getNavigationHelper().gotoCellTablePage();
		//*****************************************************************************
		// step #4
		// Description: Click the 'Last' button to load the last page with data
		// Expected Results: The last page is loaded
		//*****************************************************************************
		app.getCellTableHelper().ClickLastPageButton();
		//*****************************************************************************
		// step #5
		// Description: View the last record in the list
		// Expected Results: Rec1 is the last record in the list. 
		// Data entered in the 'First Name', 'Last Name', 'Address' and 'Category' fields 
		// correspond to the information entered in the 'Contact Info' section at the moment of creation 
		// the Rec1: FirstName1, LastName1, Address1, Businesses.
		//*****************************************************************************
		app.getCellTableHelper().CheckRowInCellTable(newDateUser, stopTCWnenError, "[TestCase_CL_0001] [STEP #5]");	
		app.getCellTableHelper().ClickFirstPageButton();
		app.getNavigationHelper().gotoCellListPage();
		Thread.sleep(3000);
		//*****************************************************************************		
	}
	//*****************************************************************************
	
	@Test
	public void TestCase_CL_0002() throws Exception {
		//*****************************************************************************
		// step #1
		// Description: View the record counter at the bottom of the page
		// Expected Results: The information about number of records loaded is present as well as total number of records: '1-15 of 250'
		//*****************************************************************************
		app.getNavigationHelper().gotoCellTablePage();
		
		expRes = "1-15 of 251";
		actRes = app.getCellTableHelper().GetCountCellTable();
		getResult = app.getNavigationHelper().ComparisonTwoValues(actRes, expRes);
		if (stopTCWnenError)
			Assert.assertTrue(getResult, "[TestCase_CL_0002] [STEP #1]: Wrong inform. about number of records. ActRes: " + actRes + " ExpRes: " + expRes);			
		else
			if (!getResult)
				System.out.println("[TestCase_CL_0002] [STEP #1]: Warring!!! Wrong inform. about number of records. ActRes: " + actRes + " ExpRes: " + expRes);
		//*****************************************************************************
		// step #2
		// Description: Check the availability of buttons 'First', 'Previous', 'Next' and 'Last'
		// Expected Results: Buttons 'First' and 'Previous' are disabled; Buttons 'Next'  and 'Last' are enabled.
		app.getCellTableHelper().GetEnabledPageButtons("First", false, false, "[TestCase_CL_0002] [STEP #2]:");
		app.getCellTableHelper().GetEnabledPageButtons("Previous", false, false, "[TestCase_CL_0002] [STEP #2]:");		
		app.getCellTableHelper().GetEnabledPageButtons("Next", true, false, "[TestCase_CL_0002] [STEP #2]:");
		app.getCellTableHelper().GetEnabledPageButtons("Last", true, false, "[TestCase_CL_0002] [STEP #2]:");
		app.getCellTableHelper().ClickFirstPageButton();
		//*****************************************************************************
		// step #3
		// Description: Click 'Next' button
		// Expected Results: Next 15 records are loaded (record counter now reads '16-30 of 250');
		// Buttons 'First' and 'Previous' become enabled; Buttons 'Next' and 'Last' are still enabled.
		//*****************************************************************************
		app.getCellTableHelper().ClickNextPageButton();
		app.getCellTableHelper().CheckRecordCounterCellTable(16, 30, false, "[TestCase_CL_0002] [STEP #3]"); 
		app.getCellTableHelper().GetEnabledPageButtons("First", true, false, "[TestCase_CL_0002] [STEP #3]:");
		app.getCellTableHelper().ClickNextPageButton();
		app.getCellTableHelper().GetEnabledPageButtons("Previous", true, false, "[TestCase_CL_0002] [STEP #3]:");		
		app.getCellTableHelper().ClickNextPageButton();
		//*****************************************************************************
		// step #4
		// Description: Click 'Last' button
		// Expected Results: The system loads the last page with records: records from 241 to 250;
		// Buttons 'First' and 'Previous' are still enabled; Buttons 'Next' and 'Last' become disabled.
		//*****************************************************************************
		app.getCellTableHelper().ClickLastPageButton();
		app.getCellTableHelper().CheckRecordCounterCellTable(241, 251, false, "[TestCase_CL_0002] [STEP #4]");
		app.getCellTableHelper().GetEnabledPageButtons("Next", false, false, "[TestCase_CL_0002] [STEP #4]:");
		app.getCellTableHelper().GetEnabledPageButtons("Last", false, false, "[TestCase_CL_0002] [STEP #4]:");		
		app.getCellTableHelper().GetEnabledPageButtons("Previous", true, false, "[TestCase_CL_0002] [STEP #4]:");
		app.getCellTableHelper().GetEnabledPageButtons("First", true, false, "[TestCase_CL_0002] [STEP #4]:");
		app.getCellTableHelper().ClickLastPageButton();
		//*****************************************************************************
		// step #5
		// Description: Click 'Previous' button
		// Expected Results: The system loads the page previous to the last one: '226-240 of 250 '. 
		// Buttons 'First' and 'Previous' are still enabled; Buttons 'Next' and 'Last' become enabled.
		//*****************************************************************************
		app.getCellTableHelper().ClickPreviousPageButton();
		app.getCellTableHelper().CheckRecordCounterCellTable(226, 240, false, "[TestCase_CL_0002] [STEP #5]");
		app.getCellTableHelper().GetEnabledPageButtons("Next", true, false, "[TestCase_CL_0002] [STEP #5]:");
		app.getCellTableHelper().ClickPreviousPageButton();
		app.getCellTableHelper().GetEnabledPageButtons("Last", true, false, "[TestCase_CL_0002] [STEP #5]:");
		app.getCellTableHelper().ClickPreviousPageButton();
		app.getCellTableHelper().GetEnabledPageButtons("First", true, false, "[TestCase_CL_0002] [STEP #5]:");
		//*****************************************************************************
		// step #6
		// Description: Click 'First' button
		// Expected Results: The system loads the first page of records: records from 1 to 15.
		//*****************************************************************************
		app.getCellTableHelper().CheckRecordCounterCellTable(1, 15, false, "[TestCase_CL_0002] [STEP #6]");
		//*****************************************************************************
		// step #7
		// Description: Consequently click 'Next' button for 15 times
		// Expected Results: Each loaded page contains 15 records.
		//*****************************************************************************
		app.getCellTableHelper().ClickNextPageButton();
		app.getCellTableHelper().CheckRecordCounterCellTable(16, 30, false, "[TestCase_CL_0002] [STEP #7]");
		app.getCellTableHelper().ClickNextPageButton();
		app.getCellTableHelper().CheckRecordCounterCellTable(31, 45, false, "[TestCase_CL_0002] [STEP #7]");
		app.getCellTableHelper().ClickNextPageButton();
		app.getCellTableHelper().CheckRecordCounterCellTable(46, 60, false, "[TestCase_CL_0002] [STEP #7]");
		app.getCellTableHelper().ClickNextPageButton();
		app.getCellTableHelper().CheckRecordCounterCellTable(61, 75, false, "[TestCase_CL_0002] [STEP #7]");
		app.getCellTableHelper().ClickNextPageButton();
		app.getCellTableHelper().CheckRecordCounterCellTable(76, 90, false, "[TestCase_CL_0002] [STEP #7]");
		app.getCellTableHelper().ClickNextPageButton();
		app.getCellTableHelper().CheckRecordCounterCellTable(91, 105, false, "[TestCase_CL_0002] [STEP #7]");
		app.getCellTableHelper().ClickNextPageButton();
		app.getCellTableHelper().CheckRecordCounterCellTable(106, 120, false, "[TestCase_CL_0002] [STEP #7]");
		app.getCellTableHelper().ClickNextPageButton();
		app.getCellTableHelper().CheckRecordCounterCellTable(121, 135, false, "[TestCase_CL_0002] [STEP #7]");
		app.getCellTableHelper().ClickNextPageButton();
		app.getCellTableHelper().CheckRecordCounterCellTable(136, 150, false, "[TestCase_CL_0002] [STEP #7]");
		app.getCellTableHelper().ClickNextPageButton();
		app.getCellTableHelper().CheckRecordCounterCellTable(151, 165, false, "[TestCase_CL_0002] [STEP #7]");
		app.getCellTableHelper().ClickNextPageButton();
		app.getCellTableHelper().CheckRecordCounterCellTable(166, 180, false, "[TestCase_CL_0002] [STEP #7]");
		app.getCellTableHelper().ClickNextPageButton();
		app.getCellTableHelper().CheckRecordCounterCellTable(181, 195, false, "[TestCase_CL_0002] [STEP #7]");
		app.getCellTableHelper().ClickNextPageButton();
		app.getCellTableHelper().CheckRecordCounterCellTable(196, 210, false, "[TestCase_CL_0002] [STEP #7]");
		app.getCellTableHelper().ClickNextPageButton();
		app.getCellTableHelper().CheckRecordCounterCellTable(211, 225, false, "[TestCase_CL_0002] [STEP #7]");
		app.getCellTableHelper().ClickNextPageButton();
		app.getCellTableHelper().CheckRecordCounterCellTable(226, 240, false, "[TestCase_CL_0002] [STEP #7]");
		//*****************************************************************************
		// step #8
		// Description: Click 'Next' button one more time
		// Expected Results: The last loaded page contains 10 records (from 241 to 250).
		app.getCellTableHelper().ClickNextPageButton();
		app.getCellTableHelper().CheckRecordCounterCellTable(241, 251, false, "[TestCase_CL_0002] [STEP #8]");
		//*****************************************************************************	
		app.stop();
		
	}
	
}
