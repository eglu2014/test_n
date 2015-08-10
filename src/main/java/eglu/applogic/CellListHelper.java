package eglu.applogic;

import java.util.List;

import eglu.model.CellList;

public interface CellListHelper {
	
	void DownCellList();
	
	void SetFirstName(CellList cellList);
	void SetLastName(CellList cellList);
	void SetCategoty(CellList cellList);
	void SetBirthDay(CellList cellList);
	void SetAddress(CellList cellList);
	void SetAllFields(CellList cellList);
		
	String GetColorForBirthDay(CellList cellList);
	public String GetDateInCalendar(String needMonthYear, String nameButton);
	
	void CheckOnEnabledButtons();
	void CheckOnEnabledUpdateContactButton();
	void ClickCreateContactButton();
	void ClickUpdateContactButton();
	
	String GetCountCellList();
	
	int GetFirstNumber(String counterCellList);
	int GetSecondNumber(String counterCellList);
	
	void ClickCellListByIndex(int index);
	public List<String> GetDataByIndexCellList(int _index);
	void CheckRowInCellList(List<String> expRes, boolean stopTCWnenError, String infoForMessage);
	void CheckAddNewRecordCellList(boolean stopTCWnenError, boolean recordShouldBeAdded, String infoForMessage);

}
