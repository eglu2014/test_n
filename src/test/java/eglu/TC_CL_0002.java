package eglu;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.*;

import eglu.model.CellList;

public class TC_CL_0002 extends eglu.pages.TestBase  {
	
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
	public void OpenPage() throws Exception {
		    app.getNavigationHelper().openPage("/samples/Showcase/Showcase.html#!CwCellList"); 
	}
	
	
	// ---------- TestCase #2 ----------
		// The intent of this test case is to check that the contact information can be updated in the Cell List.
		@Test
		public void TestCase_CL_0002() throws Exception {
			//****************************************************************************
			// Step #1
			// Description: Enter any 'First Name' (FirstName1), 'Last Name' (LastName1), 'Address' (Address1) 
			// and any past date (Date1) in the 'Birthday' field, change the 'Category' to 'Businesses' and click 'Create Contact'
			// Expected Results: Record counter under the Cell List is increased by 1; 'Update Contact' button is enabled.
			//****************************************************************************
				
				newDateUser.clear();
				
				newDateUser.add("Andre");
				newDateUser.add("Pupkin");
				newDateUser.add("Coworkers");
				newDateUser.add("10 St street");
						
				cellList = new CellList()
					.setFirstName(newDateUser.get(0))
					.setLastName(newDateUser.get(1))
					.setCategory(newDateUser.get(2))
					.setAddress(newDateUser.get(3));
				app.getCellListHelper().SetAllFields(cellList);			
				app.getCellListHelper().CheckAddNewRecordCellList(stopTCWnenError, true, "[TC #2] [STEP #1]");			
				Thread.sleep(2000);
				app.getCellListHelper().CheckOnEnabledUpdateContactButton();
				
			//****************************************************************************
			// Step #2
			// Description: Scroll the Cell List down to the end
			// Expected Results: One new record (Rec1) is added with 
			// the First/Last Name and Address corresponding to FirstName1, LastName1 and Address1.
			//****************************************************************************
				app.getCellListHelper().DownCellList();
				app.getCellListHelper().CheckRowInCellList(newDateUser, stopTCWnenError, "[TC #2] [STEP #2]");			
			//****************************************************************************
			// Step #3
			// Description: Access Cell Widgets/Cell Table
			// Expected Results: Cell Table page is loaded
			//****************************************************************************
				app.getNavigationHelper().gotoCellTablePage();
			//****************************************************************************
			// Step #4
			// Description: Click the 'Last' button to load the last page with data
			// Expected Results: The last page is loaded
			//****************************************************************************
				app.getCellTableHelper().ClickLastPageButton();
			//****************************************************************************
			// Step #5
			// Description: View the last record in the list
			// Expected Results: Rec1 is the last record in the list. 
			// Data entered in the 'First Name', 'Last Name', 'Address' and 'Category' fields 
			// correspond to the information entered in the 'Contact Info' section at the moment of creation the Rec1.
			//****************************************************************************
				app.getCellTableHelper().CheckRowInCellTable(newDateUser, stopTCWnenError, "[TC #2] [STEP #5]");
			//****************************************************************************
			// Step #6
			// Description: Switch back to the Cell List page and highlight the Rec1 in the Cell List
			// Expected Results: Rec1 contact is highlighted
			//****************************************************************************
				app.getNavigationHelper().gotoCellListPage();
				app.getCellListHelper().DownCellList();
			//****************************************************************************
			// Step #7
			// Description: Change the FirstName1 to FirstName2, LastName1 to LastName2 and 'Category' to 'Friends'
			// Expected Results:  'First Name' field is changed to FirstName2; 'Last Name' field is changed to LastName2; 'Category' is set to 'Friends'
			//****************************************************************************
				newDateUser.clear();
				newDateUser.add("Volt");
				newDateUser.add("Maskin");
				newDateUser.add("Friends");
				newDateUser.add("10 St street");
				cellList = new CellList()
				.setFirstName(newDateUser.get(0))
				.setLastName(newDateUser.get(1))
				.setCategory(newDateUser.get(2));
				app.getCellListHelper().SetFirstName(cellList);
				app.getCellListHelper().SetLastName(cellList);
				app.getCellListHelper().SetCategoty(cellList);
			//****************************************************************************
			// Step #8
			// Description: Click 'Update Contact'
			// Expected Results: FirstName1 is changed to FirstName2 and LastName1 is changed to LastName2 for the Rec1 in the Cell List.
			//****************************************************************************
				app.getCellListHelper().ClickUpdateContactButton();
				app.getCellListHelper().DownCellList();
				app.getCellListHelper().CheckRowInCellList(newDateUser, stopTCWnenError, "[TC #2] [STEP #8]");
			//****************************************************************************
			// Step #9
			// Description: Access Cell Widgets/Cell Table 
			// Expected Results: Cell Table page is loaded
			//****************************************************************************
				app.getNavigationHelper().gotoCellTablePage();
			//****************************************************************************
			// Step #10
			// Description: Load the last page
			// Expected Results: The last page with contacts is loaded
			//****************************************************************************
				app.getCellTableHelper().ClickLastPageButton();
			//****************************************************************************
			// Step #11
			// Description: View the information for Rec1
			// Expected Results: 'First Name' is populated as FirstName2, 'Last Name' is populated as LastName2, 'Category' is set to 'Friends'
			//****************************************************************************
				app.getCellTableHelper().CheckRowInCellTable(newDateUser, stopTCWnenError, "[TC #2] [STEP #11]");
			//****************************************************************************		
		}
		
		// close:
		@AfterMethod
			void browserClose() throws Exception {
				app.stop();
				Thread.sleep(3000);
			}
}
