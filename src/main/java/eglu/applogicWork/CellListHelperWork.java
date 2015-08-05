package eglu.applogicWork;

import java.util.ArrayList;
import java.util.List;

import eglu.applogicWork.DriverBasedHelper;
import eglu.applogic.CellListHelper;
import eglu.model.CellList;

import org.testng.Assert;

public class CellListHelperWork extends DriverBasedHelper implements CellListHelper {
	
	//................................................................
	public CellListHelperWork(ApplicationManagerWork manager) {
	    super(manager.getWebDriver());
	}
	//................................................................
	@Override
	public int GetFirstNumber(String counterCellList) {
				
		return Integer.parseInt(counterCellList.substring(counterCellList.indexOf('-') + 2, counterCellList.lastIndexOf(':') - 1));
	}
	
	@Override
	public int GetSecondNumber(String counterCellList) {
		
		return Integer.parseInt(counterCellList.substring(counterCellList.lastIndexOf(':') + 2));
	}
	
	//................................................................
	// for working with Cell List element:
	//................................................................
	@Override
	public List<String> GetDataByIndexCellList(int _index) {
		
		List<String> _return = new ArrayList<String>();
		_return.add(pages.cellListPage.ensurePageLoaded().getDataByIndexCellList(_index).get(0));
		_return.add(pages.cellListPage.ensurePageLoaded().getDataByIndexCellList(_index).get(1));
		
		return _return;
	}
	
	@Override
	public void DownCellList() {
		
		int numb1, numb2;
		
		numb1 = GetFirstNumber(pages.cellListPage.getCountCellList());
		numb2 = GetSecondNumber(pages.cellListPage.getCountCellList());
		
		while(numb1 != numb2) {
			pages.cellListPage.ensurePageLoaded().downcellListTotal();
			numb1 = GetFirstNumber(pages.cellListPage.getCountCellList());
			
			if (numb1 == numb2) {
				break;
			}		
		}
		
		pages.cellListPage.ensurePageLoaded().upCellListTotal();
		pages.cellListPage.ensurePageLoaded().downcellListTotal();
				
	}
	
	@Override
	public void CheckRowInCellList(List<String> expRes, boolean stopTCWnenError, String infoForMessage) {
		
		int index;
		boolean getResult;
		String act, exp;
		
		index = GetSecondNumber(GetCountCellList()) - 1;
		
		exp = expRes.get(0) + " " + expRes.get(1);
		act = GetDataByIndexCellList(index).get(0);
		getResult = ÑomparisonTwoValues(act, exp);
		if (stopTCWnenError)
			Assert.assertTrue(getResult, "Record is not corresponding First/LastName; ActRes: " + act + " ExpRes: " + exp);			
		else
			if (!getResult)
				System.out.println("Warring: Record is not corresponding First/LastName; ActRes: " + act + " ExpRes: " + exp);
		
		exp = expRes.get(3);
		act = GetDataByIndexCellList(index).get(1);
		getResult = ÑomparisonTwoValues(act, exp);
		if (stopTCWnenError)
			Assert.assertTrue(getResult, "Record is not corresponding Address; ActRes: " + act + " ExpRes: " + exp);			
		else
			if (!getResult)
				System.out.println("Warring: Record is not corresponding Address; ActRes: " + act + " ExpRes: " + exp);		
	}
	
	@Override
	public void CheckAddNewRecordCellList(boolean stopTCWnenError, boolean recordShouldBeAdded, String infoForMessage) {
		
		int getValue1, getValue2;
		boolean getResult = false;
		
		getValue1 = GetSecondNumber(GetCountCellList());
		ClickCreateContactButton();			
		getValue2 = GetSecondNumber(GetCountCellList());
		
		if (recordShouldBeAdded) {
			if ((getValue2 - getValue1) == 1)
				getResult = true;
					
			if (stopTCWnenError)
				Assert.assertTrue(getResult, infoForMessage + " Record is NOT added in Cell list. ActRes: " + getValue1 + " ExpRes: " + getValue2);			
			else
				if (!getResult)
					System.out.println(infoForMessage + " Warring!!! Record is NOT added in Cell list. ActRes: " + getValue1 + " ExpRes: " + getValue2);
		}
		else {
			
			if ((getValue2 - getValue1) == 0)
				getResult = true;
			
			if (stopTCWnenError)
				Assert.assertTrue(getResult, infoForMessage + " Record is added in Cell list. ActRes: " + getValue2 + " ExpRes: " + getValue1);			
			else
				if (!getResult)
					System.out.println(infoForMessage + " Warring!!! Record is added in Cell list. ActRes: " + getValue2 + " ExpRes: " + getValue1);
			
		}
		
		
	}
	
