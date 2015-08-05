package eglu.applogicWork;

import java.util.ArrayList;
import java.util.List;

import eglu.applogicWork.DriverBasedHelper;
import eglu.applogic.CellTableHelper;

import org.testng.Assert;

public class CellTableHelperWork extends DriverBasedHelper implements CellTableHelper {
	// ......................................................
	public CellTableHelperWork(ApplicationManagerWork manager) {
	    super(manager.getWebDriver());
	}
	// ......................................................		
	
	// ......................................................
	// for working Table List element:
	// ......................................................
	@Override
	public String GetCountCellTable() {
		return pages.cellTablePage.ensurePageLoaded().getCountCellTable();	
	}
	
	@Override
	public void ClickFirstPageButton() {
		pages.cellTablePage.ensurePageLoaded().clickFirstPageButton();
	}
	
	@Override
	public void ClickLastPageButton() {
		pages.cellTablePage.ensurePageLoaded().clickLastPageButton();
	}
	
	@Override
	public void ClickNextPageButton() {
		pages.cellTablePage.ensurePageLoaded().clickNextPageButton();
	}
	
	@Override
	public void ClickPreviousPageButton() {
		pages.cellTablePage.ensurePageLoaded().clickPreviousPageButton();
	}
	
	@Override
	public boolean GetEnabledFirstPageButton() {
		
		int beforeClick, afterClick;
		boolean returnValue;
		
		beforeClick = GetNumbersRecord(GetCountCellTable()).get(2);
		ClickFirstPageButton();
		afterClick = GetNumbersRecord(GetCountCellTable()).get(2);
		
		if (beforeClick == afterClick)
			returnValue = false;
		else
			returnValue = true;		
			
		return returnValue;
	}
	
	@Override
	public void GetEnabledPageButtons(String nameButton, boolean isEnabled, boolean stopTCWnenError, String infoMessage) {
		
		String nameBtn = ""; 
		int beforeClick, afterClick;
		boolean returnValue;
		
		beforeClick = GetNumbersRecord(GetCountCellTable()).get(2);
		
		if (nameButton.equals("First")) {
			ClickFirstPageButton();
			nameBtn = " [First page] ";
		}
		else if (nameButton.equals("Last")) {
			ClickLastPageButton();
			nameBtn = " [Last page] ";
		}
		else if (nameButton.equals("Next")) {
			ClickNextPageButton();
			nameBtn = " [Next page] ";
		}
		else if (nameButton.equals("Previous")) {
			ClickPreviousPageButton();
			nameBtn = " [Previous page] ";
		}
		else
			System.out.println("Wrong name button. Please check!!!");
				
		afterClick = GetNumbersRecord(GetCountCellTable()).get(2);
		
		if (beforeClick == afterClick)
			returnValue = false;
		else
			returnValue = true;		
		
		if (isEnabled) {			
			if (stopTCWnenError)
				Assert.assertTrue(returnValue, infoMessage + nameBtn + "button is disabled;");			
			else
				if (!returnValue)
					System.out.println(infoMessage + " Warring!!!" + nameBtn + "button is disabled;");		
		}
		else {
			
			if (stopTCWnenError)
				Assert.assertFalse(returnValue, infoMessage + nameBtn + "button is enabled;");			
			else
				if (returnValue)
					System.out.println(infoMessage + " Warring!!!" + nameBtn + "button is enabled;");			
		}	
	}
		
	@Override
	public boolean GetEnabledLastPageButton() {
		
		int beforeClick, afterClick;
		boolean returnValue;
		
		beforeClick = GetNumbersRecord(GetCountCellTable()).get(2);
		ClickLastPageButton();
		afterClick = GetNumbersRecord(GetCountCellTable()).get(2);
		if (beforeClick == afterClick)
			returnValue = false;
		else
			returnValue = true;		
		return returnValue;			
	}
		
	@Override
	public boolean GetEnabledNextPageButton() {
		
		int beforeClick, afterClick;
		boolean returnValue;
		
		beforeClick = GetNumbersRecord(GetCountCellTable()).get(2);
		ClickNextPageButton();
		afterClick = GetNumbersRecord(GetCountCellTable()).get(2);
		if (beforeClick == afterClick)
			returnValue = false;
		else
			returnValue = true;		
		return returnValue;				
	}
	
	@Override
	public boolean GetEnabledPreviousPageButton() {
		
		int beforeClick, afterClick;
		boolean returnValue;
		
		beforeClick = GetNumbersRecord(GetCountCellTable()).get(2);
		ClickPreviousPageButton();
		afterClick = GetNumbersRecord(GetCountCellTable()).get(2);
		if (beforeClick == afterClick)
			returnValue = false;
		else
			returnValue = true;		
		return returnValue;	
	}
	
