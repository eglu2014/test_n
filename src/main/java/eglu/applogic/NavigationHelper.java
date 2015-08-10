package eglu.applogic;

public interface NavigationHelper {

	void openPage(String url);
	
	void gotoCellListPage();
	void gotoCellTablePage();
	
	boolean ComparisonTwoValues(String act, String exp);
	boolean ComparisonTwoValues(int act, int exp);
}
