package eglu.applogic;

import eglu.applogic.CellListHelper;
import eglu.applogic.CellTableHelper;
import eglu.applogic.NavigationHelper;

public interface ApplicationManager {
	
	CellListHelper getCellListHelper();
	CellTableHelper getCellTableHelper();
	NavigationHelper getNavigationHelper();
	void stop();

}