	@Override
	public List<String> GetDataByIndexCellTable(int index) {
		
		List<String> _return = new ArrayList<String>();
		
		_return.add(pages.cellTablePage.ensurePageLoaded().getDataByIndexTableList(index).get(0));
		_return.add(pages.cellTablePage.ensurePageLoaded().getDataByIndexTableList(index).get(1));
		_return.add(pages.cellTablePage.ensurePageLoaded().getDataByIndexTableList(index).get(2));
		_return.add(pages.cellTablePage.ensurePageLoaded().getDataByIndexTableList(index).get(3));
		
		return _return;
			
	}
	
	@Override
	public void CheckRecordCounterCellTable(int value1, int value2, boolean stopTCWnenError, String infoMessage) {
	
		int getActValue;
		boolean getResult;
		
		getActValue = GetNumbersRecord(GetCountCellTable()).get(2);
		
		if (value1 == getActValue)
			getResult = true;
		else
			getResult = false;
		
		if (stopTCWnenError)
			Assert.assertTrue(getResult, infoMessage + " Wrong first value in record counter. act: " + getActValue + " exp: " + value1);			
		else
			if (!getResult)
				System.out.println(infoMessage + " Wrong first value in record counter. act: " + getActValue + " exp: " + value1);
		
		getActValue = GetNumbersRecord(GetCountCellTable()).get(0);
		if (value2 == getActValue)
			getResult = true;
		else
			getResult = false;
		
		if (stopTCWnenError)
			Assert.assertTrue(getResult, infoMessage + " Wrong second value in record counter. act: " + getActValue + " exp: " + value2);			
		else
			if (!getResult)
				System.out.println(infoMessage + " Wrong second value in record counter. act: " + getActValue + " exp: " + value2);
		
		
	}	
	
	@Override
	public List<Integer> GetNumbersRecord(String counterTableList) {
		
		Integer index;
		List<Integer> returnResults = new ArrayList<Integer>();
		
		returnResults.add(0, Integer.parseInt(counterTableList.substring(counterTableList.indexOf('-') + 1, counterTableList.lastIndexOf('f') - 2)));
		returnResults.add(1, Integer.parseInt(counterTableList.substring(counterTableList.lastIndexOf('f') + 2)));
		
		// first number - index has 2:
		index = counterTableList.indexOf('-');
		returnResults.add(2, Integer.parseInt(counterTableList.substring(0, index)));
		
		return returnResults;				
	}	
	
	@Override
	public void CheckRowInCellTable(List<String> expRes, boolean stopTCWnenError, String infoForMessage) {
		
		int index;
		boolean getResult;
		String act, exp;
		
		index = GetNumbersRecord(GetCountCellTable()).get(0) - 1; 
		
		exp = expRes.get(0);
		act = GetDataByIndexCellTable(index).get(0);
		getResult = ÑomparisonTwoValues(act, exp);
		if (stopTCWnenError)
			Assert.assertTrue(getResult, infoForMessage + " [First Name] column has wrong value. ActRes: " + act + " ExpRes: " + exp);			
		else
			if (!getResult)
				System.out.println(infoForMessage + " Warring: [First Name] column has wrong value. ActRes: " + act + " ExpRes: " + exp);
		
		exp = expRes.get(1);
		act = GetDataByIndexCellTable(index).get(1);
		getResult = ÑomparisonTwoValues(act, exp);
		if (stopTCWnenError)
			Assert.assertTrue(getResult, infoForMessage + " [Last Name] column has wrong value. ActRes: " + act + " ExpRes: " + exp);			
		else
			if (!getResult)
				System.out.println(infoForMessage + " Warring: [Last Name] column has wrong value. ActRes: " + act + " ExpRes: " + exp);
		
		exp = expRes.get(2);
		act = GetDataByIndexCellTable(index).get(2);
		getResult = ÑomparisonTwoValues(act, exp);
		if (stopTCWnenError)
			Assert.assertTrue(getResult, infoForMessage + " [Category] column has wrong value. ActRes: " + act + " ExpRes: " + exp);			
		else
			if (!getResult)
				System.out.println(infoForMessage + " Warring: [Category] column has wrong value. ActRes: " + act + " ExpRes: " + exp);
		
		exp = expRes.get(3);
		act = GetDataByIndexCellTable(index).get(3);
		getResult = ÑomparisonTwoValues(act, exp);
		if (stopTCWnenError)
			Assert.assertTrue(getResult, infoForMessage + " [Address] column has wrong value. ActRes: " + act + " ExpRes: " + exp);			
		else
			if (!getResult)
				System.out.println(infoForMessage + " Warring: [Address] column has wrong value. ActRes: " + act + " ExpRes: " + exp);		
		}
	
	
}
