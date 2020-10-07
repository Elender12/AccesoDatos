package restaurant;


public class Utils {
	public static int generateTableNumber() {
		int tableNum= (int) (Math.random()*5+1);
		return tableNum;
	}
}
