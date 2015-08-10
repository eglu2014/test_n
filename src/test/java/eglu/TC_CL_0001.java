package eglu;

import java.util.ArrayList;
import java.util.List;

import org.testng.*;
import org.testng.annotations.*;

import eglu.model.CellList;

public class TC_CL_0001 extends eglu.pages.TestBase {
	
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
	   
	// ---------- TestCase: CL_0001 ----------
	// The intent of this test case is to check the ability to add a contact information to the Cell List.
	@Test
	public void TestCase_CL_0001() throws Exception {				
		//*****************************************************************************	
		// step #1
		// Description: In the 'Contact Info' section check the availability of the buttons 'Update Contact', 
		// 'Create Contact' and 'Generate 50 Contacts'
		// Expected Results: Button 'Update Contact' is disabled; Buttons 'Create Contact' and 'Generate 50 Contacts' are enabled
		//*****************************************************************************
		app.getCellListHelper().CheckOnEnabledButtons();
		//*****************************************************************************	
		// step #2
		// Description:
		// Click 'Create Contact' button without filling in any field in the 'Contact Info' section
		// Expected Results
		// Total of 250 contacts are present in the Cell List. Not any new contact is added to the list.
		//*****************************************************************************
		expRes = "0 - 30 : 250";
		actRes = app.getCellListHelper().GetCountCellList();
		getResult = app.getNavigationHelper().ÑomparisonTwoValues(actRes, expRes);
				
		if (stopTCWnenError)
			Assert.assertTrue(getResult, "[TC #1] [STEP #2]: Wrong value is present the Cell List. ActRes: " + actRes + " ExpRes: " + expRes);			
		else
			if (!getResult)
				System.out.println("[TC #1] [STEP #2]: Warring!!! Wrong value is present the Cell List. ActRes: " + actRes + " ExpRes: " + expRes);
				
		app.getCellListHelper().CheckAddNewRecordCellList(stopTCWnenError, false, "[TC #1] [STEP #2]");
		
		//*****************************************************************************
		// step #3
		// Description:
		// Select any past date in the 'Birthday' field and 
		// click 'Create Contact' button without entering any data in 'First Name', 'Last Name' and 'Address' fields
		// Expected Results
		// The system prevents the user from creating a new contact with empty 'First Name', 'Last Name' and 'Address'.
		//*****************************************************************************
		expRes = "May 13, 2015";
		actRes = app.getCellListHelper().GetDateInCalendar("May 2015", "Previous");
		getResult = app.getNavigationHelper().ÑomparisonTwoValues(actRes, expRes);
		if (stopTCWnenError)
			Assert.assertTrue(getResult, "[TC #1] [STEP #3]: Wrong value is set in the Birthday. ActRes: " + actRes + " ExpRes: " + expRes);			
		else
			if (!getResult)
				System.out.println("[TC #1] [STEP #3]: Warring!!! Wrong value is set in the Birthday. ActRes: " + actRes + " ExpRes: " + expRes);		
		
		app.getCellListHelper().CheckAddNewRecordCellList(stopTCWnenError, false, "[TC #1] [STEP #3]");
		
		//*****************************************************************************
		// step #4
		// Description:
		// Open the calendar lookup in the 'Birthday' field and select any future date (e.g. August 26, 2016)
		// Expected Results
		// The system prevents the user from selecting the future date.
		//*****************************************************************************
		expRes = "";
		actRes = app.getCellListHelper().GetDateInCalendar("Jan 2016", "Next");
		getResult = app.getNavigationHelper().ÑomparisonTwoValues(actRes, expRes);
		if (stopTCWnenError)
			Assert.assertTrue(getResult, "[TC #1] [STEP #4]: Wrong value is set in the Birthday. ActRes: " + actRes + " ExpRes: " + expRes);			
		else
			if (!getResult)
				System.out.println("[TC #1] [STEP #4]: Warring: Wrong value is set in the Birthday. ActRes: " + actRes + " ExpRes: " + expRes);		
		//*****************************************************************************
		// Step #5
		// Description:
		// Enter any future date manually in the 'Birthday' field, move the focus from the field
		// Expected Results
		// Future date is considered invalid for the 'Birthday' field and is not accepted: field is highlighted in red.
		//*****************************************************************************
		cellList = new CellList().setBirthday("May 13, 2020");
		expRes = "rgba(255, 204, 204, 1)";
		actRes = app.getCellListHelper().GetColorForBirthDay(cellList);
		getResult = app.getNavigationHelper().ÑomparisonTwoValues(actRes, expRes);
		if (stopTCWnenError)
			Assert.assertTrue(getResult, "[TC #1] [STEP #5]: Wrong color in the Birthday field. ActRes: " + actRes + " ExpRes: " + expRes);			
		else
			if (!getResult)
				System.out.println("[TC #1] [STEP #5]: Warring: Wrong color in the Birthday field. ActRes: " + actRes + " ExpRes: " + expRes);
		//*****************************************************************************
		// Step # 6 
		// Description:
		// Enter any information in the 'Birthday' field which is not in the expected date format of 
		// '<Month><Day>, <Year>' (e.g., 'Test1') and move the focus from the field
		// Expected Results: Incorrect format of date is not accepted: field is highlighted in red.
		//*****************************************************************************
		cellList = new CellList().setBirthday("Test");
		expRes = "rgba(255, 204, 204, 1)";
		actRes = app.getCellListHelper().GetColorForBirthDay(cellList);
		getResult = app.getNavigationHelper().ÑomparisonTwoValues(actRes, expRes);
		if (stopTCWnenError)
			Assert.assertTrue(getResult, "[TC #1] [STEP #6]: Wrong color in the Birthday field. ActRes: " + actRes + " ExpRes: " + expRes);			
		else
			if (!getResult)
				System.out.println("[TC #1] [STEP #6]: Warring: Wrong color in the Birthday field. ActRes: " + actRes + " ExpRes: " + expRes);
		//*****************************************************************************
		// step # 7
		// Description:
		// Enter any 'First Name' (FirstName1), 'Last Name' (LastName1), 'Address' (Address1)
		// any past date (D;8ate1) in the 'Birthday' field, change the 'Category' to 'Businesses' and click 'Create Contact'
		// Expected Results: Record counter under the Cell List is increased by 1
		//*****************************************************************************
		newDateUser.add("First 1");
		newDateUser.add("Last 1");
		newDateUser.add("Businesses");
		newDateUser.add("Address 1");
				
		cellList = new CellList()
			.setFirstName(newDateUser.get(0))
			.setLastName(newDateUser.get(1))
			.setCategory(newDateUser.get(2))
			.setAddress(newDateUser.get(3));
		app.getCellListHelper().SetAllFields(cellList);
		
		app.getCellListHelper().CheckAddNewRecordCellList(stopTCWnenError, true, "[TC #1] [STEP #7]");
		//*****************************************************************************
		// step #8
		// Description:
		// Scroll the Cell List down to the end
		// Expected Results:
		// One new record (Rec1) is added with the First/Last Name and Address corresponding to FirstName1, LastName1 and Address1.
		//*****************************************************************************
		app.getCellListHelper().DownCellList();
		app.getCellListHelper().CheckRowInCellList(newDateUser, stopTCWnenError, "[TC #1] [STEP #8]");			
		//*****************************************************************************				
	 }
	
		// close:
		@AfterMethod
			void browserClose() throws Exception {
				app.stop();
				Thread.sleep(3000);
			}
	
}
