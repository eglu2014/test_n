package eglu.applogic;

public interface NavigationHelper {

	void openPage(String url);
	
	void gotoCellListPage();
	void gotoCellTablePage();
	
	boolean ÑomparisonTwoValues(String act, String exp);
	boolean ÑomparisonTwoValues(Integer act, Integer exp);
}
