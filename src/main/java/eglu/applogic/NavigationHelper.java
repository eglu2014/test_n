package eglu.applogic;

public interface NavigationHelper {

	void openPage(String url);
	
	void gotoCellListPage();
	void gotoCellTablePage();
	
	boolean �omparisonTwoValues(String act, String exp);
	boolean �omparisonTwoValues(Integer act, Integer exp);
}