	@Override
	public String GetCountCellList() {
		return pages.cellListPage.ensurePageLoaded().getCountCellList();
	}
	//................................................................
	@Override
	public void SetFirstName (CellList cellList) {
		pages.cellListPage.ensurePageLoaded().setFirstNameField(cellList.getFirstName());
	}
	
	@Override
	public void SetLastName (CellList cellList) {
		pages.cellListPage.ensurePageLoaded().setLastNameField(cellList.getLastName());
	}
	
	@Override
	public void SetCategoty(CellList cellList) {
		pages.cellListPage.ensurePageLoaded().setCategory(cellList.getCategory());
	}
	
	@Override
	public void SetAddress(CellList cellList) {
		pages.cellListPage.ensurePageLoaded().setAddressField(cellList.getAddress());
	}
	
	@Override
	public void SetAllFields(CellList cellList) {
		pages.cellListPage.ensurePageLoaded().setFirstNameField(cellList.getFirstName());
		pages.cellListPage.ensurePageLoaded().setLastNameField(cellList.getLastName());
		pages.cellListPage.ensurePageLoaded().setCategory(cellList.getCategory());
		GetDateInCalendar("May 2014", "Previous");
		pages.cellListPage.ensurePageLoaded().setAddressField(cellList.getAddress());
	}
	
	//................................................................
	// _____for BirthDay field // Calendar component:
	@Override
	public void SetBirthDay(CellList cellList) {
		pages.cellListPage.ensurePageLoaded().clearBirthdayField();
		pages.cellListPage.ensurePageLoaded().setBirthdayField(cellList.getBirthday());
	}
	
	@Override
	public String GetColorForBirthDay(CellList cellList) {
		SetBirthDay(cellList);
		pages.cellListPage.ensurePageLoaded().clickAddressField();
		return pages.cellListPage.ensurePageLoaded().getColorBirthdayField();		
	}
	
	@Override
	public String GetDateInCalendar(String needMoòthYear, String nameButton) {
		String actRes;
		pages.cellListPage.clickBirthdayField();
		if (nameButton.equals("Previous")) {
			actRes = pages.cellListPage.getMonthInCalendar();
			while(!actRes.equals(needMoòthYear)) {
				pages.cellListPage.clickPreviousButtonInCalendar();
				actRes = pages.cellListPage.getMonthInCalendar();
			}
		}
		
		if (nameButton.equals("Next")) {
			actRes = pages.cellListPage.getMonthInCalendar();
			while(!actRes.equals(needMoòthYear)) {
				pages.cellListPage.clickNextButtonInCalendar();
				actRes = pages.cellListPage.getMonthInCalendar();
			}
		}
		
		pages.cellListPage.clickCell33();
		
		return pages.cellListPage.getBirthdayField();		
	}
	
	//................................................................
	// _____for buttons:
	@Override
	public void ClickCreateContactButton() {
		pages.cellListPage.ensurePageLoaded().clickCreateContactButton();
	}
	
	@Override
	public void ClickUpdateContactButton() {
		pages.cellListPage.ensurePageLoaded().clickUpdateContactButton();
	}
	
	@Override
	public void CheckOnEnabledButtons() {
		boolean actRes;
		actRes = pages.cellListPage.ensurePageLoaded().checkOnEnabledButtons("UpdateContact");
		Assert.assertFalse(actRes, "Update Contact button is enabled;");
		actRes = pages.cellListPage.ensurePageLoaded().checkOnEnabledButtons("CreateContact");
		Assert.assertTrue(actRes, "Create Contact button is NOT enabled;");
		actRes = pages.cellListPage.ensurePageLoaded().checkOnEnabledButtons("Generate50Contacts");
		Assert.assertTrue(actRes, "Generate 50 Contacts button is NOT enabled;");
	}
	
	@Override
	public void CheckOnEnabledUpdateContactButton() {
		boolean actRes;
		actRes = pages.cellListPage.ensurePageLoaded().checkOnEnabledButtons("UpdateContact");
		Assert.assertTrue(actRes, "Update Contact button is enabled;");
	}
	
	//................................................................
		
	
	

	
	
	 
	 
	

}
