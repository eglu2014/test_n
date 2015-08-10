package eglu;

import java.util.ArrayList;
import java.util.List;

import org.testng.*;
import org.testng.annotations.*;

import eglu.model.CellList;

public class TC_CL_0003  extends eglu.pages.TestBase {
	
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
		
	// ---------- TestCase #3 ----------
		// The intent of this test case is to check that duplicates are not allowed in the Cell List..
		//@Test
		public void TestCase_CL_0003() throws Exception {
			//****************************************************************************
			// step #1
			// Description: Enter any 'First Name' (FirstName1), 'Last Name' (LastName1), 
			// 'Address' (Address1) and any past date (Date1) in the 'Birthday' field, 
			// change the 'Category' to 'Businesses' and click 'Create Contact'
			// Expected Results: Record counter under the Cell List is increased by 1;
			//****************************************************************************
			app.getNavigationHelper().gotoCellListPage();
			Thread.sleep(1000);
			
			newDateUser.clear();
			
			newDateUser.add("Vova");
			newDateUser.add("Vasechkin");
			newDateUser.add("Businesses");
			newDateUser.add("100 street Pushkina");
					
			cellList = new CellList()
				.setFirstName(newDateUser.get(0))
				.setLastName(newDateUser.get(1))
				.setCategory(newDateUser.get(2))
				.setAddress(newDateUser.get(3));
			app.getCellListHelper().SetAllFields(cellList);
			
			app.getCellListHelper().CheckAddNewRecordCellList(stopTCWnenError, true, "[TC #3] [STEP #1]");		
			//****************************************************************************
			// step #2
			// Description: Scroll the Cell List down to the end
			// Expected Results: One new record (Rec1) is added with the First/Last Name and Address corresponding to FirstName1, LastName1 and Address1.
			//****************************************************************************
			app.getCellListHelper().DownCellList();
			app.getCellListHelper().CheckRowInCellList(newDateUser, stopTCWnenError, "[TC #3] [STEP #2]");
			//****************************************************************************
			// step #3
			// Description: Click 'Create Contact' button one more time without clearing or changing any information in the 'Contact Info' section
			// Expected Results: System prevents the user from creating duplicated records: total number of records are not increased.
			app.getCellListHelper().CheckAddNewRecordCellList(stopTCWnenError, false, "[TC #3] [STEP #3]");
			//****************************************************************************
			// step #4
			// Description: Change 'Last Name' from LastName1 to LastName2 and click 'Create Contact'
			// Expected Results: 'Last Name' is changed from LastName1 to lastName2, 
			// new contact is added to the Cell List (total number of records is increased by 1;)
			//****************************************************************************
			newDateUser.remove(1);
			newDateUser.add(1, "Zaycev");
			
			cellList = new CellList()
			.setFirstName(newDateUser.get(0))
			.setLastName(newDateUser.get(1))
			.setCategory(newDateUser.get(2))
			.setAddress(newDateUser.get(3));
			app.getCellListHelper().SetLastName(cellList);
			
			app.getCellListHelper().CheckAddNewRecordCellList(stopTCWnenError, true, "[TC #3] [STEP #4]");	
			//****************************************************************************			
		}	
		// close:
		@AfterMethod
			void browserClose() throws Exception {
				app.stop();
				Thread.sleep(3000);
		}
}
