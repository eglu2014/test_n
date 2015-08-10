package eglu.applogic;

import java.util.List;

public interface CellTableHelper {

	void ClickFirstPageButton();
	void ClickLastPageButton();
	void ClickNextPageButton();
	void ClickPreviousPageButton();
	
	boolean GetEnabledFirstPageButton();
	boolean GetEnabledLastPageButton();
	boolean GetEnabledNextPageButton();
	boolean GetEnabledPreviousPageButton();
	void GetEnabledPageButtons(String nameButton, boolean isEnabled, boolean stopTCWnenError, String infoMessage);
	
	String GetCountCellTable();
	
	void CheckRecordCounterCellTable(int value1, int value2, boolean stopTCWnenError, String infoMessage);
	
	List<Integer> GetNumbersRecord(String counterTableList);
	
	List<String> GetDataByIndexCellTable(int index);
	
	void CheckRowInCellTable(List<String> expRes, boolean stopTCWnenError, String infoForMessage);
	
	
}
